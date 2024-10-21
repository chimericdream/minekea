package com.chimericdream.minekea.fabric.block.building;

import com.chimericdream.lib.colors.ColorHelpers;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.block.building.dyed.DyedBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.Optional;
import java.util.function.Function;

public class DyedBlockDataGenerator implements FabricBlockDataGenerator {
    public DyedBlock BLOCK;

    public DyedBlockDataGenerator(Block block) {
        BLOCK = (DyedBlock) block;
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.PICKAXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block parentBlock = BLOCK.config.getIngredient();
        Item dye = ColorHelpers.getDye(BLOCK.color);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 8)
            .pattern("###")
            .pattern("#D#")
            .pattern("###")
            .input('#', parentBlock)
            .input('D', dye)
            .criterion(FabricRecipeProvider.hasItem(parentBlock),
                FabricRecipeProvider.conditionsFromItem(parentBlock))
            .criterion(FabricRecipeProvider.hasItem(dye),
                FabricRecipeProvider.conditionsFromItem(dye))
            .offerTo(exporter);
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("%s Dyed %s", ColorHelpers.getName(BLOCK.color), BLOCK.config.getMaterialName()));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BLOCK);
    }
}
