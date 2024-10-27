package com.chimericdream.minekea.block.furniture.doors;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.DoorBlock;
import net.minecraft.util.Identifier;

public class BookshelfDoorBlock extends DoorBlock {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public BookshelfDoorBlock(BlockSetType type, BlockConfig config) {
        super(type, AbstractBlock.Settings.copy(config.getIngredient()));

        BLOCK_ID = makeId(config.getMaterial());
        this.config = config;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("furniture/doors/bookshelves/%s", material));
    }
}
