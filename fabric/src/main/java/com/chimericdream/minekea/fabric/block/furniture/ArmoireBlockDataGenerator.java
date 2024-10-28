package com.chimericdream.minekea.fabric.block.furniture;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.armoires.ArmoireBlock;
import com.chimericdream.minekea.fabric.data.blockstate.suppliers.CustomBlockStateModelSupplier;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;
import java.util.function.Function;

public class ArmoireBlockDataGenerator implements FabricBlockDataGenerator {
    protected final ArmoireBlock BLOCK;

    protected static final Model BOTTOM_MODEL = makeModel("block/furniture/armoires/bottom");
    protected static final Model TOP_MODEL = makeModel("block/furniture/armoires/top");
    protected static final Model ITEM_MODEL = makeModel("item/furniture/armoire");

    public ArmoireBlockDataGenerator(Block block) {
        BLOCK = (ArmoireBlock) block;
    }

    protected static Model makeModel(String id) {
        return new CustomBlockStateModelSupplier.CustomBlockModel(
            BlockConfig.RenderType.CUTOUT,
            Optional.of(Identifier.of(ModInfo.MOD_ID, id)),
            Optional.empty(),
            MinekeaTextures.BAR,
            MinekeaTextures.MATERIAL,
            MinekeaTextures.PLANKS
        );
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.AXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block slabIngredient = BLOCK.config.getIngredient("slab");
        Block plankIngredient = BLOCK.config.getIngredient("planks");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 1)
            .pattern("BSB")
            .pattern("BCB")
            .pattern("###")
            .input('B', slabIngredient)
            .input('C', Items.CHEST)
            .input('S', Items.ARMOR_STAND)
            .input('#', plankIngredient)
            .criterion(FabricRecipeProvider.hasItem(slabIngredient),
                FabricRecipeProvider.conditionsFromItem(slabIngredient))
            .criterion(FabricRecipeProvider.hasItem(Items.CHEST),
                FabricRecipeProvider.conditionsFromItem(Items.CHEST))
            .criterion(FabricRecipeProvider.hasItem(Items.ARMOR_STAND),
                FabricRecipeProvider.conditionsFromItem(Items.ARMOR_STAND))
            .criterion(FabricRecipeProvider.hasItem(plankIngredient),
                FabricRecipeProvider.conditionsFromItem(plankIngredient))
            .offerTo(exporter);
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK, generator.dropsWithProperty(BLOCK, ArmoireBlock.HALF, DoubleBlockHalf.LOWER));
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("%s Armor-oire", BLOCK.config.getMaterialName()));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.BAR, Registries.BLOCK.getId(Blocks.NETHERITE_BLOCK).withPrefixedPath("block/"))
            .put(MinekeaTextures.MATERIAL, Registries.BLOCK.getId(BLOCK.config.getIngredient("log")).withPrefixedPath("block/"))
            .put(MinekeaTextures.PLANKS, Registries.BLOCK.getId(Blocks.OAK_PLANKS).withPrefixedPath("block/"));

        Identifier topModelId = blockStateModelGenerator.createSubModel(BLOCK, "_top", TOP_MODEL, unused -> textures);
        Identifier bottomModelId = blockStateModelGenerator.createSubModel(BLOCK, "_bottom", BOTTOM_MODEL, unused -> textures);
        Identifier itemModelId = blockStateModelGenerator.createSubModel(BLOCK, "_item", ITEM_MODEL, unused -> textures);

        blockStateModelGenerator.registerParentedItemModel(BLOCK, itemModelId);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(BLOCK)
                    .with(
                        When.create()
                            .set(ArmoireBlock.FACING, Direction.NORTH)
                            .set(ArmoireBlock.HALF, DoubleBlockHalf.LOWER),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(ArmoireBlock.FACING, Direction.NORTH)
                            .set(ArmoireBlock.HALF, DoubleBlockHalf.UPPER),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(ArmoireBlock.FACING, Direction.SOUTH)
                            .set(ArmoireBlock.HALF, DoubleBlockHalf.LOWER),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(ArmoireBlock.FACING, Direction.SOUTH)
                            .set(ArmoireBlock.HALF, DoubleBlockHalf.UPPER),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(ArmoireBlock.FACING, Direction.EAST)
                            .set(ArmoireBlock.HALF, DoubleBlockHalf.LOWER),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(ArmoireBlock.FACING, Direction.EAST)
                            .set(ArmoireBlock.HALF, DoubleBlockHalf.UPPER),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(ArmoireBlock.FACING, Direction.WEST)
                            .set(ArmoireBlock.HALF, DoubleBlockHalf.LOWER),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(ArmoireBlock.FACING, Direction.WEST)
                            .set(ArmoireBlock.HALF, DoubleBlockHalf.UPPER),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topModelId)
                    )
            );
    }
}
