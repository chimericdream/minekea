package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.building.framed.FramedBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.ChiseledBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.block.building.general.WaxBlock;
import com.chimericdream.minekea.block.building.slabs.Slabs;
import com.chimericdream.minekea.block.building.stairs.Stairs;
import com.chimericdream.minekea.block.building.storage.StorageBlocks;
import com.chimericdream.minekea.block.building.walls.Walls;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

@SuppressWarnings("UnstableApiUsage")
public class BuildingBlocks implements ModThingGroup {
    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();
    public static final Map<String, RegistrySupplier<Block>> WAX_BLOCKS = new LinkedHashMap<>();

    public static final Item.Settings DEFAULT_SETTINGS = new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS);
    public static final Item.Settings WAX_BLOCK_SETTINGS = new Item.Settings().arch$tab(ItemGroups.COLORED_BLOCKS);

    public static final RegistrySupplier<Block> BASALT_BRICKS = registerWithItem(BasaltBricksBlock.BLOCK_ID, BasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> CHISELED_BASALT_BRICKS = registerWithItem(ChiseledBasaltBricksBlock.BLOCK_ID, ChiseledBasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> CRACKED_BASALT_BRICKS = registerWithItem(CrackedBasaltBricksBlock.BLOCK_ID, CrackedBasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> CRIMSON_BASALT_BRICKS = registerWithItem(CrimsonBasaltBricksBlock.BLOCK_ID, CrimsonBasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> MOSSY_BASALT_BRICKS = registerWithItem(MossyBasaltBricksBlock.BLOCK_ID, MossyBasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> WARPED_BASALT_BRICKS = registerWithItem(WarpedBasaltBricksBlock.BLOCK_ID, WarpedBasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> WARPED_NETHER_BRICKS = registerWithItem(WarpedNetherBricksBlock.BLOCK_ID, WarpedNetherBricksBlock::new, DEFAULT_SETTINGS);

    public static final RegistrySupplier<Block> PLAIN_WAX_BLOCK = registerWithItem(WaxBlock.makeId("plain"), () -> new WaxBlock("plain"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> WHITE_WAX_BLOCK = registerWithItem(WaxBlock.makeId("white"), () -> new WaxBlock("white"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> LIGHT_GRAY_WAX_BLOCK = registerWithItem(WaxBlock.makeId("light_gray"), () -> new WaxBlock("light_gray"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> GRAY_WAX_BLOCK = registerWithItem(WaxBlock.makeId("gray"), () -> new WaxBlock("gray"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> BLACK_WAX_BLOCK = registerWithItem(WaxBlock.makeId("black"), () -> new WaxBlock("black"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> BROWN_WAX_BLOCK = registerWithItem(WaxBlock.makeId("brown"), () -> new WaxBlock("brown"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> RED_WAX_BLOCK = registerWithItem(WaxBlock.makeId("red"), () -> new WaxBlock("red"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> ORANGE_WAX_BLOCK = registerWithItem(WaxBlock.makeId("orange"), () -> new WaxBlock("orange"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> YELLOW_WAX_BLOCK = registerWithItem(WaxBlock.makeId("yellow"), () -> new WaxBlock("yellow"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> LIME_WAX_BLOCK = registerWithItem(WaxBlock.makeId("lime"), () -> new WaxBlock("lime"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> GREEN_WAX_BLOCK = registerWithItem(WaxBlock.makeId("green"), () -> new WaxBlock("green"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> CYAN_WAX_BLOCK = registerWithItem(WaxBlock.makeId("cyan"), () -> new WaxBlock("cyan"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> LIGHT_BLUE_WAX_BLOCK = registerWithItem(WaxBlock.makeId("light_blue"), () -> new WaxBlock("light_blue"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> BLUE_WAX_BLOCK = registerWithItem(WaxBlock.makeId("blue"), () -> new WaxBlock("blue"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> PURPLE_WAX_BLOCK = registerWithItem(WaxBlock.makeId("purple"), () -> new WaxBlock("purple"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> MAGENTA_WAX_BLOCK = registerWithItem(WaxBlock.makeId("magenta"), () -> new WaxBlock("magenta"), WAX_BLOCK_SETTINGS);
    public static final RegistrySupplier<Block> PINK_WAX_BLOCK = registerWithItem(WaxBlock.makeId("pink"), () -> new WaxBlock("pink"), WAX_BLOCK_SETTINGS);

    static {
        BLOCKS.add(BASALT_BRICKS);
        BLOCKS.add(CHISELED_BASALT_BRICKS);
        BLOCKS.add(CRACKED_BASALT_BRICKS);
        BLOCKS.add(CRIMSON_BASALT_BRICKS);
        BLOCKS.add(MOSSY_BASALT_BRICKS);
        BLOCKS.add(WARPED_BASALT_BRICKS);
        BLOCKS.add(WARPED_NETHER_BRICKS);

        WAX_BLOCKS.put("plain", PLAIN_WAX_BLOCK);
        WAX_BLOCKS.put("white", WHITE_WAX_BLOCK);
        WAX_BLOCKS.put("light_gray", LIGHT_GRAY_WAX_BLOCK);
        WAX_BLOCKS.put("gray", GRAY_WAX_BLOCK);
        WAX_BLOCKS.put("black", BLACK_WAX_BLOCK);
        WAX_BLOCKS.put("brown", BROWN_WAX_BLOCK);
        WAX_BLOCKS.put("red", RED_WAX_BLOCK);
        WAX_BLOCKS.put("orange", ORANGE_WAX_BLOCK);
        WAX_BLOCKS.put("yellow", YELLOW_WAX_BLOCK);
        WAX_BLOCKS.put("lime", LIME_WAX_BLOCK);
        WAX_BLOCKS.put("green", GREEN_WAX_BLOCK);
        WAX_BLOCKS.put("cyan", CYAN_WAX_BLOCK);
        WAX_BLOCKS.put("light_blue", LIGHT_BLUE_WAX_BLOCK);
        WAX_BLOCKS.put("blue", BLUE_WAX_BLOCK);
        WAX_BLOCKS.put("purple", PURPLE_WAX_BLOCK);
        WAX_BLOCKS.put("magenta", MAGENTA_WAX_BLOCK);
        WAX_BLOCKS.put("pink", PINK_WAX_BLOCK);

        BLOCKS.addAll(WAX_BLOCKS.values());

        BLOCKS.addAll(Beams.BLOCKS);
        BLOCKS.addAll(CompressedBlocks.BLOCKS);
        BLOCKS.addAll(CompressedBlocks.COLUMN_BLOCKS);
        BLOCKS.addAll(CompressedBlocks.MINEKEA_BLOCKS);
        BLOCKS.addAll(Covers.BLOCKS);
        BLOCKS.addAll(DyedBlocks.BLOCK_MAP.values());
        BLOCKS.addAll(DyedBlocks.PILLAR_BLOCK_MAP.values());
        BLOCKS.addAll(FramedBlocks.FRAMED_PLANKS);
        BLOCKS.addAll(Slabs.SLAB_BLOCKS);
        BLOCKS.addAll(Slabs.VERTICAL_SLAB_BLOCKS);
        BLOCKS.addAll(Slabs.BOOKSHELF_SLAB_BLOCKS);
        BLOCKS.addAll(Slabs.VERTICAL_BOOKSHELF_SLAB_BLOCKS);
        BLOCKS.addAll(Stairs.STAIRS_BLOCKS);
        BLOCKS.addAll(Stairs.VERTICAL_STAIRS_BLOCKS);
        BLOCKS.addAll(Stairs.BOOKSHELF_STAIRS_BLOCKS);
        BLOCKS.addAll(Stairs.VERTICAL_BOOKSHELF_STAIRS_BLOCKS);
        BLOCKS.addAll(StorageBlocks.BLOCKS);
        BLOCKS.addAll(Walls.BLOCKS);
    }
}
