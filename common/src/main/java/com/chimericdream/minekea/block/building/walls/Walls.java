package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class Walls implements ModThingGroup {
    public static final Item.Settings DEFAULT_WALL_SETTINGS = new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS);

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(registerWithItem(WallBlock.makeId("basalt_bricks"), () -> new WallBlock(new BlockConfig().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS).texture(BasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))), DEFAULT_WALL_SETTINGS));
        BLOCKS.add(registerWithItem(WallBlock.makeId("cracked_basalt_bricks"), () -> new WallBlock(new BlockConfig().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS).texture(CrackedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))), DEFAULT_WALL_SETTINGS));
        BLOCKS.add(registerWithItem(WallBlock.makeId("crimson_basalt_bricks"), () -> new WallBlock(new BlockConfig().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS).texture(CrimsonBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))), DEFAULT_WALL_SETTINGS));
        BLOCKS.add(registerWithItem(WallBlock.makeId("mossy_basalt_bricks"), () -> new WallBlock(new BlockConfig().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS).texture(MossyBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))), DEFAULT_WALL_SETTINGS));
        BLOCKS.add(registerWithItem(WallBlock.makeId("warped_basalt_bricks"), () -> new WallBlock(new BlockConfig().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS).texture(WarpedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))), DEFAULT_WALL_SETTINGS));
        BLOCKS.add(registerWithItem(WallBlock.makeId("warped_nether_bricks"), () -> new WallBlock(new BlockConfig().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS).texture(WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/"))), DEFAULT_WALL_SETTINGS));
    }
}
