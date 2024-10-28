package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.util.Identifier;

public class StairsBlock extends net.minecraft.block.StairsBlock {
    public Identifier BLOCK_ID;
    public final BlockConfig config;

    public StairsBlock(BlockConfig config) {
        super(config.getIngredient().getDefaultState(), config.getBaseSettings());

        BLOCK_ID = makeId(config.getMaterial());
        this.config = config;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("building/stairs/%s", material));
    }
}
