package com.chimericdream.minekea.block.building.framed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.property.MinekeaProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class FramedPlanksBlock extends Block {
    public static final DirectionProperty FACING;
    public static final BooleanProperty CONNECTED_NORTH;
    public static final BooleanProperty CONNECTED_SOUTH;
    public static final BooleanProperty CONNECTED_EAST;
    public static final BooleanProperty CONNECTED_WEST;

    static {
        FACING = MinekeaProperties.HORIZONTAL_AXIS_FACING;
        CONNECTED_NORTH = BooleanProperty.of("connected_north");
        CONNECTED_SOUTH = BooleanProperty.of("connected_south");
        CONNECTED_EAST = BooleanProperty.of("connected_east");
        CONNECTED_WEST = BooleanProperty.of("connected_west");
    }

    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public FramedPlanksBlock(BlockConfig config) {
        super(config.getBaseSettings());

        BLOCK_ID = makeId(config.getMaterial());
        this.config = config;

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(CONNECTED_NORTH, false)
                .with(CONNECTED_SOUTH, false)
                .with(CONNECTED_EAST, false)
                .with(CONNECTED_WEST, false)
        );
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("building/general/framed_planks/%s", material));
    }

    public BlockConfig getConfig() {
        return config;
    }

    private boolean shouldConnect(ItemPlacementContext ctx, Direction direction, Direction facing) {
        return shouldConnect(ctx.getWorld(), ctx.getBlockPos(), direction, facing);
    }

    private boolean shouldConnect(BlockView world, BlockPos pos, Direction direction, Direction facing) {
        BlockPos neighborPos = pos.offset(direction);
        BlockState neighborState = world.getBlockState(neighborPos);

        return neighborState.isOf(this) && neighborState.get(FACING).equals(facing);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(
            FACING,
            CONNECTED_NORTH,
            CONNECTED_SOUTH,
            CONNECTED_EAST,
            CONNECTED_WEST
        );
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getPlayer() == null) {
            return this.getDefaultState();
        }

        Direction facing = getHorizontalAxisFacing(ctx.getPlayer().getHorizontalFacing());

        if (facing.equals(Direction.NORTH)) {
            return this.getDefaultState()
                .with(FACING, facing)
                .with(CONNECTED_EAST, shouldConnect(ctx, Direction.EAST, facing))
                .with(CONNECTED_WEST, shouldConnect(ctx, Direction.WEST, facing));
        }

        return this.getDefaultState()
            .with(FACING, facing)
            .with(CONNECTED_NORTH, shouldConnect(ctx, Direction.NORTH, facing))
            .with(CONNECTED_SOUTH, shouldConnect(ctx, Direction.SOUTH, facing));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getAxis().isVertical()) {
            return state;
        }

        BooleanProperty prop = getConnectionProperty(direction);

        if (!state.isOf(this)) {
            return state.with(prop, false);
        }

        return state.with(prop, neighborState.isOf(this) && neighborState.get(FACING) == state.get(FACING));
    }

    private Direction getHorizontalAxisFacing(Direction direction) {
        return switch (direction) {
            case EAST, WEST -> Direction.EAST;
            default -> Direction.NORTH;
        };
    }

    @Nullable
    private BooleanProperty getConnectionProperty(Direction direction) {
        return switch (direction) {
            case NORTH -> CONNECTED_NORTH;
            case SOUTH -> CONNECTED_SOUTH;
            case EAST -> CONNECTED_EAST;
            case WEST -> CONNECTED_WEST;
            case UP, DOWN -> null;
        };
    }
}
