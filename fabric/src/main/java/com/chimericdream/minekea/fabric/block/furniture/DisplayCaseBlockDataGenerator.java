package com.chimericdream.minekea.fabric.block.furniture;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.block.furniture.displaycases.DisplayCaseBlock;
import com.chimericdream.minekea.fabric.data.blockstate.suppliers.CustomBlockStateModelSupplier;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Function;

public class DisplayCaseBlockDataGenerator implements FabricBlockDataGenerator {
    private static final Model DISPLAY_CASE_MODEL = new CustomBlockStateModelSupplier.CustomBlockModel(
        BlockConfig.RenderType.CUTOUT,
        Optional.of(Identifier.of("minekea:block/furniture/display_case")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.STRIPPED_MATERIAL
    );

    private final DisplayCaseBlock BLOCK;

    public DisplayCaseBlockDataGenerator(Block block) {
        BLOCK = (DisplayCaseBlock) block;
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.AXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block plankIngredient = BLOCK.config.getIngredient("planks");
        Block logIngredient = BLOCK.config.getIngredient("log");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 1)
            .pattern(" G ")
            .pattern("X X")
            .pattern("###")
            .input('G', Blocks.GLASS)
            .input('X', plankIngredient)
            .input('#', logIngredient)
            .criterion(FabricRecipeProvider.hasItem(Blocks.GLASS),
                FabricRecipeProvider.conditionsFromItem(Blocks.GLASS))
            .criterion(FabricRecipeProvider.hasItem(plankIngredient),
                FabricRecipeProvider.conditionsFromItem(plankIngredient))
            .criterion(FabricRecipeProvider.hasItem(logIngredient),
                FabricRecipeProvider.conditionsFromItem(logIngredient))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("%s Display Case", BLOCK.config.getMaterialName()));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block logIngredient = BLOCK.config.getIngredient("log");
        Block strippedLogIngredient = Optional.ofNullable(BLOCK.config.getIngredient("stripped_log")).orElse(logIngredient);

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.MATERIAL, TextureMap.getId(logIngredient))
            .put(MinekeaTextures.STRIPPED_MATERIAL, TextureMap.getId(strippedLogIngredient));

        blockStateModelGenerator.registerSingleton(
            BLOCK,
            textures,
            DISPLAY_CASE_MODEL
        );
    }
}
