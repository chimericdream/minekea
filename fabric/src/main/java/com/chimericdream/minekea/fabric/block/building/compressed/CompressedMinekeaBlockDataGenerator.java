package com.chimericdream.minekea.fabric.block.building.compressed;

import com.chimericdream.minekea.block.building.compressed.CompressedMinekeaBlock;
import com.chimericdream.minekea.fabric.data.TextureGenerator;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;

import java.awt.image.BufferedImage;
import java.util.Optional;

public class CompressedMinekeaBlockDataGenerator extends CompressedBlockDataGenerator {
    public CompressedMinekeaBlockDataGenerator(Block block) {
        super(block);
    }

    @Override
    public void generateTextures() {
        TextureGenerator.getInstance().generate(Registries.BLOCK.getKey(), instance -> {
            final Optional<BufferedImage> source = instance.getMinekeaImage(((CompressedMinekeaBlock) BLOCK).baseBlockId.withPrefixedPath("block/").getPath());
            addTextureOverlay(instance, source, BLOCK.BLOCK_ID);
        });
    }
}
