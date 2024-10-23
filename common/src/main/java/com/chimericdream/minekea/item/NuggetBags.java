package com.chimericdream.minekea.item;

import com.chimericdream.minekea.item.currency.NuggetBag;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerItem;

public class NuggetBags implements ModThingGroup {
    public static final List<RegistrySupplier<Item>> ITEMS = new ArrayList<>();

    public static final RegistrySupplier<Item> GOLD_NUGGET_BAG = registerItem(NuggetBag.makeId("gold"), () -> new NuggetBag("gold", Items.GOLD_NUGGET));
    public static final RegistrySupplier<Item> IRON_NUGGET_BAG = registerItem(NuggetBag.makeId("iron"), () -> new NuggetBag("iron", Items.GOLD_NUGGET));

    static {
        ITEMS.add(GOLD_NUGGET_BAG);
        ITEMS.add(IRON_NUGGET_BAG);
    }
}
