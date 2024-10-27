package com.chimericdream.minekea.block.furniture.trapdoors;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.util.Identifier;

public class BookshelfTrapdoorBlock extends TrapdoorBlock {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public BookshelfTrapdoorBlock(BlockSetType type, BlockConfig config) {
        super(type, config.getBaseSettings());

        BLOCK_ID = makeId(config.getMaterial());
        this.config = config;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("furniture/trapdoors/bookshelves/%s", material));
    }
}
