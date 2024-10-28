package com.chimericdream.minekea.block.building.slabs;

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

public class Slabs implements ModThingGroup {
    public static final Item.Settings DEFAULT_SLAB_SETTINGS = new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS);
    public static final Item.Settings DEFAULT_VERTICAL_SLAB_SETTINGS = new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS);

    public static final List<RegistrySupplier<Block>> SLAB_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> VERTICAL_SLAB_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> BOOKSHELF_SLAB_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> VERTICAL_BOOKSHELF_SLAB_BLOCKS = new ArrayList<>();

    static {
        SLAB_BLOCKS.add(registerWithItem(SlabBlock.makeId("basalt_bricks"), () -> new SlabBlock(new BlockConfig().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS.get()).texture(TextureUtils.block(BasaltBricksBlock.BLOCK_ID))), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(registerWithItem(SlabBlock.makeId("cracked_basalt_bricks"), () -> new SlabBlock(new BlockConfig().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS.get()).texture(TextureUtils.block(CrackedBasaltBricksBlock.BLOCK_ID))), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(registerWithItem(SlabBlock.makeId("crimson_basalt_bricks"), () -> new SlabBlock(new BlockConfig().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS.get()).texture(TextureUtils.block(CrimsonBasaltBricksBlock.BLOCK_ID))), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(registerWithItem(SlabBlock.makeId("mossy_basalt_bricks"), () -> new SlabBlock(new BlockConfig().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS.get()).texture(TextureUtils.block(MossyBasaltBricksBlock.BLOCK_ID))), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(registerWithItem(SlabBlock.makeId("warped_basalt_bricks"), () -> new SlabBlock(new BlockConfig().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS.get()).texture(TextureUtils.block(WarpedBasaltBricksBlock.BLOCK_ID))), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(registerWithItem(SlabBlock.makeId("warped_nether_bricks"), () -> new SlabBlock(new BlockConfig().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS.get()).texture(TextureUtils.block(WarpedNetherBricksBlock.BLOCK_ID))), DEFAULT_SLAB_SETTINGS));

        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("acacia"), () -> new VerticalSlabBlock(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("bamboo_planks"), () -> new VerticalSlabBlock(new BlockConfig().material("bamboo_planks").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("birch"), () -> new VerticalSlabBlock(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("cherry"), () -> new VerticalSlabBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("crimson"), () -> new VerticalSlabBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("dark_oak"), () -> new VerticalSlabBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("jungle"), () -> new VerticalSlabBlock(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("mangrove"), () -> new VerticalSlabBlock(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("oak"), () -> new VerticalSlabBlock(new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("spruce"), () -> new VerticalSlabBlock(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("warped"), () -> new VerticalSlabBlock(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));

        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("andesite"), () -> new VerticalSlabBlock(new BlockConfig().material("andesite").materialName("Andesite").ingredient(Blocks.ANDESITE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("bamboo_mosaic"), () -> new VerticalSlabBlock(new BlockConfig().material("bamboo_mosaic").materialName("Bamboo Mosaic").ingredient(Blocks.BAMBOO_MOSAIC).tool(Tool.AXE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("blackstone"), () -> new VerticalSlabBlock(new BlockConfig().material("blackstone").materialName("Blackstone").ingredient(Blocks.BLACKSTONE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("bricks").materialName("Brick").ingredient(Blocks.BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("cobbled_deepslate"), () -> new VerticalSlabBlock(new BlockConfig().material("cobbled_deepslate").materialName("Cobbled Deepslate").ingredient(Blocks.COBBLED_DEEPSLATE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("cobblestone"), () -> new VerticalSlabBlock(new BlockConfig().material("cobblestone").materialName("Cobblestone").ingredient(Blocks.COBBLESTONE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("cut_red_sandstone"), () -> new VerticalSlabBlock(new BlockConfig().material("cut_red_sandstone").materialName("Cut Red Sandstone").ingredient(Blocks.CUT_RED_SANDSTONE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("cut_sandstone"), () -> new VerticalSlabBlock(new BlockConfig().material("cut_sandstone").materialName("Cut Sandstone").ingredient(Blocks.CUT_SANDSTONE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("dark_prismarine"), () -> new VerticalSlabBlock(new BlockConfig().material("dark_prismarine").materialName("Dark Prismarine").ingredient(Blocks.DARK_PRISMARINE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("deepslate_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("deepslate_bricks").materialName("Deepslate Brick").ingredient(Blocks.DEEPSLATE_BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("deepslate_tiles"), () -> new VerticalSlabBlock(new BlockConfig().material("deepslate_tiles").materialName("Deepslate Tile").ingredient(Blocks.DEEPSLATE_TILES)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("diorite"), () -> new VerticalSlabBlock(new BlockConfig().material("diorite").materialName("Diorite").ingredient(Blocks.DIORITE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("end_stone_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("end_stone_bricks").materialName("End Stone Brick").ingredient(Blocks.END_STONE_BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("granite"), () -> new VerticalSlabBlock(new BlockConfig().material("granite").materialName("Granite").ingredient(Blocks.GRANITE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("mossy_cobblestone"), () -> new VerticalSlabBlock(new BlockConfig().material("mossy_cobblestone").materialName("Mossy Cobblestone").ingredient(Blocks.MOSSY_COBBLESTONE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("mossy_stone_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("mossy_stone_bricks").materialName("Mossy Stone Brick").ingredient(Blocks.MOSSY_STONE_BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("mud_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("mud_bricks").materialName("Mud Brick").ingredient(Blocks.MUD_BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("nether_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("nether_bricks").materialName("Nether Brick").ingredient(Blocks.NETHER_BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("polished_andesite"), () -> new VerticalSlabBlock(new BlockConfig().material("polished_andesite").materialName("Polished Andesite").ingredient(Blocks.POLISHED_ANDESITE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("polished_blackstone"), () -> new VerticalSlabBlock(new BlockConfig().material("polished_blackstone").materialName("Polished Blackstone").ingredient(Blocks.POLISHED_BLACKSTONE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("polished_blackstone_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("polished_blackstone_bricks").materialName("Polished Blackstone Brick").ingredient(Blocks.POLISHED_BLACKSTONE_BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("polished_deepslate"), () -> new VerticalSlabBlock(new BlockConfig().material("polished_deepslate").materialName("Polished Deepslate").ingredient(Blocks.POLISHED_DEEPSLATE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("polished_diorite"), () -> new VerticalSlabBlock(new BlockConfig().material("polished_diorite").materialName("Polished Diorite").ingredient(Blocks.POLISHED_DIORITE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("polished_granite"), () -> new VerticalSlabBlock(new BlockConfig().material("polished_granite").materialName("Polished Granite").ingredient(Blocks.POLISHED_GRANITE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("polished_tuff"), () -> new VerticalSlabBlock(new BlockConfig().material("polished_tuff").materialName("Polished Tuff").ingredient(Blocks.POLISHED_TUFF)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("prismarine"), () -> new VerticalSlabBlock(new BlockConfig().material("prismarine").materialName("Prismarine").ingredient(Blocks.PRISMARINE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("prismarine_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("prismarine_bricks").materialName("Prismarine Brick").ingredient(Blocks.PRISMARINE_BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("purpur_block"), () -> new VerticalSlabBlock(new BlockConfig().material("purpur_block").materialName("Purpur").ingredient(Blocks.PURPUR_BLOCK)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("quartz_block"), () -> new VerticalSlabBlock(new BlockConfig().material("quartz_block").materialName("Quartz").ingredient(Blocks.QUARTZ_BLOCK).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_top"))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("red_nether_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("red_nether_bricks").materialName("Red Nether Brick").ingredient(Blocks.RED_NETHER_BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("red_sandstone"), () -> new VerticalSlabBlock(new BlockConfig().material("red_sandstone").materialName("Red Sandstone").ingredient(Blocks.RED_SANDSTONE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("sandstone"), () -> new VerticalSlabBlock(new BlockConfig().material("sandstone").materialName("Sandstone").ingredient(Blocks.SANDSTONE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("smooth_quartz"), () -> new VerticalSlabBlock(new BlockConfig().material("smooth_quartz").materialName("Smooth Quartz").ingredient(Blocks.SMOOTH_QUARTZ).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_bottom"))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("smooth_red_sandstone"), () -> new VerticalSlabBlock(new BlockConfig().material("smooth_red_sandstone").materialName("Smooth Red Sandstone").ingredient(Blocks.SMOOTH_RED_SANDSTONE).texture(TextureUtils.block(Blocks.RED_SANDSTONE, "_top"))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("smooth_sandstone"), () -> new VerticalSlabBlock(new BlockConfig().material("smooth_sandstone").materialName("Smooth Sandstone").ingredient(Blocks.SMOOTH_SANDSTONE).texture(TextureUtils.block(Blocks.SANDSTONE, "_top"))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("smooth_stone"), () -> new VerticalSlabBlock(new BlockConfig().material("smooth_stone").materialName("Smooth Stone").ingredient(Blocks.SMOOTH_STONE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("stone"), () -> new VerticalSlabBlock(new BlockConfig().material("stone").materialName("Stone").ingredient(Blocks.STONE)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("stone_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("stone_bricks").materialName("Stone Brick").ingredient(Blocks.STONE_BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("tuff"), () -> new VerticalSlabBlock(new BlockConfig().material("tuff").materialName("Tuff").ingredient(Blocks.TUFF)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("tuff_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("tuff_bricks").materialName("Tuff Brick").ingredient(Blocks.TUFF_BRICKS)), DEFAULT_VERTICAL_SLAB_SETTINGS));

        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("cut_copper"), () -> new VerticalSlabBlock(new BlockConfig().material("cut_copper").materialName("Cut Copper").ingredient(Blocks.CUT_COPPER)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("waxed_cut_copper"), () -> new VerticalSlabBlock(new BlockConfig().material("waxed_cut_copper").materialName("Waxed Cut Copper").ingredient(Blocks.WAXED_CUT_COPPER).texture(TextureUtils.block(Blocks.CUT_COPPER))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("exposed_cut_copper"), () -> new VerticalSlabBlock(new BlockConfig().material("exposed_cut_copper").materialName("Exposed Cut Copper").ingredient(Blocks.EXPOSED_CUT_COPPER)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("waxed_exposed_cut_copper"), () -> new VerticalSlabBlock(new BlockConfig().material("waxed_exposed_cut_copper").materialName("Waxed Exposed Cut Copper").ingredient(Blocks.WAXED_EXPOSED_CUT_COPPER).texture(TextureUtils.block(Blocks.EXPOSED_CUT_COPPER))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("weathered_cut_copper"), () -> new VerticalSlabBlock(new BlockConfig().material("weathered_cut_copper").materialName("Weathered Cut Copper").ingredient(Blocks.WEATHERED_CUT_COPPER)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("waxed_weathered_cut_copper"), () -> new VerticalSlabBlock(new BlockConfig().material("waxed_weathered_cut_copper").materialName("Waxed Weathered Cut Copper").ingredient(Blocks.WAXED_WEATHERED_CUT_COPPER).texture(TextureUtils.block(Blocks.WEATHERED_CUT_COPPER))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("oxidized_cut_copper"), () -> new VerticalSlabBlock(new BlockConfig().material("oxidized_cut_copper").materialName("Oxidized Cut Copper").ingredient(Blocks.OXIDIZED_CUT_COPPER)), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("waxed_oxidized_cut_copper"), () -> new VerticalSlabBlock(new BlockConfig().material("waxed_oxidized_cut_copper").materialName("Waxed Oxidized Cut Copper").ingredient(Blocks.WAXED_OXIDIZED_CUT_COPPER).texture(TextureUtils.block(Blocks.OXIDIZED_CUT_COPPER))), DEFAULT_VERTICAL_SLAB_SETTINGS));

        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("basalt_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS.get()).texture(TextureUtils.block(BasaltBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("cracked_basalt_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS.get()).texture(TextureUtils.block(CrackedBasaltBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("crimson_basalt_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS.get()).texture(TextureUtils.block(CrimsonBasaltBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("mossy_basalt_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS.get()).texture(TextureUtils.block(MossyBasaltBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("warped_basalt_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS.get()).texture(TextureUtils.block(WarpedBasaltBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_SLAB_SETTINGS));
        VERTICAL_SLAB_BLOCKS.add(registerWithItem(VerticalSlabBlock.makeId("warped_nether_bricks"), () -> new VerticalSlabBlock(new BlockConfig().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS.get()).texture(TextureUtils.block(WarpedNetherBricksBlock.BLOCK_ID))), DEFAULT_VERTICAL_SLAB_SETTINGS));

        Bookshelves.BOOKSHELF_CONFIGS.forEach((material, config) -> {
            BOOKSHELF_SLAB_BLOCKS.add(
                registerWithItem(BookshelfSlabBlock.makeId(material),
                    () -> new BookshelfSlabBlock(config),
                    DEFAULT_SLAB_SETTINGS
                )
            );

            VERTICAL_BOOKSHELF_SLAB_BLOCKS.add(
                registerWithItem(VerticalBookshelfSlabBlock.makeId(material),
                    () -> new VerticalBookshelfSlabBlock(config),
                    DEFAULT_VERTICAL_SLAB_SETTINGS
                )
            );
        });
    }
}
