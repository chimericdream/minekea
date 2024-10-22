package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.util.Identifier;

public class SlabBlock extends net.minecraft.block.SlabBlock {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public SlabBlock(BlockConfig config) {
        super(config.getBaseSettings());

        BLOCK_ID = makeId(config.getMaterial());
        this.config = config;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("building/slabs/%s", material));
    }
}
