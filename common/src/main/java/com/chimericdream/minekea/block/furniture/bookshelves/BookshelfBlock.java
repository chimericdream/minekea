package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

public class BookshelfBlock extends Block {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public BookshelfBlock(BlockConfig config) {
        super(config.getBaseSettings());

        BLOCK_ID = makeId(config.getMaterial());
        this.config = config;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("furniture/bookshelves/%s", material));
    }
}
