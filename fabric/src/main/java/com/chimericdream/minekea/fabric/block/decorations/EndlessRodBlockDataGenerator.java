package com.chimericdream.minekea.fabric.block.decorations;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.block.decorations.DecorationBlocks;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

public class EndlessRodBlockDataGenerator implements FabricBlockDataGenerator {
    public void configureRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorationBlocks.ENDLESS_ROD.get(), 1)
            .input(Items.END_ROD)
            .criterion(FabricRecipeProvider.hasItem(Items.END_ROD),
                FabricRecipeProvider.conditionsFromItem(Items.END_ROD))
            .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.END_ROD, 1)
            .input(DecorationBlocks.ENDLESS_ROD.get())
            .criterion(FabricRecipeProvider.hasItem(DecorationBlocks.ENDLESS_ROD.get()),
                FabricRecipeProvider.conditionsFromItem(DecorationBlocks.ENDLESS_ROD.get()))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(DecorationBlocks.ENDLESS_ROD.get(), "End(less) Rod");
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(DecorationBlocks.ENDLESS_ROD.get());
    }
}
