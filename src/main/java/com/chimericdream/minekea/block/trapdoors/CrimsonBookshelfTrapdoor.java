package com.chimericdream.minekea.block.trapdoors;

import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CrimsonBookshelfTrapdoor extends PublicTrapdoorBlock {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "bookshelves/trapdoors/crimson_bookshelf_trapdoor");

    public CrimsonBookshelfTrapdoor() {
        super(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).sounds(BlockSoundGroup.WOOD));
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));
    }
}
