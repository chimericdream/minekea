package com.chimericdream.minekea.crop;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;

public class WarpedWartItem extends AliasedBlockItem {
    public static final Identifier ITEM_ID = Identifier.of(ModInfo.MOD_ID, "crops/warped_wart");

    public WarpedWartItem() {
        super(ModCrops.WARPED_WART_PLANT_BLOCK.get(), new Item.Settings().arch$tab(ItemGroups.INGREDIENTS));
    }
}
