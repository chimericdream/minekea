package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entity.block.furniture.ShelfBlockEntity;
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

public class Shelves implements ModThingGroup {
    public static final Item.Settings DEFAULT_SHELF_SETTINGS = new Item.Settings().arch$tab(ModRegistries.FURNITURE_ITEM_GROUP);

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> SHELF_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> FLOATING_SHELF_BLOCKS = new ArrayList<>();

    public static final Identifier SHELF_BLOCK_ENTITY_ID = Identifier.of(ModInfo.MOD_ID, "entities/blocks/furniture/shelf");
    public static RegistrySupplier<BlockEntityType<ShelfBlockEntity>> SHELF_BLOCK_ENTITY;

    static {
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("acacia"), () -> new ShelfBlock(new BlockConfig().material("acacia").materialName("Acacia").ingredient("slab", Blocks.ACACIA_SLAB).ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()), DEFAULT_SHELF_SETTINGS));
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("bamboo"), () -> new ShelfBlock(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient("slab", Blocks.BAMBOO_SLAB).ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()), DEFAULT_SHELF_SETTINGS));
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("birch"), () -> new ShelfBlock(new BlockConfig().material("birch").materialName("Birch").ingredient("slab", Blocks.BIRCH_SLAB).ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()), DEFAULT_SHELF_SETTINGS));
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("cherry"), () -> new ShelfBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient("slab", Blocks.CHERRY_SLAB).ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()), DEFAULT_SHELF_SETTINGS));
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("crimson"), () -> new ShelfBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient("slab", Blocks.CRIMSON_SLAB).ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)), DEFAULT_SHELF_SETTINGS));
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("dark_oak"), () -> new ShelfBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient("slab", Blocks.DARK_OAK_SLAB).ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()), DEFAULT_SHELF_SETTINGS));
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("jungle"), () -> new ShelfBlock(new BlockConfig().material("jungle").materialName("Jungle").ingredient("slab", Blocks.JUNGLE_SLAB).ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()), DEFAULT_SHELF_SETTINGS));
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("mangrove"), () -> new ShelfBlock(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient("slab", Blocks.MANGROVE_SLAB).ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()), DEFAULT_SHELF_SETTINGS));
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("oak"), () -> new ShelfBlock(new BlockConfig().material("oak").materialName("Oak").ingredient("slab", Blocks.OAK_SLAB).ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()), DEFAULT_SHELF_SETTINGS));
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("spruce"), () -> new ShelfBlock(new BlockConfig().material("spruce").materialName("Spruce").ingredient("slab", Blocks.SPRUCE_SLAB).ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()), DEFAULT_SHELF_SETTINGS));
        SHELF_BLOCKS.add(registerWithItem(ShelfBlock.makeId("warped"), () -> new ShelfBlock(new BlockConfig().material("warped").materialName("Warped").ingredient("slab", Blocks.WARPED_SLAB).ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)), DEFAULT_SHELF_SETTINGS));

        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("acacia"), () -> new FloatingShelfBlock(new BlockConfig().material("acacia").materialName("Acacia").ingredient("slab", Blocks.ACACIA_SLAB).ingredient("planks", Blocks.ACACIA_PLANKS).flammable()), DEFAULT_SHELF_SETTINGS));
        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("bamboo"), () -> new FloatingShelfBlock(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient("slab", Blocks.BAMBOO_SLAB).ingredient("planks", Blocks.BAMBOO_PLANKS).flammable()), DEFAULT_SHELF_SETTINGS));
        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("birch"), () -> new FloatingShelfBlock(new BlockConfig().material("birch").materialName("Birch").ingredient("slab", Blocks.BIRCH_SLAB).ingredient("planks", Blocks.BIRCH_PLANKS).flammable()), DEFAULT_SHELF_SETTINGS));
        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("cherry"), () -> new FloatingShelfBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient("slab", Blocks.CHERRY_SLAB).ingredient("planks", Blocks.CHERRY_PLANKS).flammable()), DEFAULT_SHELF_SETTINGS));
        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("crimson"), () -> new FloatingShelfBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient("slab", Blocks.CRIMSON_SLAB).ingredient("planks", Blocks.CRIMSON_PLANKS)), DEFAULT_SHELF_SETTINGS));
        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("dark_oak"), () -> new FloatingShelfBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient("slab", Blocks.DARK_OAK_SLAB).ingredient("planks", Blocks.DARK_OAK_PLANKS).flammable()), DEFAULT_SHELF_SETTINGS));
        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("jungle"), () -> new FloatingShelfBlock(new BlockConfig().material("jungle").materialName("Jungle").ingredient("slab", Blocks.JUNGLE_SLAB).ingredient("planks", Blocks.JUNGLE_PLANKS).flammable()), DEFAULT_SHELF_SETTINGS));
        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("mangrove"), () -> new FloatingShelfBlock(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient("slab", Blocks.MANGROVE_SLAB).ingredient("planks", Blocks.MANGROVE_PLANKS).flammable()), DEFAULT_SHELF_SETTINGS));
        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("oak"), () -> new FloatingShelfBlock(new BlockConfig().material("oak").materialName("Oak").ingredient("slab", Blocks.OAK_SLAB).ingredient("planks", Blocks.OAK_PLANKS).flammable()), DEFAULT_SHELF_SETTINGS));
        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("spruce"), () -> new FloatingShelfBlock(new BlockConfig().material("spruce").materialName("Spruce").ingredient("slab", Blocks.SPRUCE_SLAB).ingredient("planks", Blocks.SPRUCE_PLANKS).flammable()), DEFAULT_SHELF_SETTINGS));
        FLOATING_SHELF_BLOCKS.add(registerWithItem(FloatingShelfBlock.makeId("warped"), () -> new FloatingShelfBlock(new BlockConfig().material("warped").materialName("Warped").ingredient("slab", Blocks.WARPED_SLAB).ingredient("planks", Blocks.WARPED_PLANKS)), DEFAULT_SHELF_SETTINGS));

        BLOCKS.addAll(SHELF_BLOCKS);
        BLOCKS.addAll(FLOATING_SHELF_BLOCKS);

        SHELF_BLOCK_ENTITY = registerBlockEntity(
            SHELF_BLOCK_ENTITY_ID,
            () -> BlockEntityType.Builder
                .create(
                    ShelfBlockEntity::new,
                    BLOCKS.stream().map(Supplier::get).toList().toArray(new Block[0])
                )
                .build(null)
        );
    }
}
