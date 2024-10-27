package com.chimericdream.minekea.block.furniture.shutters;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.registry.ModRegistries;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class Shutters implements ModThingGroup {
    public static final Item.Settings DEFAULT_SHUTTER_SETTINGS = new Item.Settings().arch$tab(ModRegistries.FURNITURE_ITEM_GROUP);
    public static final Item.Settings DEFAULT_SHUTTER_HALF_SETTINGS = new Item.Settings();

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();
    public static final Map<String, BlockConfig> CONFIGS = new LinkedHashMap<>();
    public static final Map<String, RegistrySupplier<Block>> SHUTTER_BLOCKS = new LinkedHashMap<>();
    public static final Map<String, RegistrySupplier<Block>> OPEN_SHUTTER_HALF_BLOCKS = new LinkedHashMap<>();

    static {
        CONFIGS.put("acacia", new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable());
        CONFIGS.put("bamboo", new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable());
        CONFIGS.put("birch", new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable());
        CONFIGS.put("cherry", new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable());
        CONFIGS.put("crimson", new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM));
        CONFIGS.put("dark_oak", new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable());
        CONFIGS.put("jungle", new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable());
        CONFIGS.put("mangrove", new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable());
        CONFIGS.put("oak", new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable());
        CONFIGS.put("spruce", new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable());
        CONFIGS.put("warped", new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM));

        CONFIGS.put("stripped_acacia", new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable());
        CONFIGS.put("stripped_bamboo", new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable());
        CONFIGS.put("stripped_birch", new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable());
        CONFIGS.put("stripped_cherry", new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable());
        CONFIGS.put("stripped_crimson", new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM));
        CONFIGS.put("stripped_dark_oak", new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable());
        CONFIGS.put("stripped_jungle", new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable());
        CONFIGS.put("stripped_mangrove", new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable());
        CONFIGS.put("stripped_oak", new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable());
        CONFIGS.put("stripped_spruce", new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable());
        CONFIGS.put("stripped_warped", new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM));

        SHUTTER_BLOCKS.put("acacia", registerWithItem(ShutterBlock.makeId("acacia"), () -> new ShutterBlock(BlockSetType.ACACIA, CONFIGS.get("acacia")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("bamboo", registerWithItem(ShutterBlock.makeId("bamboo"), () -> new ShutterBlock(BlockSetType.BAMBOO, CONFIGS.get("bamboo")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("birch", registerWithItem(ShutterBlock.makeId("birch"), () -> new ShutterBlock(BlockSetType.BIRCH, CONFIGS.get("birch")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("cherry", registerWithItem(ShutterBlock.makeId("cherry"), () -> new ShutterBlock(BlockSetType.CHERRY, CONFIGS.get("cherry")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("crimson", registerWithItem(ShutterBlock.makeId("crimson"), () -> new ShutterBlock(BlockSetType.CRIMSON, CONFIGS.get("crimson")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("dark_oak", registerWithItem(ShutterBlock.makeId("dark_oak"), () -> new ShutterBlock(BlockSetType.DARK_OAK, CONFIGS.get("dark_oak")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("jungle", registerWithItem(ShutterBlock.makeId("jungle"), () -> new ShutterBlock(BlockSetType.JUNGLE, CONFIGS.get("jungle")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("mangrove", registerWithItem(ShutterBlock.makeId("mangrove"), () -> new ShutterBlock(BlockSetType.MANGROVE, CONFIGS.get("mangrove")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("oak", registerWithItem(ShutterBlock.makeId("oak"), () -> new ShutterBlock(BlockSetType.OAK, CONFIGS.get("oak")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("spruce", registerWithItem(ShutterBlock.makeId("spruce"), () -> new ShutterBlock(BlockSetType.SPRUCE, CONFIGS.get("spruce")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("warped", registerWithItem(ShutterBlock.makeId("warped"), () -> new ShutterBlock(BlockSetType.WARPED, CONFIGS.get("warped")), DEFAULT_SHUTTER_SETTINGS));

        SHUTTER_BLOCKS.put("stripped_acacia", registerWithItem(ShutterBlock.makeId("stripped_acacia"), () -> new ShutterBlock(BlockSetType.ACACIA, CONFIGS.get("stripped_acacia")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("stripped_bamboo", registerWithItem(ShutterBlock.makeId("stripped_bamboo"), () -> new ShutterBlock(BlockSetType.BAMBOO, CONFIGS.get("stripped_bamboo")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("stripped_birch", registerWithItem(ShutterBlock.makeId("stripped_birch"), () -> new ShutterBlock(BlockSetType.BIRCH, CONFIGS.get("stripped_birch")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("stripped_cherry", registerWithItem(ShutterBlock.makeId("stripped_cherry"), () -> new ShutterBlock(BlockSetType.CHERRY, CONFIGS.get("stripped_cherry")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("stripped_crimson", registerWithItem(ShutterBlock.makeId("stripped_crimson"), () -> new ShutterBlock(BlockSetType.CRIMSON, CONFIGS.get("stripped_crimson")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("stripped_dark_oak", registerWithItem(ShutterBlock.makeId("stripped_dark_oak"), () -> new ShutterBlock(BlockSetType.DARK_OAK, CONFIGS.get("stripped_dark_oak")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("stripped_jungle", registerWithItem(ShutterBlock.makeId("stripped_jungle"), () -> new ShutterBlock(BlockSetType.JUNGLE, CONFIGS.get("stripped_jungle")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("stripped_mangrove", registerWithItem(ShutterBlock.makeId("stripped_mangrove"), () -> new ShutterBlock(BlockSetType.MANGROVE, CONFIGS.get("stripped_mangrove")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("stripped_oak", registerWithItem(ShutterBlock.makeId("stripped_oak"), () -> new ShutterBlock(BlockSetType.OAK, CONFIGS.get("stripped_oak")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("stripped_spruce", registerWithItem(ShutterBlock.makeId("stripped_spruce"), () -> new ShutterBlock(BlockSetType.SPRUCE, CONFIGS.get("stripped_spruce")), DEFAULT_SHUTTER_SETTINGS));
        SHUTTER_BLOCKS.put("stripped_warped", registerWithItem(ShutterBlock.makeId("stripped_warped"), () -> new ShutterBlock(BlockSetType.WARPED, CONFIGS.get("stripped_warped")), DEFAULT_SHUTTER_SETTINGS));

        OPEN_SHUTTER_HALF_BLOCKS.put("acacia", registerWithItem(OpenShutterHalfBlock.makeId("acacia"), () -> new OpenShutterHalfBlock(BlockSetType.ACACIA, CONFIGS.get("acacia")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("bamboo", registerWithItem(OpenShutterHalfBlock.makeId("bamboo"), () -> new OpenShutterHalfBlock(BlockSetType.BAMBOO, CONFIGS.get("bamboo")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("birch", registerWithItem(OpenShutterHalfBlock.makeId("birch"), () -> new OpenShutterHalfBlock(BlockSetType.BIRCH, CONFIGS.get("birch")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("cherry", registerWithItem(OpenShutterHalfBlock.makeId("cherry"), () -> new OpenShutterHalfBlock(BlockSetType.CHERRY, CONFIGS.get("cherry")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("crimson", registerWithItem(OpenShutterHalfBlock.makeId("crimson"), () -> new OpenShutterHalfBlock(BlockSetType.CRIMSON, CONFIGS.get("crimson")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("dark_oak", registerWithItem(OpenShutterHalfBlock.makeId("dark_oak"), () -> new OpenShutterHalfBlock(BlockSetType.DARK_OAK, CONFIGS.get("dark_oak")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("jungle", registerWithItem(OpenShutterHalfBlock.makeId("jungle"), () -> new OpenShutterHalfBlock(BlockSetType.JUNGLE, CONFIGS.get("jungle")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("mangrove", registerWithItem(OpenShutterHalfBlock.makeId("mangrove"), () -> new OpenShutterHalfBlock(BlockSetType.MANGROVE, CONFIGS.get("mangrove")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("oak", registerWithItem(OpenShutterHalfBlock.makeId("oak"), () -> new OpenShutterHalfBlock(BlockSetType.OAK, CONFIGS.get("oak")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("spruce", registerWithItem(OpenShutterHalfBlock.makeId("spruce"), () -> new OpenShutterHalfBlock(BlockSetType.SPRUCE, CONFIGS.get("spruce")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("warped", registerWithItem(OpenShutterHalfBlock.makeId("warped"), () -> new OpenShutterHalfBlock(BlockSetType.WARPED, CONFIGS.get("warped")), DEFAULT_SHUTTER_HALF_SETTINGS));

        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_acacia", registerWithItem(OpenShutterHalfBlock.makeId("stripped_acacia"), () -> new OpenShutterHalfBlock(BlockSetType.ACACIA, CONFIGS.get("stripped_acacia")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_bamboo", registerWithItem(OpenShutterHalfBlock.makeId("stripped_bamboo"), () -> new OpenShutterHalfBlock(BlockSetType.BAMBOO, CONFIGS.get("stripped_bamboo")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_birch", registerWithItem(OpenShutterHalfBlock.makeId("stripped_birch"), () -> new OpenShutterHalfBlock(BlockSetType.BIRCH, CONFIGS.get("stripped_birch")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_cherry", registerWithItem(OpenShutterHalfBlock.makeId("stripped_cherry"), () -> new OpenShutterHalfBlock(BlockSetType.CHERRY, CONFIGS.get("stripped_cherry")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_crimson", registerWithItem(OpenShutterHalfBlock.makeId("stripped_crimson"), () -> new OpenShutterHalfBlock(BlockSetType.CRIMSON, CONFIGS.get("stripped_crimson")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_dark_oak", registerWithItem(OpenShutterHalfBlock.makeId("stripped_dark_oak"), () -> new OpenShutterHalfBlock(BlockSetType.DARK_OAK, CONFIGS.get("stripped_dark_oak")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_jungle", registerWithItem(OpenShutterHalfBlock.makeId("stripped_jungle"), () -> new OpenShutterHalfBlock(BlockSetType.JUNGLE, CONFIGS.get("stripped_jungle")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_mangrove", registerWithItem(OpenShutterHalfBlock.makeId("stripped_mangrove"), () -> new OpenShutterHalfBlock(BlockSetType.MANGROVE, CONFIGS.get("stripped_mangrove")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_oak", registerWithItem(OpenShutterHalfBlock.makeId("stripped_oak"), () -> new OpenShutterHalfBlock(BlockSetType.OAK, CONFIGS.get("stripped_oak")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_spruce", registerWithItem(OpenShutterHalfBlock.makeId("stripped_spruce"), () -> new OpenShutterHalfBlock(BlockSetType.SPRUCE, CONFIGS.get("stripped_spruce")), DEFAULT_SHUTTER_HALF_SETTINGS));
        OPEN_SHUTTER_HALF_BLOCKS.put("stripped_warped", registerWithItem(OpenShutterHalfBlock.makeId("stripped_warped"), () -> new OpenShutterHalfBlock(BlockSetType.WARPED, CONFIGS.get("stripped_warped")), DEFAULT_SHUTTER_HALF_SETTINGS));

        BLOCKS.addAll(SHUTTER_BLOCKS.values());
        BLOCKS.addAll(OPEN_SHUTTER_HALF_BLOCKS.values());
    }
}
