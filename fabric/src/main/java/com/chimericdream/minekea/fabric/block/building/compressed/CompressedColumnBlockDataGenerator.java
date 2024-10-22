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

    @Override
    public void generateTextures() {
        TextureGenerator.getInstance().generate(Registries.BLOCK.getKey(), instance -> {
            generateTexture(instance, BLOCK.config.getMaterial() + ((CompressedColumnBlock) BLOCK).endTextureSuffix, BLOCK.BLOCK_ID.withSuffixedPath("_end"));
            generateTexture(instance, BLOCK.config.getMaterial() + ((CompressedColumnBlock) BLOCK).sideTextureSuffix, BLOCK.BLOCK_ID.withSuffixedPath("_side"));
        });
    }
}
