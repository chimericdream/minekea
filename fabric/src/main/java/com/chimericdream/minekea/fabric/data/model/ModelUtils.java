package com.chimericdream.minekea.fabric.data.model;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.fabric.data.blockstate.suppliers.CustomBlockStateModelSupplier;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

public class ModelUtils {
    public static final Model CUSTOM_TEMPLATE_LANTERN = new CustomBlockStateModelSupplier.CustomBlockModel(
        BlockConfig.RenderType.CUTOUT,
        Optional.of(Identifier.ofVanilla("block/template_lantern")),
        Optional.empty(),
        TextureKey.LANTERN
    );

    public static final Model CUSTOM_TEMPLATE_HANGING_LANTERN = new CustomBlockStateModelSupplier.CustomBlockModel(
        BlockConfig.RenderType.CUTOUT,
        Optional.of(Identifier.ofVanilla("block/template_hanging_lantern")),
        Optional.empty(),
        TextureKey.LANTERN
    );

    public static void registerGeneratedItem(
        ItemModelGenerator itemModelGenerator,
        Block block,
        Identifier blockId
    ) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.LAYER0, blockId.withPrefixedPath("item/"));

        Models.GENERATED.upload(
            block,
            textures,
            itemModelGenerator.writer
        );
    }

    public static void registerLanternBlock(
        BlockStateModelGenerator blockStateModelGenerator,
        Block block,
        Identifier blockId
    ) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.LANTERN, blockId.withPrefixedPath("block/"));

        Identifier baseModelId = blockStateModelGenerator.createSubModel(block, "_base", CUSTOM_TEMPLATE_LANTERN, unused -> textures);
        Identifier hangingModelId = blockStateModelGenerator.createSubModel(block, "_hanging", CUSTOM_TEMPLATE_HANGING_LANTERN, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(block)
                    .with(
                        When.create().set(Properties.HANGING, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, hangingModelId)
                    )
                    .with(
                        When.create().set(Properties.HANGING, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                    )
            );
    }

    public static void registerBlockWithAxis(
        BlockStateModelGenerator blockStateModelGenerator,
        EnumProperty<Direction.Axis> axis,
        Block block,
        Identifier subModelId
    ) {
        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(block)
                    .with(
                        When.create().set(axis, Direction.Axis.X),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(axis, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(axis, Direction.Axis.Z),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
            );
    }

    public static void registerBlockWithWallSide(
        BlockStateModelGenerator blockStateModelGenerator,
        DirectionProperty wallSide,
        Block block,
        Identifier subModelId
    ) {
        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(block)
                    .with(
                        When.create().set(wallSide, Direction.NORTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(wallSide, Direction.EAST),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(wallSide, Direction.SOUTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(wallSide, Direction.WEST),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, subModelId)
                    )
            );
    }

    public static void registerBlockWithHorizontalFacing(
        BlockStateModelGenerator blockStateModelGenerator,
        DirectionProperty facing,
        Block block,
        Identifier subModelId
    ) {
        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(block)
                    .with(
                        When.create().set(facing, Direction.NORTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.EAST),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.SOUTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.WEST),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, subModelId)
                    )
            );
    }

    public static void registerBlockWithFacing(
        BlockStateModelGenerator blockStateModelGenerator,
        DirectionProperty facing,
        Block block,
        Identifier subModelId
    ) {
        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(block)
                    .with(
                        When.create().set(facing, Direction.NORTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.EAST),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.SOUTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.WEST),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.UP),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.DOWN),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, subModelId)
                    )
            );
    }
}
