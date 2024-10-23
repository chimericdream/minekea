package com.chimericdream.minekea.fabric.crop;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.crop.ModCrops;
import com.chimericdream.minekea.crop.WarpedWartPlantBlock;
import com.chimericdream.minekea.fabric.data.blockstate.suppliers.CustomBlockStateModelSupplier;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;

public class WarpedWartCropDataGenerator implements FabricBlockDataGenerator {
    public static final Block BLOCK = ModCrops.WARPED_WART_PLANT_BLOCK.get();

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        RegistryWrapper.Impl<Enchantment> impl = registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        generator.addDrop(
            BLOCK,
            block -> LootTable.builder()
                .pool(
                    generator.applyExplosionDecay(
                        block,
                        LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1.0F))
                            .with(
                                ItemEntry.builder(ModCrops.WARPED_WART_ITEM.get())
                                    .apply(
                                        SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F))
                                            .conditionally(
                                                BlockStatePropertyLootCondition
                                                    .builder(block)
                                                    .properties(StatePredicate.Builder.create().exactMatch(WarpedWartPlantBlock.AGE, 3))
                                            )
                                    )
                                    .apply(
                                        ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))
                                            .conditionally(
                                                BlockStatePropertyLootCondition
                                                    .builder(block)
                                                    .properties(StatePredicate.Builder.create().exactMatch(WarpedWartPlantBlock.AGE, 3))
                                            )
                                    )
                            )
                    )
                )
        );
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, "Warped Wart");
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        CustomBlockStateModelSupplier.registerCrop(blockStateModelGenerator, BLOCK, Properties.AGE_3, 0, 1, 1, 2);
    }
}
