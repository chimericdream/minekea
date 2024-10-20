package com.chimericdream.minekea.crop;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import static com.chimericdream.minekea.registry.ModRegistries.registerBlock;
import static com.chimericdream.minekea.registry.ModRegistries.registerItem;

public class ModCrops {
    public static final RegistrySupplier<Block> WARPED_WART_PLANT_BLOCK = registerBlock(WarpedWartPlantBlock.BLOCK_ID, WarpedWartPlantBlock::new);
    public static final RegistrySupplier<Item> WARPED_WART_ITEM = registerItem(WarpedWartItem.ITEM_ID, WarpedWartItem::new);

    public static void init() {
    }
}
