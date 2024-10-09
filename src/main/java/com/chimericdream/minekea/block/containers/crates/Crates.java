package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.minekea.entities.blocks.containers.CrateBlockEntity;
import com.chimericdream.minekea.screen.crate.CrateScreen;
import com.chimericdream.minekea.screen.crate.CrateScreenHandler;
import com.chimericdream.minekea.screen.crate.DoubleCrateScreen;
import com.chimericdream.minekea.screen.crate.DoubleCrateScreenHandler;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;

import java.util.ArrayList;
import java.util.List;

public class Crates implements MinekeaBlockCategory {
    public static final List<Block> CRATES = new ArrayList<>();

    public static BlockEntityType<CrateBlockEntity> CRATE_BLOCK_ENTITY;
    public static ScreenHandlerType<CrateScreenHandler> CRATE_SCREEN_HANDLER;
    public static ScreenHandlerType<DoubleCrateScreenHandler> DOUBLE_CRATE_SCREEN_HANDLER;

    static {
        CRATES.add(new GenericCrate(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).tagIngredient(ItemTags.ACACIA_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_ACACIA_LOG)).flammable()));
        CRATES.add(new GenericCrate(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).tagIngredient(ItemTags.BAMBOO_BLOCKS).texture("brace", TextureUtils.block(Blocks.STRIPPED_BAMBOO_BLOCK)).flammable()));
        CRATES.add(new GenericCrate(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).tagIngredient(ItemTags.BIRCH_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_BIRCH_LOG)).flammable()));
        CRATES.add(new GenericCrate(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).tagIngredient(ItemTags.CHERRY_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_CHERRY_LOG)).flammable()));
        CRATES.add(new GenericCrate(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).tagIngredient(ItemTags.CRIMSON_STEMS).texture("brace", TextureUtils.block(Blocks.STRIPPED_CRIMSON_STEM))));
        CRATES.add(new GenericCrate(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).tagIngredient(ItemTags.DARK_OAK_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_DARK_OAK_LOG)).flammable()));
        CRATES.add(new GenericCrate(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).tagIngredient(ItemTags.JUNGLE_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_JUNGLE_LOG)).flammable()));
        CRATES.add(new GenericCrate(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).tagIngredient(ItemTags.MANGROVE_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_MANGROVE_LOG)).flammable()));
        CRATES.add(new GenericCrate(new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).tagIngredient(ItemTags.OAK_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_OAK_LOG)).flammable()));
        CRATES.add(new GenericCrate(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).tagIngredient(ItemTags.SPRUCE_LOGS).texture("brace", TextureUtils.block(Blocks.STRIPPED_SPRUCE_LOG)).flammable()));
        CRATES.add(new GenericCrate(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).tagIngredient(ItemTags.WARPED_STEMS).texture("brace", TextureUtils.block(Blocks.STRIPPED_WARPED_STEM))));

        List<GenericCrate> trapped = new ArrayList<>();
        CRATES.forEach(crate -> {
            trapped.add(new TrappedCrate(((GenericCrate) crate).config, crate));
        });
        CRATES.addAll(trapped);

        CRATE_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            CrateScreenHandler.SCREEN_ID,
            new ScreenHandlerType<>(CrateScreenHandler::new, FeatureSet.empty())
        );

        DOUBLE_CRATE_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            DoubleCrateScreenHandler.SCREEN_ID,
            new ScreenHandlerType<>(DoubleCrateScreenHandler::new, FeatureSet.empty())
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        HandledScreens.register(CRATE_SCREEN_HANDLER, CrateScreen::new);
        HandledScreens.register(DOUBLE_CRATE_SCREEN_HANDLER, DoubleCrateScreen::new);
    }

    public List<Block> getCategoryBlocks() {
        return CRATES;
    }

    @Override
    public void registerBlockEntities() {
        CRATE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            CrateBlockEntity.ENTITY_ID,
            BlockEntityType.Builder.create(
                CrateBlockEntity::new,
                CRATES.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        MinekeaBlockCategory.super.configureTranslations(registryLookup, translationBuilder);

        translationBuilder.add("minekea:screens/container/crate", "Crate");
        translationBuilder.add("minekea:screens/container/double_crate", "Large Crate");
        translationBuilder.add("minekea:screens/container/crate/trapped", "Trapped Crate");
        translationBuilder.add("minekea:screens/container/double_crate/trapped", "Trapped Large Crate");
    }
}
