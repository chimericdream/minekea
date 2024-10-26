package com.chimericdream.minekea.fabric.block;

import com.chimericdream.minekea.fabric.block.building.BuildingBlocksDataGenerator;
import com.chimericdream.minekea.fabric.block.containers.ContainerBlocksDataGenerator;
import com.chimericdream.minekea.fabric.block.decorations.DecorationBlocksDataGenerator;
import com.chimericdream.minekea.fabric.block.furniture.FurnitureBlocksDataGenerator;
import com.chimericdream.minekea.fabric.crop.CropBlockDataGenerators;
import com.chimericdream.minekea.fabric.util.BlockDataGeneratorGroup;

import java.util.ArrayList;
import java.util.List;

public class ModBlockDataGenerators {
    public static final List<BlockDataGeneratorGroup> BLOCK_GROUPS = new ArrayList<>();

    public static final BuildingBlocksDataGenerator BUILDING_BLOCKS;
    public static final ContainerBlocksDataGenerator CONTAINER_BLOCKS;
    public static final CropBlockDataGenerators CROP_BLOCKS;
    public static final DecorationBlocksDataGenerator DECORATION_BLOCKS;
    public static final FurnitureBlocksDataGenerator FURNITURE_BLOCKS;

    static {
        BUILDING_BLOCKS = new BuildingBlocksDataGenerator();
        CONTAINER_BLOCKS = new ContainerBlocksDataGenerator();
        CROP_BLOCKS = new CropBlockDataGenerators();
        DECORATION_BLOCKS = new DecorationBlocksDataGenerator();
        FURNITURE_BLOCKS = new FurnitureBlocksDataGenerator();

        BLOCK_GROUPS.add(BUILDING_BLOCKS);
        BLOCK_GROUPS.add(CONTAINER_BLOCKS);
        BLOCK_GROUPS.add(CROP_BLOCKS);
        BLOCK_GROUPS.add(DECORATION_BLOCKS);
        BLOCK_GROUPS.add(FURNITURE_BLOCKS);
    }
}
