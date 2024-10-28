package com.chimericdream.minekea.fabric.block.furniture;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.trapdoors.BookshelfTrapdoorBlock;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.enums.BlockHalf;
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
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;
import java.util.function.Function;

public class BookshelfTrapdoorBlockDataGenerator implements FabricBlockDataGenerator {
    protected static final Model BOTTOM_MODEL = makeModel("block/furniture/trapdoors/bookshelves/bottom");
    protected static final Model TOP_MODEL = makeModel("block/furniture/trapdoors/bookshelves/top");
    protected static final Model OPEN_MODEL = makeModel("block/furniture/trapdoors/bookshelves/open");

    protected final BookshelfTrapdoorBlock BLOCK;

    public BookshelfTrapdoorBlockDataGenerator(Block block) {
        BLOCK = (BookshelfTrapdoorBlock) block;
    }

    protected static Model makeModel(String path) {
        return new Model(
            Optional.of(Identifier.of(ModInfo.MOD_ID, path)),
            Optional.empty(),
            MinekeaTextures.MATERIAL,
            MinekeaTextures.SHELF
        );
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block bookshelf = BLOCK.config.getIngredient();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 12)
            .pattern("###")
            .pattern("###")
            .input('#', bookshelf)
            .criterion(FabricRecipeProvider.hasItem(bookshelf),
                FabricRecipeProvider.conditionsFromItem(bookshelf))
            .offerTo(exporter);
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.AXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("%s Bookshelf Trapdoor", BLOCK.config.getMaterialName()));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(BLOCK);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block plankIngredient = BLOCK.config.getIngredient("planks");

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.MATERIAL, TextureMap.getId(plankIngredient))
            .put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf0"));

        Identifier bottomModelId = blockStateModelGenerator.createSubModel(BLOCK, "_bottom", BOTTOM_MODEL, unused -> textures);
        Identifier topModelId = blockStateModelGenerator.createSubModel(BLOCK, "_top", TOP_MODEL, unused -> textures);
        Identifier openModelId = blockStateModelGenerator.createSubModel(BLOCK, "_open", OPEN_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(BLOCK)
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.EAST)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.BOTTOM)
                            .set(BookshelfTrapdoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.BOTTOM)
                            .set(BookshelfTrapdoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.BOTTOM)
                            .set(BookshelfTrapdoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.WEST)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.BOTTOM)
                            .set(BookshelfTrapdoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.EAST)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.TOP)
                            .set(BookshelfTrapdoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.TOP)
                            .set(BookshelfTrapdoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.TOP)
                            .set(BookshelfTrapdoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.WEST)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.TOP)
                            .set(BookshelfTrapdoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.EAST)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.BOTTOM)
                            .set(BookshelfTrapdoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.BOTTOM)
                            .set(BookshelfTrapdoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.BOTTOM)
                            .set(BookshelfTrapdoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.WEST)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.BOTTOM)
                            .set(BookshelfTrapdoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.EAST)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.TOP)
                            .set(BookshelfTrapdoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.TOP)
                            .set(BookshelfTrapdoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.TOP)
                            .set(BookshelfTrapdoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R0)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfTrapdoorBlock.FACING, Direction.WEST)
                            .set(BookshelfTrapdoorBlock.HALF, BlockHalf.TOP)
                            .set(BookshelfTrapdoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, openModelId)
                    ));

        blockStateModelGenerator.registerParentedItemModel(BLOCK, bottomModelId);
    }
}
