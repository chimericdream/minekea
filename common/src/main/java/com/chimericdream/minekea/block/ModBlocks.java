package com.chimericdream.minekea.block;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.util.ModThingGroup;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<ModThingGroup> BLOCK_GROUPS = new ArrayList<>();

    public static final BuildingBlocks BUILDING_BLOCKS;

    static {
        BUILDING_BLOCKS = new BuildingBlocks();

        BLOCK_GROUPS.add(BUILDING_BLOCKS);
    }

    public static void init() {
    }
}
