package com.chimericdream.minekea.fabric.block.decorations;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.block.decorations.candles.VotiveCandles;
import com.chimericdream.minekea.block.decorations.lighting.Lanterns;
import com.chimericdream.minekea.fabric.util.BlockDataGeneratorGroup;

import java.util.ArrayList;
import java.util.List;

public class DecorationBlocksDataGenerator implements BlockDataGeneratorGroup {
    protected static final List<FabricBlockDataGenerator> BLOCK_GENERATORS = new ArrayList<>();

    static {
        Lanterns.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new LanternBlockDataGenerator(block.get())));
        VotiveCandles.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new VotiveCandleBlockDataGenerator(block.get())));

        BLOCK_GENERATORS.add(new EndlessRodBlockDataGenerator());
        BLOCK_GENERATORS.add(new FakeCakeBlockDataGenerator());
    }

    @Override
    public List<FabricBlockDataGenerator> getBlockGenerators() {
        return BLOCK_GENERATORS;
    }
}
