package com.chimericdream.minekea.block.building.covers;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class Covers implements MinekeaBlockCategory {
    public static final List<Block> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("amethyst").materialName("Amethyst").ingredient(Blocks.AMETHYST_BLOCK)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("andesite").materialName("Andesite").ingredient(Blocks.ANDESITE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("basalt").materialName("Basalt").ingredient(Blocks.BASALT).texture(TextureUtils.block(Blocks.BASALT, "_top")).texture("side", TextureUtils.block(Blocks.BASALT, "_side"))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("basalt_brick").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS_BLOCK).texture(TextureUtils.block(BasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("blackstone").materialName("Blackstone").ingredient(Blocks.BLACKSTONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("bone").materialName("Bone").ingredient(Blocks.BONE_BLOCK).texture(TextureUtils.block(Blocks.BONE_BLOCK, "_top")).texture("side", TextureUtils.block(Blocks.BONE_BLOCK, "_side"))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("brick").materialName("Brick").ingredient(Blocks.BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("calcite").materialName("Calcite").ingredient(Blocks.CALCITE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cobbled_deepslate").materialName("Cobbled Deepslate").ingredient(Blocks.COBBLED_DEEPSLATE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cobblestone").materialName("Cobblestone").ingredient(Blocks.COBBLESTONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cracked_basalt_brick").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(CrackedBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cracked_deepslate_brick").materialName("Cracked Deepslate Brick").ingredient(Blocks.CRACKED_DEEPSLATE_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cracked_deepslate_tile").materialName("Cracked Deepslate Tile").ingredient(Blocks.CRACKED_DEEPSLATE_TILES)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cracked_stone_brick").materialName("Cracked Stone Brick").ingredient(Blocks.CRACKED_STONE_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("crimson_basalt_brick").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(CrimsonBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("crying_obsidian").materialName("Crying Obsidian").ingredient(Blocks.CRYING_OBSIDIAN)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cut_red_sandstone").materialName("Cut Red Sandstone").ingredient(Blocks.CUT_RED_SANDSTONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cut_sandstone").materialName("Cut Sandstone").ingredient(Blocks.CUT_SANDSTONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("dark_prismarine").materialName("Dark Prismarine").ingredient(Blocks.DARK_PRISMARINE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("deepslate").materialName("Deepslate").ingredient(Blocks.DEEPSLATE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("deepslate_brick").materialName("Deepslate Brick").ingredient(Blocks.DEEPSLATE_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("deepslate_tile").materialName("Deepslate Tile").ingredient(Blocks.DEEPSLATE_TILES)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("diorite").materialName("Diorite").ingredient(Blocks.DIORITE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("end_stone").materialName("End Stone").ingredient(Blocks.END_STONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("end_stone_brick").materialName("End Stone Brick").ingredient(Blocks.END_STONE_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("granite").materialName("Granite").ingredient(Blocks.GRANITE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("mossy_basalt_brick").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(MossyBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("mossy_cobblestone").materialName("Mossy Cobblestone").ingredient(Blocks.MOSSY_COBBLESTONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("mossy_stone_brick").materialName("Mossy Stone Brick").ingredient(Blocks.MOSSY_STONE_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("mud_brick").materialName("Mud Brick").ingredient(Blocks.MUD_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("netherrack").materialName("Netherrack").ingredient(Blocks.NETHERRACK)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("nether_brick").materialName("Nether Brick").ingredient(Blocks.NETHER_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("obsidian").materialName("Obsidian").ingredient(Blocks.OBSIDIAN)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("packed_mud").materialName("Packed Mud").ingredient(Blocks.PACKED_MUD)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("polished_andesite").materialName("Polished Andesite").ingredient(Blocks.POLISHED_ANDESITE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("polished_basalt").materialName("Polished Basalt").ingredient(Blocks.POLISHED_BASALT).texture(TextureUtils.block(Blocks.POLISHED_BASALT, "_top")).texture("side", TextureUtils.block(Blocks.POLISHED_BASALT, "_side"))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("polished_blackstone").materialName("Polished Blackstone").ingredient(Blocks.POLISHED_BLACKSTONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("polished_blackstone_brick").materialName("Polished Blackstone Brick").ingredient(Blocks.POLISHED_BLACKSTONE_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("polished_deepslate").materialName("Polished Deepslate").ingredient(Blocks.POLISHED_DEEPSLATE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("polished_diorite").materialName("Polished Diorite").ingredient(Blocks.POLISHED_DIORITE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("polished_granite").materialName("Polished Granite").ingredient(Blocks.POLISHED_GRANITE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("prismarine").materialName("Prismarine").ingredient(Blocks.PRISMARINE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("prismarine_brick").materialName("Prismarine Brick").ingredient(Blocks.PRISMARINE_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("purpur").materialName("Purpur").ingredient(Blocks.PURPUR_BLOCK)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("purpur_pillar").materialName("Purpur Pillar").ingredient(Blocks.PURPUR_PILLAR)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("quartz").materialName("Quartz").ingredient(Blocks.QUARTZ_BLOCK).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_top"))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("quartz_brick").materialName("Quartz Brick").ingredient(Blocks.QUARTZ_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("red_nether_brick").materialName("Red Nether Brick").ingredient(Blocks.RED_NETHER_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("red_sandstone").materialName("Red Sandstone").ingredient(Blocks.RED_SANDSTONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("sandstone").materialName("Sandstone").ingredient(Blocks.SANDSTONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("smooth_basalt").materialName("Smooth Basalt").ingredient(Blocks.SMOOTH_BASALT)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("smooth_quartz").materialName("Smooth Quartz").ingredient(Blocks.SMOOTH_QUARTZ).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_bottom"))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("smooth_red_sandstone").materialName("Smooth Red Sandstone").ingredient(Blocks.SMOOTH_RED_SANDSTONE).texture(TextureUtils.block(Blocks.RED_SANDSTONE, "_top"))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("smooth_sandstone").materialName("Smooth Sandstone").ingredient(Blocks.SMOOTH_SANDSTONE).texture(TextureUtils.block(Blocks.SANDSTONE, "_top"))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("smooth_stone").materialName("Smooth Stone").ingredient(Blocks.SMOOTH_STONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("stone").materialName("Stone").ingredient(Blocks.STONE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("stone_brick").materialName("Stone Brick").ingredient(Blocks.STONE_BRICKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("tuff").materialName("Tuff").ingredient(Blocks.TUFF)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("warped_basalt_brick").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(WarpedBasaltBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("warped_nether_brick").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK).texture(TextureUtils.block(WarpedNetherBricksBlock.BLOCK_ID))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("copper_block").materialName("Copper Block").ingredient(Blocks.COPPER_BLOCK)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("diamond_block").materialName("Diamond Block").ingredient(Blocks.DIAMOND_BLOCK)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("gold_block").materialName("Gold Block").ingredient(Blocks.GOLD_BLOCK)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("iron_block").materialName("Iron Block").ingredient(Blocks.IRON_BLOCK)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("lapis_block").materialName("Lapis Block").ingredient(Blocks.LAPIS_BLOCK)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("netherite_block").materialName("Netherite Block").ingredient(Blocks.NETHERITE_BLOCK)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("redstone_block").materialName("Redstone Block").ingredient(Blocks.REDSTONE_BLOCK)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cut_copper").materialName("Cut Copper").ingredient(Blocks.CUT_COPPER)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("exposed_cut_copper").materialName("Exposed Cut Copper").ingredient(Blocks.EXPOSED_CUT_COPPER)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("weathered_cut_copper").materialName("Weathered Cut Copper").ingredient(Blocks.WEATHERED_CUT_COPPER)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("oxidized_cut_copper").materialName("Oxidized Cut Copper").ingredient(Blocks.OXIDIZED_CUT_COPPER)));

        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("white_terracotta").materialName("White Terracotta").ingredient(Blocks.WHITE_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("light_gray_terracotta").materialName("Light Gray Terracotta").ingredient(Blocks.LIGHT_GRAY_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("gray_terracotta").materialName("Gray Terracotta").ingredient(Blocks.GRAY_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("black_terracotta").materialName("Black Terracotta").ingredient(Blocks.BLACK_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("brown_terracotta").materialName("Brown Terracotta").ingredient(Blocks.BROWN_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("red_terracotta").materialName("Red Terracotta").ingredient(Blocks.RED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("orange_terracotta").materialName("Orange Terracotta").ingredient(Blocks.ORANGE_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("yellow_terracotta").materialName("Yellow Terracotta").ingredient(Blocks.YELLOW_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("lime_terracotta").materialName("Lime Terracotta").ingredient(Blocks.LIME_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("green_terracotta").materialName("Green Terracotta").ingredient(Blocks.GREEN_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cyan_terracotta").materialName("Cyan Terracotta").ingredient(Blocks.CYAN_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("light_blue_terracotta").materialName("Light Blue Terracotta").ingredient(Blocks.LIGHT_BLUE_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("blue_terracotta").materialName("Blue Terracotta").ingredient(Blocks.BLUE_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("purple_terracotta").materialName("Purple Terracotta").ingredient(Blocks.PURPLE_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("magenta_terracotta").materialName("Magenta Terracotta").ingredient(Blocks.MAGENTA_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("pink_terracotta").materialName("Pink Terracotta").ingredient(Blocks.PINK_TERRACOTTA)));

        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("white_glazed_terracotta").materialName("White Glazed Terracotta").ingredient(Blocks.WHITE_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("light_gray_glazed_terracotta").materialName("Light Gray Glazed Terracotta").ingredient(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("gray_glazed_terracotta").materialName("Gray Glazed Terracotta").ingredient(Blocks.GRAY_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("black_glazed_terracotta").materialName("Black Glazed Terracotta").ingredient(Blocks.BLACK_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("brown_glazed_terracotta").materialName("Brown Glazed Terracotta").ingredient(Blocks.BROWN_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("red_glazed_terracotta").materialName("Red Glazed Terracotta").ingredient(Blocks.RED_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("orange_glazed_terracotta").materialName("Orange Glazed Terracotta").ingredient(Blocks.ORANGE_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("yellow_glazed_terracotta").materialName("Yellow Glazed Terracotta").ingredient(Blocks.YELLOW_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("lime_glazed_terracotta").materialName("Lime Glazed Terracotta").ingredient(Blocks.LIME_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("green_glazed_terracotta").materialName("Green Glazed Terracotta").ingredient(Blocks.GREEN_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cyan_glazed_terracotta").materialName("Cyan Glazed Terracotta").ingredient(Blocks.CYAN_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("light_blue_glazed_terracotta").materialName("Light Blue Glazed Terracotta").ingredient(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("blue_glazed_terracotta").materialName("Blue Glazed Terracotta").ingredient(Blocks.BLUE_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("purple_glazed_terracotta").materialName("Purple Glazed Terracotta").ingredient(Blocks.PURPLE_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("magenta_glazed_terracotta").materialName("Magenta Glazed Terracotta").ingredient(Blocks.MAGENTA_GLAZED_TERRACOTTA)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("pink_glazed_terracotta").materialName("Pink Glazed Terracotta").ingredient(Blocks.PINK_GLAZED_TERRACOTTA)));

        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("white_concrete").materialName("White Concrete").ingredient(Blocks.WHITE_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("light_gray_concrete").materialName("Light Gray Concrete").ingredient(Blocks.LIGHT_GRAY_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("gray_concrete").materialName("Gray Concrete").ingredient(Blocks.GRAY_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("black_concrete").materialName("Black Concrete").ingredient(Blocks.BLACK_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("brown_concrete").materialName("Brown Concrete").ingredient(Blocks.BROWN_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("red_concrete").materialName("Red Concrete").ingredient(Blocks.RED_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("orange_concrete").materialName("Orange Concrete").ingredient(Blocks.ORANGE_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("yellow_concrete").materialName("Yellow Concrete").ingredient(Blocks.YELLOW_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("lime_concrete").materialName("Lime Concrete").ingredient(Blocks.LIME_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("green_concrete").materialName("Green Concrete").ingredient(Blocks.GREEN_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cyan_concrete").materialName("Cyan Concrete").ingredient(Blocks.CYAN_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("light_blue_concrete").materialName("Light Blue Concrete").ingredient(Blocks.LIGHT_BLUE_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("blue_concrete").materialName("Blue Concrete").ingredient(Blocks.BLUE_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("purple_concrete").materialName("Purple Concrete").ingredient(Blocks.PURPLE_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("magenta_concrete").materialName("Magenta Concrete").ingredient(Blocks.MAGENTA_CONCRETE)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("pink_concrete").materialName("Pink Concrete").ingredient(Blocks.PINK_CONCRETE)));

        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("acacia").materialName("Acacia").flammable().ingredient(Blocks.ACACIA_PLANKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("birch").materialName("Birch").flammable().ingredient(Blocks.BIRCH_PLANKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").flammable().ingredient(Blocks.DARK_OAK_PLANKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("jungle").materialName("Jungle").flammable().ingredient(Blocks.JUNGLE_PLANKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("mangrove").materialName("Mangrove").flammable().ingredient(Blocks.MANGROVE_PLANKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("oak").materialName("Oak").flammable().ingredient(Blocks.OAK_PLANKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("spruce").materialName("Spruce").flammable().ingredient(Blocks.SPRUCE_PLANKS)));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS)));

        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("acacia_log").materialName("Acacia Log").flammable().settings(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)).ingredient(Blocks.ACACIA_LOG).texture(TextureUtils.block(Blocks.ACACIA_LOG, "_top")).texture("side", TextureUtils.block(Blocks.ACACIA_LOG))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("birch_log").materialName("Birch Log").flammable().settings(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)).ingredient(Blocks.BIRCH_LOG).texture(TextureUtils.block(Blocks.BIRCH_LOG, "_top")).texture("side", TextureUtils.block(Blocks.BIRCH_LOG))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("cherry_log").materialName("Cherry Log").settings(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)).ingredient(Blocks.CHERRY_LOG).texture(TextureUtils.block(Blocks.CHERRY_LOG, "_top")).texture("side", TextureUtils.block(Blocks.CHERRY_LOG))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("crimson_stem").materialName("Crimson Stem").settings(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)).ingredient(Blocks.CRIMSON_STEM).texture(TextureUtils.block(Blocks.CRIMSON_STEM, "_top")).texture("side", TextureUtils.block(Blocks.CRIMSON_STEM))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("dark_oak_log").materialName("Dark Oak Log").flammable().settings(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)).ingredient(Blocks.DARK_OAK_LOG).texture(TextureUtils.block(Blocks.DARK_OAK_LOG, "_top")).texture("side", TextureUtils.block(Blocks.DARK_OAK_LOG))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("jungle_log").materialName("Jungle Log").flammable().settings(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)).ingredient(Blocks.JUNGLE_LOG).texture(TextureUtils.block(Blocks.JUNGLE_LOG, "_top")).texture("side", TextureUtils.block(Blocks.JUNGLE_LOG))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("mangrove_log").materialName("Mangrove Log").flammable().settings(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)).ingredient(Blocks.MANGROVE_LOG).texture(TextureUtils.block(Blocks.MANGROVE_LOG, "_top")).texture("side", TextureUtils.block(Blocks.MANGROVE_LOG))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("oak_log").materialName("Oak Log").flammable().settings(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)).ingredient(Blocks.OAK_LOG).texture(TextureUtils.block(Blocks.OAK_LOG, "_top")).texture("side", TextureUtils.block(Blocks.OAK_LOG))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("spruce_log").materialName("Spruce Log").flammable().settings(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)).ingredient(Blocks.SPRUCE_LOG).texture(TextureUtils.block(Blocks.SPRUCE_LOG, "_top")).texture("side", TextureUtils.block(Blocks.SPRUCE_LOG))));
        BLOCKS.add(new GenericCoverBlock(new BlockConfig().material("warped_stem").materialName("Warped Stem").settings(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)).ingredient(Blocks.WARPED_STEM).texture(TextureUtils.block(Blocks.WARPED_STEM, "_top")).texture("side", TextureUtils.block(Blocks.WARPED_STEM))));
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }
}
