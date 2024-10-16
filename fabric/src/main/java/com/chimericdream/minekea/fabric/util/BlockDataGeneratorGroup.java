package com.chimericdream.minekea.fabric.util;

import com.chimericdream.lib.blocks.BlockDataGenerator;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Function;

public interface BlockDataGeneratorGroup {
    List<FabricBlockDataGenerator> getBlockGenerators();

    default void configureRecipes(RecipeExporter exporter) {
        getBlockGenerators().forEach(generator -> generator.configureRecipes(exporter));
    }

    default void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator lootTableGenerator) {
        getBlockGenerators().forEach(generator -> generator.configureBlockLootTables(registryLookup, lootTableGenerator));
    }

    default void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        getBlockGenerators().forEach(generator -> generator.configureBlockStateModels(blockStateModelGenerator));
    }

    default void configureItemModels(ItemModelGenerator itemModelGenerator) {
        getBlockGenerators().forEach(generator -> generator.configureItemModels(itemModelGenerator));
    }

    default void generateTextures() {
        getBlockGenerators().forEach(BlockDataGenerator::generateTextures);
    }

    default void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBlockGenerators().forEach(generator -> generator.configureBlockTags(registryLookup, getBuilder));
    }

    default void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        getBlockGenerators().forEach(generator -> generator.configureItemTags(registryLookup, getBuilder));
    }

    default void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        getBlockGenerators().forEach(generator -> generator.configureTranslations(registryLookup, translationBuilder));
    }
}
