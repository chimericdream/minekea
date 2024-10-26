package com.chimericdream.minekea.fluid;

import com.chimericdream.minekea.ModInfo;
import dev.architectury.core.block.ArchitecturyLiquidBlock;
import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.core.fluid.ArchitecturyFluidAttributes;
import dev.architectury.core.fluid.SimpleArchitecturyFluidAttributes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MilkFluid extends ArchitecturyFlowingFluid.Source {
    public static final ArchitecturyFluidAttributes ATTRIBUTES = SimpleArchitecturyFluidAttributes.of(
            ModFluids.FLOWING_MILK,
            ModFluids.MILK_FLUID
        )
        .blockSupplier(() -> ModFluids.MILK_SOURCE_BLOCK)
        .slopeFindDistance(2)
        .dropOff(2)
        .tickDelay(10)
        .sourceTexture(Identifier.of(ModInfo.MOD_ID, "block/fluids/milk"))
        .flowingTexture(Identifier.of(ModInfo.MOD_ID, "block/fluids/milk/flowing"))
        .fillSound(SoundEvents.ITEM_BUCKET_FILL)
        .color(0xFFFFFF);

    public MilkFluid() {
        super(MilkFluid.ATTRIBUTES);
    }

    @Override
    public Item getBucketItem() {
        return Items.MILK_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModFluids.MILK_SOURCE_BLOCK.get().getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    public static class Flowing extends ArchitecturyFlowingFluid.Flowing {
        public Flowing() {
            super(MilkFluid.ATTRIBUTES);
        }

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
        }
    }

    public static class Block extends ArchitecturyLiquidBlock {
        public Block() {
            super(ModFluids.MILK_FLUID, AbstractBlock.Settings.copy(Blocks.WATER));
        }

        @Override
        public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
            super.onEntityCollision(state, world, pos, entity);

            int level = state.get(FluidBlock.LEVEL);

            if (!world.isClient() && entity instanceof LivingEntity && level == 0) {
                ((LivingEntity) entity).clearStatusEffects();
            }
        }
    }
}
