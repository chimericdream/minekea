package com.chimericdream.minekea.registry;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ColoredBlocksRegistry {
    public static final List<ColoredBlock> REGISTRY = new ArrayList<>();

    public static void init() {
        addBlock(Blocks.WHITE_CONCRETE, "minecraft:concrete", BlockColor.WHITE);
        addBlock(Blocks.ORANGE_CONCRETE, "minecraft:concrete", BlockColor.ORANGE);
        addBlock(Blocks.MAGENTA_CONCRETE, "minecraft:concrete", BlockColor.MAGENTA);
        addBlock(Blocks.LIGHT_BLUE_CONCRETE, "minecraft:concrete", BlockColor.LIGHT_BLUE);
        addBlock(Blocks.YELLOW_CONCRETE, "minecraft:concrete", BlockColor.YELLOW);
        addBlock(Blocks.LIME_CONCRETE, "minecraft:concrete", BlockColor.LIME);
        addBlock(Blocks.PINK_CONCRETE, "minecraft:concrete", BlockColor.PINK);
        addBlock(Blocks.GRAY_CONCRETE, "minecraft:concrete", BlockColor.GRAY);
        addBlock(Blocks.LIGHT_GRAY_CONCRETE, "minecraft:concrete", BlockColor.LIGHT_GRAY);
        addBlock(Blocks.CYAN_CONCRETE, "minecraft:concrete", BlockColor.CYAN);
        addBlock(Blocks.PURPLE_CONCRETE, "minecraft:concrete", BlockColor.PURPLE);
        addBlock(Blocks.BLUE_CONCRETE, "minecraft:concrete", BlockColor.BLUE);
        addBlock(Blocks.BROWN_CONCRETE, "minecraft:concrete", BlockColor.BROWN);
        addBlock(Blocks.GREEN_CONCRETE, "minecraft:concrete", BlockColor.GREEN);
        addBlock(Blocks.RED_CONCRETE, "minecraft:concrete", BlockColor.RED);
        addBlock(Blocks.BLACK_CONCRETE, "minecraft:concrete", BlockColor.BLACK);

        addBlock(Blocks.WHITE_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.WHITE);
        addBlock(Blocks.ORANGE_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.ORANGE);
        addBlock(Blocks.MAGENTA_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.MAGENTA);
        addBlock(Blocks.LIGHT_BLUE_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.LIGHT_BLUE);
        addBlock(Blocks.YELLOW_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.YELLOW);
        addBlock(Blocks.LIME_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.LIME);
        addBlock(Blocks.PINK_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.PINK);
        addBlock(Blocks.GRAY_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.GRAY);
        addBlock(Blocks.LIGHT_GRAY_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.LIGHT_GRAY);
        addBlock(Blocks.CYAN_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.CYAN);
        addBlock(Blocks.PURPLE_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.PURPLE);
        addBlock(Blocks.BLUE_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.BLUE);
        addBlock(Blocks.BROWN_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.BROWN);
        addBlock(Blocks.GREEN_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.GREEN);
        addBlock(Blocks.RED_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.RED);
        addBlock(Blocks.BLACK_CONCRETE_POWDER, "minecraft:concrete_powder", BlockColor.BLACK);

        addBlock(Blocks.WHITE_WOOL, "minecraft:wool", BlockColor.WHITE);
        addBlock(Blocks.ORANGE_WOOL, "minecraft:wool", BlockColor.ORANGE);
        addBlock(Blocks.MAGENTA_WOOL, "minecraft:wool", BlockColor.MAGENTA);
        addBlock(Blocks.LIGHT_BLUE_WOOL, "minecraft:wool", BlockColor.LIGHT_BLUE);
        addBlock(Blocks.YELLOW_WOOL, "minecraft:wool", BlockColor.YELLOW);
        addBlock(Blocks.LIME_WOOL, "minecraft:wool", BlockColor.LIME);
        addBlock(Blocks.PINK_WOOL, "minecraft:wool", BlockColor.PINK);
        addBlock(Blocks.GRAY_WOOL, "minecraft:wool", BlockColor.GRAY);
        addBlock(Blocks.LIGHT_GRAY_WOOL, "minecraft:wool", BlockColor.LIGHT_GRAY);
        addBlock(Blocks.CYAN_WOOL, "minecraft:wool", BlockColor.CYAN);
        addBlock(Blocks.PURPLE_WOOL, "minecraft:wool", BlockColor.PURPLE);
        addBlock(Blocks.BLUE_WOOL, "minecraft:wool", BlockColor.BLUE);
        addBlock(Blocks.BROWN_WOOL, "minecraft:wool", BlockColor.BROWN);
        addBlock(Blocks.GREEN_WOOL, "minecraft:wool", BlockColor.GREEN);
        addBlock(Blocks.RED_WOOL, "minecraft:wool", BlockColor.RED);
        addBlock(Blocks.BLACK_WOOL, "minecraft:wool", BlockColor.BLACK);

        addBlock(Blocks.TERRACOTTA, "minecraft:terracotta", BlockColor.NONE);
        addBlock(Blocks.WHITE_TERRACOTTA, "minecraft:terracotta", BlockColor.WHITE);
        addBlock(Blocks.ORANGE_TERRACOTTA, "minecraft:terracotta", BlockColor.ORANGE);
        addBlock(Blocks.MAGENTA_TERRACOTTA, "minecraft:terracotta", BlockColor.MAGENTA);
        addBlock(Blocks.LIGHT_BLUE_TERRACOTTA, "minecraft:terracotta", BlockColor.LIGHT_BLUE);
        addBlock(Blocks.YELLOW_TERRACOTTA, "minecraft:terracotta", BlockColor.YELLOW);
        addBlock(Blocks.LIME_TERRACOTTA, "minecraft:terracotta", BlockColor.LIME);
        addBlock(Blocks.PINK_TERRACOTTA, "minecraft:terracotta", BlockColor.PINK);
        addBlock(Blocks.GRAY_TERRACOTTA, "minecraft:terracotta", BlockColor.GRAY);
        addBlock(Blocks.LIGHT_GRAY_TERRACOTTA, "minecraft:terracotta", BlockColor.LIGHT_GRAY);
        addBlock(Blocks.CYAN_TERRACOTTA, "minecraft:terracotta", BlockColor.CYAN);
        addBlock(Blocks.PURPLE_TERRACOTTA, "minecraft:terracotta", BlockColor.PURPLE);
        addBlock(Blocks.BLUE_TERRACOTTA, "minecraft:terracotta", BlockColor.BLUE);
        addBlock(Blocks.BROWN_TERRACOTTA, "minecraft:terracotta", BlockColor.BROWN);
        addBlock(Blocks.GREEN_TERRACOTTA, "minecraft:terracotta", BlockColor.GREEN);
        addBlock(Blocks.RED_TERRACOTTA, "minecraft:terracotta", BlockColor.RED);
        addBlock(Blocks.BLACK_TERRACOTTA, "minecraft:terracotta", BlockColor.BLACK);

        addBlock(Blocks.WHITE_STAINED_GLASS, "minecraft:stained_glass", BlockColor.WHITE);
        addBlock(Blocks.ORANGE_STAINED_GLASS, "minecraft:stained_glass", BlockColor.ORANGE);
        addBlock(Blocks.MAGENTA_STAINED_GLASS, "minecraft:stained_glass", BlockColor.MAGENTA);
        addBlock(Blocks.LIGHT_BLUE_STAINED_GLASS, "minecraft:stained_glass", BlockColor.LIGHT_BLUE);
        addBlock(Blocks.YELLOW_STAINED_GLASS, "minecraft:stained_glass", BlockColor.YELLOW);
        addBlock(Blocks.LIME_STAINED_GLASS, "minecraft:stained_glass", BlockColor.LIME);
        addBlock(Blocks.PINK_STAINED_GLASS, "minecraft:stained_glass", BlockColor.PINK);
        addBlock(Blocks.GRAY_STAINED_GLASS, "minecraft:stained_glass", BlockColor.GRAY);
        addBlock(Blocks.LIGHT_GRAY_STAINED_GLASS, "minecraft:stained_glass", BlockColor.LIGHT_GRAY);
        addBlock(Blocks.CYAN_STAINED_GLASS, "minecraft:stained_glass", BlockColor.CYAN);
        addBlock(Blocks.PURPLE_STAINED_GLASS, "minecraft:stained_glass", BlockColor.PURPLE);
        addBlock(Blocks.BLUE_STAINED_GLASS, "minecraft:stained_glass", BlockColor.BLUE);
        addBlock(Blocks.BROWN_STAINED_GLASS, "minecraft:stained_glass", BlockColor.BROWN);
        addBlock(Blocks.GREEN_STAINED_GLASS, "minecraft:stained_glass", BlockColor.GREEN);
        addBlock(Blocks.RED_STAINED_GLASS, "minecraft:stained_glass", BlockColor.RED);
        addBlock(Blocks.BLACK_STAINED_GLASS, "minecraft:stained_glass", BlockColor.BLACK);
    }

    public static void addBlock(Block block, String group, BlockColor color) {
        REGISTRY.add(new ColoredBlock(block, group, color));
    }

    public static @Nullable String getBlockGroup(Block block) {
        ColoredBlock match = REGISTRY.stream()
            .filter((ColoredBlock cb) -> cb.block.asItem() == block.asItem())
            .findFirst()
            .orElse(null);

        if (match == null) {
            return null;
        }

        return match.group;
    }

    public static @Nullable Block findBlock(String group, BlockColor color) {
        ColoredBlock match = REGISTRY.stream()
            .filter((ColoredBlock cb) -> cb.group.equals(group) && cb.color == color)
            .findFirst()
            .orElse(null);

        if (match == null) {
            return null;
        }

        return match.block;
    }

    public static class ColoredBlock {
        private final Block block;
        private final String group;
        private final BlockColor color;

        ColoredBlock(Block block, String group, BlockColor color) {
            this.block = block;
            this.group = group;
            this.color = color;
        }
    }

    public enum BlockColor {
        NONE(-1, -1, null),
        WHITE(0, 2232000, Items.WHITE_DYE),
        LIGHT_GRAY(1, 2232001, Items.LIGHT_GRAY_DYE),
        GRAY(2, 2232002, Items.GRAY_DYE),
        BLACK(3, 2232003, Items.BLACK_DYE),
        BROWN(4, 2232004, Items.BROWN_DYE),
        RED(5, 2232005, Items.RED_DYE),
        ORANGE(6, 2232006, Items.ORANGE_DYE),
        YELLOW(7, 2232007, Items.YELLOW_DYE),
        LIME(8, 2232008, Items.LIME_DYE),
        GREEN(9, 2232009, Items.GREEN_DYE),
        CYAN(10, 2232010, Items.CYAN_DYE),
        LIGHT_BLUE(11, 2232011, Items.LIGHT_BLUE_DYE),
        BLUE(12, 2232012, Items.BLUE_DYE),
        PURPLE(13, 2232013, Items.PURPLE_DYE),
        MAGENTA(14, 2232014, Items.MAGENTA_DYE),
        PINK(15, 2232015, Items.PINK_DYE);

        private final int idx;
        private final int modelNumber;
        private final Item dye;

        BlockColor(int idx, int modelNumber, Item dye) {
            this.idx = idx;
            this.modelNumber = modelNumber;
            this.dye = dye;
        }

        public static BlockColor get(String value) {
            for (BlockColor color : values()) {
                if (color.toString().equals(value)) {
                    return color;
                }
            }

            return WHITE;
        }

        public int getIndex() {
            return idx;
        }

        public int getModelNumber() {
            return modelNumber;
        }

        public Item getDye() {
            return dye;
        }

        public BlockColor getNext() {
            int nextIdx = (idx + 1) % 16;

            for (BlockColor color : values()) {
                if (color.idx == nextIdx) {
                    return color;
                }
            }

            return WHITE;
        }
    }
}
