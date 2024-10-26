package com.chimericdream.minekea.block;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.block.decorations.DecorationBlocks;
import com.chimericdream.minekea.block.furniture.FurnitureBlocks;
import com.chimericdream.minekea.util.ModThingGroup;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<ModThingGroup> BLOCK_GROUPS = new ArrayList<>();

    public static final BuildingBlocks BUILDING_BLOCKS;
    public static final ContainerBlocks CONTAINER_BLOCKS;
    public static final DecorationBlocks DECORATION_BLOCKS;
    public static final FurnitureBlocks FURNITURE_BLOCKS;

    static {
        BUILDING_BLOCKS = new BuildingBlocks();
        CONTAINER_BLOCKS = new ContainerBlocks();
        DECORATION_BLOCKS = new DecorationBlocks();
        FURNITURE_BLOCKS = new FurnitureBlocks();

        BLOCK_GROUPS.add(BUILDING_BLOCKS);
        BLOCK_GROUPS.add(CONTAINER_BLOCKS);
        BLOCK_GROUPS.add(DECORATION_BLOCKS);
        BLOCK_GROUPS.add(FURNITURE_BLOCKS);
    }

    public static void init() {
    }
}
