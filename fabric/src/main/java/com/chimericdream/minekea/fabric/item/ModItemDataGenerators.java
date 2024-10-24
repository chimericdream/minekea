package com.chimericdream.minekea.fabric.item;

import com.chimericdream.minekea.fabric.crop.CropItemDataGenerators;
import com.chimericdream.minekea.fabric.util.ItemDataGeneratorGroup;

import java.util.ArrayList;
import java.util.List;

public class ModItemDataGenerators {
    public static final List<ItemDataGeneratorGroup> ITEM_GROUPS = new ArrayList<>();

    public static final CropItemDataGenerators CROP_ITEMS;
    public static final ToolItemsDataGenerators TOOL_ITEMS;
    public static final WaxItemsDataGenerator WAX_ITEMS;

    static {
        CROP_ITEMS = new CropItemDataGenerators();
        TOOL_ITEMS = new ToolItemsDataGenerators();
        WAX_ITEMS = new WaxItemsDataGenerator();

        ITEM_GROUPS.add(CROP_ITEMS);
        ITEM_GROUPS.add(TOOL_ITEMS);
        ITEM_GROUPS.add(WAX_ITEMS);
    }
}
