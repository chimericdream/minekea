package com.chimericdream.minekea.fabric.item.ingredients;

import com.chimericdream.lib.colors.ColorHelpers;
import com.chimericdream.lib.fabric.items.FabricItemDataGenerator;
import com.chimericdream.minekea.item.ingredients.WaxItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

public class WaxItemDataGenerator implements FabricItemDataGenerator {
    public WaxItem ITEM;

    public WaxItemDataGenerator(Item item) {
        ITEM = (WaxItem) item;
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        CookingRecipeJsonBuilder.createSmelting(
                Ingredient.ofItems(ITEM.ingredient),
                RecipeCategory.MISC,
                ITEM,
                0.1f,
                200
            )
            .criterion(FabricRecipeProvider.hasItem(ITEM.ingredient),
                FabricRecipeProvider.conditionsFromItem(ITEM.ingredient))
            .offerTo(exporter);

        if (ITEM.color.equals("plain")) {
            CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItems(Items.HONEYCOMB),
                    RecipeCategory.MISC,
                    ITEM,
                    0.1f,
                    200
                )
                .criterion(FabricRecipeProvider.hasItem(Items.HONEYCOMB),
                    FabricRecipeProvider.conditionsFromItem(Items.HONEYCOMB))
                .offerTo(exporter, ITEM.ITEM_ID.withSuffixedPath("_from_honeycomb"));
        }
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        if (ITEM.color.equals("plain")) {
            translationBuilder.add(ITEM, "Wax");

            return;
        }

        translationBuilder.add(ITEM, String.format("%s Wax", ColorHelpers.getName(ITEM.color)));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ITEM, Models.GENERATED);
    }
}
