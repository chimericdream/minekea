package com.chimericdream.minekea.fabric.block.building;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.beams.BeamBlock;
import com.chimericdream.minekea.tag.MinekeaBlockTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Function;

import static com.chimericdream.minekea.block.building.beams.BeamBlock.CONNECTED_DOWN;
import static com.chimericdream.minekea.block.building.beams.BeamBlock.CONNECTED_EAST;
import static com.chimericdream.minekea.block.building.beams.BeamBlock.CONNECTED_NORTH;
import static com.chimericdream.minekea.block.building.beams.BeamBlock.CONNECTED_SOUTH;
import static com.chimericdream.minekea.block.building.beams.BeamBlock.CONNECTED_UP;
import static com.chimericdream.minekea.block.building.beams.BeamBlock.CONNECTED_WEST;

public class BeamBlockDataGenerator implements FabricBlockDataGenerator {
    protected static final Model CONNECTED_NORTH_MODEL = makeModel("north");
    protected static final Model CONNECTED_SOUTH_MODEL = makeModel("south");
    protected static final Model CONNECTED_EAST_MODEL = makeModel("east");
    protected static final Model CONNECTED_WEST_MODEL = makeModel("west");
    protected static final Model CONNECTED_UP_MODEL = makeModel("up");
    protected static final Model CONNECTED_DOWN_MODEL = makeModel("down");
    protected static final Model CORE_MODEL = makeModel(Identifier.of(ModInfo.MOD_ID, "block/building/beams/core"));
    protected static final Model ITEM_MODEL = makeModel(Identifier.of(ModInfo.MOD_ID, "item/building/beam"));

    public BeamBlock BLOCK;

    public BeamBlockDataGenerator(Block block) {
        BLOCK = (BeamBlock) block;
    }

    private static Model makeModel(String direction) {
        return makeModel(Identifier.of(ModInfo.MOD_ID, String.format("block/building/beams/connected_%s", direction)));
    }

    private static Model makeModel(Identifier id) {
        return new Model(
            Optional.of(id),
            Optional.empty(),
            TextureKey.SIDE,
            TextureKey.END
        );
    }

    public Block getBlock() {
        return BLOCK;
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(MinekeaBlockTags.BEAMS)
            .setReplace(false)
            .add(BLOCK);

        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.PICKAXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block ingredient = BLOCK.config.getIngredient();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 6)
            .pattern("# #")
            .pattern("# #")
            .pattern("# #")
            .input('#', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("%s Beam", BLOCK.config.getMaterialName()));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = getTextures();

        Identifier coreModelId = blockStateModelGenerator.createSubModel(BLOCK, "", CORE_MODEL, unused -> textures);
        Identifier northModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_north", CONNECTED_NORTH_MODEL, unused -> textures);
        Identifier southModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_south", CONNECTED_SOUTH_MODEL, unused -> textures);
        Identifier eastModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_east", CONNECTED_EAST_MODEL, unused -> textures);
        Identifier westModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_west", CONNECTED_WEST_MODEL, unused -> textures);
        Identifier upModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_up", CONNECTED_UP_MODEL, unused -> textures);
        Identifier downModelId = blockStateModelGenerator.createSubModel(BLOCK, "_connected_down", CONNECTED_DOWN_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(BLOCK)
                    .with(
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                    )
                    .with(
                        When.create().set(CONNECTED_NORTH, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, northModelId)
                    )
                    .with(
                        When.create().set(CONNECTED_SOUTH, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, southModelId)
                    )
                    .with(
                        When.create().set(CONNECTED_EAST, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, eastModelId)
                    )
                    .with(
                        When.create().set(CONNECTED_WEST, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, westModelId)
                    )
                    .with(
                        When.create().set(CONNECTED_UP, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, upModelId)
                    )
                    .with(
                        When.create().set(CONNECTED_DOWN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, downModelId)
                    )
            );
    }

    private TextureMap getTextures() {
        Identifier sideTexture = BLOCK.config.getTexture();
        Identifier endTexture = Optional.ofNullable(BLOCK.config.getTexture("end")).orElse(sideTexture);

        return new TextureMap()
            .put(TextureKey.SIDE, sideTexture)
            .put(TextureKey.END, endTexture);
    }

    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        ITEM_MODEL.upload(
            BLOCK.BLOCK_ID.withPrefixedPath("item/"),
            getTextures(),
            itemModelGenerator.writer
        );
    }
}
