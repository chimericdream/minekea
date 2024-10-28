package com.chimericdream.minekea.fabric.block.building.storage;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.storage.ItemStorageBlock;
import com.chimericdream.minekea.fabric.data.blockstate.suppliers.CustomBlockStateModelSupplier;
import com.chimericdream.minekea.fabric.data.model.ModelUtils;
import com.chimericdream.minekea.resource.MinekeaTextures;
import com.chimericdream.minekea.tag.MinekeaItemTags;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemStorageBlockDataGenerator implements FabricBlockDataGenerator {
    public final ItemStorageBlock BLOCK;

    public ItemStorageBlockDataGenerator(Block block) {
        this.BLOCK = (ItemStorageBlock) block;
    }

    protected static Model makeCubeModel(BlockConfig.RenderType renderType) {
        return new CustomBlockStateModelSupplier.CustomBlockModel(
            renderType,
            Optional.of(Identifier.of("block/cube_all")),
            Optional.empty(),
            TextureKey.ALL
        );
    }

    protected static Model makeColumnModel(BlockConfig.RenderType renderType) {
        return new CustomBlockStateModelSupplier.CustomBlockModel(
            renderType,
            Optional.of(Identifier.of("minekea:block/storage/compressed_column")),
            Optional.empty(),
            TextureKey.BOTTOM,
            TextureKey.SIDE,
            TextureKey.TOP
        );
    }

    protected static Model makeBaggedModel(BlockConfig.RenderType renderType) {
        return new CustomBlockStateModelSupplier.CustomBlockModel(
            renderType,
            Optional.of(Identifier.of("minekea:block/storage/bagged_block")),
            Optional.empty(),
            MinekeaTextures.CONTENTS
        );
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.PICKAXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        if (BLOCK.isBaggedItem) {
            getBuilder.apply(MinekeaItemTags.BAGGED_ITEMS)
                .setReplace(false)
                .add(BLOCK.asItem());
        }
    }

    public void configureRecipes(RecipeExporter exporter) {
        Item baseItem = BLOCK.config.getItem();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 1)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .input('#', baseItem)
            .criterion(FabricRecipeProvider.hasItem(baseItem),
                FabricRecipeProvider.conditionsFromItem(baseItem))
            .offerTo(exporter);

        // This means that things like totems won't be uncraftable; modpacks which have some method to override
        // the max stack size can re-add these recipes in a datapack
        if (baseItem.getMaxCount() >= 9) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, baseItem, 9)
                .input(BLOCK)
                .criterion(FabricRecipeProvider.hasItem(BLOCK),
                    FabricRecipeProvider.conditionsFromItem(BLOCK))
                .offerTo(exporter, Registries.ITEM.getId(baseItem).withSuffixedPath("_from_compressed"));
        }
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        if (BLOCK.config.getName() != null) {
            translationBuilder.add(BLOCK, BLOCK.config.getName());
        } else {
            translationBuilder.add(BLOCK, String.format("Compressed %s", BLOCK.config.getMaterialName()));
        }
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureBaggedBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.CONTENTS, Identifier.of(ModInfo.MOD_ID, String.format("block/%s", BLOCK.BLOCK_ID.getPath())))
            .put(TextureKey.ALL, Identifier.of(ModInfo.MOD_ID, String.format("block/%s", BLOCK.BLOCK_ID.getPath())));

        configureBaggedBlockModels(blockStateModelGenerator, textures);
    }

    public void configureBaggedBlockModels(BlockStateModelGenerator blockStateModelGenerator, TextureMap textures) {
        Identifier baggedModelId = blockStateModelGenerator.createSubModel(BLOCK, "_bagged", makeBaggedModel(BlockConfig.RenderType.CUTOUT), unused -> textures);
        Identifier baseModelId = blockStateModelGenerator.createSubModel(BLOCK, "", Models.CUBE_ALL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(BLOCK)
                    .with(
                        When.create().set(ItemStorageBlock.IS_BAGGED, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baggedModelId)
                    )
                    .with(
                        When.create().set(ItemStorageBlock.IS_BAGGED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                    )
            );

        blockStateModelGenerator.excludeFromSimpleItemModelGeneration(BLOCK);
    }

    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        if (BLOCK.isBaggedItem) {
            Block self = BLOCK;

            itemModelGenerator.writer.accept(ModelIds.getItemModelId(BLOCK.asItem()), new Supplier<JsonElement>() {
                @Override
                public JsonElement get() {
                    JsonArray overrides = new JsonArray();

                    JsonObject override = new JsonObject();
                    JsonObject predicate = new JsonObject();
                    predicate.addProperty("custom_model_data", 9001);
                    override.add("predicate", predicate);
                    override.addProperty("model", ModelIds.getBlockModelId(self).withSuffixedPath("_bagged").toString());

                    overrides.add(override);

                    JsonObject modelJson = new JsonObject();
                    modelJson.addProperty("parent", ModelIds.getBlockModelId(self).toString());
                    modelJson.add("overrides", overrides);

                    return modelJson;
                }
            });
        }
    }

    protected void configureCustomBaggedBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier contentsTexture = BLOCK.config.getTexture("contents");
        Identifier allTexture = BLOCK.config.getTexture("all");

        if (contentsTexture == null || allTexture == null) {
            throw new RuntimeException("Missing textures for block model");
        }

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.CONTENTS, contentsTexture)
            .put(TextureKey.ALL, allTexture);

        configureBaggedBlockModels(blockStateModelGenerator, textures);
    }

    protected void configureBlockStateModelsWithFacing(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier bottomTexture = Identifier.of(ModInfo.MOD_ID, String.format("block/%s_bottom", BLOCK.BLOCK_ID.getPath()));
        Identifier sideTexture = Identifier.of(ModInfo.MOD_ID, String.format("block/%s_side", BLOCK.BLOCK_ID.getPath()));
        Identifier topTexture = Identifier.of(ModInfo.MOD_ID, String.format("block/%s_top", BLOCK.BLOCK_ID.getPath()));

        TextureMap textures = new TextureMap()
            .put(TextureKey.BOTTOM, bottomTexture)
            .put(TextureKey.SIDE, sideTexture)
            .put(TextureKey.TOP, topTexture);

        Identifier subModelId = blockStateModelGenerator.createSubModel(BLOCK, "", makeColumnModel(BLOCK.config.getRenderType()), unused -> textures);

        ModelUtils.registerBlockWithFacing(blockStateModelGenerator, ItemStorageBlock.FACING, BLOCK, subModelId);
    }

    protected void configureBlockStateModelsWithAxis(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier endTexture = Identifier.of(ModInfo.MOD_ID, String.format("block/%s_end", BLOCK.BLOCK_ID.getPath()));
        Identifier sideTexture = Identifier.of(ModInfo.MOD_ID, String.format("block/%s_side", BLOCK.BLOCK_ID.getPath()));

        TextureMap textures = new TextureMap()
            .put(TextureKey.BOTTOM, endTexture)
            .put(TextureKey.SIDE, sideTexture)
            .put(TextureKey.TOP, endTexture);

        Identifier subModelId = blockStateModelGenerator.createSubModel(BLOCK, "", makeColumnModel(BLOCK.config.getRenderType()), unused -> textures);

        ModelUtils.registerBlockWithAxis(blockStateModelGenerator, ItemStorageBlock.AXIS, BLOCK, subModelId);
    }

    protected void configureDefaultBlockStateModel(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap().put(TextureKey.ALL, TextureUtils.block(BLOCK));
        blockStateModelGenerator.registerSingleton(BLOCK, textures, makeCubeModel(BLOCK.config.getRenderType()));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        switch (BLOCK.model) {
            case CUSTOM:
                configureCustomBaggedBlockStateModels(blockStateModelGenerator);
                break;
            case FACING:
                configureBlockStateModelsWithFacing(blockStateModelGenerator);
                break;
            case AXIS:
                configureBlockStateModelsWithAxis(blockStateModelGenerator);
                break;
            case BAGGED:
                configureBaggedBlockModels(blockStateModelGenerator);
                break;
            case DEFAULT:
            default:
                configureDefaultBlockStateModel(blockStateModelGenerator);
        }
    }
}
