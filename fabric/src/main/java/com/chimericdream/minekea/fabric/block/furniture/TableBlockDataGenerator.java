package com.chimericdream.minekea.fabric.block.furniture;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.tables.TableBlock;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
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
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Function;

public class TableBlockDataGenerator implements FabricBlockDataGenerator {
    private final TableBlock BLOCK;

    protected static final Model CORE_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/table")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model ALL_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_all_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model NORTH_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_north_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model SOUTH_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_south_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model EAST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_east_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model WEST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_west_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model NORTH_EAST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_north_east_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model SOUTH_EAST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_south_east_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model NORTH_WEST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_north_west_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model SOUTH_WEST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_south_west_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );

    public TableBlockDataGenerator(Block block) {
        this.BLOCK = (TableBlock) block;
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.AXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block plankIngredient = BLOCK.config.getIngredient();
        Block logIngredient = BLOCK.config.getIngredient("log");

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 3)
            .pattern("XXX")
            .pattern("# #")
            .pattern("# #")
            .input('X', plankIngredient)
            .input('#', logIngredient)
            .criterion(FabricRecipeProvider.hasItem(plankIngredient),
                FabricRecipeProvider.conditionsFromItem(plankIngredient))
            .criterion(FabricRecipeProvider.hasItem(logIngredient),
                FabricRecipeProvider.conditionsFromItem(logIngredient))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("%s Table", BLOCK.config.getMaterialName()));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block plankIngredient = BLOCK.config.getIngredient();
        Block logIngredient = BLOCK.config.getIngredient("log");

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.LOG, Registries.BLOCK.getId(logIngredient).withPrefixedPath("block/"))
            .put(MinekeaTextures.PLANKS, Registries.BLOCK.getId(plankIngredient).withPrefixedPath("block/"));

        Identifier coreModelId = blockStateModelGenerator.createSubModel(BLOCK, "", CORE_MODEL, unused -> textures);
        Identifier allConnectedModelId = blockStateModelGenerator.createSubModel(BLOCK, "_all_connected", ALL_CONNECTED_MODEL, unused -> textures);
        Identifier northConnectedModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_north", NORTH_CONNECTED_MODEL, unused -> textures);
        Identifier southConnectedModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_south", SOUTH_CONNECTED_MODEL, unused -> textures);
        Identifier eastConnectedModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_east", EAST_CONNECTED_MODEL, unused -> textures);
        Identifier westConnectedModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_west", WEST_CONNECTED_MODEL, unused -> textures);
        Identifier northEastConnectedModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_north_east", NORTH_EAST_CONNECTED_MODEL, unused -> textures);
        Identifier southEastConnectedModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_south_east", SOUTH_EAST_CONNECTED_MODEL, unused -> textures);
        Identifier northWestConnectedModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_north_west", NORTH_WEST_CONNECTED_MODEL, unused -> textures);
        Identifier southWestConnectedModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_south_west", SOUTH_WEST_CONNECTED_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(BLOCK)
                    .with(
                        When.create()
                            .set(TableBlock.NORTH_CONNECTED, false)
                            .set(TableBlock.SOUTH_CONNECTED, false)
                            .set(TableBlock.EAST_CONNECTED, false)
                            .set(TableBlock.WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                    )
                    .with(
                        When.create()
                            .set(TableBlock.NORTH_CONNECTED, true)
                            .set(TableBlock.SOUTH_CONNECTED, false)
                            .set(TableBlock.EAST_CONNECTED, false)
                            .set(TableBlock.WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, northConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(TableBlock.NORTH_CONNECTED, false)
                            .set(TableBlock.SOUTH_CONNECTED, false)
                            .set(TableBlock.EAST_CONNECTED, true)
                            .set(TableBlock.WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, eastConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(TableBlock.NORTH_CONNECTED, false)
                            .set(TableBlock.SOUTH_CONNECTED, true)
                            .set(TableBlock.EAST_CONNECTED, false)
                            .set(TableBlock.WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, southConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(TableBlock.NORTH_CONNECTED, false)
                            .set(TableBlock.SOUTH_CONNECTED, false)
                            .set(TableBlock.EAST_CONNECTED, false)
                            .set(TableBlock.WEST_CONNECTED, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, westConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(TableBlock.NORTH_CONNECTED, true)
                            .set(TableBlock.SOUTH_CONNECTED, false)
                            .set(TableBlock.EAST_CONNECTED, true)
                            .set(TableBlock.WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, northEastConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(TableBlock.NORTH_CONNECTED, false)
                            .set(TableBlock.SOUTH_CONNECTED, true)
                            .set(TableBlock.EAST_CONNECTED, true)
                            .set(TableBlock.WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, southEastConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(TableBlock.NORTH_CONNECTED, true)
                            .set(TableBlock.SOUTH_CONNECTED, false)
                            .set(TableBlock.EAST_CONNECTED, false)
                            .set(TableBlock.WEST_CONNECTED, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, northWestConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(TableBlock.NORTH_CONNECTED, false)
                            .set(TableBlock.SOUTH_CONNECTED, true)
                            .set(TableBlock.EAST_CONNECTED, false)
                            .set(TableBlock.WEST_CONNECTED, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, southWestConnectedModelId)
                    )
                    .with(
                        When.anyOf(
                            When.create()
                                .set(TableBlock.NORTH_CONNECTED, false)
                                .set(TableBlock.SOUTH_CONNECTED, false)
                                .set(TableBlock.EAST_CONNECTED, true)
                                .set(TableBlock.WEST_CONNECTED, true),
                            When.create()
                                .set(TableBlock.NORTH_CONNECTED, true)
                                .set(TableBlock.SOUTH_CONNECTED, true)
                                .set(TableBlock.EAST_CONNECTED, false)
                                .set(TableBlock.WEST_CONNECTED, false),
                            When.create()
                                .set(TableBlock.NORTH_CONNECTED, false)
                                .set(TableBlock.SOUTH_CONNECTED, true)
                                .set(TableBlock.EAST_CONNECTED, true)
                                .set(TableBlock.WEST_CONNECTED, true),
                            When.create()
                                .set(TableBlock.NORTH_CONNECTED, true)
                                .set(TableBlock.SOUTH_CONNECTED, false)
                                .set(TableBlock.EAST_CONNECTED, true)
                                .set(TableBlock.WEST_CONNECTED, true),
                            When.create()
                                .set(TableBlock.NORTH_CONNECTED, true)
                                .set(TableBlock.SOUTH_CONNECTED, true)
                                .set(TableBlock.EAST_CONNECTED, true)
                                .set(TableBlock.WEST_CONNECTED, false),
                            When.create()
                                .set(TableBlock.NORTH_CONNECTED, true)
                                .set(TableBlock.SOUTH_CONNECTED, true)
                                .set(TableBlock.EAST_CONNECTED, false)
                                .set(TableBlock.WEST_CONNECTED, true),
                            When.create()
                                .set(TableBlock.NORTH_CONNECTED, true)
                                .set(TableBlock.SOUTH_CONNECTED, true)
                                .set(TableBlock.EAST_CONNECTED, true)
                                .set(TableBlock.WEST_CONNECTED, true)
                        ),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, allConnectedModelId)
                    )
            );
    }

    public static class TableTooltipDataGenerator implements FabricBlockDataGenerator {
        public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
            translationBuilder.add(TableBlock.TOOLTIP_KEY, "Simple design, but somehow LACKing...");
        }
    }
}
