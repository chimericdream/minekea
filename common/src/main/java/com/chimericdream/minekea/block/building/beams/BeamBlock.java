package com.chimericdream.minekea.block.building.beams;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.tags.CommonItemTags;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.tag.MinekeaBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class BeamBlock extends Block implements Waterloggable {
    protected static final VoxelShape CORE_SHAPE = Block.createCuboidShape(5.0, 5.0, 5.0, 11.0, 11.0, 11.0);
    protected static final VoxelShape CONNECTED_NORTH_SHAPE = Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 5.0);
    protected static final VoxelShape CONNECTED_SOUTH_SHAPE = Block.createCuboidShape(5.0, 5.0, 11.0, 11.0, 11.0, 16.0);
    protected static final VoxelShape CONNECTED_EAST_SHAPE = Block.createCuboidShape(11.0, 5.0, 5.0, 16.0, 11.0, 11.0);
    protected static final VoxelShape CONNECTED_WEST_SHAPE = Block.createCuboidShape(0.0, 5.0, 5.0, 5.0, 11.0, 11.0);
    protected static final VoxelShape CONNECTED_UP_SHAPE = Block.createCuboidShape(5.0, 11.0, 5.0, 11.0, 16.0, 11.0);
    protected static final VoxelShape CONNECTED_DOWN_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 5.0, 11.0);

    public static final BooleanProperty CONNECTED_NORTH;
    public static final BooleanProperty CONNECTED_SOUTH;
    public static final BooleanProperty CONNECTED_EAST;
    public static final BooleanProperty CONNECTED_WEST;
    public static final BooleanProperty CONNECTED_UP;
    public static final BooleanProperty CONNECTED_DOWN;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    static {
        CONNECTED_NORTH = BooleanProperty.of("connected_north");
        CONNECTED_SOUTH = BooleanProperty.of("connected_south");
        CONNECTED_EAST = BooleanProperty.of("connected_east");
        CONNECTED_WEST = BooleanProperty.of("connected_west");
        CONNECTED_UP = BooleanProperty.of("connected_up");
        CONNECTED_DOWN = BooleanProperty.of("connected_down");
    }

    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public BeamBlock(BlockConfig config) {
        super(config.getBaseSettings());

        BLOCK_ID = makeId(config.getMaterial());

        this.config = config;

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(CONNECTED_NORTH, false)
                .with(CONNECTED_SOUTH, false)
                .with(CONNECTED_EAST, false)
                .with(CONNECTED_WEST, false)
                .with(CONNECTED_UP, false)
                .with(CONNECTED_DOWN, false)
                .with(WATERLOGGED, false)
        );
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, "building/beams/" + material);
    }

    public BlockConfig getConfig() {
        return config;
    }

    private boolean shouldConnect(ItemPlacementContext ctx, Direction direction) {
        return shouldConnect(ctx.getWorld(), ctx.getBlockPos(), direction);
    }

    private boolean shouldConnect(BlockView world, BlockPos pos, Direction direction) {
        BlockPos neighborPos = pos.offset(direction);
        BlockState neighborState = world.getBlockState(neighborPos);

        if (neighborState.isOf(Blocks.AIR)) {
            return false;
        }

        return neighborState.getFluidState().isEmpty() || neighborState.isIn(MinekeaBlockTags.BEAMS);
    }

    private double getPartialCoord(Direction hitSide, double coord) {
        double offset = 0.00001;

        if (hitSide == Direction.EAST || hitSide == Direction.SOUTH || hitSide == Direction.UP) {
            offset = -1 * offset;
        }

        int floor = MathHelper.floor(coord + offset);

        return coord - (double) floor;
    }

    // @TODO: Add "override" versions of the CONNECTED_* properties to allow for more granular control of the beam connections
    @Override
    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!stack.isIn(CommonItemTags.WRENCHES)) {
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        Direction hitSide = hit.getSide();
        Vec3d hitPos = hit.getPos();
        BooleanProperty connection = getConnectionProperty(hitSide);

        double x = getPartialCoord(hitSide, hitPos.x);
        double y = getPartialCoord(hitSide, hitPos.y);
        double z = getPartialCoord(hitSide, hitPos.z);

        double UPPER_ARM_START = 0.687500;
        double LOWER_ARM_END = 0.312500;

        if (x > UPPER_ARM_START) {
            connection = CONNECTED_EAST;
        } else if (y > UPPER_ARM_START) {
            connection = CONNECTED_UP;
        } else if (z > UPPER_ARM_START) {
            connection = CONNECTED_SOUTH;
        } else if (x < LOWER_ARM_END) {
            connection = CONNECTED_WEST;
        } else if (y < LOWER_ARM_END) {
            connection = CONNECTED_DOWN;
        } else if (z < LOWER_ARM_END) {
            connection = CONNECTED_NORTH;
        }

        world.setBlockState(pos, state.with(connection, !state.get(connection)));
        world.markDirty(pos);

        if (!world.isClient()) {
            world.playSound(null, pos, SoundEvents.ITEM_SPYGLASS_USE, SoundCategory.AMBIENT, 2.0F, 1.5F);
        }

        return ItemActionResult.CONSUME;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
            .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER)
            .with(CONNECTED_NORTH, shouldConnect(ctx, Direction.NORTH))
            .with(CONNECTED_SOUTH, shouldConnect(ctx, Direction.SOUTH))
            .with(CONNECTED_EAST, shouldConnect(ctx, Direction.EAST))
            .with(CONNECTED_WEST, shouldConnect(ctx, Direction.WEST))
            .with(CONNECTED_UP, shouldConnect(ctx, Direction.UP))
            .with(CONNECTED_DOWN, shouldConnect(ctx, Direction.DOWN))
            .with(getConnectionProperty(ctx.getSide()), true);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        if (neighborState.isOf(Blocks.AIR)) {
            return state.with(getConnectionProperty(direction), false);
        }

        return state.with(
            getConnectionProperty(direction),
            neighborState.getFluidState().isEmpty() || neighborState.isIn(MinekeaBlockTags.BEAMS)
        );
    }

    private BooleanProperty getConnectionProperty(Direction direction) {
        return switch (direction) {
            case NORTH -> CONNECTED_NORTH;
            case SOUTH -> CONNECTED_SOUTH;
            case EAST -> CONNECTED_EAST;
            case WEST -> CONNECTED_WEST;
            case UP -> CONNECTED_UP;
            case DOWN -> CONNECTED_DOWN;
        };
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(
            CONNECTED_NORTH,
            CONNECTED_SOUTH,
            CONNECTED_EAST,
            CONNECTED_WEST,
            CONNECTED_UP,
            CONNECTED_DOWN,
            WATERLOGGED
        );
    }

    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.NORMAL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        boolean connectedNorth = state.get(CONNECTED_NORTH);
        boolean connectedSouth = state.get(CONNECTED_SOUTH);
        boolean connectedEast = state.get(CONNECTED_EAST);
        boolean connectedWest = state.get(CONNECTED_WEST);
        boolean connectedUp = state.get(CONNECTED_UP);
        boolean connectedDown = state.get(CONNECTED_DOWN);

        VoxelShape outline = CORE_SHAPE;

        if (connectedNorth) {
            outline = VoxelShapes.union(outline, CONNECTED_NORTH_SHAPE);
        }
        if (connectedSouth) {
            outline = VoxelShapes.union(outline, CONNECTED_SOUTH_SHAPE);
        }
        if (connectedEast) {
            outline = VoxelShapes.union(outline, CONNECTED_EAST_SHAPE);
        }
        if (connectedWest) {
            outline = VoxelShapes.union(outline, CONNECTED_WEST_SHAPE);
        }
        if (connectedUp) {
            outline = VoxelShapes.union(outline, CONNECTED_UP_SHAPE);
        }
        if (connectedDown) {
            outline = VoxelShapes.union(outline, CONNECTED_DOWN_SHAPE);
        }

        return outline;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, NavigationType type) {
        return false;
    }

//    public void register() {
//        RegistryHelpers.registerBlockWithItem(this, BLOCK_ID);
//        FabricItemGroupEventHelpers.addBlockToItemGroup(this, MinekeaItemGroups.BEAM_ITEM_GROUP_KEY);
//
//        if (config.isFlammable()) {
//            FabricRegistryHelpers.registerFlammableBlock(this);
//        }
//    }
//
}
