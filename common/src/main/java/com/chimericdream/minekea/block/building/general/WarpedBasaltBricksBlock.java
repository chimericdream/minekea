package com.chimericdream.minekea.block.building.general;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

public class WarpedBasaltBricksBlock extends Block {
    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "building/general/warped_basalt_bricks");

    public WarpedBasaltBricksBlock() {
        super(AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT));
    }
}
