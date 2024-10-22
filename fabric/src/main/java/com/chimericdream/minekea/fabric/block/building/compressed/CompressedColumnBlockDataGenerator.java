package com.chimericdream.minekea.fabric.block.building.compressed;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.compressed.CompressedColumnBlock;
import com.chimericdream.minekea.fabric.data.TextureGenerator;
import com.chimericdream.minekea.fabric.data.model.ModelUtils;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class CompressedColumnBlockDataGenerator extends CompressedBlockDataGenerator {
    public CompressedColumnBlockDataGenerator(Block block) {
        super(block);
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.END, Identifier.of(ModInfo.MOD_ID, String.format("block/%s_end", BLOCK.BLOCK_ID.getPath())))
            .put(TextureKey.SIDE, Identifier.of(ModInfo.MOD_ID, String.format("block/%s_side", BLOCK.BLOCK_ID.getPath())));

        Identifier subModelId = blockStateModelGenerator.createSubModel(BLOCK, "", Models.CUBE_COLUMN, unused -> textures);

        ModelUtils.registerBlockWithAxis(blockStateModelGenerator, CompressedColumnBlock.AXIS, BLOCK, subModelId);
    }

    private void generateTexture(TextureGenerator.Instance<Block> instance, String key, Identifier blockId) {
        final Optional<BufferedImage> source = instance.getImage(key);

        if (source.isPresent()) {
            BufferedImage sourceImage = source.get();
            BufferedImage overlayImage = instance.getMinekeaImage(String.format("block/building/compressed/level-%d", BLOCK.compressionLevel)).orElse(null);

            BufferedImage combined = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

            Graphics g = combined.getGraphics();
            g.drawImage(sourceImage, 0, 0, null);
            g.drawImage(overlayImage, 0, 0, 16, 16, null);

            g.dispose();

            instance.generate(blockId, combined);
        }
    }

    @Override
    public void generateTextures() {
        TextureGenerator.getInstance().generate(Registries.BLOCK.getKey(), instance -> {
            generateTexture(instance, BLOCK.config.getMaterial() + ((CompressedColumnBlock) BLOCK).endTextureSuffix, BLOCK.BLOCK_ID.withSuffixedPath("_end"));
            generateTexture(instance, BLOCK.config.getMaterial() + ((CompressedColumnBlock) BLOCK).sideTextureSuffix, BLOCK.BLOCK_ID.withSuffixedPath("_side"));
        });
    }
}
