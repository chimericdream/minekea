package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class FloatingShelfBlock extends ShelfBlock {
    public FloatingShelfBlock(BlockConfig config) {
        super(config, makeId(config.getMaterial()));
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("furniture/shelves/floating/%s", material));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction wall = state.get(WALL_SIDE);

        return switch (wall) {
            case EAST -> Block.createCuboidShape(0.0, 7.0, 0.0, 7.0, 9.0, 16.0);
            case SOUTH -> Block.createCuboidShape(0.0, 7.0, 0.0, 16.0, 9.0, 7.0);
            case WEST -> Block.createCuboidShape(9.0, 7.0, 0.0, 16.0, 9.0, 16.0);
            default -> Block.createCuboidShape(0.0, 7.0, 9.0, 16.0, 9.0, 16.0);
        };
    }
}
