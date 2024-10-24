package com.chimericdream.minekea.fabric.item.tools;

import com.chimericdream.lib.fabric.items.FabricItemDataGenerator;
import com.chimericdream.lib.tags.CommonItemTags;
import com.chimericdream.minekea.item.Tools;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Function;

public class WrenchItemDataGenerator implements FabricItemDataGenerator {
    private final Item ITEM;

    public WrenchItemDataGenerator() {
        ITEM = Tools.WRENCH_ITEM.get();
    }

//    @Override
//    public void register() {
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
//            .register((itemGroup) -> {
//                itemGroup.add(this);
//            });
//    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ITEM, 1)
            .pattern(" # ")
            .pattern(" ##")
            .pattern("#  ")
            .input('#', net.minecraft.item.Items.IRON_INGOT)
            .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
            .offerTo(exporter);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(CommonItemTags.WRENCHES)
            .setReplace(false)
            .add(ITEM);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(ITEM, "Wrench");
    }
}
