package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.bookshelves.BookshelfBlock;
import net.minecraft.util.Identifier;

public class VerticalBookshelfSlabBlock extends VerticalSlabBlock {
    public final Identifier BASE_BLOCK_ID;

    public VerticalBookshelfSlabBlock(BlockConfig config) {
        super(config);

        BLOCK_ID = makeId(config.getMaterial());
        BASE_BLOCK_ID = BookshelfBlock.makeId(config.getMaterial());
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("building/slabs/bookshelves/vertical/%s", material));
    }
}
