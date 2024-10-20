package com.chimericdream.minekea.item.ingredients;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;

public class WaxItem extends Item {
    public final Identifier ITEM_ID;
    public final String color;
    public final Item ingredient;

    public WaxItem(String color, Item ingredient) {
        super(new Item.Settings().arch$tab(ItemGroups.INGREDIENTS));

        ITEM_ID = makeId(color);

        this.color = color;
        this.ingredient = ingredient;
    }

    public static Identifier makeId(String color) {
        return Identifier.of(ModInfo.MOD_ID, String.format("ingredients/wax/%s", color));
    }
}
