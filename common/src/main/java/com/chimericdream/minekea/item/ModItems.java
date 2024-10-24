package com.chimericdream.minekea.item;

import com.chimericdream.minekea.util.ModThingGroup;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<ModThingGroup> ITEM_GROUPS = new ArrayList<>();

    public static final Tools TOOLS;
    public static final NuggetBags NUGGET_BAGS;
    public static final WaxItems WAX_ITEMS;

    static {
        TOOLS = new Tools();
        NUGGET_BAGS = new NuggetBags();
        WAX_ITEMS = new WaxItems();

        ITEM_GROUPS.add(TOOLS);
        ITEM_GROUPS.add(NUGGET_BAGS);
        ITEM_GROUPS.add(WAX_ITEMS);
    }

    public static void init() {
    }
}
