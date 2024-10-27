package com.chimericdream.minekea.fabric.block.furniture;

import com.chimericdream.minekea.block.furniture.shelves.ShelfBlock;
import com.chimericdream.minekea.fabric.data.model.ModelUtils;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

public class FloatingShelfBlockDataGenerator extends ShelfBlockDataGenerator {
    public FloatingShelfBlockDataGenerator(Block block) {
        super(block);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        Block slabIngredient = BLOCK.config.getIngredient("slab");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 3)
            .pattern("XXX")
            .pattern("# #")
            .pattern("XXX")
            .input('X', slabIngredient)
            .input('#', Items.IRON_INGOT)
            .criterion(FabricRecipeProvider.hasItem(slabIngredient),
                FabricRecipeProvider.conditionsFromItem(slabIngredient))
            .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("%s Floating Shelf", BLOCK.config.getMaterialName()));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block plankIngredient = BLOCK.config.getIngredient("planks");

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.PLANKS, TextureMap.getId(plankIngredient));

        Identifier subModelId = blockStateModelGenerator.createSubModel(BLOCK, "", FLOATING_SHELF_MODEL, unused -> textures);

        ModelUtils.registerBlockWithWallSide(blockStateModelGenerator, ShelfBlock.WALL_SIDE, BLOCK, subModelId);
    }
}
