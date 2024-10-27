package com.chimericdream.minekea.block.furniture.seats;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.entities.SimpleSeatEntity;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.registry.ModRegistries;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerEntityType;
import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class Seats implements ModThingGroup {
    public static final Item.Settings DEFAULT_CHAIR_SETTINGS = new Item.Settings().arch$tab(ModRegistries.FURNITURE_ITEM_GROUP);
    public static final Item.Settings DEFAULT_STOOL_SETTINGS = new Item.Settings().arch$tab(ModRegistries.FURNITURE_ITEM_GROUP);

    public static final List<RegistrySupplier<Block>> CHAIR_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> STOOL_BLOCKS = new ArrayList<>();

    public static Identifier SEAT_ENTITY_ID = Identifier.of(ModInfo.MOD_ID, "entities/mounts/seat");
    public static final RegistrySupplier<EntityType<SimpleSeatEntity>> SEAT_ENTITY = registerEntityType(
        SEAT_ENTITY_ID,
        () -> EntityType.Builder.create(SimpleSeatEntity::new, SpawnGroup.MISC).build(SEAT_ENTITY_ID.toString())
    );

    static {
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("acacia"), () -> new ChairBlock(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("bamboo"), () -> new ChairBlock(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("birch"), () -> new ChairBlock(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("cherry"), () -> new ChairBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("crimson"), () -> new ChairBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("dark_oak"), () -> new ChairBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("jungle"), () -> new ChairBlock(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("mangrove"), () -> new ChairBlock(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("oak"), () -> new ChairBlock(new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("spruce"), () -> new ChairBlock(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("warped"), () -> new ChairBlock(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)), DEFAULT_CHAIR_SETTINGS));

        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_acacia"), () -> new ChairBlock(new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_bamboo"), () -> new ChairBlock(new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_birch"), () -> new ChairBlock(new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_cherry"), () -> new ChairBlock(new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_crimson"), () -> new ChairBlock(new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_dark_oak"), () -> new ChairBlock(new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_jungle"), () -> new ChairBlock(new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_mangrove"), () -> new ChairBlock(new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_oak"), () -> new ChairBlock(new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_spruce"), () -> new ChairBlock(new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()), DEFAULT_CHAIR_SETTINGS));
        CHAIR_BLOCKS.add(registerWithItem(ChairBlock.makeId("stripped_warped"), () -> new ChairBlock(new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)), DEFAULT_CHAIR_SETTINGS));

        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("acacia"), () -> new StoolBlock(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("bamboo"), () -> new StoolBlock(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("birch"), () -> new StoolBlock(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("cherry"), () -> new StoolBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("crimson"), () -> new StoolBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("dark_oak"), () -> new StoolBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("jungle"), () -> new StoolBlock(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("mangrove"), () -> new StoolBlock(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("oak"), () -> new StoolBlock(new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("spruce"), () -> new StoolBlock(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("warped"), () -> new StoolBlock(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)), DEFAULT_STOOL_SETTINGS));

        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_acacia"), () -> new StoolBlock(new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_bamboo"), () -> new StoolBlock(new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_birch"), () -> new StoolBlock(new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_cherry"), () -> new StoolBlock(new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_crimson"), () -> new StoolBlock(new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_dark_oak"), () -> new StoolBlock(new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_jungle"), () -> new StoolBlock(new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_mangrove"), () -> new StoolBlock(new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_oak"), () -> new StoolBlock(new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_spruce"), () -> new StoolBlock(new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()), DEFAULT_STOOL_SETTINGS));
        STOOL_BLOCKS.add(registerWithItem(StoolBlock.makeId("stripped_warped"), () -> new StoolBlock(new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)), DEFAULT_STOOL_SETTINGS));
    }
}
