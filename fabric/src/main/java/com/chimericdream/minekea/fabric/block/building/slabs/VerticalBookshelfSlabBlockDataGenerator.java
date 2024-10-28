package com.chimericdream.minekea.fabric.block.building.slabs;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.slabs.VerticalBookshelfSlabBlock;
import com.chimericdream.minekea.block.building.slabs.VerticalSlabBlock;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;
import java.util.function.Function;

public class VerticalBookshelfSlabBlockDataGenerator implements FabricBlockDataGenerator {
    protected static final Model VERTICAL_BOOKSHELF_SLAB_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/building/slabs/bookshelves/vertical")),
        Optional.empty(),
        MinekeaTextures.SHELF,
        MinekeaTextures.MATERIAL
    );

    private final VerticalBookshelfSlabBlock BLOCK;

    public VerticalBookshelfSlabBlockDataGenerator(Block block) {
        BLOCK = (VerticalBookshelfSlabBlock) block;
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.PICKAXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 6)
            .pattern("#")
            .pattern("#")
            .pattern("#")
            .input('#', Registries.BLOCK.get(BLOCK.BASE_BLOCK_ID))
            .criterion(FabricRecipeProvider.hasItem(Registries.BLOCK.get(BLOCK.BASE_BLOCK_ID)),
                FabricRecipeProvider.conditionsFromItem(Registries.BLOCK.get(BLOCK.BASE_BLOCK_ID)))
            .offerTo(exporter);
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
//        generator.addDrop(this, generator.slabDrops(this));
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("Vertical %s Bookshelf Slab", BLOCK.config.getMaterialName()));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier textureId = BLOCK.config.getTexture();

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf0"))
            .put(MinekeaTextures.MATERIAL, textureId);

        Identifier modelId = blockStateModelGenerator.createSubModel(BLOCK, "", VERTICAL_BOOKSHELF_SLAB_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(BLOCK)
                    .with(
                        When.create().set(VerticalSlabBlock.FACING, Direction.NORTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(VerticalSlabBlock.FACING, Direction.EAST),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(VerticalSlabBlock.FACING, Direction.SOUTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(VerticalSlabBlock.FACING, Direction.WEST),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                            .put(VariantSettings.UVLOCK, true)
                    )
            );
    }
}
