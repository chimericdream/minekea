package com.chimericdream.minekea.fabric.block.furniture;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.block.furniture.pillows.Pillows;
import com.chimericdream.minekea.block.furniture.seats.Seats;
import com.chimericdream.minekea.block.furniture.tables.Tables;
import com.chimericdream.minekea.fabric.util.BlockDataGeneratorGroup;

import java.util.ArrayList;
import java.util.List;

public class FurnitureBlocksDataGenerator implements BlockDataGeneratorGroup {
    protected static final List<FabricBlockDataGenerator> BLOCK_GENERATORS = new ArrayList<>();

    static {
        Seats.CHAIR_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new ChairBlockDataGenerator(block.get())));
        Seats.STOOL_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new StoolBlockDataGenerator(block.get())));
        Pillows.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new PillowBlockDataGenerator(block.get())));
        Tables.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new TableBlockDataGenerator(block.get())));

        BLOCK_GENERATORS.add(new TableBlockDataGenerator.TableTooltipDataGenerator());
    }

    @Override
    public List<FabricBlockDataGenerator> getBlockGenerators() {
        return BLOCK_GENERATORS;
    }
}
