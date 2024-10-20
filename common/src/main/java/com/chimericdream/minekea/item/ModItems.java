package com.chimericdream.minekea.item;

import com.chimericdream.minekea.util.ModThingGroup;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<ModThingGroup> ITEM_GROUPS = new ArrayList<>();

    public static final WaxItems WAX_ITEMS;

    static {
        WAX_ITEMS = new WaxItems();

        ITEM_GROUPS.add(WAX_ITEMS);
    }

    public static void init() {
    }
}
