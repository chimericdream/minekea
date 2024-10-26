package com.chimericdream.minekea.fluid;

import com.chimericdream.minekea.ModInfo;
import dev.architectury.core.block.ArchitecturyLiquidBlock;
import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.core.fluid.ArchitecturyFluidAttributes;
import dev.architectury.core.fluid.SimpleArchitecturyFluidAttributes;
import dev.architectury.core.item.ArchitecturyBucketItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class HoneyFluid extends ArchitecturyFlowingFluid.Source {
    public static final ArchitecturyFluidAttributes ATTRIBUTES = SimpleArchitecturyFluidAttributes.of(
            ModFluids.FLOWING_HONEY,
            ModFluids.HONEY_FLUID
        )
        .blockSupplier(() -> ModFluids.HONEY_SOURCE_BLOCK)
        .bucketItemSupplier(() -> ModFluids.HONEY_BUCKET)
        .slopeFindDistance(2)
        .dropOff(2)
        .tickDelay(40)
        .sourceTexture(Identifier.of(ModInfo.MOD_ID, "block/fluids/honey"))
        .flowingTexture(Identifier.of(ModInfo.MOD_ID, "block/fluids/honey/flowing"))
        .fillSound(SoundEvents.ITEM_BUCKET_FILL_LAVA)
        .color(0xFFFFFF);

    public HoneyFluid() {
        super(HoneyFluid.ATTRIBUTES);
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModFluids.HONEY_SOURCE_BLOCK.get().getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    @Override
    public @NotNull Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL_LAVA);
    }

    public static class Flowing extends ArchitecturyFlowingFluid.Flowing {
        public Flowing() {
            super(HoneyFluid.ATTRIBUTES);
        }

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
        }
    }

    public static class Block extends ArchitecturyLiquidBlock {
        public Block() {
            super(ModFluids.HONEY_FLUID, AbstractBlock.Settings.copy(Blocks.WATER));
        }

        @Override
        public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
            super.onEntityCollision(state, world, pos, entity);

            if (!world.isClient() && entity instanceof LivingEntity) {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, 2));
            }
        }
    }

    public static class Bucket extends ArchitecturyBucketItem {
        public Bucket() {
            super(ModFluids.HONEY_FLUID, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).arch$tab(ItemGroups.INGREDIENTS));
        }
    }
}

