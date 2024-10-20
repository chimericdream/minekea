package com.chimericdream.minekea.block.building.general;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.util.Identifier;

public class WaxBlock extends Block {
    public final Identifier BLOCK_ID;

    public final String color;

    public WaxBlock(String color) {
        super(AbstractBlock.Settings.copy(Blocks.HONEYCOMB_BLOCK).pistonBehavior(PistonBehavior.PUSH_ONLY).slipperiness(0.9F));

        BLOCK_ID = makeId(color);
        this.color = color;
    }

    public static Identifier makeId(String color) {
        return Identifier.of(ModInfo.MOD_ID, String.format("building/general/wax/%s", color));
    }
}
