package com.chimericdream.minekea.fabric.block.containers;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.block.containers.barrels.BarrelBlock;
import com.chimericdream.minekea.fabric.data.TextureGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
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

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;
import java.util.function.Function;

public class BarrelBlockDataGenerator implements FabricBlockDataGenerator {
    private final BarrelBlock BLOCK;

    public BarrelBlockDataGenerator(Block block) {
        BLOCK = (BarrelBlock) block;
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.AXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block plankIngredient = BLOCK.config.getIngredient();
        Block slabIngredient = BLOCK.config.getIngredient("slab");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 1)
            .pattern("PSP")
            .pattern("P P")
            .pattern("PSP")
            .input('P', plankIngredient)
            .input('S', slabIngredient)
            .criterion(FabricRecipeProvider.hasItem(plankIngredient),
                FabricRecipeProvider.conditionsFromItem(plankIngredient))
            .criterion(FabricRecipeProvider.hasItem(slabIngredient),
                FabricRecipeProvider.conditionsFromItem(slabIngredient))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("%s Barrel", BLOCK.config.getMaterialName()));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier bottomTexture = TextureUtils.block(BLOCK.BLOCK_ID, "_bottom");
        Identifier sideTexture = TextureUtils.block(BLOCK.BLOCK_ID, "_side");
        Identifier topTexture = TextureUtils.block(BLOCK.BLOCK_ID, "_top");
        Identifier topOpenTexture = TextureUtils.block(BLOCK.BLOCK_ID, "_top_open");

        TextureMap baseTextures = new TextureMap()
            .put(TextureKey.BOTTOM, bottomTexture)
            .put(TextureKey.SIDE, sideTexture)
            .put(TextureKey.TOP, topTexture);

        TextureMap openTextures = new TextureMap()
            .put(TextureKey.BOTTOM, bottomTexture)
            .put(TextureKey.SIDE, sideTexture)
            .put(TextureKey.TOP, topOpenTexture);

        Identifier baseModelId = blockStateModelGenerator.createSubModel(BLOCK, "", Models.CUBE_BOTTOM_TOP, unused -> baseTextures);
        Identifier openModelId = blockStateModelGenerator.createSubModel(BLOCK, "_open", Models.CUBE_BOTTOM_TOP, unused -> openTextures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(BLOCK)
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.DOWN)
                            .set(BarrelBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180))
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.EAST)
                            .set(BarrelBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.NORTH)
                            .set(BarrelBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90))
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.SOUTH)
                            .set(BarrelBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.UP)
                            .set(BarrelBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId))
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.WEST)
                            .set(BarrelBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270))

                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.DOWN)
                            .set(BarrelBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180))
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.EAST)
                            .set(BarrelBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90))
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.NORTH)
                            .set(BarrelBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90))
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.SOUTH)
                            .set(BarrelBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180))
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.UP)
                            .set(BarrelBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId))
                    .with(
                        When.create()
                            .set(BarrelBlock.FACING, Direction.WEST)
                            .set(BarrelBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270))
            );
    }

    public void generateTextures() {
        generateTextures(BLOCK.faceTextureKey, BLOCK.sideTextureKey, BLOCK.BLOCK_ID);
    }

    public static void generateTextures(String faceKey, String sideKey, Identifier blockId) {
        TextureGenerator.getInstance().generate(Registries.BLOCK.getKey(), instance -> {
            final Optional<BufferedImage> faceTexture = instance.getImage(faceKey);
            final Optional<BufferedImage> sideTexture = instance.getImage(sideKey);

            if (faceTexture.isPresent() && sideTexture.isPresent()) {
                BufferedImage faceImage = faceTexture.get();
                BufferedImage sideImage = sideTexture.get();

                BufferedImage bandsImage = instance.getMinekeaImage("block/barrels/barrel_bands").orElse(null);
                BufferedImage bottomOverlayImage = instance.getMinekeaImage("block/barrels/barrel_bottom_overlay").orElse(null);
                BufferedImage sideOverlayImage = instance.getMinekeaImage("block/barrels/barrel_side_overlay").orElse(null);
                BufferedImage topOverlayImage = instance.getMinekeaImage("block/barrels/barrel_top_overlay").orElse(null);
                BufferedImage topOpenOverlayImage = instance.getMinekeaImage("block/barrels/barrel_top_open_overlay").orElse(null);

                int fw = faceImage.getWidth();
                int fh = faceImage.getHeight();

                int sw = sideImage.getWidth();
                int sh = sideImage.getHeight();

                BufferedImage bottomCombined = new BufferedImage(fw, fh, BufferedImage.TYPE_INT_ARGB);
                BufferedImage sideCombined = new BufferedImage(sw, sh, BufferedImage.TYPE_INT_ARGB);
                BufferedImage topCombined = new BufferedImage(fw, fh, BufferedImage.TYPE_INT_ARGB);
                BufferedImage topOpenCombined = new BufferedImage(fw, fh, BufferedImage.TYPE_INT_ARGB);

                Graphics bg = bottomCombined.getGraphics();
                bg.drawImage(faceImage, 0, 0, null);
                bg.drawImage(bottomOverlayImage, 0, 0, fw, fh, null);
                bg.dispose();

                Graphics sg = sideCombined.getGraphics();
                sg.drawImage(sideImage, 0, 0, null);
                sg.drawImage(sideOverlayImage, 0, 0, sw, sh, null);
                sg.drawImage(bandsImage, 0, 0, sw, sh, null);
                sg.dispose();

                Graphics tg = topCombined.getGraphics();
                tg.drawImage(faceImage, 0, 0, null);
                tg.drawImage(topOverlayImage, 0, 0, fw, fh, null);
                tg.dispose();

                Graphics tog = topOpenCombined.getGraphics();
                tog.drawImage(faceImage, 0, 0, null);
                tog.drawImage(topOpenOverlayImage, 0, 0, fw, fh, null);
                tog.dispose();

                instance.generate(blockId.withSuffixedPath("_bottom"), bottomCombined);
                instance.generate(blockId.withSuffixedPath("_side"), sideCombined);
                instance.generate(blockId.withSuffixedPath("_top"), topCombined);
                instance.generate(blockId.withSuffixedPath("_top_open"), topOpenCombined);
            }
        });
    }

    public static class OakBarrelDataGenerator implements FabricBlockDataGenerator {
        @Override
        public void generateTextures() {
            BarrelBlockDataGenerator.generateTextures("stripped_oak_log", "oak_planks", Registries.BLOCK.getId(Blocks.BARREL));
        }
    }
}
