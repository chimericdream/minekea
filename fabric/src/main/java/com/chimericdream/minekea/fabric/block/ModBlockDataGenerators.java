package com.chimericdream.minekea.fabric.block;

import com.chimericdream.minekea.fabric.block.building.BuildingBlocksDataGenerator;
import com.chimericdream.minekea.fabric.crop.CropBlockDataGenerators;
import com.chimericdream.minekea.fabric.util.BlockDataGeneratorGroup;

import java.util.ArrayList;
import java.util.List;

public class ModBlockDataGenerators {
    public static final List<BlockDataGeneratorGroup> BLOCK_GROUPS = new ArrayList<>();

    public static final BuildingBlocksDataGenerator BUILDING_BLOCKS;
    public static final CropBlockDataGenerators CROP_BLOCKS;

    static {
        BUILDING_BLOCKS = new BuildingBlocksDataGenerator();
        CROP_BLOCKS = new CropBlockDataGenerators();

        BLOCK_GROUPS.add(BUILDING_BLOCKS);
        BLOCK_GROUPS.add(CROP_BLOCKS);
    }
}
