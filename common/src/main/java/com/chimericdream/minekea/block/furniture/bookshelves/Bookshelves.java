package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class Bookshelves implements ModThingGroup {
    public static final Item.Settings DEFAULT_BOOKSHELF_SETTINGS = new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS);

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();
    public static final Map<String, RegistrySupplier<Block>> BOOKSHELVES = new LinkedHashMap<>();

    static {
        BOOKSHELVES.put("acacia", registerWithItem(BookshelfBlock.makeId("acacia"), () -> new BookshelfBlock(new BlockConfig().material("acacia").materialName("Acacia").flammable().ingredient(Blocks.ACACIA_PLANKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("bamboo", registerWithItem(BookshelfBlock.makeId("bamboo"), () -> new BookshelfBlock(new BlockConfig().material("bamboo").materialName("Bamboo").flammable().ingredient(Blocks.BAMBOO_PLANKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("birch", registerWithItem(BookshelfBlock.makeId("birch"), () -> new BookshelfBlock(new BlockConfig().material("birch").materialName("Birch").flammable().ingredient(Blocks.BIRCH_PLANKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("cherry", registerWithItem(BookshelfBlock.makeId("cherry"), () -> new BookshelfBlock(new BlockConfig().material("cherry").materialName("Cherry").flammable().ingredient(Blocks.CHERRY_PLANKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("crimson", registerWithItem(BookshelfBlock.makeId("crimson"), () -> new BookshelfBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("dark_oak", registerWithItem(BookshelfBlock.makeId("dark_oak"), () -> new BookshelfBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").flammable().ingredient(Blocks.DARK_OAK_PLANKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("jungle", registerWithItem(BookshelfBlock.makeId("jungle"), () -> new BookshelfBlock(new BlockConfig().material("jungle").materialName("Jungle").flammable().ingredient(Blocks.JUNGLE_PLANKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("mangrove", registerWithItem(BookshelfBlock.makeId("mangrove"), () -> new BookshelfBlock(new BlockConfig().material("mangrove").materialName("Mangrove").flammable().ingredient(Blocks.MANGROVE_PLANKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("spruce", registerWithItem(BookshelfBlock.makeId("spruce"), () -> new BookshelfBlock(new BlockConfig().material("spruce").materialName("Spruce").flammable().ingredient(Blocks.SPRUCE_PLANKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("warped", registerWithItem(BookshelfBlock.makeId("warped"), () -> new BookshelfBlock(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS)), DEFAULT_BOOKSHELF_SETTINGS));

        BOOKSHELVES.put("bone", registerWithItem(BookshelfBlock.makeId("bone"), () -> new BookshelfBlock(new BlockConfig().material("bone").materialName("Bone").ingredient(Blocks.BONE_BLOCK).texture("default", Registries.BLOCK.getId(Blocks.BONE_BLOCK).withPrefixedPath("block/").withSuffixedPath("_side"))), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("dark_prismarine", registerWithItem(BookshelfBlock.makeId("dark_prismarine"), () -> new BookshelfBlock(new BlockConfig().material("dark_prismarine").materialName("Dark Prismarine").ingredient(Blocks.DARK_PRISMARINE)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("deepslate_brick", registerWithItem(BookshelfBlock.makeId("deepslate_brick"), () -> new BookshelfBlock(new BlockConfig().material("deepslate_brick").materialName("Deepslate Brick").ingredient(Blocks.DEEPSLATE_BRICKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("end_stone_brick", registerWithItem(BookshelfBlock.makeId("end_stone_brick"), () -> new BookshelfBlock(new BlockConfig().material("end_stone_brick").materialName("End Stone Brick").ingredient(Blocks.END_STONE_BRICKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("nether_brick", registerWithItem(BookshelfBlock.makeId("nether_brick"), () -> new BookshelfBlock(new BlockConfig().material("nether_brick").materialName("Nether Brick").ingredient(Blocks.NETHER_BRICKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("polished_andesite", registerWithItem(BookshelfBlock.makeId("polished_andesite"), () -> new BookshelfBlock(new BlockConfig().material("polished_andesite").materialName("Polished Andesite").ingredient(Blocks.POLISHED_ANDESITE)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("polished_basalt", registerWithItem(BookshelfBlock.makeId("polished_basalt"), () -> new BookshelfBlock(new BlockConfig().material("polished_basalt").materialName("Polished Basalt").ingredient(Blocks.POLISHED_BASALT).texture("default", Registries.BLOCK.getId(Blocks.POLISHED_BASALT).withPrefixedPath("block/").withSuffixedPath("_top"))), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("polished_blackstone", registerWithItem(BookshelfBlock.makeId("polished_blackstone"), () -> new BookshelfBlock(new BlockConfig().material("polished_blackstone").materialName("Polished Blackstone").ingredient(Blocks.POLISHED_BLACKSTONE)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("polished_blackstone_brick", registerWithItem(BookshelfBlock.makeId("polished_blackstone_brick"), () -> new BookshelfBlock(new BlockConfig().material("polished_blackstone_brick").materialName("Polished Blackstone Brick").ingredient(Blocks.POLISHED_BLACKSTONE_BRICKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("polished_deepslate", registerWithItem(BookshelfBlock.makeId("polished_deepslate"), () -> new BookshelfBlock(new BlockConfig().material("polished_deepslate").materialName("Polished Deepslate").ingredient(Blocks.POLISHED_DEEPSLATE)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("polished_diorite", registerWithItem(BookshelfBlock.makeId("polished_diorite"), () -> new BookshelfBlock(new BlockConfig().material("polished_diorite").materialName("Polished Diorite").ingredient(Blocks.POLISHED_DIORITE)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("polished_granite", registerWithItem(BookshelfBlock.makeId("polished_granite"), () -> new BookshelfBlock(new BlockConfig().material("polished_granite").materialName("Polished Granite").ingredient(Blocks.POLISHED_GRANITE)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("polished_tuff", registerWithItem(BookshelfBlock.makeId("polished_tuff"), () -> new BookshelfBlock(new BlockConfig().material("polished_tuff").materialName("Polished Tuff").ingredient(Blocks.POLISHED_TUFF)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("prismarine", registerWithItem(BookshelfBlock.makeId("prismarine"), () -> new BookshelfBlock(new BlockConfig().material("prismarine").materialName("Prismarine").ingredient(Blocks.PRISMARINE)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("prismarine_brick", registerWithItem(BookshelfBlock.makeId("prismarine_brick"), () -> new BookshelfBlock(new BlockConfig().material("prismarine_brick").materialName("Prismarine Brick").ingredient(Blocks.PRISMARINE_BRICKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("purpur", registerWithItem(BookshelfBlock.makeId("purpur"), () -> new BookshelfBlock(new BlockConfig().material("purpur").materialName("Purpur").ingredient(Blocks.PURPUR_BLOCK)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("quartz_brick", registerWithItem(BookshelfBlock.makeId("quartz_brick"), () -> new BookshelfBlock(new BlockConfig().material("quartz_brick").materialName("Quartz Brick").ingredient(Blocks.QUARTZ_BRICKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("red_nether_brick", registerWithItem(BookshelfBlock.makeId("red_nether_brick"), () -> new BookshelfBlock(new BlockConfig().material("red_nether_brick").materialName("Red Nether Brick").ingredient(Blocks.RED_NETHER_BRICKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("smooth_quartz", registerWithItem(BookshelfBlock.makeId("smooth_quartz"), () -> new BookshelfBlock(new BlockConfig().material("smooth_quartz").materialName("Smooth Quartz").ingredient(Blocks.SMOOTH_QUARTZ).texture("default", Registries.BLOCK.getId(Blocks.QUARTZ_BLOCK).withPrefixedPath("block/").withSuffixedPath("_bottom"))), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("smooth_stone", registerWithItem(BookshelfBlock.makeId("smooth_stone"), () -> new BookshelfBlock(new BlockConfig().material("smooth_stone").materialName("Smooth Stone").ingredient(Blocks.SMOOTH_STONE)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("stone_brick", registerWithItem(BookshelfBlock.makeId("stone_brick"), () -> new BookshelfBlock(new BlockConfig().material("stone_brick").materialName("Stone Brick").ingredient(Blocks.STONE_BRICKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("tuff_brick", registerWithItem(BookshelfBlock.makeId("tuff_brick"), () -> new BookshelfBlock(new BlockConfig().material("tuff_brick").materialName("Tuff Brick").ingredient(Blocks.TUFF_BRICKS)), DEFAULT_BOOKSHELF_SETTINGS));
        BOOKSHELVES.put("warped_nether_brick", registerWithItem(BookshelfBlock.makeId("warped_nether_brick"), () -> new BookshelfBlock(new BlockConfig().material("warped_nether_brick").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS).texture("default", WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/"))), DEFAULT_BOOKSHELF_SETTINGS));

        BLOCKS.addAll(BOOKSHELVES.values());
    }
}
