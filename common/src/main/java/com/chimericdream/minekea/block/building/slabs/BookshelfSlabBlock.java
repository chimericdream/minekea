package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.bookshelves.BookshelfBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.util.Identifier;

public class BookshelfSlabBlock extends SlabBlock {
    public final Identifier BLOCK_ID;
    public final Identifier BASE_BLOCK_ID;
    public final BlockConfig config;

    public BookshelfSlabBlock(BlockConfig config) {
        super(config.getBaseSettings());

        BLOCK_ID = makeId(config.getMaterial());
        BASE_BLOCK_ID = BookshelfBlock.makeId(config.getMaterial());
        this.config = config;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("building/slabs/bookshelves/%s", material));
    }
}
