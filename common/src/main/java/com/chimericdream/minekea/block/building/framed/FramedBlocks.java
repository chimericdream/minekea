package com.chimericdream.minekea.block.building.framed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class FramedBlocks implements ModThingGroup {
    public static final Item.Settings DEFAULT_FRAMED_BLOCK_SETTINGS = new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS);

    public static final List<RegistrySupplier<Block>> FRAMED_PLANKS = new ArrayList<>();

    static {
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("acacia"), () -> new FramedPlanksBlock(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("acacia_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("acacia_stripped").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("bamboo"), () -> new FramedPlanksBlock(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("bamboo_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("bamboo_stripped").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("birch"), () -> new FramedPlanksBlock(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("birch_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("birch_stripped").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("cherry"), () -> new FramedPlanksBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("cherry_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("cherry_stripped").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("crimson"), () -> new FramedPlanksBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("crimson_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("crimson_stripped").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("dark_oak"), () -> new FramedPlanksBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("dark_oak_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("dark_oak_stripped").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("jungle"), () -> new FramedPlanksBlock(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("jungle_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("jungle_stripped").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("mangrove"), () -> new FramedPlanksBlock(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("mangrove_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("mangrove_stripped").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("oak"), () -> new FramedPlanksBlock(new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("oak_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("oak_stripped").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("spruce"), () -> new FramedPlanksBlock(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("spruce_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("spruce_stripped").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("warped"), () -> new FramedPlanksBlock(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)), DEFAULT_FRAMED_BLOCK_SETTINGS));
        FRAMED_PLANKS.add(registerWithItem(FramedPlanksBlock.makeId("warped_stripped"), () -> new FramedPlanksBlock(new BlockConfig().material("warped_stripped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)), DEFAULT_FRAMED_BLOCK_SETTINGS));
    }
}
