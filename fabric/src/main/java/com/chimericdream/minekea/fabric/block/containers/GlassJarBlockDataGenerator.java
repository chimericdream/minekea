package com.chimericdream.minekea.fabric.block.containers;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.tag.MinekeaItemTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.chimericdream.minekea.block.containers.ContainerBlocks.GLASS_JAR;
import static com.chimericdream.minekea.block.containers.GlassJarBlock.ALLOWED_ITEMS;

public class GlassJarBlockDataGenerator implements FabricBlockDataGenerator {
    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        FabricTagProvider<Item>.FabricTagBuilder builder = getBuilder.apply(MinekeaItemTags.GLASS_JAR_STORABLE).setReplace(false);

        for (String id : ALLOWED_ITEMS.keySet()) {
            builder.add(Identifier.of(id));
        }
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, GLASS_JAR.get(), 3)
            .pattern(" L ")
            .pattern("G G")
            .pattern("GGG")
            .input('L', ItemTags.PLANKS)
            .input('G', Items.GLASS_PANE)
            .criterion(FabricRecipeProvider.hasItem(Items.GLASS_PANE),
                FabricRecipeProvider.conditionsFromItem(Items.GLASS_PANE))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(GLASS_JAR.get(), "Glass Jar");
    }
}
