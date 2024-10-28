package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class Stairs implements ModThingGroup {
    public static final Item.Settings DEFAULT_STAIRS_SETTINGS = new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS);
    public static final Item.Settings DEFAULT_VERTICAL_STAIRS_SETTINGS = new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS);

    public static final List<RegistrySupplier<Block>> STAIRS_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> VERTICAL_STAIRS_BLOCKS = new ArrayList<>();

    public static final List<RegistrySupplier<Block>> BOOKSHELF_STAIRS_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> VERTICAL_BOOKSHELF_STAIRS_BLOCKS = new ArrayList<>();

    static {
        STAIRS_BLOCKS.add(registerWithItem(StairsBlock.makeId("basalt_bricks"), () -> new StairsBlock(new BlockConfig().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS.get()).texture(TextureUtils.block(BasaltBricksBlock.BLOCK_ID))), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(registerWithItem(StairsBlock.makeId("cracked_basalt_bricks"), () -> new StairsBlock(new BlockConfig().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS.get()).texture(TextureUtils.block(CrackedBasaltBricksBlock.BLOCK_ID))), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(registerWithItem(StairsBlock.makeId("crimson_basalt_bricks"), () -> new StairsBlock(new BlockConfig().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS.get()).texture(TextureUtils.block(CrimsonBasaltBricksBlock.BLOCK_ID))), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(registerWithItem(StairsBlock.makeId("mossy_basalt_bricks"), () -> new StairsBlock(new BlockConfig().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS.get()).texture(TextureUtils.block(MossyBasaltBricksBlock.BLOCK_ID))), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(registerWithItem(StairsBlock.makeId("warped_basalt_bricks"), () -> new StairsBlock(new BlockConfig().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS.get()).texture(TextureUtils.block(WarpedBasaltBricksBlock.BLOCK_ID))), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(registerWithItem(StairsBlock.makeId("warped_nether_bricks"), () -> new StairsBlock(new BlockConfig().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS.get()).texture(TextureUtils.block(WarpedNetherBricksBlock.BLOCK_ID))), DEFAULT_STAIRS_SETTINGS));

        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("acacia_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("acacia_planks").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("birch_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("birch_planks").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("cherry_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("cherry_planks").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("crimson_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("crimson_planks").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("dark_oak_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("dark_oak_planks").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("jungle_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("jungle_planks").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("mangrove_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("mangrove_planks").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("oak_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("oak_planks").materialName("Oak").ingredient(Blocks.OAK_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("spruce_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("spruce_planks").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("warped_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("warped_planks").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("andesite"), () -> new VerticalStairsBlock(new BlockConfig().material("andesite").materialName("Andesite").ingredient(Blocks.ANDESITE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("bamboo_mosaic"), () -> new VerticalStairsBlock(new BlockConfig().material("bamboo_mosaic").materialName("Bamboo Mosaic").ingredient(Blocks.BAMBOO_MOSAIC).tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("blackstone"), () -> new VerticalStairsBlock(new BlockConfig().material("blackstone").materialName("Blackstone").ingredient(Blocks.BLACKSTONE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("bricks").materialName("Brick").ingredient(Blocks.BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("cobbled_deepslate"), () -> new VerticalStairsBlock(new BlockConfig().material("cobbled_deepslate").materialName("Cobbled Deepslate").ingredient(Blocks.COBBLED_DEEPSLATE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("cobblestone"), () -> new VerticalStairsBlock(new BlockConfig().material("cobblestone").materialName("Cobblestone").ingredient(Blocks.COBBLESTONE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("dark_prismarine"), () -> new VerticalStairsBlock(new BlockConfig().material("dark_prismarine").materialName("Dark Prismarine").ingredient(Blocks.DARK_PRISMARINE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("deepslate_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("deepslate_bricks").materialName("Deepslate Brick").ingredient(Blocks.DEEPSLATE_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("deepslate_tiles"), () -> new VerticalStairsBlock(new BlockConfig().material("deepslate_tiles").materialName("Deepslate Tile").ingredient(Blocks.DEEPSLATE_TILES)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("diorite"), () -> new VerticalStairsBlock(new BlockConfig().material("diorite").materialName("Diorite").ingredient(Blocks.DIORITE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("end_stone_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("end_stone_bricks").materialName("End Stone Brick").ingredient(Blocks.END_STONE_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("granite"), () -> new VerticalStairsBlock(new BlockConfig().material("granite").materialName("Granite").ingredient(Blocks.GRANITE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("mossy_cobblestone"), () -> new VerticalStairsBlock(new BlockConfig().material("mossy_cobblestone").materialName("Mossy Cobblestone").ingredient(Blocks.MOSSY_COBBLESTONE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("mossy_stone_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("mossy_stone_bricks").materialName("Mossy Stone Brick").ingredient(Blocks.MOSSY_STONE_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("mud_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("mud_bricks").materialName("Mud Brick").ingredient(Blocks.MUD_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("nether_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("nether_bricks").materialName("Nether Brick").ingredient(Blocks.NETHER_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("polished_andesite"), () -> new VerticalStairsBlock(new BlockConfig().material("polished_andesite").materialName("Polished Andesite").ingredient(Blocks.POLISHED_ANDESITE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("polished_blackstone_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("polished_blackstone_bricks").materialName("Polished Blackstone Brick").ingredient(Blocks.POLISHED_BLACKSTONE_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("polished_blackstone"), () -> new VerticalStairsBlock(new BlockConfig().material("polished_blackstone").materialName("Polished Blackstone").ingredient(Blocks.POLISHED_BLACKSTONE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("polished_deepslate"), () -> new VerticalStairsBlock(new BlockConfig().material("polished_deepslate").materialName("Polished Deepslate").ingredient(Blocks.POLISHED_DEEPSLATE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("polished_diorite"), () -> new VerticalStairsBlock(new BlockConfig().material("polished_diorite").materialName("Polished Diorite").ingredient(Blocks.POLISHED_DIORITE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("polished_granite"), () -> new VerticalStairsBlock(new BlockConfig().material("polished_granite").materialName("Polished Granite").ingredient(Blocks.POLISHED_GRANITE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("polished_tuff"), () -> new VerticalStairsBlock(new BlockConfig().material("polished_tuff").materialName("Polished Tuff").ingredient(Blocks.POLISHED_TUFF)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("prismarine_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("prismarine_bricks").materialName("Prismarine Brick").ingredient(Blocks.PRISMARINE_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("prismarine"), () -> new VerticalStairsBlock(new BlockConfig().material("prismarine").materialName("Prismarine").ingredient(Blocks.PRISMARINE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("purpur_block"), () -> new VerticalStairsBlock(new BlockConfig().material("purpur_block").materialName("Purpur").ingredient(Blocks.PURPUR_BLOCK)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("quartz_block"), () -> new VerticalStairsBlock(new BlockConfig().material("quartz_block").materialName("Quartz").ingredient(Blocks.QUARTZ_BLOCK).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_top"))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("red_nether_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("red_nether_bricks").materialName("Red Nether Brick").ingredient(Blocks.RED_NETHER_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("red_sandstone"), () -> new VerticalStairsBlock(new BlockConfig().material("red_sandstone").materialName("Red Sandstone").ingredient(Blocks.RED_SANDSTONE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("sandstone"), () -> new VerticalStairsBlock(new BlockConfig().material("sandstone").materialName("Sandstone").ingredient(Blocks.SANDSTONE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("quartz_block_bottom"), () -> new VerticalStairsBlock(new BlockConfig().material("quartz_block_bottom").materialName("Smooth Quartz").ingredient(Blocks.SMOOTH_QUARTZ).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_bottom"))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("red_sandstone_top"), () -> new VerticalStairsBlock(new BlockConfig().material("red_sandstone_top").materialName("Smooth Red Sandstone").ingredient(Blocks.SMOOTH_RED_SANDSTONE).texture(TextureUtils.block(Blocks.RED_SANDSTONE, "_top"))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("sandstone_top"), () -> new VerticalStairsBlock(new BlockConfig().material("sandstone_top").materialName("Smooth Sandstone").ingredient(Blocks.SMOOTH_SANDSTONE).texture(TextureUtils.block(Blocks.SANDSTONE, "_top"))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("stone_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("stone_bricks").materialName("Stone Brick").ingredient(Blocks.STONE_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("stone"), () -> new VerticalStairsBlock(new BlockConfig().material("stone").materialName("Stone").ingredient(Blocks.STONE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("tuff_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("tuff_bricks").materialName("Tuff Brick").ingredient(Blocks.TUFF_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("tuff"), () -> new VerticalStairsBlock(new BlockConfig().material("tuff").materialName("Tuff").ingredient(Blocks.TUFF)), DEFAULT_VERTICAL_STAIRS_SETTINGS));

        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("cut_copper"), () -> new VerticalStairsBlock(new BlockConfig().material("cut_copper").materialName("Cut Copper").ingredient(Blocks.CUT_COPPER)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("waxed_cut_copper"), () -> new VerticalStairsBlock(new BlockConfig().material("waxed_cut_copper").materialName("Waxed Cut Copper").ingredient(Blocks.WAXED_CUT_COPPER).texture(TextureUtils.block(Blocks.CUT_COPPER))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("exposed_cut_copper"), () -> new VerticalStairsBlock(new BlockConfig().material("exposed_cut_copper").materialName("Exposed Cut Copper").ingredient(Blocks.EXPOSED_CUT_COPPER)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("waxed_exposed_cut_copper"), () -> new VerticalStairsBlock(new BlockConfig().material("waxed_exposed_cut_copper").materialName("Waxed Exposed Cut Copper").ingredient(Blocks.WAXED_EXPOSED_CUT_COPPER).texture(TextureUtils.block(Blocks.EXPOSED_CUT_COPPER))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("weathered_cut_copper"), () -> new VerticalStairsBlock(new BlockConfig().material("weathered_cut_copper").materialName("Weathered Cut Copper").ingredient(Blocks.WEATHERED_CUT_COPPER)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("waxed_weathered_cut_copper"), () -> new VerticalStairsBlock(new BlockConfig().material("waxed_weathered_cut_copper").materialName("Waxed Weathered Cut Copper").ingredient(Blocks.WAXED_WEATHERED_CUT_COPPER).texture(TextureUtils.block(Blocks.WEATHERED_CUT_COPPER))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("oxidized_cut_copper"), () -> new VerticalStairsBlock(new BlockConfig().material("oxidized_cut_copper").materialName("Oxidized Cut Copper").ingredient(Blocks.OXIDIZED_CUT_COPPER)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("waxed_oxidized_cut_copper"), () -> new VerticalStairsBlock(new BlockConfig().material("waxed_oxidized_cut_copper").materialName("Waxed Oxidized Cut Copper").ingredient(Blocks.WAXED_OXIDIZED_CUT_COPPER).texture(TextureUtils.block(Blocks.OXIDIZED_CUT_COPPER))), DEFAULT_VERTICAL_STAIRS_SETTINGS));

        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("basalt_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS.get()).texture(TextureUtils.block(BasaltBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("cracked_basalt_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS.get()).texture(TextureUtils.block(CrackedBasaltBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("crimson_basalt_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS.get()).texture(TextureUtils.block(CrimsonBasaltBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("mossy_basalt_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS.get()).texture(TextureUtils.block(MossyBasaltBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("warped_basalt_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS.get()).texture(TextureUtils.block(WarpedBasaltBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(registerWithItem(VerticalStairsBlock.makeId("warped_nether_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS.get()).texture(TextureUtils.block(WarpedNetherBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_STAIRS_SETTINGS));

        Bookshelves.BOOKSHELF_CONFIGS.forEach((material, config) -> {
            BOOKSHELF_STAIRS_BLOCKS.add(
                registerWithItem(BookshelfStairsBlock.makeId(material),
                    () -> new BookshelfStairsBlock(config),
                    DEFAULT_STAIRS_SETTINGS
                )
            );

            VERTICAL_BOOKSHELF_STAIRS_BLOCKS.add(
                registerWithItem(VerticalBookshelfStairsBlock.makeId(material),
                    () -> new VerticalBookshelfStairsBlock(config),
                    DEFAULT_VERTICAL_STAIRS_SETTINGS
                )
            );
        });
    }
}
