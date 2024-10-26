package com.chimericdream.minekea.block.decorations.lighting;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class Lanterns implements ModThingGroup {
    public static final Item.Settings DEFAULT_LANTERN_SETTINGS = new Item.Settings().arch$tab(ItemGroups.FUNCTIONAL);

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(registerWithItem(LanternBlock.makeId("ancient"), () -> new LanternBlock(new BlockConfig().name("Ancient Lantern").item(Items.ECHO_SHARD), "ancient"), DEFAULT_LANTERN_SETTINGS));
        BLOCKS.add(registerWithItem(LanternBlock.makeId("doom"), () -> new LanternBlock(new BlockConfig().name("Doom Lantern").item(Items.CRIMSON_FUNGUS), "doom"), DEFAULT_LANTERN_SETTINGS));
        BLOCKS.add(registerWithItem(LanternBlock.makeId("end"), () -> new LanternBlock(new BlockConfig().name("End Lantern").item(Items.ENDER_PEARL), "end"), DEFAULT_LANTERN_SETTINGS));

        // auto-suggested ideas from copilot
//        BLOCKS.add(registerWithItem(LanternBlock.makeId("crystal"), () -> new LanternBlock(new BlockConfig().name("Crystal Lantern").item(Items.ECHO_SHARD), "crystal"), DEFAULT_LANTERN_SETTINGS));
//        BLOCKS.add(registerWithItem(LanternBlock.makeId("fancy"), () -> new LanternBlock(new BlockConfig().name("Fancy Lantern").item(Items.ECHO_SHARD), "fancy"), DEFAULT_LANTERN_SETTINGS));
//        BLOCKS.add(registerWithItem(LanternBlock.makeId("iron"), () -> new LanternBlock(new BlockConfig().name("Iron Lantern").item(Items.ECHO_SHARD), "iron"), DEFAULT_LANTERN_SETTINGS));
//        BLOCKS.add(registerWithItem(LanternBlock.makeId("rustic"), () -> new LanternBlock(new BlockConfig().name("Rustic Lantern").item(Items.ECHO_SHARD), "rustic"), DEFAULT_LANTERN_SETTINGS));
//        BLOCKS.add(registerWithItem(LanternBlock.makeId("simple"), () -> new LanternBlock(new BlockConfig().name("Simple Lantern").item(Items.ECHO_SHARD), "simple"), DEFAULT_LANTERN_SETTINGS));
//        BLOCKS.add(registerWithItem(LanternBlock.makeId("stone"), () -> new LanternBlock(new BlockConfig().name("Stone Lantern").item(Items.ECHO_SHARD), "stone"), DEFAULT_LANTERN_SETTINGS));
//        BLOCKS.add(registerWithItem(LanternBlock.makeId("wooden"), () -> new LanternBlock(new BlockConfig().name("Wooden Lantern").item(Items.ECHO_SHARD), "wooden"), DEFAULT_LANTERN_SETTINGS));
    }
}
