package com.chimericdream.minekea.block.decorations.lighting;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

public class LanternBlock extends net.minecraft.block.LanternBlock {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public LanternBlock(BlockConfig config, String name) {
        super(AbstractBlock.Settings.copy(Blocks.LANTERN).nonOpaque());

        this.BLOCK_ID = makeId(name);
        this.config = config;
    }

    public static Identifier makeId(String name) {
        return Identifier.of(ModInfo.MOD_ID, String.format("decorations/lighting/%s_lantern", name));
    }
}
