package com.chimericdream.minekea.fabric.block.furniture;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.doors.BookshelfDoorBlock;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
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

public class BookshelfDoorBlockDataGenerator implements FabricBlockDataGenerator {
    protected static final Model ITEM_MODEL = makeModel("item/furniture/doors/bookshelf");
    protected static final Model BOTTOM_MODEL = makeModel("block/furniture/doors/bookshelves/bottom");
    protected static final Model BOTTOM_HINGE_MODEL = makeModel("block/furniture/doors/bookshelves/bottom_rh");
    protected static final Model TOP_MODEL = makeModel("block/furniture/doors/bookshelves/top");
    protected static final Model TOP_HINGE_MODEL = makeModel("block/furniture/doors/bookshelves/top_rh");

    protected final BookshelfDoorBlock BLOCK;

    public BookshelfDoorBlockDataGenerator(Block block) {
        BLOCK = (BookshelfDoorBlock) block;
    }

    protected static Model makeModel(String path) {
        return new Model(
            Optional.of(Identifier.of(ModInfo.MOD_ID, path)),
            Optional.empty(),
            MinekeaTextures.MATERIAL,
            MinekeaTextures.SHELF
        );
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.AXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block bookshelf = BLOCK.config.getIngredient();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BLOCK, 3)
            .pattern("##")
            .pattern("##")
            .pattern("##")
            .input('#', bookshelf)
            .criterion(FabricRecipeProvider.hasItem(bookshelf),
                FabricRecipeProvider.conditionsFromItem(bookshelf))
            .offerTo(exporter);
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.doorDrops(BLOCK);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(BLOCK, String.format("%s Bookshelf Door", BLOCK.config.getMaterialName()));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block plankIngredient = BLOCK.config.getIngredient("planks");

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.MATERIAL, TextureMap.getId(plankIngredient))
            .put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf0"));

        Identifier bottomModelId = blockStateModelGenerator.createSubModel(BLOCK, "_bottom", BOTTOM_MODEL, unused -> textures);
        Identifier bottomHingeModelId = blockStateModelGenerator.createSubModel(BLOCK, "_bottom_rh", BOTTOM_HINGE_MODEL, unused -> textures);
        Identifier topModelId = blockStateModelGenerator.createSubModel(BLOCK, "_top", TOP_MODEL, unused -> textures);
        Identifier topHingeModelId = blockStateModelGenerator.createSubModel(BLOCK, "_top_rh", TOP_HINGE_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(BLOCK)
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.EAST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.EAST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.WEST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.WEST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.EAST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.EAST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.WEST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.WEST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.LOWER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.EAST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.EAST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.WEST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.WEST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.EAST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.EAST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.NORTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.SOUTH)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.WEST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.LEFT)
                            .set(BookshelfDoorBlock.OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(BookshelfDoorBlock.FACING, Direction.WEST)
                            .set(BookshelfDoorBlock.HALF, DoubleBlockHalf.UPPER)
                            .set(BookshelfDoorBlock.HINGE, DoorHinge.RIGHT)
                            .set(BookshelfDoorBlock.OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
            );
    }

    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        Block plankIngredient = BLOCK.config.getIngredient("planks");

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.MATERIAL, TextureMap.getId(plankIngredient))
            .put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf0"));

        ITEM_MODEL.upload(
            BLOCK.BLOCK_ID.withPrefixedPath("item/"),
            textures,
            itemModelGenerator.writer
        );
    }
}
