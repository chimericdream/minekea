package com.chimericdream.minekea.block.furniture.trapdoors;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class Trapdoors implements ModThingGroup {
    public static final Item.Settings DEFAULT_TRAPDOOR_SETTINGS = new Item.Settings().arch$tab(ItemGroups.REDSTONE);

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> BOOKSHELF_TRAPDOOR_BLOCKS = new ArrayList<>();

    static {
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("acacia"), () -> new BookshelfTrapdoorBlock(BlockSetType.ACACIA, new BlockConfig().material("acacia").materialName("Acacia").ingredient(Bookshelves.BOOKSHELVES.get("acacia")).ingredient("planks", Blocks.ACACIA_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("bamboo"), () -> new BookshelfTrapdoorBlock(BlockSetType.BAMBOO, new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Bookshelves.BOOKSHELVES.get("bamboo")).ingredient("planks", Blocks.BAMBOO_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("birch"), () -> new BookshelfTrapdoorBlock(BlockSetType.BIRCH, new BlockConfig().material("birch").materialName("Birch").ingredient(Bookshelves.BOOKSHELVES.get("birch")).ingredient("planks", Blocks.BIRCH_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("cherry"), () -> new BookshelfTrapdoorBlock(BlockSetType.CHERRY, new BlockConfig().material("cherry").materialName("Cherry").ingredient(Bookshelves.BOOKSHELVES.get("cherry")).ingredient("planks", Blocks.CHERRY_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("crimson"), () -> new BookshelfTrapdoorBlock(BlockSetType.CRIMSON, new BlockConfig().material("crimson").materialName("Crimson").ingredient(Bookshelves.BOOKSHELVES.get("crimson")).ingredient("planks", Blocks.CRIMSON_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("dark_oak"), () -> new BookshelfTrapdoorBlock(BlockSetType.DARK_OAK, new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Bookshelves.BOOKSHELVES.get("dark_oak")).ingredient("planks", Blocks.DARK_OAK_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("jungle"), () -> new BookshelfTrapdoorBlock(BlockSetType.JUNGLE, new BlockConfig().material("jungle").materialName("Jungle").ingredient(Bookshelves.BOOKSHELVES.get("jungle")).ingredient("planks", Blocks.JUNGLE_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("mangrove"), () -> new BookshelfTrapdoorBlock(BlockSetType.MANGROVE, new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Bookshelves.BOOKSHELVES.get("mangrove")).ingredient("planks", Blocks.MANGROVE_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("oak"), () -> new BookshelfTrapdoorBlock(BlockSetType.OAK, new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.BOOKSHELF).ingredient("planks", Blocks.OAK_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("spruce"), () -> new BookshelfTrapdoorBlock(BlockSetType.SPRUCE, new BlockConfig().material("spruce").materialName("Spruce").ingredient(Bookshelves.BOOKSHELVES.get("spruce")).ingredient("planks", Blocks.SPRUCE_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));
        BOOKSHELF_TRAPDOOR_BLOCKS.add(registerWithItem(BookshelfTrapdoorBlock.makeId("warped"), () -> new BookshelfTrapdoorBlock(BlockSetType.WARPED, new BlockConfig().material("warped").materialName("Warped").ingredient(Bookshelves.BOOKSHELVES.get("warped")).ingredient("planks", Blocks.WARPED_PLANKS)), DEFAULT_TRAPDOOR_SETTINGS));

        BLOCKS.addAll(BOOKSHELF_TRAPDOOR_BLOCKS);
    }
}
