package com.chimericdream.minekea.item;

import com.chimericdream.minekea.item.ingredients.WaxItem;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.chimericdream.minekea.registry.ModRegistries.registerItem;

public class WaxItems implements ModThingGroup {
    public static final Map<String, RegistrySupplier<Item>> WAX_ITEMS = new LinkedHashMap<>();

    public static final RegistrySupplier<Item> PLAIN_WAX_ITEM = registerItem(WaxItem.makeId("plain"), () -> new WaxItem("plain", Items.CANDLE));
    public static final RegistrySupplier<Item> WHITE_WAX_ITEM = registerItem(WaxItem.makeId("white"), () -> new WaxItem("white", Items.WHITE_CANDLE));
    public static final RegistrySupplier<Item> LIGHT_GRAY_WAX_ITEM = registerItem(WaxItem.makeId("light_gray"), () -> new WaxItem("light_gray", Items.LIGHT_GRAY_CANDLE));
    public static final RegistrySupplier<Item> GRAY_WAX_ITEM = registerItem(WaxItem.makeId("gray"), () -> new WaxItem("gray", Items.GRAY_CANDLE));
    public static final RegistrySupplier<Item> BLACK_WAX_ITEM = registerItem(WaxItem.makeId("black"), () -> new WaxItem("black", Items.BLACK_CANDLE));
    public static final RegistrySupplier<Item> BROWN_WAX_ITEM = registerItem(WaxItem.makeId("brown"), () -> new WaxItem("brown", Items.BROWN_CANDLE));
    public static final RegistrySupplier<Item> RED_WAX_ITEM = registerItem(WaxItem.makeId("red"), () -> new WaxItem("red", Items.RED_CANDLE));
    public static final RegistrySupplier<Item> ORANGE_WAX_ITEM = registerItem(WaxItem.makeId("orange"), () -> new WaxItem("orange", Items.ORANGE_CANDLE));
    public static final RegistrySupplier<Item> YELLOW_WAX_ITEM = registerItem(WaxItem.makeId("yellow"), () -> new WaxItem("yellow", Items.YELLOW_CANDLE));
    public static final RegistrySupplier<Item> LIME_WAX_ITEM = registerItem(WaxItem.makeId("lime"), () -> new WaxItem("lime", Items.LIME_CANDLE));
    public static final RegistrySupplier<Item> GREEN_WAX_ITEM = registerItem(WaxItem.makeId("green"), () -> new WaxItem("green", Items.GREEN_CANDLE));
    public static final RegistrySupplier<Item> CYAN_WAX_ITEM = registerItem(WaxItem.makeId("cyan"), () -> new WaxItem("cyan", Items.CYAN_CANDLE));
    public static final RegistrySupplier<Item> LIGHT_BLUE_WAX_ITEM = registerItem(WaxItem.makeId("light_blue"), () -> new WaxItem("light_blue", Items.LIGHT_BLUE_CANDLE));
    public static final RegistrySupplier<Item> BLUE_WAX_ITEM = registerItem(WaxItem.makeId("blue"), () -> new WaxItem("blue", Items.BLUE_CANDLE));
    public static final RegistrySupplier<Item> PURPLE_WAX_ITEM = registerItem(WaxItem.makeId("purple"), () -> new WaxItem("purple", Items.PURPLE_CANDLE));
    public static final RegistrySupplier<Item> MAGENTA_WAX_ITEM = registerItem(WaxItem.makeId("magenta"), () -> new WaxItem("magenta", Items.MAGENTA_CANDLE));
    public static final RegistrySupplier<Item> PINK_WAX_ITEM = registerItem(WaxItem.makeId("pink"), () -> new WaxItem("pink", Items.PINK_CANDLE));

    static {
        WAX_ITEMS.put("plain", PLAIN_WAX_ITEM);
        WAX_ITEMS.put("white", WHITE_WAX_ITEM);
        WAX_ITEMS.put("light_gray", LIGHT_GRAY_WAX_ITEM);
        WAX_ITEMS.put("gray", GRAY_WAX_ITEM);
        WAX_ITEMS.put("black", BLACK_WAX_ITEM);
        WAX_ITEMS.put("brown", BROWN_WAX_ITEM);
        WAX_ITEMS.put("red", RED_WAX_ITEM);
        WAX_ITEMS.put("orange", ORANGE_WAX_ITEM);
        WAX_ITEMS.put("yellow", YELLOW_WAX_ITEM);
        WAX_ITEMS.put("lime", LIME_WAX_ITEM);
        WAX_ITEMS.put("green", GREEN_WAX_ITEM);
        WAX_ITEMS.put("cyan", CYAN_WAX_ITEM);
        WAX_ITEMS.put("light_blue", LIGHT_BLUE_WAX_ITEM);
        WAX_ITEMS.put("blue", BLUE_WAX_ITEM);
        WAX_ITEMS.put("purple", PURPLE_WAX_ITEM);
        WAX_ITEMS.put("magenta", MAGENTA_WAX_ITEM);
        WAX_ITEMS.put("pink", PINK_WAX_ITEM);
    }
}
