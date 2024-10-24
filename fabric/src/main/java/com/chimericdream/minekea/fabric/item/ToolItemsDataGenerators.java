package com.chimericdream.minekea.fabric.item;

import com.chimericdream.lib.fabric.items.FabricItemDataGenerator;
import com.chimericdream.minekea.fabric.item.tools.BlockPainterItemDataGenerator;
import com.chimericdream.minekea.fabric.item.tools.HammerItemDataGenerator;
import com.chimericdream.minekea.fabric.item.tools.WrenchItemDataGenerator;
import com.chimericdream.minekea.fabric.util.ItemDataGeneratorGroup;
import com.chimericdream.minekea.item.Tools;

import java.util.ArrayList;
import java.util.List;

public class ToolItemsDataGenerators implements ItemDataGeneratorGroup {
    protected static final List<FabricItemDataGenerator> ITEM_GENERATORS = new ArrayList<>();

    static {
        Tools.HAMMERS.forEach(hammer -> ITEM_GENERATORS.add(new HammerItemDataGenerator(hammer.get())));

        ITEM_GENERATORS.add(new BlockPainterItemDataGenerator());
        ITEM_GENERATORS.add(new HammerItemDataGenerator.NetheriteUpgrade());
        ITEM_GENERATORS.add(new WrenchItemDataGenerator());
    }

    @Override
    public List<FabricItemDataGenerator> getItemGenerators() {
        return ITEM_GENERATORS;
    }
}
