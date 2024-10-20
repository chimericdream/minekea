package com.chimericdream.minekea.fabric.crop;

import com.chimericdream.lib.fabric.items.FabricItemDataGenerator;
import com.chimericdream.minekea.fabric.util.ItemDataGeneratorGroup;

import java.util.ArrayList;
import java.util.List;

public class CropItemDataGenerators implements ItemDataGeneratorGroup {
    protected static final List<FabricItemDataGenerator> ITEM_GENERATORS = new ArrayList<>();

    static {
        ITEM_GENERATORS.add(new WarpedWartItemDataGenerator());
    }

    @Override
    public List<FabricItemDataGenerator> getItemGenerators() {
        return ITEM_GENERATORS;
    }
}
