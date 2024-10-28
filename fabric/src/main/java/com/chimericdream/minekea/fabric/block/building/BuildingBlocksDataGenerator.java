package com.chimericdream.minekea.fabric.block.building;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.building.framed.FramedBlocks;
import com.chimericdream.minekea.block.building.slabs.Slabs;
import com.chimericdream.minekea.block.building.stairs.Stairs;
import com.chimericdream.minekea.block.building.storage.StorageBlocks;
import com.chimericdream.minekea.block.building.walls.Walls;
import com.chimericdream.minekea.fabric.block.building.compressed.CompressedBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.compressed.CompressedColumnBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.compressed.CompressedMinekeaBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.BasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.ChiseledBasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.CrackedBasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.CrimsonBasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.MossyBasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.WarpedBasaltBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.WarpedNetherBricksDataGenerator;
import com.chimericdream.minekea.fabric.block.building.general.WaxBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.slabs.BookshelfSlabBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.slabs.SlabBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.slabs.VerticalBookshelfSlabBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.slabs.VerticalSlabBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.stairs.BookshelfStairsBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.stairs.StairsBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.stairs.VerticalBookshelfStairsBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.stairs.VerticalStairsBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.storage.DyeBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.storage.ItemStorageBlockDataGenerator;
import com.chimericdream.minekea.fabric.block.building.storage.SetOfEggsBlockDataGenerator;
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
        CompressedBlocks.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new CompressedBlockDataGenerator(block.get())));
        CompressedBlocks.COLUMN_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new CompressedColumnBlockDataGenerator(block.get())));
        CompressedBlocks.MINEKEA_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new CompressedMinekeaBlockDataGenerator(block.get())));
        Covers.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new CoverBlockDataGenerator(block.get())));
        DyedBlocks.BLOCK_MAP.values().forEach(block -> BLOCK_GENERATORS.add(new DyedBlockDataGenerator(block.get())));
        DyedBlocks.PILLAR_BLOCK_MAP.values().forEach(block -> BLOCK_GENERATORS.add(new DyedPillarBlockDataGenerator(block.get())));
        FramedBlocks.FRAMED_PLANKS.forEach(block -> BLOCK_GENERATORS.add(new FramedPlanksBlockDataGenerator(block.get())));
        Slabs.SLAB_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new SlabBlockDataGenerator(block.get())));
        Slabs.VERTICAL_SLAB_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new VerticalSlabBlockDataGenerator(block.get())));
        Slabs.BOOKSHELF_SLAB_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new BookshelfSlabBlockDataGenerator(block.get())));
        Slabs.VERTICAL_BOOKSHELF_SLAB_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new VerticalBookshelfSlabBlockDataGenerator(block.get())));
        Stairs.STAIRS_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new StairsBlockDataGenerator(block.get())));
        Stairs.VERTICAL_STAIRS_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new VerticalStairsBlockDataGenerator(block.get())));
        Stairs.BOOKSHELF_STAIRS_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new BookshelfStairsBlockDataGenerator(block.get())));
        Stairs.VERTICAL_BOOKSHELF_STAIRS_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new VerticalBookshelfStairsBlockDataGenerator(block.get())));
        StorageBlocks.STORAGE_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new ItemStorageBlockDataGenerator(block.get())));
        StorageBlocks.DYE_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new DyeBlockDataGenerator(block.get())));
        Walls.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new WallBlockDataGenerator(block.get())));

        BLOCK_GENERATORS.add(new CompressedBlockDataGenerator.CompressedBlockTooltipDataGenerator());
        BLOCK_GENERATORS.add(new SetOfEggsBlockDataGenerator());
    }

    @Override
    public List<FabricBlockDataGenerator> getBlockGenerators() {
        return BLOCK_GENERATORS;
    }
}
