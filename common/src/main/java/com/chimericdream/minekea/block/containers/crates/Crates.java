package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.minekea.client.screen.crate.CrateScreenHandler;
import com.chimericdream.minekea.client.screen.crate.DoubleCrateScreenHandler;
import com.chimericdream.minekea.entity.block.containers.CrateBlockEntity;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static com.chimericdream.minekea.registry.ModRegistries.registerBlockEntity;
import static com.chimericdream.minekea.registry.ModRegistries.registerScreenHandler;
import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class Crates implements ModThingGroup {
    public static final Item.Settings DEFAULT_CRATE_SETTINGS = new Item.Settings().arch$tab(ItemGroups.FUNCTIONAL);

    public static RegistrySupplier<BlockEntityType<CrateBlockEntity>> CRATE_BLOCK_ENTITY;

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();
    public static final Map<String, BlockConfig> CONFIGS = new LinkedHashMap<>();

    public static final Map<String, RegistrySupplier<Block>> CRATES = new LinkedHashMap<>();
    public static final Map<String, RegistrySupplier<Block>> TRAPPED_CRATES = new LinkedHashMap<>();

    public static final RegistrySupplier<ScreenHandlerType<CrateScreenHandler>> CRATE_SCREEN_HANDLER = registerScreenHandler(
        CrateScreenHandler.SCREEN_ID,
        () -> new ScreenHandlerType<>(CrateScreenHandler::new, FeatureSet.empty())
    );
    public static final RegistrySupplier<ScreenHandlerType<DoubleCrateScreenHandler>> DOUBLE_CRATE_SCREEN_HANDLER = registerScreenHandler(
        DoubleCrateScreenHandler.SCREEN_ID,
        () -> new ScreenHandlerType<>(DoubleCrateScreenHandler::new, FeatureSet.empty())
    );

    static {
        CONFIGS.put("acacia", new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).tagIngredient(ItemTags.ACACIA_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_ACACIA_LOG)).flammable());
        CONFIGS.put("bamboo", new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).tagIngredient(ItemTags.BAMBOO_BLOCKS).texture("brace", TextureUtils.block(Blocks.STRIPPED_BAMBOO_BLOCK)).flammable());
        CONFIGS.put("birch", new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).tagIngredient(ItemTags.BIRCH_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_BIRCH_LOG)).flammable());
        CONFIGS.put("cherry", new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).tagIngredient(ItemTags.CHERRY_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_CHERRY_LOG)).flammable());
        CONFIGS.put("crimson", new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).tagIngredient(ItemTags.CRIMSON_STEMS).texture("brace", TextureUtils.block(Blocks.STRIPPED_CRIMSON_STEM)));
        CONFIGS.put("dark_oak", new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).tagIngredient(ItemTags.DARK_OAK_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_DARK_OAK_LOG)).flammable());
        CONFIGS.put("jungle", new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).tagIngredient(ItemTags.JUNGLE_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_JUNGLE_LOG)).flammable());
        CONFIGS.put("mangrove", new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).tagIngredient(ItemTags.MANGROVE_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_MANGROVE_LOG)).flammable());
        CONFIGS.put("oak", new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).tagIngredient(ItemTags.OAK_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_OAK_LOG)).flammable());
        CONFIGS.put("spruce", new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).tagIngredient(ItemTags.SPRUCE_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_SPRUCE_LOG)).flammable());
        CONFIGS.put("warped", new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).tagIngredient(ItemTags.WARPED_STEMS).texture("brace", TextureUtils.block(Blocks.STRIPPED_WARPED_STEM)));

        CRATES.put("acacia", registerWithItem(CrateBlock.makeId("acacia"), () -> new CrateBlock(CONFIGS.get("acacia")), DEFAULT_CRATE_SETTINGS));
        CRATES.put("bamboo", registerWithItem(CrateBlock.makeId("bamboo"), () -> new CrateBlock(CONFIGS.get("bamboo")), DEFAULT_CRATE_SETTINGS));
        CRATES.put("birch", registerWithItem(CrateBlock.makeId("birch"), () -> new CrateBlock(CONFIGS.get("birch")), DEFAULT_CRATE_SETTINGS));
        CRATES.put("cherry", registerWithItem(CrateBlock.makeId("cherry"), () -> new CrateBlock(CONFIGS.get("cherry")), DEFAULT_CRATE_SETTINGS));
        CRATES.put("crimson", registerWithItem(CrateBlock.makeId("crimson"), () -> new CrateBlock(CONFIGS.get("crimson")), DEFAULT_CRATE_SETTINGS));
        CRATES.put("dark_oak", registerWithItem(CrateBlock.makeId("dark_oak"), () -> new CrateBlock(CONFIGS.get("dark_oak")), DEFAULT_CRATE_SETTINGS));
        CRATES.put("jungle", registerWithItem(CrateBlock.makeId("jungle"), () -> new CrateBlock(CONFIGS.get("jungle")), DEFAULT_CRATE_SETTINGS));
        CRATES.put("mangrove", registerWithItem(CrateBlock.makeId("mangrove"), () -> new CrateBlock(CONFIGS.get("mangrove")), DEFAULT_CRATE_SETTINGS));
        CRATES.put("oak", registerWithItem(CrateBlock.makeId("oak"), () -> new CrateBlock(CONFIGS.get("oak")), DEFAULT_CRATE_SETTINGS));
        CRATES.put("spruce", registerWithItem(CrateBlock.makeId("spruce"), () -> new CrateBlock(CONFIGS.get("spruce")), DEFAULT_CRATE_SETTINGS));
        CRATES.put("warped", registerWithItem(CrateBlock.makeId("warped"), () -> new CrateBlock(CONFIGS.get("warped")), DEFAULT_CRATE_SETTINGS));

        TRAPPED_CRATES.put("acacia", registerWithItem(TrappedCrateBlock.makeId("acacia"), () -> new TrappedCrateBlock(CONFIGS.get("acacia"), CRATES.get("acacia")), DEFAULT_CRATE_SETTINGS));
        TRAPPED_CRATES.put("bamboo", registerWithItem(TrappedCrateBlock.makeId("bamboo"), () -> new TrappedCrateBlock(CONFIGS.get("bamboo"), CRATES.get("bamboo")), DEFAULT_CRATE_SETTINGS));
        TRAPPED_CRATES.put("birch", registerWithItem(TrappedCrateBlock.makeId("birch"), () -> new TrappedCrateBlock(CONFIGS.get("birch"), CRATES.get("birch")), DEFAULT_CRATE_SETTINGS));
        TRAPPED_CRATES.put("cherry", registerWithItem(TrappedCrateBlock.makeId("cherry"), () -> new TrappedCrateBlock(CONFIGS.get("cherry"), CRATES.get("cherry")), DEFAULT_CRATE_SETTINGS));
        TRAPPED_CRATES.put("crimson", registerWithItem(TrappedCrateBlock.makeId("crimson"), () -> new TrappedCrateBlock(CONFIGS.get("crimson"), CRATES.get("crimson")), DEFAULT_CRATE_SETTINGS));
        TRAPPED_CRATES.put("dark_oak", registerWithItem(TrappedCrateBlock.makeId("dark_oak"), () -> new TrappedCrateBlock(CONFIGS.get("dark_oak"), CRATES.get("dark_oak")), DEFAULT_CRATE_SETTINGS));
        TRAPPED_CRATES.put("jungle", registerWithItem(TrappedCrateBlock.makeId("jungle"), () -> new TrappedCrateBlock(CONFIGS.get("jungle"), CRATES.get("jungle")), DEFAULT_CRATE_SETTINGS));
        TRAPPED_CRATES.put("mangrove", registerWithItem(TrappedCrateBlock.makeId("mangrove"), () -> new TrappedCrateBlock(CONFIGS.get("mangrove"), CRATES.get("mangrove")), DEFAULT_CRATE_SETTINGS));
        TRAPPED_CRATES.put("oak", registerWithItem(TrappedCrateBlock.makeId("oak"), () -> new TrappedCrateBlock(CONFIGS.get("oak"), CRATES.get("oak")), DEFAULT_CRATE_SETTINGS));
        TRAPPED_CRATES.put("spruce", registerWithItem(TrappedCrateBlock.makeId("spruce"), () -> new TrappedCrateBlock(CONFIGS.get("spruce"), CRATES.get("spruce")), DEFAULT_CRATE_SETTINGS));
        TRAPPED_CRATES.put("warped", registerWithItem(TrappedCrateBlock.makeId("warped"), () -> new TrappedCrateBlock(CONFIGS.get("warped"), CRATES.get("warped")), DEFAULT_CRATE_SETTINGS));

        BLOCKS.addAll(CRATES.values());
        BLOCKS.addAll(TRAPPED_CRATES.values());

        CRATE_BLOCK_ENTITY = registerBlockEntity(
            CrateBlockEntity.ENTITY_ID,
            () -> BlockEntityType.Builder
                .create(
                    CrateBlockEntity::new,
                    BLOCKS.stream().map(Supplier::get).toList().toArray(new Block[0])
                )
                .build(null)
        );
    }
}
