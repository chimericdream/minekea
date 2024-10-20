package com.chimericdream.minekea.fabric.block.building.general;

import com.chimericdream.lib.colors.ColorHelpers;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.block.building.general.WaxBlock;
import com.chimericdream.minekea.item.WaxItems;
import com.chimericdream.minekea.item.ingredients.WaxItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Function;

public class WaxBlockDataGenerator implements FabricBlockDataGenerator {
    public WaxBlock BLOCK;

    public WaxBlockDataGenerator(Block block) {
        BLOCK = (WaxBlock) block;
    }

    public Block getBlock() {
        return BLOCK;
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.HOE_MINEABLE)
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Item ingredient = WaxItems.WAX_ITEMS.getOrDefault(BLOCK.color, WaxItems.WAX_ITEMS.get("plain")).get();

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BLOCK, 1)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .input('#', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ingredient, 9)
            .input(BLOCK)
            .criterion(FabricRecipeProvider.hasItem(BLOCK),
                FabricRecipeProvider.conditionsFromItem(BLOCK))
            .offerTo(exporter, WaxItem.makeId(BLOCK.color).withSuffixedPath("_from_block"));
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        if (BLOCK.color.equals("plain")) {
            translationBuilder.add(BLOCK, "Wax Block");

            return;
        }

        translationBuilder.add(BLOCK, String.format("%s Wax Block", ColorHelpers.getName(BLOCK.color)));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BLOCK);
    }
}
