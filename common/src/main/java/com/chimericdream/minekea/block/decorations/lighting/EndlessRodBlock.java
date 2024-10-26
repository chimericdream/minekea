package com.chimericdream.minekea.block.decorations.lighting;

import com.chimericdream.minekea.ModInfo;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RodBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class EndlessRodBlock extends RodBlock {
    public final static Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "decorations/lighting/endless_rod");
    public static final MapCodec<EndlessRodBlock> CODEC = createCodec(EndlessRodBlock::new);

    public MapCodec<EndlessRodBlock> getCodec() {
        return CODEC;
    }

    public EndlessRodBlock(Settings settings) {
        this();
    }

    public EndlessRodBlock() {
        super(AbstractBlock.Settings.copy(Blocks.END_ROD));

        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.UP));
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getSide();
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(direction.getOpposite()));

        return blockState.isOf(this) && blockState.get(FACING) == direction
            ? this.getDefaultState().with(FACING, direction.getOpposite())
            : this.getDefaultState().with(FACING, direction);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction direction = state.get(FACING);

        double d = (double) pos.getX() + 0.55 - (double) (random.nextFloat() * 0.1F);
        double e = (double) pos.getY() + 0.55 - (double) (random.nextFloat() * 0.1F);
        double f = (double) pos.getZ() + 0.55 - (double) (random.nextFloat() * 0.1F);
        double g = 0.4F - (random.nextFloat() + random.nextFloat()) * 0.4F;

        if (random.nextInt(5) == 0) {
            world.addParticle(
                ParticleTypes.END_ROD,
                d + (double) direction.getOffsetX() * g,
                e + (double) direction.getOffsetY() * g,
                f + (double) direction.getOffsetZ() * g,
                random.nextGaussian() * 0.005,
                random.nextGaussian() * 0.005,
                random.nextGaussian() * 0.005
            );
        }

    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

//    public void register() {
//        RegistryHelpers.registerBlockWithItem(this, BLOCK_ID);
//        FabricItemGroupEventHelpers.addBlockToItemGroup(this, ItemGroups.FUNCTIONAL);
//    }
}
