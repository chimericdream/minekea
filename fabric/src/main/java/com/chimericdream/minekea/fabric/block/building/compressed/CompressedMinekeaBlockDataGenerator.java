package com.chimericdream.minekea.fabric.block.building.compressed;

import com.chimericdream.minekea.block.building.compressed.CompressedMinekeaBlock;
import com.chimericdream.minekea.fabric.data.TextureGenerator;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;

import java.awt.*;
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

            if (source.isPresent()) {
                BufferedImage sourceImage = source.get();
                BufferedImage overlayImage = instance.getMinekeaImage(String.format("block/building/compressed/level-%d", BLOCK.compressionLevel)).orElse(null);

                BufferedImage combined = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

                Graphics g = combined.getGraphics();
                g.drawImage(sourceImage, 0, 0, null);
                g.drawImage(overlayImage, 0, 0, 16, 16, null);

                g.dispose();

                instance.generate(BLOCK.BLOCK_ID, combined);
            }
        });
    }
}
