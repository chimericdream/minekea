package com.chimericdream.minekea.fabric.block.building;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.building.framed.FramedBlocks;
import com.chimericdream.minekea.fabric.block.building.general.BasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.ChiseledBasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.CrackedBasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.CrimsonBasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.MossyBasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.WarpedBasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.WarpedNetherBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.WaxBlockDataGenerator;
import com.chimericdream.minekea.fabric.util.BlockDataGeneratorGroup;

import java.util.ArrayList;
import java.util.List;

public class BuildingBlocksDataGenerator implements BlockDataGeneratorGroup {
    protected static final List<FabricBlockDataGenerator> BLOCK_GENERATORS = new ArrayList<>();

    static {
        BLOCK_GENERATORS.add(new BasaltBricksDataGenerator());
        BLOCK_GENERATORS.add(new ChiseledBasaltBricksDataGenerator());
        BLOCK_GENERATORS.add(new CrackedBasaltBricksDataGenerator());
        BLOCK_GENERATORS.add(new CrimsonBasaltBricksDataGenerator());
        BLOCK_GENERATORS.add(new MossyBasaltBricksDataGenerator());
        BLOCK_GENERATORS.add(new WarpedBasaltBricksDataGenerator());
        BLOCK_GENERATORS.add(new WarpedNetherBricksDataGenerator());

        BuildingBlocks.WAX_BLOCKS.values().forEach(block -> BLOCK_GENERATORS.add(new WaxBlockDataGenerator(block.get())));
        Beams.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new BeamBlockDataGenerator(block.get())));
        Covers.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new CoverBlockDataGenerator(block.get())));
        DyedBlocks.BLOCK_MAP.values().forEach(block -> BLOCK_GENERATORS.add(new DyedBlockDataGenerator(block.get())));
        DyedBlocks.PILLAR_BLOCK_MAP.values().forEach(block -> BLOCK_GENERATORS.add(new DyedPillarBlockDataGenerator(block.get())));
        FramedBlocks.FRAMED_PLANKS.forEach(block -> BLOCK_GENERATORS.add(new FramedPlanksBlockDataGenerator(block.get())));
    }

    @Override
    public List<FabricBlockDataGenerator> getBlockGenerators() {
        return BLOCK_GENERATORS;
    }
}
