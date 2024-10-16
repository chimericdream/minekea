package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.util.ModBlockGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class BuildingBlocks implements ModBlockGroup {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Item.Settings DEFAULT_SETTINGS = new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS);

    public static final RegistrySupplier<Block> BASALT_BRICKS = registerWithItem(BasaltBricksBlock.BLOCK_ID, BasaltBricksBlock::new, DEFAULT_SETTINGS);

    static {
        BLOCKS.add(BASALT_BRICKS.get());
    }

    public static void init() {
    }

    @Override
    public List<Block> getBlocks() {
        return BLOCKS;
    }
}
