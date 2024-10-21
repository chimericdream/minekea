package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.registry.ModRegistries;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class DyedBlocks implements ModThingGroup {
    public static final Item.Settings DEFAULT_DYED_BLOCK_SETTINGS = new Item.Settings().arch$tab(ModRegistries.DYED_BLOCK_ITEM_GROUP);

    public static final Map<String, RegistrySupplier<Block>> BLOCK_MAP = new LinkedHashMap<>();
    public static final Map<String, RegistrySupplier<Block>> PILLAR_BLOCK_MAP = new LinkedHashMap<>();

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    protected static final List<Triplet<Pair<String, String>, Block, Tool>> BLOCKS_TO_DYE = List.of(
        new Triplet<>(new Pair<>("Bricks", "bricks"), Blocks.BRICKS, null),
        new Triplet<>(new Pair<>("Calcite", "calcite"), Blocks.CALCITE, null),
        new Triplet<>(new Pair<>("Cobblestone", "cobblestone"), Blocks.COBBLESTONE, null),
        new Triplet<>(new Pair<>("Dark Prismarine", "dark_prismarine"), Blocks.DARK_PRISMARINE, null),
        new Triplet<>(new Pair<>("Mud Bricks", "mud_bricks"), Blocks.MUD_BRICKS, null),
        new Triplet<>(new Pair<>("Oak Planks", "oak_planks"), Blocks.OAK_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Prismarine", "prismarine"), Blocks.PRISMARINE, null),
        new Triplet<>(new Pair<>("Prismarine Bricks", "prismarine_bricks"), Blocks.PRISMARINE_BRICKS, null),
        new Triplet<>(new Pair<>("Smooth Stone", "smooth_stone"), Blocks.SMOOTH_STONE, null),
        new Triplet<>(new Pair<>("Stone", "stone"), Blocks.STONE, null),
        new Triplet<>(new Pair<>("Stone Bricks", "stone_bricks"), Blocks.STONE_BRICKS, null)
    );

    protected static final List<Triplet<Pair<String, String>, Block, Tool>> PILLAR_BLOCKS_TO_DYE = List.of(
        new Triplet<>(new Pair<>("Bone Block", "bone_block"), Blocks.BONE_BLOCK, null)
    );

    protected static final List<RegistrySupplier<Block>> WHITE_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> LIGHT_GRAY_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> GRAY_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> BLACK_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> BROWN_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> RED_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> ORANGE_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> YELLOW_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> LIME_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> GREEN_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> CYAN_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> LIGHT_BLUE_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> BLUE_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> PURPLE_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> MAGENTA_BLOCKS = new ArrayList<>();
    protected static final List<RegistrySupplier<Block>> PINK_BLOCKS = new ArrayList<>();

    static {
        BLOCKS_TO_DYE.forEach(data -> {
            String materialName = data.getA().getA();
            String material = data.getA().getB();
            Block baseBlock = data.getB();
            Tool tool = data.getC();

            BlockConfig config = new BlockConfig()
                .material(material)
                .materialName(materialName)
                .ingredient(baseBlock)
                .tool(tool);

            RegistrySupplier<Block> whiteBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.WHITE), () -> new DyedBlock(config, DyeColor.WHITE), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> lightGrayBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.LIGHT_GRAY), () -> new DyedBlock(config, DyeColor.LIGHT_GRAY), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> grayBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.GRAY), () -> new DyedBlock(config, DyeColor.GRAY), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> blackBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.BLACK), () -> new DyedBlock(config, DyeColor.BLACK), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> brownBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.BROWN), () -> new DyedBlock(config, DyeColor.BROWN), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> redBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.RED), () -> new DyedBlock(config, DyeColor.RED), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> orangeBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.ORANGE), () -> new DyedBlock(config, DyeColor.ORANGE), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> yellowBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.YELLOW), () -> new DyedBlock(config, DyeColor.YELLOW), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> limeBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.LIME), () -> new DyedBlock(config, DyeColor.LIME), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> greenBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.GREEN), () -> new DyedBlock(config, DyeColor.GREEN), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> cyanBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.CYAN), () -> new DyedBlock(config, DyeColor.CYAN), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> lightBlueBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.LIGHT_BLUE), () -> new DyedBlock(config, DyeColor.LIGHT_BLUE), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> blueBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.BLUE), () -> new DyedBlock(config, DyeColor.BLUE), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> purpleBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.PURPLE), () -> new DyedBlock(config, DyeColor.PURPLE), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> magentaBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.MAGENTA), () -> new DyedBlock(config, DyeColor.MAGENTA), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> pinkBlock = registerWithItem(DyedBlock.makeId(config.getMaterial(), DyeColor.PINK), () -> new DyedBlock(config, DyeColor.PINK), DEFAULT_DYED_BLOCK_SETTINGS);

            BLOCK_MAP.put(material + "white", whiteBlock);
            BLOCK_MAP.put(material + "light_gray", lightGrayBlock);
            BLOCK_MAP.put(material + "gray", grayBlock);
            BLOCK_MAP.put(material + "black", blackBlock);
            BLOCK_MAP.put(material + "brown", brownBlock);
            BLOCK_MAP.put(material + "red", redBlock);
            BLOCK_MAP.put(material + "orange", orangeBlock);
            BLOCK_MAP.put(material + "yellow", yellowBlock);
            BLOCK_MAP.put(material + "lime", limeBlock);
            BLOCK_MAP.put(material + "green", greenBlock);
            BLOCK_MAP.put(material + "cyan", cyanBlock);
            BLOCK_MAP.put(material + "light_blue", lightBlueBlock);
            BLOCK_MAP.put(material + "blue", blueBlock);
            BLOCK_MAP.put(material + "purple", purpleBlock);
            BLOCK_MAP.put(material + "magenta", magentaBlock);
            BLOCK_MAP.put(material + "pink", pinkBlock);

            WHITE_BLOCKS.add(whiteBlock);
            LIGHT_GRAY_BLOCKS.add(lightGrayBlock);
            GRAY_BLOCKS.add(grayBlock);
            BLACK_BLOCKS.add(blackBlock);
            BROWN_BLOCKS.add(brownBlock);
            RED_BLOCKS.add(redBlock);
            ORANGE_BLOCKS.add(orangeBlock);
            YELLOW_BLOCKS.add(yellowBlock);
            LIME_BLOCKS.add(limeBlock);
            GREEN_BLOCKS.add(greenBlock);
            CYAN_BLOCKS.add(cyanBlock);
            LIGHT_BLUE_BLOCKS.add(lightBlueBlock);
            BLUE_BLOCKS.add(blueBlock);
            PURPLE_BLOCKS.add(purpleBlock);
            MAGENTA_BLOCKS.add(magentaBlock);
            PINK_BLOCKS.add(pinkBlock);
        });

        PILLAR_BLOCKS_TO_DYE.forEach(data -> {
            String materialName = data.getA().getA();
            String material = data.getA().getB();
            Block ingredient = data.getB();
            Tool tool = data.getC();

            BlockConfig config = new BlockConfig()
                .materialName(materialName)
                .material(material)
                .ingredient(ingredient)
                .tool(tool);

            RegistrySupplier<Block> whiteBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.WHITE), () -> new DyedPillarBlock(config, DyeColor.WHITE), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> lightGrayBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.LIGHT_GRAY), () -> new DyedPillarBlock(config, DyeColor.LIGHT_GRAY), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> grayBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.GRAY), () -> new DyedPillarBlock(config, DyeColor.GRAY), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> blackBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.BLACK), () -> new DyedPillarBlock(config, DyeColor.BLACK), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> brownBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.BROWN), () -> new DyedPillarBlock(config, DyeColor.BROWN), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> redBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.RED), () -> new DyedPillarBlock(config, DyeColor.RED), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> orangeBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.ORANGE), () -> new DyedPillarBlock(config, DyeColor.ORANGE), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> yellowBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.YELLOW), () -> new DyedPillarBlock(config, DyeColor.YELLOW), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> limeBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.LIME), () -> new DyedPillarBlock(config, DyeColor.LIME), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> greenBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.GREEN), () -> new DyedPillarBlock(config, DyeColor.GREEN), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> cyanBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.CYAN), () -> new DyedPillarBlock(config, DyeColor.CYAN), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> lightBlueBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.LIGHT_BLUE), () -> new DyedPillarBlock(config, DyeColor.LIGHT_BLUE), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> blueBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.BLUE), () -> new DyedPillarBlock(config, DyeColor.BLUE), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> purpleBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.PURPLE), () -> new DyedPillarBlock(config, DyeColor.PURPLE), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> magentaBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.MAGENTA), () -> new DyedPillarBlock(config, DyeColor.MAGENTA), DEFAULT_DYED_BLOCK_SETTINGS);
            RegistrySupplier<Block> pinkBlock = registerWithItem(DyedPillarBlock.makeId(config.getMaterial(), DyeColor.PINK), () -> new DyedPillarBlock(config, DyeColor.PINK), DEFAULT_DYED_BLOCK_SETTINGS);

            PILLAR_BLOCK_MAP.put(material + "white", whiteBlock);
            PILLAR_BLOCK_MAP.put(material + "light_gray", lightGrayBlock);
            PILLAR_BLOCK_MAP.put(material + "gray", grayBlock);
            PILLAR_BLOCK_MAP.put(material + "black", blackBlock);
            PILLAR_BLOCK_MAP.put(material + "brown", brownBlock);
            PILLAR_BLOCK_MAP.put(material + "red", redBlock);
            PILLAR_BLOCK_MAP.put(material + "orange", orangeBlock);
            PILLAR_BLOCK_MAP.put(material + "yellow", yellowBlock);
            PILLAR_BLOCK_MAP.put(material + "lime", limeBlock);
            PILLAR_BLOCK_MAP.put(material + "green", greenBlock);
            PILLAR_BLOCK_MAP.put(material + "cyan", cyanBlock);
            PILLAR_BLOCK_MAP.put(material + "light_blue", lightBlueBlock);
            PILLAR_BLOCK_MAP.put(material + "blue", blueBlock);
            PILLAR_BLOCK_MAP.put(material + "purple", purpleBlock);
            PILLAR_BLOCK_MAP.put(material + "magenta", magentaBlock);
            PILLAR_BLOCK_MAP.put(material + "pink", pinkBlock);

            WHITE_BLOCKS.add(whiteBlock);
            LIGHT_GRAY_BLOCKS.add(lightGrayBlock);
            GRAY_BLOCKS.add(grayBlock);
            BLACK_BLOCKS.add(blackBlock);
            BROWN_BLOCKS.add(brownBlock);
            RED_BLOCKS.add(redBlock);
            ORANGE_BLOCKS.add(orangeBlock);
            YELLOW_BLOCKS.add(yellowBlock);
            LIME_BLOCKS.add(limeBlock);
            GREEN_BLOCKS.add(greenBlock);
            CYAN_BLOCKS.add(cyanBlock);
            LIGHT_BLUE_BLOCKS.add(lightBlueBlock);
            BLUE_BLOCKS.add(blueBlock);
            PURPLE_BLOCKS.add(purpleBlock);
            MAGENTA_BLOCKS.add(magentaBlock);
            PINK_BLOCKS.add(pinkBlock);
        });

        BLOCKS.addAll(BLOCK_MAP.values());
        BLOCKS.addAll(PILLAR_BLOCK_MAP.values());
    }
}
