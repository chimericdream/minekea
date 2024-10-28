package com.chimericdream.minekea.fabric.block.furniture;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.shutters.OpenShutterHalfBlock;
import com.chimericdream.minekea.resource.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;
import java.util.function.Function;

public class OpenShutterHalfBlockDataGenerator implements FabricBlockDataGenerator {
    protected static final Model LEFT_HALF_MODEL = makeModel("block/furniture/shutters/left_half");
    protected static final Model RIGHT_HALF_MODEL = makeModel("block/furniture/shutters/right_half");

    protected final OpenShutterHalfBlock BLOCK;

    public OpenShutterHalfBlockDataGenerator(Block block) {
        BLOCK = (OpenShutterHalfBlock) block;
    }

    protected static Model makeModel(String path) {
        return new Model(
            Optional.of(Identifier.of(ModInfo.MOD_ID, path)),
            Optional.empty(),
            MinekeaTextures.PANEL,
            MinekeaTextures.FRAME
        );
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        Tool tool = Optional.ofNullable(BLOCK.config.getTool()).orElse(Tool.AXE);
        getBuilder.apply(tool.getMineableTag())
            .setReplace(false)
            .add(BLOCK);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block plankIngredient = BLOCK.config.getIngredient();
        Block logIngredient = BLOCK.config.getIngredient("log");

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.FRAME, Registries.BLOCK.getId(logIngredient).withPrefixedPath("block/"))
            .put(MinekeaTextures.PANEL, Registries.BLOCK.getId(plankIngredient).withPrefixedPath("block/"));

        Identifier leftHalfModelId = blockStateModelGenerator.createSubModel(BLOCK, "_left_half", LEFT_HALF_MODEL, unused -> textures);
        Identifier rightHalfModelId = blockStateModelGenerator.createSubModel(BLOCK, "_right_half", RIGHT_HALF_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(BLOCK)
                    .with(
                        When.create()
                            .set(OpenShutterHalfBlock.WALL_SIDE, Direction.NORTH)
                            .set(OpenShutterHalfBlock.HALF, OpenShutterHalfBlock.ShutterHalf.LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, rightHalfModelId)
                    )
                    .with(
                        When.create()
                            .set(OpenShutterHalfBlock.WALL_SIDE, Direction.SOUTH)
                            .set(OpenShutterHalfBlock.HALF, OpenShutterHalfBlock.ShutterHalf.LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, rightHalfModelId)
                    )
                    .with(
                        When.create()
                            .set(OpenShutterHalfBlock.WALL_SIDE, Direction.EAST)
                            .set(OpenShutterHalfBlock.HALF, OpenShutterHalfBlock.ShutterHalf.LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, rightHalfModelId)
                    )
                    .with(
                        When.create()
                            .set(OpenShutterHalfBlock.WALL_SIDE, Direction.WEST)
                            .set(OpenShutterHalfBlock.HALF, OpenShutterHalfBlock.ShutterHalf.LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, rightHalfModelId)
                    )
                    .with(
                        When.create()
                            .set(OpenShutterHalfBlock.WALL_SIDE, Direction.NORTH)
                            .set(OpenShutterHalfBlock.HALF, OpenShutterHalfBlock.ShutterHalf.RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, leftHalfModelId)
                    )
                    .with(
                        When.create()
                            .set(OpenShutterHalfBlock.WALL_SIDE, Direction.SOUTH)
                            .set(OpenShutterHalfBlock.HALF, OpenShutterHalfBlock.ShutterHalf.RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, leftHalfModelId)
                    )
                    .with(
                        When.create()
                            .set(OpenShutterHalfBlock.WALL_SIDE, Direction.EAST)
                            .set(OpenShutterHalfBlock.HALF, OpenShutterHalfBlock.ShutterHalf.RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, leftHalfModelId)
                    )
                    .with(
                        When.create()
                            .set(OpenShutterHalfBlock.WALL_SIDE, Direction.WEST)
                            .set(OpenShutterHalfBlock.HALF, OpenShutterHalfBlock.ShutterHalf.RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, leftHalfModelId)
                    )
            );
    }
}
