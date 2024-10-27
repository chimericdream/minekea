package com.chimericdream.minekea.fabric.block.containers;

import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.minekea.block.containers.crates.TrappedCrateBlock;
import com.chimericdream.minekea.fabric.data.TextureGenerator;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class TrappedCrateBlockDataGenerator extends CrateBlockDataGenerator {
    public TrappedCrateBlockDataGenerator(Block block) {
        super(block);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, BLOCK, 1)
            .input(((TrappedCrateBlock) BLOCK).BASE_CRATE.get())
            .input(Items.TRIPWIRE_HOOK)
            .criterion(FabricRecipeProvider.hasItem(((TrappedCrateBlock) BLOCK).BASE_CRATE.get()),
                FabricRecipeProvider.conditionsFromItem(((TrappedCrateBlock) BLOCK).BASE_CRATE.get()))
            .criterion(FabricRecipeProvider.hasItem(Items.TRIPWIRE_HOOK),
                FabricRecipeProvider.conditionsFromItem(Items.TRIPWIRE_HOOK))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("Trapped %s Crate", BLOCK.config.getMaterialName()));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.BRACE, BLOCK.config.getTexture("brace"))
            .put(MinekeaTextures.MATERIAL, TextureUtils.block(BLOCK.BLOCK_ID, "_material"));

        configureBlockStateModels(blockStateModelGenerator, textures);
    }

    @Override
    public void generateTextures() {
        TextureGenerator.getInstance().generate(Registries.BLOCK.getKey(), instance -> {
            final Optional<BufferedImage> source = instance.getImage(String.format("%s_planks", BLOCK.config.getMaterial()));

            if (source.isPresent()) {
                BufferedImage sourceImage = source.get();
                BufferedImage overlayImage = instance.getMinekeaImage("block/crates/trapped_overlay").orElse(null);

                int w = sourceImage.getWidth();
                int h = sourceImage.getHeight();

                BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

                Graphics g = combined.getGraphics();
                g.drawImage(sourceImage, 0, 0, null);
                g.drawImage(overlayImage, 0, 0, w, h, null);

                g.dispose();

                instance.generate(BLOCK.BLOCK_ID.withSuffixedPath("_material"), combined);
            }
        });
    }
}
