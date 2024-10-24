package com.chimericdream.minekea.fabric.item.tools;

import com.chimericdream.lib.fabric.items.FabricItemDataGenerator;
import com.chimericdream.minekea.item.Tools;
import com.chimericdream.minekea.item.tools.HammerItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

public class HammerItemDataGenerator implements FabricItemDataGenerator {
    private final HammerItem ITEM;

    public HammerItemDataGenerator(Item item) {
        ITEM = (HammerItem) item;
    }

//    @Override
//    public void register() {
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
//            .register(itemGroup -> itemGroup.add(ITEM));
//    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        if (ITEM.itemIngredient == null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ITEM, 1)
                .pattern("ISI")
                .pattern(" S ")
                .pattern(" S ")
                .input('I', ITEM.itemIngredientTag)
                .input('S', Items.STICK)
                .criterion("has_item_from_tag",
                    FabricRecipeProvider.conditionsFromTag(ITEM.itemIngredientTag))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                    FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

            return;
        }

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ITEM, 1)
            .pattern("ISI")
            .pattern(" S ")
            .pattern(" S ")
            .input('I', ITEM.itemIngredient)
            .input('S', Items.STICK)
            .criterion(FabricRecipeProvider.hasItem(ITEM.itemIngredient),
                FabricRecipeProvider.conditionsFromItem(ITEM.itemIngredient))
            .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                FabricRecipeProvider.conditionsFromItem(Items.STICK))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(ITEM, String.format("%s Hammer", ITEM.materialName));
    }

    public static class NetheriteUpgrade implements FabricItemDataGenerator {
        @Override
        public void configureRecipes(RecipeExporter exporter) {
            SmithingTransformRecipeJsonBuilder.create(
                    Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                    Ingredient.ofItems(Tools.DIAMOND_HAMMER_ITEM.get()),
                    Ingredient.ofItems(Items.NETHERITE_INGOT),
                    RecipeCategory.TOOLS,
                    Tools.NETHERITE_HAMMER_ITEM.get()
                )
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                    FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .criterion(FabricRecipeProvider.hasItem(Tools.DIAMOND_HAMMER_ITEM.get()),
                    FabricRecipeProvider.conditionsFromItem(Tools.DIAMOND_HAMMER_ITEM.get()))
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_INGOT),
                    FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, ((HammerItem) Tools.NETHERITE_HAMMER_ITEM.get()).ITEM_ID.withSuffixedPath("_upgrade_from_diamond"));
        }
    }
}
