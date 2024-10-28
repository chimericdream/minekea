package com.chimericdream.minekea.fabric.block.building.stairs;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.stairs.VerticalBookshelfStairsBlock;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class VerticalBookshelfStairsBlockDataGenerator extends VerticalStairsBlockDataGenerator {
    protected static final Model VERTICAL_BOOKSHELF_STAIRS_MODEL = makeModel("block/building/stairs/bookshelves/vertical");

    public VerticalBookshelfStairsBlockDataGenerator(Block block) {
        super(block);
    }

    protected static Model makeModel(String path) {
        return new Model(
            Optional.of(Identifier.of(ModInfo.MOD_ID, path)),
            Optional.empty(),
            MinekeaTextures.SHELF,
            MinekeaTextures.MATERIAL
        );
    }

    public void configureRecipes(RecipeExporter exporter) {
        Identifier ingredientId = ((VerticalBookshelfStairsBlock) BLOCK).BASE_BLOCK_ID;
        Block ingredient = Registries.BLOCK.get(ingredientId);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 8)
            .pattern("###")
            .pattern(" ##")
            .pattern("  #")
            .input('#', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("Vertical %s Bookshelf Stairs", BLOCK.config.getMaterialName()));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf0"))
            .put(MinekeaTextures.MATERIAL, BLOCK.config.getTexture());

        Identifier modelId = blockStateModelGenerator.createSubModel(BLOCK, "", VERTICAL_BOOKSHELF_STAIRS_MODEL, unused -> textures);

        doBlockStateModels(blockStateModelGenerator, BLOCK, modelId);
    }
}
