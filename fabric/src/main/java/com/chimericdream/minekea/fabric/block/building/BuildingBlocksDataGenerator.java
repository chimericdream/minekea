package com.chimericdream.minekea.fabric.block.building;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.BasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.util.BlockDataGeneratorGroup;

import java.util.List;

public class BuildingBlocksDataGenerator implements BlockDataGeneratorGroup {
    @Override
    public List<FabricBlockDataGenerator> getBlockGenerators() {
        return List.of(new BasaltBricksDataGenerator());
    }
}
