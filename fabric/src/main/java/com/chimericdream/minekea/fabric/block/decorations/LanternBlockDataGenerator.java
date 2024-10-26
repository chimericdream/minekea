package com.chimericdream.minekea.fabric.block.decorations;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.block.decorations.lighting.LanternBlock;
import com.chimericdream.minekea.fabric.data.model.ModelUtils;
import com.chimericdream.minekea.tag.MinekeaBlockTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Function;

public class LanternBlockDataGenerator implements FabricBlockDataGenerator {
    public LanternBlock BLOCK;

    public LanternBlockDataGenerator(Block block) {
        BLOCK = (LanternBlock) block;
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(MinekeaBlockTags.LANTERNS).add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Item ingredient = BLOCK.config.getItem();

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BLOCK, 1)
            .pattern("###")
            .pattern("#P#")
            .pattern("#T#")
            .input('#', Items.IRON_NUGGET)
            .input('P', Items.ENDER_PEARL)
            .input('T', Items.TORCH)
            .criterion(FabricRecipeProvider.hasItem(Items.IRON_NUGGET),
                FabricRecipeProvider.conditionsFromItem(Items.IRON_NUGGET))
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .criterion(FabricRecipeProvider.hasItem(Items.TORCH),
                FabricRecipeProvider.conditionsFromItem(Items.TORCH))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, BLOCK.config.getName());
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        ModelUtils.registerLanternBlock(blockStateModelGenerator, BLOCK, BLOCK.BLOCK_ID);
    }

    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        ModelUtils.registerGeneratedItem(itemModelGenerator, BLOCK, BLOCK.BLOCK_ID);
    }
}
