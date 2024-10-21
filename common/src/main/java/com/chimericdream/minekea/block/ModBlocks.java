package com.chimericdream.minekea.block;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.furniture.FurnitureBlocks;
import com.chimericdream.minekea.util.ModThingGroup;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<ModThingGroup> BLOCK_GROUPS = new ArrayList<>();

    public static final BuildingBlocks BUILDING_BLOCKS;
    public static final FurnitureBlocks FURNITURE_BLOCKS;

    static {
        BUILDING_BLOCKS = new BuildingBlocks();
        FURNITURE_BLOCKS = new FurnitureBlocks();

        BLOCK_GROUPS.add(BUILDING_BLOCKS);
        BLOCK_GROUPS.add(FURNITURE_BLOCKS);
    }

    public static void init() {
    }
}
