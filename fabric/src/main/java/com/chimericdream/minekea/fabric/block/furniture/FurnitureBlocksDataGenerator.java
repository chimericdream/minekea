package com.chimericdream.minekea.fabric.block.furniture;

import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.block.furniture.armoires.Armoires;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import com.chimericdream.minekea.block.furniture.doors.Doors;
import com.chimericdream.minekea.block.furniture.pillows.Pillows;
import com.chimericdream.minekea.block.furniture.seats.Seats;
import com.chimericdream.minekea.block.furniture.shelves.Shelves;
import com.chimericdream.minekea.block.furniture.shutters.Shutters;
import com.chimericdream.minekea.block.furniture.tables.Tables;
import com.chimericdream.minekea.block.furniture.trapdoors.Trapdoors;
import com.chimericdream.minekea.fabric.util.BlockDataGeneratorGroup;

import java.util.ArrayList;
import java.util.List;

public class FurnitureBlocksDataGenerator implements BlockDataGeneratorGroup {
    protected static final List<FabricBlockDataGenerator> BLOCK_GENERATORS = new ArrayList<>();

    static {
        Armoires.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new ArmoireBlockDataGenerator(block.get())));
        Bookshelves.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new BookshelfBlockDataGenerator(block.get())));
        DisplayCases.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new DisplayCaseBlockDataGenerator(block.get())));
        Doors.BOOKSHELF_DOOR_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new BookshelfDoorBlockDataGenerator(block.get())));
        Seats.CHAIR_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new ChairBlockDataGenerator(block.get())));
        Seats.STOOL_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new StoolBlockDataGenerator(block.get())));
        Pillows.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new PillowBlockDataGenerator(block.get())));
        Shelves.SHELF_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new ShelfBlockDataGenerator(block.get())));
        Shelves.FLOATING_SHELF_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new FloatingShelfBlockDataGenerator(block.get())));
        Shutters.SHUTTER_BLOCKS.values().forEach(block -> BLOCK_GENERATORS.add(new ShutterBlockDataGenerator(block.get())));
        Shutters.OPEN_SHUTTER_HALF_BLOCKS.values().forEach(block -> BLOCK_GENERATORS.add(new OpenShutterHalfBlockDataGenerator(block.get())));
        Tables.BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new TableBlockDataGenerator(block.get())));
        Trapdoors.BOOKSHELF_TRAPDOOR_BLOCKS.forEach(block -> BLOCK_GENERATORS.add(new BookshelfTrapdoorBlockDataGenerator(block.get())));

        BLOCK_GENERATORS.add(new TableBlockDataGenerator.TableTooltipDataGenerator());
    }

    @Override
    public List<FabricBlockDataGenerator> getBlockGenerators() {
        return BLOCK_GENERATORS;
    }
}
