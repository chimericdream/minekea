package com.chimericdream.minekea.fabric.block.furniture;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.bookshelves.BookshelfBlock;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Function;

public class BookshelfBlockDataGenerator implements FabricBlockDataGenerator {
    protected final BookshelfBlock BLOCK;

    public BookshelfBlockDataGenerator(Block block) {
        BLOCK = (BookshelfBlock) block;
    }

    protected static final Model BOOKSHELF_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/bookshelf")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.SHELF
    );

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.ENCHANTMENT_POWER_PROVIDER).setReplace(false).add(BLOCK);
        getBuilder.apply(BlockTags.AXE_MINEABLE).setReplace(false).add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block ingredient = BLOCK.config.getIngredient();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 3)
            .pattern("###")
            .pattern("XXX")
            .pattern("###")
            .input('#', ingredient)
            .input('X', Items.BOOK)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .criterion(FabricRecipeProvider.hasItem(Items.BOOK),
                FabricRecipeProvider.conditionsFromItem(Items.BOOK))
            .offerTo(exporter);
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK, generator.drops(BLOCK, Items.BOOK, ConstantLootNumberProvider.create(3)));
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("%s Bookshelf", BLOCK.config.getMaterialName()));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap().put(MinekeaTextures.MATERIAL, BLOCK.config.getTexture());

        Identifier variant0Id = blockStateModelGenerator.createSubModel(BLOCK, "_v0", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf0")));
        Identifier variant1Id = blockStateModelGenerator.createSubModel(BLOCK, "_v1", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf1")));
        Identifier variant2Id = blockStateModelGenerator.createSubModel(BLOCK, "_v2", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf2")));
        Identifier variant3Id = blockStateModelGenerator.createSubModel(BLOCK, "_v3", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf3")));
        Identifier variant4Id = blockStateModelGenerator.createSubModel(BLOCK, "_v4", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf4")));
        Identifier variant5Id = blockStateModelGenerator.createSubModel(BLOCK, "_v5", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf5")));
        Identifier variant6Id = blockStateModelGenerator.createSubModel(BLOCK, "_v6", BOOKSHELF_MODEL, unused -> textures.put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf6")));

        blockStateModelGenerator.blockStateCollector.accept(
            VariantsBlockStateSupplier.create(
                BLOCK,
                BlockStateVariant.create().put(VariantSettings.MODEL, variant0Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant1Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant2Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant3Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant4Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant5Id),
                BlockStateVariant.create().put(VariantSettings.MODEL, variant6Id)
            )
        );

        blockStateModelGenerator.registerParentedItemModel(BLOCK, variant0Id);
    }
}
