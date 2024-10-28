package com.chimericdream.minekea.item;

import com.chimericdream.minekea.item.containers.ContainerItems;
import com.chimericdream.minekea.util.ModThingGroup;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<ModThingGroup> ITEM_GROUPS = new ArrayList<>();

    public static final ContainerItems CONTAINER_ITEMS;
    public static final NuggetBags NUGGET_BAGS;
    public static final Tools TOOLS;
    public static final WaxItems WAX_ITEMS;

    static {
        CONTAINER_ITEMS = new ContainerItems();
        NUGGET_BAGS = new NuggetBags();
        TOOLS = new Tools();
        WAX_ITEMS = new WaxItems();

        ITEM_GROUPS.add(CONTAINER_ITEMS);
        ITEM_GROUPS.add(NUGGET_BAGS);
        ITEM_GROUPS.add(TOOLS);
        ITEM_GROUPS.add(WAX_ITEMS);
    }

    public static void init() {
    }
}
