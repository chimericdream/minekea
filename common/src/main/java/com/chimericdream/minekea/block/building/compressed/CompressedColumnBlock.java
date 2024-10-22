package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.lib.blocks.BlockConfig;

public class CompressedColumnBlock extends CompressedBlock {
    public final String sideTextureSuffix;
    public final String endTextureSuffix;

    public CompressedColumnBlock(BlockConfig config, int compressionLevel, String sideTextureSuffix, String endTextureSuffix) {
        super(config, compressionLevel);

        this.sideTextureSuffix = sideTextureSuffix;
        this.endTextureSuffix = endTextureSuffix;
    }
}
