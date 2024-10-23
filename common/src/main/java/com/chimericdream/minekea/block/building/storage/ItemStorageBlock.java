package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ItemStorageBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS;
    public static final DirectionProperty FACING;
    public static final BooleanProperty IS_BAGGED;

    public final Identifier BLOCK_ID;
    public final BlockConfig config;
    public final boolean isBaggedItem;
    public final StorageModel model;

    static {
        AXIS = Properties.AXIS;
        FACING = Properties.FACING;
        IS_BAGGED = BooleanProperty.of("is_bagged");
    }

    public ItemStorageBlock(BlockConfig config) {
        this(config, false);
    }

    public ItemStorageBlock(BlockConfig config, boolean isBaggedItem) {
        this(config, isBaggedItem, isBaggedItem ? StorageModel.BAGGED : StorageModel.DEFAULT);
    }

    public ItemStorageBlock(BlockConfig config, boolean isBaggedItem, StorageModel model) {
        super(config.getBaseSettings());

        setDefaultState(
            getStateManager()
                .getDefaultState()
                .with(AXIS, Direction.Axis.Y)
                .with(IS_BAGGED, false)
        );

        this.BLOCK_ID = makeId(config.getMaterial());
        this.config = config;
        this.isBaggedItem = isBaggedItem;
        this.model = model;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("storage/compressed/%s", material));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(IS_BAGGED)) {
            return VoxelShapes.union(
                Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 9.0, 16.0),
                Block.createCuboidShape(1.0, 9.0, 1.0, 15.0, 10.0, 15.0),
                Block.createCuboidShape(0.0, 10.0, 0.0, 16.0, 13.0, 16.0),
                Block.createCuboidShape(1.0, 13.0, 1.0, 15.0, 16.0, 15.0)
            );
        }

        return VoxelShapes.fullCube();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS, FACING, IS_BAGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = this.getDefaultState()
            .with(AXIS, ctx.getSide().getAxis())
            .with(FACING, ctx.getPlayerLookDirection().getOpposite());

        if (this.isBaggedItem) {
            return state.with(IS_BAGGED, true);
        }

        return state.with(IS_BAGGED, false);
    }

    @Override
    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(IS_BAGGED) && stack.isOf(Items.SHEARS)) {
            if (world.isClient()) {
                world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0f, 1.0f);
            } else {
                world.setBlockState(pos, state.with(IS_BAGGED, false));
                world.markDirty(pos);
            }

            return ItemActionResult.SUCCESS;
        }

        if (!state.get(IS_BAGGED) && this.isBaggedItem && stack.isOf(Items.LEATHER)) {
            if (world.isClient()) {
                world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_BUNDLE_INSERT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            } else {
                world.setBlockState(pos, state.with(IS_BAGGED, true));
                world.markDirty(pos);
            }

            return ItemActionResult.SUCCESS;
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public enum StorageModel {
        DEFAULT,
        BAGGED,
        FACING,
        AXIS,
        CUSTOM;
    }
}
