package com.chimericdream.minekea.block.furniture.pillows;

import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class Pillows implements ModThingGroup {
    public static final Item.Settings DEFAULT_PILLOW_SETTINGS = new Item.Settings().arch$tab(ItemGroups.COLORED_BLOCKS);

    public static final RegistrySupplier<Block> WHITE_PILLOW;
    public static final RegistrySupplier<Block> LIGHT_GRAY_PILLOW;
    public static final RegistrySupplier<Block> GRAY_PILLOW;
    public static final RegistrySupplier<Block> BLACK_PILLOW;
    public static final RegistrySupplier<Block> BROWN_PILLOW;
    public static final RegistrySupplier<Block> RED_PILLOW;
    public static final RegistrySupplier<Block> ORANGE_PILLOW;
    public static final RegistrySupplier<Block> YELLOW_PILLOW;
    public static final RegistrySupplier<Block> LIME_PILLOW;
    public static final RegistrySupplier<Block> GREEN_PILLOW;
    public static final RegistrySupplier<Block> CYAN_PILLOW;
    public static final RegistrySupplier<Block> LIGHT_BLUE_PILLOW;
    public static final RegistrySupplier<Block> BLUE_PILLOW;
    public static final RegistrySupplier<Block> PURPLE_PILLOW;
    public static final RegistrySupplier<Block> MAGENTA_PILLOW;
    public static final RegistrySupplier<Block> PINK_PILLOW;

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    static {
        WHITE_PILLOW = registerWithItem(PillowBlock.makeId("white"), () -> new PillowBlock("white"), DEFAULT_PILLOW_SETTINGS);
        LIGHT_GRAY_PILLOW = registerWithItem(PillowBlock.makeId("light_gray"), () -> new PillowBlock("light_gray"), DEFAULT_PILLOW_SETTINGS);
        GRAY_PILLOW = registerWithItem(PillowBlock.makeId("gray"), () -> new PillowBlock("gray"), DEFAULT_PILLOW_SETTINGS);
        BLACK_PILLOW = registerWithItem(PillowBlock.makeId("black"), () -> new PillowBlock("black"), DEFAULT_PILLOW_SETTINGS);
        BROWN_PILLOW = registerWithItem(PillowBlock.makeId("brown"), () -> new PillowBlock("brown"), DEFAULT_PILLOW_SETTINGS);
        RED_PILLOW = registerWithItem(PillowBlock.makeId("red"), () -> new PillowBlock("red"), DEFAULT_PILLOW_SETTINGS);
        ORANGE_PILLOW = registerWithItem(PillowBlock.makeId("orange"), () -> new PillowBlock("orange"), DEFAULT_PILLOW_SETTINGS);
        YELLOW_PILLOW = registerWithItem(PillowBlock.makeId("yellow"), () -> new PillowBlock("yellow"), DEFAULT_PILLOW_SETTINGS);
        LIME_PILLOW = registerWithItem(PillowBlock.makeId("lime"), () -> new PillowBlock("lime"), DEFAULT_PILLOW_SETTINGS);
        GREEN_PILLOW = registerWithItem(PillowBlock.makeId("green"), () -> new PillowBlock("green"), DEFAULT_PILLOW_SETTINGS);
        CYAN_PILLOW = registerWithItem(PillowBlock.makeId("cyan"), () -> new PillowBlock("cyan"), DEFAULT_PILLOW_SETTINGS);
        LIGHT_BLUE_PILLOW = registerWithItem(PillowBlock.makeId("light_blue"), () -> new PillowBlock("light_blue"), DEFAULT_PILLOW_SETTINGS);
        BLUE_PILLOW = registerWithItem(PillowBlock.makeId("blue"), () -> new PillowBlock("blue"), DEFAULT_PILLOW_SETTINGS);
        PURPLE_PILLOW = registerWithItem(PillowBlock.makeId("purple"), () -> new PillowBlock("purple"), DEFAULT_PILLOW_SETTINGS);
        MAGENTA_PILLOW = registerWithItem(PillowBlock.makeId("magenta"), () -> new PillowBlock("magenta"), DEFAULT_PILLOW_SETTINGS);
        PINK_PILLOW = registerWithItem(PillowBlock.makeId("pink"), () -> new PillowBlock("pink"), DEFAULT_PILLOW_SETTINGS);

        BLOCKS.addAll(List.of(
            WHITE_PILLOW,
            LIGHT_GRAY_PILLOW,
            GRAY_PILLOW,
            BLACK_PILLOW,
            BROWN_PILLOW,
            RED_PILLOW,
            ORANGE_PILLOW,
            YELLOW_PILLOW,
            LIME_PILLOW,
            GREEN_PILLOW,
            CYAN_PILLOW,
            LIGHT_BLUE_PILLOW,
            BLUE_PILLOW,
            PURPLE_PILLOW,
            MAGENTA_PILLOW,
            PINK_PILLOW
        ));
    }
}
