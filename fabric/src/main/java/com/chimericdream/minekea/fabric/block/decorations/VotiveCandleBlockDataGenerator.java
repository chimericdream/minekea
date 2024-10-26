package com.chimericdream.minekea.fabric.block.decorations;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.colors.ColorHelpers;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.decorations.candles.VotiveCandleBlock;
import com.chimericdream.minekea.fabric.data.blockstate.suppliers.CustomBlockStateModelSupplier;
import com.chimericdream.minekea.tag.MinekeaItemTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
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
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Function;

public class VotiveCandleBlockDataGenerator implements FabricBlockDataGenerator {
    protected static final Model VOTIVE_ITEM_MODEL = makeModel("block/candles/template_votive_item");
    protected static final Model ONE_VOTIVE_MODEL = makeModel("block/candles/template_votive_candle");
    protected static final Model ONE_VOTIVE_LIT_MODEL = makeModel("block/candles/template_votive_candle");
    protected static final Model TWO_VOTIVES_MODEL = makeModel("block/candles/template_two_votive_candles");
    protected static final Model TWO_VOTIVES_LIT_MODEL = makeModel("block/candles/template_two_votive_candles");
    protected static final Model THREE_VOTIVES_MODEL = makeModel("block/candles/template_three_votive_candles");
    protected static final Model THREE_VOTIVES_LIT_MODEL = makeModel("block/candles/template_three_votive_candles");
    protected static final Model FOUR_VOTIVES_MODEL = makeModel("block/candles/template_four_votive_candles");
    protected static final Model FOUR_VOTIVES_LIT_MODEL = makeModel("block/candles/template_four_votive_candles");

    public VotiveCandleBlock BLOCK;

    public VotiveCandleBlockDataGenerator(Block block) {
        BLOCK = (VotiveCandleBlock) block;
    }

    protected static Model makeModel(String template) {
        return new CustomBlockStateModelSupplier.CustomBlockModel(
            BlockConfig.RenderType.TRANSLUCENT,
            Optional.of(Identifier.of(ModInfo.MOD_ID, template)),
            Optional.empty(),
            TextureKey.CANDLE,
            TextureKey.SIDE
        );
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.CANDLES).add(BLOCK);
    }

    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(MinekeaItemTags.VOTIVE_CANDLES).add(BLOCK.asItem());
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block ingredient = BLOCK.config.getIngredient();

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BLOCK, 4)
            .input(ingredient, 4)
            .input(Items.GLASS)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .criterion(FabricRecipeProvider.hasItem(Items.GLASS),
                FabricRecipeProvider.conditionsFromItem(Items.GLASS))
            .offerTo(exporter);

        Item dye;
        if (BLOCK.color.equals("plain")) {
            dye = Items.ICE;
        } else {
            dye = ColorHelpers.getDye(BLOCK.color);
        }

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BLOCK, 8)
            .pattern("###")
            .pattern("#D#")
            .pattern("###")
            .input('#', Ingredient.fromTag(MinekeaItemTags.VOTIVE_CANDLES))
            .input('D', dye)
            .criterion("has_any_votive",
                FabricRecipeProvider.conditionsFromTag(MinekeaItemTags.VOTIVE_CANDLES))
            .criterion(FabricRecipeProvider.hasItem(dye),
                FabricRecipeProvider.conditionsFromItem(dye))
            .offerTo(exporter, BLOCK.BLOCK_ID.withSuffixedPath("_universal_dyeing"));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK, generator.candleDrops(BLOCK));
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        if (BLOCK.color.equals("plain")) {
            translationBuilder.add(BLOCK, "Votive Candle");

            return;
        }

        translationBuilder.add(BLOCK, String.format("%s Votive Candle", ColorHelpers.getName(BLOCK.color)));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block ingredient = BLOCK.config.getIngredient();

        TextureMap textures = new TextureMap()
            .put(TextureKey.CANDLE, TextureMap.getId(ingredient))
            .put(TextureKey.SIDE, TextureMap.getId(Blocks.GLASS));
        TextureMap litTextures = new TextureMap()
            .put(TextureKey.CANDLE, TextureMap.getId(ingredient).withSuffixedPath("_lit"))
            .put(TextureKey.SIDE, TextureMap.getId(Blocks.GLASS));

        Identifier candleItemModelId = blockStateModelGenerator.createSubModel(BLOCK, "", VOTIVE_ITEM_MODEL, unused -> textures);
        Identifier oneCandleModelId = blockStateModelGenerator.createSubModel(BLOCK, "_one", ONE_VOTIVE_MODEL, unused -> textures);
        Identifier oneCandleLitModelId = blockStateModelGenerator.createSubModel(BLOCK, "_one_lit", ONE_VOTIVE_LIT_MODEL, unused -> litTextures);
        Identifier twoCandlesModelId = blockStateModelGenerator.createSubModel(BLOCK, "_two", TWO_VOTIVES_MODEL, unused -> textures);
        Identifier twoCandlesLitModelId = blockStateModelGenerator.createSubModel(BLOCK, "_two_lit", TWO_VOTIVES_LIT_MODEL, unused -> litTextures);
        Identifier threeCandlesModelId = blockStateModelGenerator.createSubModel(BLOCK, "_three", THREE_VOTIVES_MODEL, unused -> textures);
        Identifier threeCandlesLitModelId = blockStateModelGenerator.createSubModel(BLOCK, "_three_lit", THREE_VOTIVES_LIT_MODEL, unused -> litTextures);
        Identifier fourCandlesModelId = blockStateModelGenerator.createSubModel(BLOCK, "_four", FOUR_VOTIVES_MODEL, unused -> textures);
        Identifier fourCandlesLitModelId = blockStateModelGenerator.createSubModel(BLOCK, "_four_lit", FOUR_VOTIVES_LIT_MODEL, unused -> litTextures);

        blockStateModelGenerator.registerParentedItemModel(BLOCK, candleItemModelId);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(BLOCK)
                    .with(
                        When.create()
                            .set(VotiveCandleBlock.CANDLES, 1)
                            .set(VotiveCandleBlock.LIT, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, oneCandleModelId)
                    )
                    .with(
                        When.create()
                            .set(VotiveCandleBlock.CANDLES, 1)
                            .set(VotiveCandleBlock.LIT, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, oneCandleLitModelId)
                    )
                    .with(
                        When.create()
                            .set(VotiveCandleBlock.CANDLES, 2)
                            .set(VotiveCandleBlock.LIT, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, twoCandlesModelId)
                    )
                    .with(
                        When.create()
                            .set(VotiveCandleBlock.CANDLES, 2)
                            .set(VotiveCandleBlock.LIT, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, twoCandlesLitModelId)
                    )
                    .with(
                        When.create()
                            .set(VotiveCandleBlock.CANDLES, 3)
                            .set(VotiveCandleBlock.LIT, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, threeCandlesModelId)
                    )
                    .with(
                        When.create()
                            .set(VotiveCandleBlock.CANDLES, 3)
                            .set(VotiveCandleBlock.LIT, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, threeCandlesLitModelId)
                    )
                    .with(
                        When.create()
                            .set(VotiveCandleBlock.CANDLES, 4)
                            .set(VotiveCandleBlock.LIT, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, fourCandlesModelId)
                    )
                    .with(
                        When.create()
                            .set(VotiveCandleBlock.CANDLES, 4)
                            .set(VotiveCandleBlock.LIT, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, fourCandlesLitModelId)
                    )
            );
    }
}
