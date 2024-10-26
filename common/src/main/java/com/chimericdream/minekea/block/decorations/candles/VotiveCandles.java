package com.chimericdream.minekea.block.decorations.candles;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class VotiveCandles implements ModThingGroup {
    public static final Item.Settings DEFAULT_CANDLE_SETTINGS = new Item.Settings().arch$tab(ItemGroups.FUNCTIONAL);

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("plain"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.CANDLE), "plain"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("white"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.WHITE_CANDLE), "white"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("light_gray"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.LIGHT_GRAY_CANDLE), "light_gray"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("gray"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.GRAY_CANDLE), "gray"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("black"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.BLACK_CANDLE), "black"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("brown"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.BROWN_CANDLE), "brown"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("red"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.RED_CANDLE), "red"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("orange"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.ORANGE_CANDLE), "orange"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("yellow"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.YELLOW_CANDLE), "yellow"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("lime"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.LIME_CANDLE), "lime"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("green"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.GREEN_CANDLE), "green"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("cyan"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.CYAN_CANDLE), "cyan"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("light_blue"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.LIGHT_BLUE_CANDLE), "light_blue"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("blue"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.BLUE_CANDLE), "blue"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("purple"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.PURPLE_CANDLE), "purple"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("magenta"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.MAGENTA_CANDLE), "magenta"), DEFAULT_CANDLE_SETTINGS));
        BLOCKS.add(registerWithItem(VotiveCandleBlock.makeId("pink"), () -> new VotiveCandleBlock(new BlockConfig().ingredient(Blocks.PINK_CANDLE), "pink"), DEFAULT_CANDLE_SETTINGS));
    }
}
