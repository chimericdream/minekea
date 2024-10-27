package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.MinekeaMod;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entity.block.furniture.ShelfBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class ShelfBlock extends BlockWithEntity implements Waterloggable {
    public static final DirectionProperty WALL_SIDE;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    static {
        WALL_SIDE = DirectionProperty.of("wall_side", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    }

    public ShelfBlock(BlockConfig config) {
        this(config, makeId(config.getMaterial()));
    }

    public ShelfBlock(BlockConfig config, Identifier blockId) {
        super(AbstractBlock.Settings.copy(config.getIngredient("planks")));

        this.setDefaultState(
            this.stateManager.getDefaultState()
                .with(WALL_SIDE, Direction.NORTH)
                .with(WATERLOGGED, false)
        );

        BLOCK_ID = blockId;
        this.config = config;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("furniture/shelves/supported/%s", material));
    }

    @Override
    protected MapCodec<ShelfBlock> getCodec() {
        return null;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(WALL_SIDE, rotation.rotate(state.get(WALL_SIDE)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(WALL_SIDE)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WALL_SIDE, WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction lookDirection = ctx.getPlayerLookDirection();

        if (lookDirection == Direction.DOWN || lookDirection == Direction.UP) {
            return this.getDefaultState().with(WALL_SIDE, Direction.NORTH)
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
        }

        return this.getDefaultState().with(WALL_SIDE, lookDirection.getOpposite())
            .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
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

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction wall = state.get(WALL_SIDE);

        return switch (wall) {
            case EAST -> VoxelShapes.union(Block.createCuboidShape(0.0, 7.0, 0.0, 7.0, 9.0, 16.0),
                Block.createCuboidShape(0.0, 4.0, 0.0, 2.0, 7.0, 1.0),
                Block.createCuboidShape(2.0, 5.0, 15.0, 4.0, 7.0, 16.0),
                Block.createCuboidShape(2.0, 5.0, 0.0, 4.0, 7.0, 1.0),
                Block.createCuboidShape(4.0, 6.0, 0.0, 6.0, 7.0, 1.0),
                Block.createCuboidShape(4.0, 6.0, 15.0, 6.0, 7.0, 16.0),
                Block.createCuboidShape(0.0, 4.0, 15.0, 2.0, 7.0, 16.0)
            );
            case SOUTH -> VoxelShapes.union(Block.createCuboidShape(0.0, 7.0, 0.0, 16.0, 9.0, 7.0),
                Block.createCuboidShape(15.0, 4.0, 0.0, 16.0, 7.0, 2.0),
                Block.createCuboidShape(0.0, 5.0, 2.0, 1.0, 7.0, 4.0),
                Block.createCuboidShape(15.0, 5.0, 2.0, 16.0, 7.0, 4.0),
                Block.createCuboidShape(15.0, 6.0, 4.0, 16.0, 7.0, 6.0),
                Block.createCuboidShape(0.0, 6.0, 4.0, 1.0, 7.0, 6.0),
                Block.createCuboidShape(0.0, 4.0, 0.0, 1.0, 7.0, 2.0)
            );
            case WEST -> VoxelShapes.union(
                Block.createCuboidShape(9.0, 7.0, 0.0, 16.0, 9.0, 16.0),
                Block.createCuboidShape(14.0, 4.0, 15.0, 16.0, 7.0, 16.0),
                Block.createCuboidShape(12.0, 5.0, 0.0, 14.0, 7.0, 1.0),
                Block.createCuboidShape(12.0, 5.0, 15.0, 14.0, 7.0, 16.0),
                Block.createCuboidShape(10.0, 6.0, 15.0, 12.0, 7.0, 16.0),
                Block.createCuboidShape(10.0, 6.0, 0.0, 12.0, 7.0, 1.0),
                Block.createCuboidShape(14.0, 4.0, 0.0, 16.0, 7.0, 1.0)
            );
            default -> VoxelShapes.union(
                Block.createCuboidShape(0.0, 7.0, 9.0, 16.0, 9.0, 16.0),
                Block.createCuboidShape(0.0, 4.0, 14.0, 1.0, 7.0, 16.0),
                Block.createCuboidShape(15.0, 5.0, 12.0, 16.0, 7.0, 14.0),
                Block.createCuboidShape(0.0, 5.0, 12.0, 1.0, 7.0, 14.0),
                Block.createCuboidShape(0.0, 6.0, 10.0, 1.0, 7.0, 12.0),
                Block.createCuboidShape(15.0, 6.0, 10.0, 16.0, 7.0, 12.0),
                Block.createCuboidShape(15.0, 4.0, 14.0, 16.0, 7.0, 16.0)
            );
        };
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ShelfBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    private int getTargetSlot(BlockState state, BlockHitResult hit) {
        Direction facing = state.get(WALL_SIDE);
        Vec3d localCoords = hit.getPos().subtract(Vec3d.of(hit.getBlockPos()));

        switch (facing) {
            case NORTH -> {
                double x = localCoords.getX();
                if (x > 0.75) return 0;
                if (x > 0.50) return 1;
                if (x > 0.25) return 2;

                return 3;
            }
            case EAST -> {
                double z = localCoords.getZ();
                if (z > 0.75) return 0;
                if (z > 0.50) return 1;
                if (z > 0.25) return 2;

                return 3;
            }
            case SOUTH -> {
                double x = localCoords.getX();
                if (x > 0.75) return 3;
                if (x > 0.50) return 2;
                if (x > 0.25) return 1;

                return 0;
            }
            case WEST -> {
                double z = localCoords.getZ();
                if (z > 0.75) return 3;
                if (z > 0.50) return 2;
                if (z > 0.25) return 1;

                return 0;
            }
        }

        return -1;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        ShelfBlockEntity entity;

        try {
            entity = (ShelfBlockEntity) world.getBlockEntity(pos);
            assert entity != null;
        } catch (Exception e) {
            MinekeaMod.LOGGER.error(String.format("The shelf at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));

            return ActionResult.FAIL;
        }

        int slot = getTargetSlot(state, hit);
        if (slot == -1) {
            throw new IllegalStateException("It should not be possible to target a slot outside of the block");
        }

        if (!player.getMainHandStack().isEmpty()) {
            // Try to insert the item in the player's hand into the targeted slot on the shelf
            player.setStackInHand(Hand.MAIN_HAND, entity.tryInsert(slot, player.getMainHandStack()));
        } else if (player.isSneaking() && player.getMainHandStack().isEmpty()) {
            if (!entity.getStack(slot).isEmpty()) {
                ItemScatterer.spawn(
                    world,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    entity.removeStack(slot)
                );
            }
        }

        entity.markDirty();
        world.markDirty(pos);

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ShelfBlockEntity) {
                ItemScatterer.spawn(world, pos, (ShelfBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
}
