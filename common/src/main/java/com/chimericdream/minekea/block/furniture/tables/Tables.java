package com.chimericdream.minekea.block.furniture.tables;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.registry.ModRegistries;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class Tables implements ModThingGroup {
    public static final Item.Settings DEFAULT_TABLE_SETTINGS = new Item.Settings().arch$tab(ModRegistries.FURNITURE_ITEM_GROUP);

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(registerWithItem(TableBlock.makeId("acacia"), () -> new TableBlock(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("bamboo"), () -> new TableBlock(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("birch"), () -> new TableBlock(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("cherry"), () -> new TableBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("crimson"), () -> new TableBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("dark_oak"), () -> new TableBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("jungle"), () -> new TableBlock(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("mangrove"), () -> new TableBlock(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("oak"), () -> new TableBlock(new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("spruce"), () -> new TableBlock(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("warped"), () -> new TableBlock(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)), DEFAULT_TABLE_SETTINGS));

        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_acacia"), () -> new TableBlock(new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_bamboo"), () -> new TableBlock(new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_birch"), () -> new TableBlock(new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_cherry"), () -> new TableBlock(new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_crimson"), () -> new TableBlock(new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_dark_oak"), () -> new TableBlock(new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_jungle"), () -> new TableBlock(new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_mangrove"), () -> new TableBlock(new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_oak"), () -> new TableBlock(new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_spruce"), () -> new TableBlock(new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(registerWithItem(TableBlock.makeId("stripped_warped"), () -> new TableBlock(new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)), DEFAULT_TABLE_SETTINGS));
    }
}
