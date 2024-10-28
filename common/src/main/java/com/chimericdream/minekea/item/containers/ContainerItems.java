package com.chimericdream.minekea.item.containers;

import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.block.containers.GlassJarBlock;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerItem;

public class ContainerItems implements ModThingGroup {
    public static final List<RegistrySupplier<Item>> ITEMS = new ArrayList<>();

    public static final RegistrySupplier<Item> GLASS_JAR_ITEM = registerItem(GlassJarBlock.BLOCK_ID, () -> new GlassJarItem(ContainerBlocks.GLASS_JAR, new Item.Settings().maxCount(8).arch$tab(ItemGroups.FUNCTIONAL)));

    static {
        ITEMS.add(GLASS_JAR_ITEM);
    }
}
