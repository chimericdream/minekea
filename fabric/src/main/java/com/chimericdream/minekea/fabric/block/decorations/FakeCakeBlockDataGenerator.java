package com.chimericdream.minekea.fabric.block.decorations;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.tags.CommonBlockTags;
import com.chimericdream.minekea.block.decorations.DecorationBlocks;
import com.chimericdream.minekea.block.decorations.FakeCakeBlock;
import com.chimericdream.minekea.fabric.data.model.ModelUtils;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class FakeCakeBlockDataGenerator implements FabricBlockDataGenerator {
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(CommonBlockTags.SHEARS_MINEABLE)
            .setReplace(false)
            .add(DecorationBlocks.FAKE_CAKE.get());
    }

    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorationBlocks.FAKE_CAKE.get(), 3)
            .pattern("AAA")
            .pattern("BEB")
            .pattern("CCC")
            .input('A', Items.WHITE_CARPET)
            .input('B', Items.WHITE_DYE)
            .input('C', Items.BROWN_WOOL)
            .input('E', Items.REDSTONE)
            .criterion(FabricRecipeProvider.hasItem(Items.WHITE_CARPET),
                FabricRecipeProvider.conditionsFromItem(Items.WHITE_CARPET))
            .criterion(FabricRecipeProvider.hasItem(Items.WHITE_DYE),
                FabricRecipeProvider.conditionsFromItem(Items.WHITE_DYE))
            .criterion(FabricRecipeProvider.hasItem(Items.BROWN_WOOL),
                FabricRecipeProvider.conditionsFromItem(Items.BROWN_WOOL))
            .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE),
                FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(DecorationBlocks.FAKE_CAKE.get(), "Cake");
        translationBuilder.add(FakeCakeBlock.TOOLTIP_KEY, "This cake is a lie!");
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = ModelIds.getBlockModelId(Blocks.CAKE);
        blockStateModelGenerator.blockStateCollector
            .accept(
                VariantsBlockStateSupplier.create(
                    DecorationBlocks.FAKE_CAKE.get(),
                    BlockStateVariant.create().put(VariantSettings.MODEL, identifier)
                )
            );
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(DecorationBlocks.FAKE_CAKE.get());
    }

    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        ModelUtils.registerGeneratedItem(itemModelGenerator, DecorationBlocks.FAKE_CAKE.get(), Registries.BLOCK.getId(Blocks.CAKE));
    }
}
