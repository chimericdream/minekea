package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.util.Tool;
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
    public static final Map<String, BlockConfig> BOOKSHELF_CONFIGS = new LinkedHashMap<>();

    static {
        BOOKSHELF_CONFIGS.put("acacia", new BlockConfig().material("acacia").materialName("Acacia").flammable().ingredient(Blocks.ACACIA_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("bamboo", new BlockConfig().material("bamboo").materialName("Bamboo").flammable().ingredient(Blocks.BAMBOO_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("birch", new BlockConfig().material("birch").materialName("Birch").flammable().ingredient(Blocks.BIRCH_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("cherry", new BlockConfig().material("cherry").materialName("Cherry").flammable().ingredient(Blocks.CHERRY_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("crimson", new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("dark_oak", new BlockConfig().material("dark_oak").materialName("Dark Oak").flammable().ingredient(Blocks.DARK_OAK_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("jungle", new BlockConfig().material("jungle").materialName("Jungle").flammable().ingredient(Blocks.JUNGLE_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("mangrove", new BlockConfig().material("mangrove").materialName("Mangrove").flammable().ingredient(Blocks.MANGROVE_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("spruce", new BlockConfig().material("spruce").materialName("Spruce").flammable().ingredient(Blocks.SPRUCE_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("warped", new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).tool(Tool.AXE));

        BOOKSHELF_CONFIGS.put("bone", new BlockConfig().material("bone").materialName("Bone").ingredient(Blocks.BONE_BLOCK).texture("default", Registries.BLOCK.getId(Blocks.BONE_BLOCK).withPrefixedPath("block/").withSuffixedPath("_side")));
        BOOKSHELF_CONFIGS.put("dark_prismarine", new BlockConfig().material("dark_prismarine").materialName("Dark Prismarine").ingredient(Blocks.DARK_PRISMARINE));
        BOOKSHELF_CONFIGS.put("deepslate_brick", new BlockConfig().material("deepslate_brick").materialName("Deepslate Brick").ingredient(Blocks.DEEPSLATE_BRICKS));
        BOOKSHELF_CONFIGS.put("end_stone_brick", new BlockConfig().material("end_stone_brick").materialName("End Stone Brick").ingredient(Blocks.END_STONE_BRICKS));
        BOOKSHELF_CONFIGS.put("nether_brick", new BlockConfig().material("nether_brick").materialName("Nether Brick").ingredient(Blocks.NETHER_BRICKS));
        BOOKSHELF_CONFIGS.put("polished_andesite", new BlockConfig().material("polished_andesite").materialName("Polished Andesite").ingredient(Blocks.POLISHED_ANDESITE));
        BOOKSHELF_CONFIGS.put("polished_basalt", new BlockConfig().material("polished_basalt").materialName("Polished Basalt").ingredient(Blocks.POLISHED_BASALT).texture("default", Registries.BLOCK.getId(Blocks.POLISHED_BASALT).withPrefixedPath("block/").withSuffixedPath("_top")));
        BOOKSHELF_CONFIGS.put("polished_blackstone", new BlockConfig().material("polished_blackstone").materialName("Polished Blackstone").ingredient(Blocks.POLISHED_BLACKSTONE));
        BOOKSHELF_CONFIGS.put("polished_blackstone_brick", new BlockConfig().material("polished_blackstone_brick").materialName("Polished Blackstone Brick").ingredient(Blocks.POLISHED_BLACKSTONE_BRICKS));
        BOOKSHELF_CONFIGS.put("polished_deepslate", new BlockConfig().material("polished_deepslate").materialName("Polished Deepslate").ingredient(Blocks.POLISHED_DEEPSLATE));
        BOOKSHELF_CONFIGS.put("polished_diorite", new BlockConfig().material("polished_diorite").materialName("Polished Diorite").ingredient(Blocks.POLISHED_DIORITE));
        BOOKSHELF_CONFIGS.put("polished_granite", new BlockConfig().material("polished_granite").materialName("Polished Granite").ingredient(Blocks.POLISHED_GRANITE));
        BOOKSHELF_CONFIGS.put("polished_tuff", new BlockConfig().material("polished_tuff").materialName("Polished Tuff").ingredient(Blocks.POLISHED_TUFF));
        BOOKSHELF_CONFIGS.put("prismarine", new BlockConfig().material("prismarine").materialName("Prismarine").ingredient(Blocks.PRISMARINE));
        BOOKSHELF_CONFIGS.put("prismarine_brick", new BlockConfig().material("prismarine_brick").materialName("Prismarine Brick").ingredient(Blocks.PRISMARINE_BRICKS));
        BOOKSHELF_CONFIGS.put("purpur", new BlockConfig().material("purpur").materialName("Purpur").ingredient(Blocks.PURPUR_BLOCK));
        BOOKSHELF_CONFIGS.put("quartz_brick", new BlockConfig().material("quartz_brick").materialName("Quartz Brick").ingredient(Blocks.QUARTZ_BRICKS));
        BOOKSHELF_CONFIGS.put("red_nether_brick", new BlockConfig().material("red_nether_brick").materialName("Red Nether Brick").ingredient(Blocks.RED_NETHER_BRICKS));
        BOOKSHELF_CONFIGS.put("smooth_quartz", new BlockConfig().material("smooth_quartz").materialName("Smooth Quartz").ingredient(Blocks.SMOOTH_QUARTZ).texture("default", Registries.BLOCK.getId(Blocks.QUARTZ_BLOCK).withPrefixedPath("block/").withSuffixedPath("_bottom")));
        BOOKSHELF_CONFIGS.put("smooth_stone", new BlockConfig().material("smooth_stone").materialName("Smooth Stone").ingredient(Blocks.SMOOTH_STONE));
        BOOKSHELF_CONFIGS.put("stone_brick", new BlockConfig().material("stone_brick").materialName("Stone Brick").ingredient(Blocks.STONE_BRICKS));
        BOOKSHELF_CONFIGS.put("tuff_brick", new BlockConfig().material("tuff_brick").materialName("Tuff Brick").ingredient(Blocks.TUFF_BRICKS));
        BOOKSHELF_CONFIGS.put("warped_nether_brick", new BlockConfig().material("warped_nether_brick").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS).texture("default", WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/")));

        BOOKSHELF_CONFIGS.forEach((key, value) -> BOOKSHELVES.put(key, registerWithItem(BookshelfBlock.makeId(key), () -> new BookshelfBlock(value), DEFAULT_BOOKSHELF_SETTINGS)));

        BLOCKS.addAll(BOOKSHELVES.values());
    }
}
