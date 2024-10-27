package com.chimericdream.minekea.block.furniture;

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
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class FurnitureBlocks implements ModThingGroup {
    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.addAll(Armoires.BLOCKS);
        BLOCKS.addAll(Bookshelves.BLOCKS);
        BLOCKS.addAll(DisplayCases.BLOCKS);
        BLOCKS.addAll(Doors.BLOCKS);
        BLOCKS.addAll(Seats.CHAIR_BLOCKS);
        BLOCKS.addAll(Seats.STOOL_BLOCKS);
        BLOCKS.addAll(Pillows.BLOCKS);
        BLOCKS.addAll(Shelves.BLOCKS);
        BLOCKS.addAll(Shutters.BLOCKS);
        BLOCKS.addAll(Tables.BLOCKS);
        BLOCKS.addAll(Trapdoors.BLOCKS);
    }
}
