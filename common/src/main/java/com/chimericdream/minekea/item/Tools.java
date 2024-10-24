package com.chimericdream.minekea.item;

import com.chimericdream.minekea.item.tools.HammerItem;
import com.chimericdream.minekea.item.tools.WrenchItem;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.tag.ItemTags;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerItem;

public class Tools implements ModThingGroup {
    public static final List<RegistrySupplier<Item>> ITEMS = new ArrayList<>();
    public static final List<RegistrySupplier<Item>> HAMMERS = new ArrayList<>();

    public static final RegistrySupplier<Item> STONE_HAMMER_ITEM = registerItem(HammerItem.makeId("stone"), () -> new HammerItem(ToolMaterials.STONE, 4, "Stone", null, ItemTags.STONE_TOOL_MATERIALS));
    public static final RegistrySupplier<Item> IRON_HAMMER_ITEM = registerItem(HammerItem.makeId("iron"), () -> new HammerItem(ToolMaterials.IRON, 5, "Iron", Items.IRON_INGOT, null));
    public static final RegistrySupplier<Item> GOLD_HAMMER_ITEM = registerItem(HammerItem.makeId("gold"), () -> new HammerItem(ToolMaterials.GOLD, 6, "Gold", Items.GOLD_INGOT, null));
    public static final RegistrySupplier<Item> DIAMOND_HAMMER_ITEM = registerItem(HammerItem.makeId("diamond"), () -> new HammerItem(ToolMaterials.DIAMOND, 7, "Diamond", Items.DIAMOND, null));
    public static final RegistrySupplier<Item> NETHERITE_HAMMER_ITEM = registerItem(HammerItem.makeId("netherite"), () -> new HammerItem(ToolMaterials.NETHERITE, 8, "Netherite", Items.NETHERITE_INGOT, null, new Item.Settings().fireproof()));

    //    public static final RegistrySupplier<Item> PAINTER_ITEM = null;
    public static final RegistrySupplier<Item> WRENCH_ITEM = registerItem(WrenchItem.ITEM_ID, WrenchItem::new);

    static {
        HAMMERS.add(STONE_HAMMER_ITEM);
        HAMMERS.add(IRON_HAMMER_ITEM);
        HAMMERS.add(GOLD_HAMMER_ITEM);
        HAMMERS.add(DIAMOND_HAMMER_ITEM);
        HAMMERS.add(NETHERITE_HAMMER_ITEM);

        ITEMS.addAll(HAMMERS);
//        ITEMS.add(PAINTER_ITEM);
        ITEMS.add(WRENCH_ITEM);
    }
}
