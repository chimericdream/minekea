package com.chimericdream.minekea.block.furniture;

import com.chimericdream.minekea.block.furniture.pillows.Pillows;
import com.chimericdream.minekea.block.furniture.seats.Seats;
import com.chimericdream.minekea.block.furniture.tables.Tables;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class FurnitureBlocks implements ModThingGroup {
    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.addAll(Seats.CHAIR_BLOCKS);
        BLOCKS.addAll(Seats.STOOL_BLOCKS);
        BLOCKS.addAll(Pillows.BLOCKS);
        BLOCKS.addAll(Tables.BLOCKS);
    }
}
