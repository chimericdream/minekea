package com.chimericdream.minekea.fabric.util;

import com.chimericdream.lib.fabric.items.FabricItemDataGenerator;
import com.chimericdream.lib.items.ItemDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Function;

public interface ItemDataGeneratorGroup {
    List<FabricItemDataGenerator> getItemGenerators();

    default void configureRecipes(RecipeExporter exporter) {
        getItemGenerators().forEach(generator -> generator.configureRecipes(exporter));
    }

    default void configureItemModels(ItemModelGenerator itemModelGenerator) {
        getItemGenerators().forEach(generator -> generator.configureItemModels(itemModelGenerator));
    }

    default void generateTextures() {
        getItemGenerators().forEach(ItemDataGenerator::generateTextures);
    }

    default void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        getItemGenerators().forEach(generator -> generator.configureItemTags(registryLookup, getBuilder));
    }

    default void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        getItemGenerators().forEach(generator -> generator.configureTranslations(registryLookup, translationBuilder));
    }
}
