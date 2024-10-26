package com.chimericdream.minekea.fabric.block.building.storage;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.colors.ColorHelpers;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.storage.DyeBlock;
import com.chimericdream.minekea.fabric.data.blockstate.suppliers.CustomBlockStateModelSupplier;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class DyeBlockDataGenerator implements FabricBlockDataGenerator {
    public final DyeBlock BLOCK;

    private static final Model DYE_BLOCK_MODEL = new CustomBlockStateModelSupplier.CustomBlockModel(
        BlockConfig.RenderType.TRANSLUCENT,
        Optional.of(Identifier.of("minekea:block/storage/dye_block")),
        Optional.empty(),
        TextureKey.BOTTOM,
        TextureKey.SIDE,
        TextureKey.TOP
    );

    public DyeBlockDataGenerator(Block block) {
        this.BLOCK = (DyeBlock) block;
    }

    public void configureRecipes(RecipeExporter exporter) {
        Item dye = ColorHelpers.getDye(BLOCK.color);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 1)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .input('#', dye)
            .criterion(FabricRecipeProvider.hasItem(dye),
                FabricRecipeProvider.conditionsFromItem(dye))
            .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, dye, 9)
            .input(BLOCK)
            .criterion(FabricRecipeProvider.hasItem(BLOCK),
                FabricRecipeProvider.conditionsFromItem(BLOCK))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("Compressed %s Dye", ColorHelpers.getName(BLOCK.color)));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.BOTTOM, Identifier.of(ModInfo.MOD_ID, String.format("block/storage/dyes/%s/bottom", BLOCK.color)))
            .put(TextureKey.SIDE, Identifier.of(ModInfo.MOD_ID, String.format("block/storage/dyes/%s/side", BLOCK.color)))
            .put(TextureKey.TOP, Identifier.of(ModInfo.MOD_ID, String.format("block/storage/dyes/%s/top", BLOCK.color)));

        blockStateModelGenerator.registerSingleton(
            BLOCK,
            textures,
            DYE_BLOCK_MODEL
        );
    }
}
