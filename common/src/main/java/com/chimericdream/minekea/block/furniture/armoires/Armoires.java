package com.chimericdream.minekea.block.furniture.armoires;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entity.block.furniture.ArmoireBlockEntity;
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

public class Armoires implements ModThingGroup {
    public static final Item.Settings DEFAULT_ARMOIRE_SETTINGS = new Item.Settings().arch$tab(ModRegistries.FURNITURE_ITEM_GROUP);

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    public static Identifier ARMOIRE_BLOCK_ENTITY_ID = Identifier.of(ModInfo.MOD_ID, "entities/blocks/furniture/armoire");
    public static final RegistrySupplier<BlockEntityType<ArmoireBlockEntity>> ARMOIRE_BLOCK_ENTITY;

    static {
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("acacia"), () -> new ArmoireBlock(new BlockConfig().material("acacia").materialName("Acacia").ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).ingredient("slab", Blocks.ACACIA_SLAB).flammable()), DEFAULT_ARMOIRE_SETTINGS));
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("bamboo"), () -> new ArmoireBlock(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).ingredient("slab", Blocks.BAMBOO_SLAB).flammable()), DEFAULT_ARMOIRE_SETTINGS));
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("birch"), () -> new ArmoireBlock(new BlockConfig().material("birch").materialName("Birch").ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).ingredient("slab", Blocks.BIRCH_SLAB).flammable()), DEFAULT_ARMOIRE_SETTINGS));
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("cherry"), () -> new ArmoireBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).ingredient("slab", Blocks.CHERRY_SLAB).flammable()), DEFAULT_ARMOIRE_SETTINGS));
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("crimson"), () -> new ArmoireBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM).ingredient("slab", Blocks.CRIMSON_SLAB)), DEFAULT_ARMOIRE_SETTINGS));
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("dark_oak"), () -> new ArmoireBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).ingredient("slab", Blocks.DARK_OAK_SLAB).flammable()), DEFAULT_ARMOIRE_SETTINGS));
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("jungle"), () -> new ArmoireBlock(new BlockConfig().material("jungle").materialName("Jungle").ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).ingredient("slab", Blocks.JUNGLE_SLAB).flammable()), DEFAULT_ARMOIRE_SETTINGS));
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("mangrove"), () -> new ArmoireBlock(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).ingredient("slab", Blocks.MANGROVE_SLAB).flammable()), DEFAULT_ARMOIRE_SETTINGS));
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("oak"), () -> new ArmoireBlock(new BlockConfig().material("oak").materialName("Oak").ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).ingredient("slab", Blocks.OAK_SLAB).flammable()), DEFAULT_ARMOIRE_SETTINGS));
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("spruce"), () -> new ArmoireBlock(new BlockConfig().material("spruce").materialName("Spruce").ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).ingredient("slab", Blocks.SPRUCE_SLAB).flammable()), DEFAULT_ARMOIRE_SETTINGS));
        BLOCKS.add(registerWithItem(ArmoireBlock.makeId("warped"), () -> new ArmoireBlock(new BlockConfig().material("warped").materialName("Warped").ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM).ingredient("slab", Blocks.WARPED_SLAB)), DEFAULT_ARMOIRE_SETTINGS));

        ARMOIRE_BLOCK_ENTITY = registerBlockEntity(
            ARMOIRE_BLOCK_ENTITY_ID,
            () -> BlockEntityType.Builder
                .create(
                    ArmoireBlockEntity::new,
                    BLOCKS.stream().map(Supplier::get).toList().toArray(new Block[0])
                )
                .build(null)
        );
    }
}
