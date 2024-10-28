package com.chimericdream.minekea.fabric.block.building.stairs;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.stairs.VerticalStairsBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;
import java.util.function.Function;

public class VerticalStairsBlockDataGenerator implements FabricBlockDataGenerator {
    public static final Model VERTICAL_STAIRS_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/building/stairs/vertical")),
        Optional.empty(),
        TextureKey.ALL
    );

    public final VerticalStairsBlock BLOCK;

    public VerticalStairsBlockDataGenerator(Block block) {
        BLOCK = (VerticalStairsBlock) block;
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.PICKAXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block ingredient = BLOCK.config.getIngredient();

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
        translationBuilder.add(BLOCK, String.format("Vertical %s Stairs", BLOCK.config.getMaterialName()));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public static void doBlockStateModels(
        BlockStateModelGenerator blockStateModelGenerator,
        Block block,
        Identifier modelId
    ) {
        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(block)
                    .with(
                        When.create().set(VerticalStairsBlock.FACING, Direction.NORTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(VerticalStairsBlock.FACING, Direction.EAST),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(VerticalStairsBlock.FACING, Direction.SOUTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(VerticalStairsBlock.FACING, Direction.WEST),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
            );
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.ALL, BLOCK.config.getTexture());

        Identifier modelId = blockStateModelGenerator.createSubModel(BLOCK, "", VERTICAL_STAIRS_MODEL, unused -> textures);

        doBlockStateModels(blockStateModelGenerator, BLOCK, modelId);
    }
}
