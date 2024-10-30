package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.client.screen.crate.DoubleCrateScreenHandler;
import com.chimericdream.minekea.entity.block.containers.CrateBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CrateBlock extends BlockWithEntity {
    public static final MapCodec<CrateBlock> CODEC = createCodec(CrateBlock::new);

    public static final Integer ROW_COUNT = 6;

    public static final DirectionProperty FACING;
    public static final EnumProperty<Axis> AXIS;
    public static final BooleanProperty OPEN;

    public static final EnumProperty<ChestType> CRATE_TYPE;
    public static final BooleanProperty CONNECTED_NORTH;
    public static final BooleanProperty CONNECTED_SOUTH;
    public static final BooleanProperty CONNECTED_EAST;
    public static final BooleanProperty CONNECTED_WEST;

    public Identifier BLOCK_ID;
    public final BlockConfig config;

    private static final DoubleBlockProperties.PropertyRetriever<CrateBlockEntity, Optional<Inventory>> INVENTORY_RETRIEVER;
    private static final DoubleBlockProperties.PropertyRetriever<CrateBlockEntity, Optional<NamedScreenHandlerFactory>> SCREEN_RETRIEVER;

    static {
        FACING = Properties.FACING;
        AXIS = Properties.AXIS;
        OPEN = Properties.OPEN;

        CRATE_TYPE = Properties.CHEST_TYPE;
        CONNECTED_NORTH = BooleanProperty.of("connected_north");
        CONNECTED_SOUTH = BooleanProperty.of("connected_south");
        CONNECTED_EAST = BooleanProperty.of("connected_east");
        CONNECTED_WEST = BooleanProperty.of("connected_west");

        INVENTORY_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<>() {
            public Optional<Inventory> getFromBoth(CrateBlockEntity crate1, CrateBlockEntity crate2) {
                return Optional.of(new DoubleInventory(crate1, crate2));
            }

            public Optional<Inventory> getFrom(CrateBlockEntity chestBlockEntity) {
                return Optional.of(chestBlockEntity);
            }

            public Optional<Inventory> getFallback() {
                return Optional.empty();
            }
        };
        SCREEN_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<>() {
            public Optional<NamedScreenHandlerFactory> getFromBoth(final CrateBlockEntity crate1, final CrateBlockEntity crate2) {
                final Inventory inventory = new DoubleInventory(crate1, crate2);

                return Optional.of(new NamedScreenHandlerFactory() {
                    public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        return new DoubleCrateScreenHandler(Crates.DOUBLE_CRATE_SCREEN_HANDLER.get(), i, playerInventory, inventory);
                    }

                    public Text getDisplayName() {
                        if (crate1.isTrapped()) {
                            return Text.translatable(DoubleCrateScreenHandler.TRAPPED_SCREEN_ID.toTranslationKey());
                        }

                        return Text.translatable(DoubleCrateScreenHandler.SCREEN_ID.toTranslationKey());
                    }
                });
            }

            public Optional<NamedScreenHandlerFactory> getFrom(CrateBlockEntity crate) {
                return Optional.of(crate);
            }

            public Optional<NamedScreenHandlerFactory> getFallback() {
                return Optional.empty();
            }
        };
    }

    public CrateBlock(AbstractBlock.Settings settings) {
        this(Crates.CONFIGS.get("oak"));
    }

    public CrateBlock(BlockConfig config) {
        super(AbstractBlock.Settings.copy(Blocks.BARREL));

        BLOCK_ID = makeId(config.getMaterial());
        this.config = config;

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(AXIS, Axis.Y)
                .with(FACING, Direction.NORTH)
                .with(CRATE_TYPE, ChestType.SINGLE)
                .with(CONNECTED_NORTH, false)
                .with(CONNECTED_SOUTH, false)
                .with(CONNECTED_EAST, false)
                .with(CONNECTED_WEST, false)
                .with(OPEN, false)
        );
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("containers/crates/%s", material));
    }

    @Override
    protected MapCodec<CrateBlock> getCodec() {
        return CODEC;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrateBlockEntity(Crates.CRATE_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, Crates.CRATE_BLOCK_ENTITY.get(), CrateBlockEntity::tick);
    }

    public static BlockState changeRotation(BlockState state, BlockRotation rotation) {
        if (isConnectedCrate(state)) {
            return state;
        }

        return switch (rotation) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.get(AXIS)) {
                case X -> (BlockState) state.with(AXIS, Axis.Z);
                case Z -> (BlockState) state.with(AXIS, Axis.X);
                default -> state;
            };
            default -> state;
        };
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, AXIS, OPEN, CRATE_TYPE, CONNECTED_NORTH, CONNECTED_SOUTH, CONNECTED_EAST, CONNECTED_WEST);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState placementState = this.getDefaultState().with(AXIS, ctx.getSide().getAxis());

        // if the player is sneaking, and they are targeting another block of this type, and that block is not already connected elsewhere
        if (ctx.getPlayer() != null && ctx.getPlayer().isSneaking() && ctx.getSide().getAxis().isHorizontal()) {
            Direction side = ctx.getSide().getOpposite();
            BlockState neighbor = getAvailableNeighboringCrate(ctx, side);
            BooleanProperty prop = getConnectionProperty(side);

            if (neighbor != null) {
                return this.getDefaultState().with(AXIS, Axis.Y).with(FACING, Direction.UP).with(prop, true).with(CRATE_TYPE, getDoubleCrateType(side));
            }
        }

        // if the player is sneaking, or if this crate is not being placed vertically, skip checking for double crate stuff
        if (ctx.shouldCancelInteraction() || ctx.getSide().getAxis().isHorizontal()) {
            if (ctx.getSide().getAxis().equals(Axis.X)) {
                return placementState.with(FACING, Direction.EAST);
            }

            return placementState.with(FACING, Direction.SOUTH);
        }

        BlockState neighbor;

        neighbor = getAvailableNeighboringCrate(ctx, Direction.NORTH);
        if (neighbor != null) {
            return placementState.with(CONNECTED_NORTH, true).with(FACING, Direction.UP).with(CRATE_TYPE, ChestType.RIGHT);
        }

        neighbor = getAvailableNeighboringCrate(ctx, Direction.EAST);
        if (neighbor != null) {
            return placementState.with(CONNECTED_EAST, true).with(FACING, Direction.UP).with(CRATE_TYPE, ChestType.LEFT);
        }

        neighbor = getAvailableNeighboringCrate(ctx, Direction.SOUTH);
        if (neighbor != null) {
            return placementState.with(CONNECTED_SOUTH, true).with(FACING, Direction.UP).with(CRATE_TYPE, ChestType.LEFT);
        }

        neighbor = getAvailableNeighboringCrate(ctx, Direction.WEST);
        if (neighbor != null) {
            return placementState.with(CONNECTED_WEST, true).with(FACING, Direction.UP).with(CRATE_TYPE, ChestType.RIGHT);
        }

        return placementState;
    }

    @Nullable
    private BooleanProperty getConnectionProperty(Direction dir) {
        return switch (dir) {
            case DOWN, UP -> null;
            case NORTH -> CONNECTED_NORTH;
            case SOUTH -> CONNECTED_SOUTH;
            case EAST -> CONNECTED_EAST;
            case WEST -> CONNECTED_WEST;
        };
    }

    @Nullable
    private ChestType getDoubleCrateType(Direction dir) {
        return switch (dir) {
            case DOWN, UP -> null;
            case NORTH, WEST -> ChestType.RIGHT;
            case SOUTH, EAST -> ChestType.LEFT;
        };
    }

    @Nullable
    private BooleanProperty getReverseConnectionProperty(Direction dir) {
        return switch (dir) {
            case DOWN, UP -> null;
            case NORTH -> CONNECTED_SOUTH;
            case SOUTH -> CONNECTED_NORTH;
            case EAST -> CONNECTED_WEST;
            case WEST -> CONNECTED_EAST;
        };
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getAxis().isVertical()) {
            return state;
        }

        if (!neighborState.isOf(this)) {
            return state.with(getConnectionProperty(direction), false);
        }

        BooleanProperty prop = getReverseConnectionProperty(direction);
        if (neighborState.get(prop)) {
            return state.with(getConnectionProperty(direction), true).with(FACING, Direction.UP);
        }

        return state;
    }

    private static boolean isConnectedCrate(BlockState crate) {
        return crate.get(CONNECTED_NORTH) || crate.get(CONNECTED_SOUTH) || crate.get(CONNECTED_EAST) || crate.get(CONNECTED_WEST);
    }

    @Nullable
    private BlockState getAvailableNeighboringCrate(ItemPlacementContext ctx, Direction dir) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(dir));

        if (!blockState.isOf(this) || isConnectedCrate(blockState) || blockState.get(AXIS).isHorizontal()) {
            return null;
        }

        return blockState;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        NamedScreenHandlerFactory screenHandlerFactory = this.createScreenHandlerFactory(state, world, pos);

        if (screenHandlerFactory != null) {
            player.openHandledScreen(screenHandlerFactory);
            return ActionResult.CONSUME;
        }

        return ActionResult.FAIL;
    }

    public static Direction getFacing(BlockState state) {
        if (state.get(CONNECTED_NORTH)) {
            return Direction.NORTH;
        }

        if (state.get(CONNECTED_SOUTH)) {
            return Direction.SOUTH;
        }

        if (state.get(CONNECTED_EAST)) {
            return Direction.EAST;
        }

        if (state.get(CONNECTED_WEST)) {
            return Direction.WEST;
        }

        return state.get(FACING);
    }

    public static DoubleBlockProperties.Type getDoubleBlockType(BlockState state) {
        if (!isConnectedCrate(state)) {
            return DoubleBlockProperties.Type.SINGLE;
        }

        if (state.get(CONNECTED_NORTH) || state.get(CONNECTED_EAST)) {
            return DoubleBlockProperties.Type.FIRST;
        }

        return DoubleBlockProperties.Type.SECOND;
    }

    public DoubleBlockProperties.PropertySource<CrateBlockEntity> getBlockEntitySource(BlockState state, World world, BlockPos pos) {
        return DoubleBlockProperties.toPropertySource(
            Crates.CRATE_BLOCK_ENTITY.get(),
            CrateBlock::getDoubleBlockType,
            CrateBlock::getFacing,
            FACING,
            state,
            world,
            pos,
            (worldx, posx) -> false
        );
    }

    @Nullable
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return (NamedScreenHandlerFactory) ((Optional) this.getBlockEntitySource(state, world, pos).apply(SCREEN_RETRIEVER)).orElse(null);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CrateBlockEntity) {
                ItemScatterer.spawn(world, pos, (CrateBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }
}
