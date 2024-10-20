package com.chimericdream.minekea.fabric.crop;

import com.chimericdream.lib.fabric.items.FabricItemDataGenerator;
import com.chimericdream.minekea.crop.ModCrops;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

public class WarpedWartItemDataGenerator implements FabricItemDataGenerator {
    public static final Item ITEM = ModCrops.WARPED_WART_ITEM.get();

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ITEM, 9)
            .input(Blocks.WARPED_WART_BLOCK)
            .criterion(FabricRecipeProvider.hasItem(Blocks.WARPED_WART_BLOCK),
                FabricRecipeProvider.conditionsFromItem(Blocks.WARPED_WART_BLOCK))
            .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.WARPED_WART_BLOCK, 1)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .input('#', ITEM)
            .criterion(FabricRecipeProvider.hasItem(ITEM),
                FabricRecipeProvider.conditionsFromItem(ITEM))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(ITEM, "Warped Wart");
    }
}
