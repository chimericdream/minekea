package com.chimericdream.minekea.world.poi;

import com.chimericdream.minekea.block.containers.barrels.Barrels;
import com.chimericdream.minekea.util.PointOfInterestHelpers;
import net.minecraft.world.poi.PointOfInterestTypes;

import java.util.function.Supplier;

public class MinekeaPointOfInterestTypes {
    public static void init() {
        PointOfInterestHelpers.addBlockStatesToPOI(Barrels.BLOCKS.stream().map(Supplier::get).toList(), PointOfInterestTypes.FISHERMAN);
    }
}
