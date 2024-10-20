package com.chimericdream.minekea.block;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.util.ModBlockGroup;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<ModBlockGroup> BLOCK_GROUPS = new ArrayList<>();

    public static final BuildingBlocks BUILDING_BLOCKS;

    static {
        BUILDING_BLOCKS = new BuildingBlocks();

        BLOCK_GROUPS.add(BUILDING_BLOCKS);
    }

    public static void init() {
        for (ModBlockGroup blockGroup : BLOCK_GROUPS) {
            blockGroup.init();
        }
    }
}
