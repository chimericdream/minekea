package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.Identifier;

public class WallBlock extends net.minecraft.block.WallBlock {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public WallBlock(BlockConfig config) {
        super(AbstractBlock.Settings.copy(config.getIngredient()));

        BLOCK_ID = makeId(config.getMaterial());
        this.config = config;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("building/walls/%s", material));
    }
}
