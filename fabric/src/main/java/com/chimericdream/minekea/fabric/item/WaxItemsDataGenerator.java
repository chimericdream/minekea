package com.chimericdream.minekea.fabric.item;

import com.chimericdream.lib.fabric.items.FabricItemDataGenerator;
import com.chimericdream.minekea.fabric.item.ingredients.WaxItemDataGenerator;
import com.chimericdream.minekea.fabric.util.ItemDataGeneratorGroup;
import com.chimericdream.minekea.item.WaxItems;

import java.util.ArrayList;
import java.util.List;

public class WaxItemsDataGenerator implements ItemDataGeneratorGroup {
    protected static final List<FabricItemDataGenerator> ITEM_GENERATORS = new ArrayList<>();

    static {
        WaxItems.WAX_ITEMS.values().forEach(item -> ITEM_GENERATORS.add(new WaxItemDataGenerator(item.get())));
    }

    @Override
    public List<FabricItemDataGenerator> getItemGenerators() {
        return ITEM_GENERATORS;
    }
}
