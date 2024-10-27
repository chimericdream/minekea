package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entity.block.furniture.DisplayCaseBlockEntity;
import com.chimericdream.minekea.registry.ModRegistries;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.chimericdream.minekea.registry.ModRegistries.registerBlockEntity;
import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class DisplayCases implements ModThingGroup {
    public static final Item.Settings DEFAULT_DISPLAY_CASE_SETTINGS = new Item.Settings().arch$tab(ModRegistries.FURNITURE_ITEM_GROUP);

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    public static Identifier DISPLAY_CASE_BLOCK_ENTITY_ID = Identifier.of(ModInfo.MOD_ID, "entities/blocks/furniture/display_case");
    public static RegistrySupplier<BlockEntityType<DisplayCaseBlockEntity>> DISPLAY_CASE_BLOCK_ENTITY;

    static {
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("acacia"), () -> new DisplayCaseBlock(new BlockConfig().material("acacia").materialName("Acacia").ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).ingredient("stripped_log", Blocks.STRIPPED_ACACIA_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("bamboo"), () -> new DisplayCaseBlock(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).ingredient("stripped_log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("birch"), () -> new DisplayCaseBlock(new BlockConfig().material("birch").materialName("Birch").ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).ingredient("stripped_log", Blocks.STRIPPED_BIRCH_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("cherry"), () -> new DisplayCaseBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).ingredient("stripped_log", Blocks.STRIPPED_CHERRY_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("crimson"), () -> new DisplayCaseBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM).ingredient("stripped_log", Blocks.STRIPPED_CRIMSON_STEM)), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("dark_oak"), () -> new DisplayCaseBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).ingredient("stripped_log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("jungle"), () -> new DisplayCaseBlock(new BlockConfig().material("jungle").materialName("Jungle").ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).ingredient("stripped_log", Blocks.STRIPPED_JUNGLE_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("mangrove"), () -> new DisplayCaseBlock(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).ingredient("stripped_log", Blocks.STRIPPED_MANGROVE_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("oak"), () -> new DisplayCaseBlock(new BlockConfig().material("oak").materialName("Oak").ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).ingredient("stripped_log", Blocks.STRIPPED_OAK_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("spruce"), () -> new DisplayCaseBlock(new BlockConfig().material("spruce").materialName("Spruce").ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).ingredient("stripped_log", Blocks.STRIPPED_SPRUCE_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("warped"), () -> new DisplayCaseBlock(new BlockConfig().material("warped").materialName("Warped").ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM).ingredient("stripped_log", Blocks.STRIPPED_WARPED_STEM)), DEFAULT_DISPLAY_CASE_SETTINGS));

        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/acacia"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/acacia").materialName("Stripped Acacia").ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/bamboo"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/bamboo").materialName("Stripped Bamboo").ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/birch"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/birch").materialName("Stripped Birch").ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/cherry"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/cherry").materialName("Stripped Cherry").ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/crimson"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/crimson").materialName("Stripped Crimson").ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/dark_oak"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/dark_oak").materialName("Stripped Dark Oak").ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/jungle"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/jungle").materialName("Stripped Jungle").ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/mangrove"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/mangrove").materialName("Stripped Mangrove").ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/oak"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/oak").materialName("Stripped Oak").ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/spruce"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/spruce").materialName("Stripped Spruce").ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()), DEFAULT_DISPLAY_CASE_SETTINGS));
        BLOCKS.add(registerWithItem(DisplayCaseBlock.makeId("stripped/warped"), () -> new DisplayCaseBlock(new BlockConfig().material("stripped/warped").materialName("Stripped Warped").ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)), DEFAULT_DISPLAY_CASE_SETTINGS));

        DISPLAY_CASE_BLOCK_ENTITY = registerBlockEntity(
            DISPLAY_CASE_BLOCK_ENTITY_ID,
            () -> BlockEntityType.Builder
                .create(
                    DisplayCaseBlockEntity::new,
                    BLOCKS.stream().map(Supplier::get).toList().toArray(new Block[0])
                )
                .build(null)
        );
    }
}
