package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.util.Identifier;

public class CompressedMinekeaBlock extends CompressedBlock {
    public final Identifier baseBlockId;

    public CompressedMinekeaBlock(
        BlockConfig config,
        int compressionLevel,
        Identifier baseBlockId
    ) {
        super(config, compressionLevel);

        this.baseBlockId = baseBlockId;

        if (compressionLevel > 1) {
            PARENT_BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/compressed/%s/%dx", config.getMaterial(), compressionLevel - 1));
        } else {
            PARENT_BLOCK_ID = baseBlockId;
        }
    }
}
