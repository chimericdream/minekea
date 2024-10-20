package com.chimericdream.minekea.fabric.block.building.general;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.crop.ModCrops;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Function;

public class WarpedNetherBricksDataGenerator implements FabricBlockDataGenerator {
    public static Block BLOCK = BuildingBlocks.WARPED_NETHER_BRICKS.get();

    public Block getBlock() {
        return BLOCK;
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.PICKAXE_MINEABLE)
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 1)
            .pattern("AB")
            .pattern("BA")
            .input('A', ModCrops.WARPED_WART_ITEM.get())
            .input('B', Items.NETHER_BRICK)
            .criterion(FabricRecipeProvider.hasItem(ModCrops.WARPED_WART_ITEM.get()),
                FabricRecipeProvider.conditionsFromItem(ModCrops.WARPED_WART_ITEM.get()))
            .criterion(FabricRecipeProvider.hasItem(Items.NETHER_BRICK),
                FabricRecipeProvider.conditionsFromItem(Items.NETHER_BRICK))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, "Warped Nether Bricks");
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BLOCK);
    }
}
