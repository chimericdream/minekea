package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.NuggetBags;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerWithItem;

public class StorageBlocks implements ModThingGroup {
    public static final Item.Settings DEFAULT_DYE_BLOCK_SETTINGS = new Item.Settings().arch$tab(ItemGroups.COLORED_BLOCKS);
    public static final Item.Settings DEFAULT_STORAGE_BLOCK_SETTINGS = new Item.Settings().arch$tab(ItemGroups.BUILDING_BLOCKS);

    public static final RegistrySupplier<Block> WHITE_DYE_BLOCK;
    public static final RegistrySupplier<Block> ORANGE_DYE_BLOCK;
    public static final RegistrySupplier<Block> MAGENTA_DYE_BLOCK;
    public static final RegistrySupplier<Block> LIGHT_BLUE_DYE_BLOCK;
    public static final RegistrySupplier<Block> YELLOW_DYE_BLOCK;
    public static final RegistrySupplier<Block> LIME_DYE_BLOCK;
    public static final RegistrySupplier<Block> PINK_DYE_BLOCK;
    public static final RegistrySupplier<Block> GRAY_DYE_BLOCK;
    public static final RegistrySupplier<Block> LIGHT_GRAY_DYE_BLOCK;
    public static final RegistrySupplier<Block> CYAN_DYE_BLOCK;
    public static final RegistrySupplier<Block> PURPLE_DYE_BLOCK;
    public static final RegistrySupplier<Block> BLUE_DYE_BLOCK;
    public static final RegistrySupplier<Block> BROWN_DYE_BLOCK;
    public static final RegistrySupplier<Block> GREEN_DYE_BLOCK;
    public static final RegistrySupplier<Block> RED_DYE_BLOCK;
    public static final RegistrySupplier<Block> BLACK_DYE_BLOCK;

    public static final List<RegistrySupplier<Block>> DYE_BLOCKS;

    public static final RegistrySupplier<Block> APPLE_STORAGE_BLOCK;
    public static final RegistrySupplier<Block> BEETROOT_BLOCK;
    public static final RegistrySupplier<Block> BEETROOT_SEEDS_BLOCK;
    public static final RegistrySupplier<Block> BLAZE_POWDER_BLOCK;
    public static final RegistrySupplier<Block> BLAZE_ROD_BLOCK;
    public static final RegistrySupplier<Block> BREEZE_ROD_BLOCK;
    public static final RegistrySupplier<Block> CARROT_BLOCK;
    public static final RegistrySupplier<Block> CHARCOAL_BLOCK;
    public static final RegistrySupplier<Block> CHORUS_FRUIT_BLOCK;
    public static final RegistrySupplier<Block> ENDER_PEARL_BLOCK;
    public static final RegistrySupplier<Block> FLINT_BLOCK;
    public static final RegistrySupplier<Block> GOLD_NUGGET_SACK;
    public static final RegistrySupplier<Block> GOLDEN_APPLE_BLOCK;
    public static final RegistrySupplier<Block> IRON_NUGGET_SACK;
    public static final RegistrySupplier<Block> LEATHER_BLOCK;
    public static final RegistrySupplier<Block> MELON_SEEDS_BLOCK;
    public static final RegistrySupplier<Block> NETHER_STAR_BLOCK;
    public static final RegistrySupplier<Block> PHANTOM_MEMBRANE_BLOCK;
    public static final RegistrySupplier<Block> POTATO_BLOCK;
    public static final RegistrySupplier<Block> PUMPKIN_SEEDS_BLOCK;
    public static final RegistrySupplier<Block> SET_OF_EGGS_BLOCK;
    public static final RegistrySupplier<Block> STICK_BLOCK;
    public static final RegistrySupplier<Block> SUGAR_BLOCK;
    public static final RegistrySupplier<Block> SUGAR_CANE_BLOCK;
    public static final RegistrySupplier<Block> TOTEM_BLOCK;
    public static final RegistrySupplier<Block> WALLPAPER_BLOCK;
    public static final RegistrySupplier<Block> WHEAT_SEEDS_BLOCK;

    public static final List<RegistrySupplier<Block>> STORAGE_BLOCKS;
    public static final List<RegistrySupplier<Block>> BAGGED_BLOCKS;

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    static {
        WHITE_DYE_BLOCK = registerWithItem(DyeBlock.makeId("white"), () -> new DyeBlock("white"), DEFAULT_DYE_BLOCK_SETTINGS);
        LIGHT_GRAY_DYE_BLOCK = registerWithItem(DyeBlock.makeId("light_gray"), () -> new DyeBlock("light_gray"), DEFAULT_DYE_BLOCK_SETTINGS);
        GRAY_DYE_BLOCK = registerWithItem(DyeBlock.makeId("gray"), () -> new DyeBlock("gray"), DEFAULT_DYE_BLOCK_SETTINGS);
        BLACK_DYE_BLOCK = registerWithItem(DyeBlock.makeId("black"), () -> new DyeBlock("black"), DEFAULT_DYE_BLOCK_SETTINGS);
        BROWN_DYE_BLOCK = registerWithItem(DyeBlock.makeId("brown"), () -> new DyeBlock("brown"), DEFAULT_DYE_BLOCK_SETTINGS);
        RED_DYE_BLOCK = registerWithItem(DyeBlock.makeId("red"), () -> new DyeBlock("red"), DEFAULT_DYE_BLOCK_SETTINGS);
        ORANGE_DYE_BLOCK = registerWithItem(DyeBlock.makeId("orange"), () -> new DyeBlock("orange"), DEFAULT_DYE_BLOCK_SETTINGS);
        YELLOW_DYE_BLOCK = registerWithItem(DyeBlock.makeId("yellow"), () -> new DyeBlock("yellow"), DEFAULT_DYE_BLOCK_SETTINGS);
        LIME_DYE_BLOCK = registerWithItem(DyeBlock.makeId("lime"), () -> new DyeBlock("lime"), DEFAULT_DYE_BLOCK_SETTINGS);
        GREEN_DYE_BLOCK = registerWithItem(DyeBlock.makeId("green"), () -> new DyeBlock("green"), DEFAULT_DYE_BLOCK_SETTINGS);
        CYAN_DYE_BLOCK = registerWithItem(DyeBlock.makeId("cyan"), () -> new DyeBlock("cyan"), DEFAULT_DYE_BLOCK_SETTINGS);
        LIGHT_BLUE_DYE_BLOCK = registerWithItem(DyeBlock.makeId("light_blue"), () -> new DyeBlock("light_blue"), DEFAULT_DYE_BLOCK_SETTINGS);
        BLUE_DYE_BLOCK = registerWithItem(DyeBlock.makeId("blue"), () -> new DyeBlock("blue"), DEFAULT_DYE_BLOCK_SETTINGS);
        PURPLE_DYE_BLOCK = registerWithItem(DyeBlock.makeId("purple"), () -> new DyeBlock("purple"), DEFAULT_DYE_BLOCK_SETTINGS);
        MAGENTA_DYE_BLOCK = registerWithItem(DyeBlock.makeId("magenta"), () -> new DyeBlock("magenta"), DEFAULT_DYE_BLOCK_SETTINGS);
        PINK_DYE_BLOCK = registerWithItem(DyeBlock.makeId("pink"), () -> new DyeBlock("pink"), DEFAULT_DYE_BLOCK_SETTINGS);

        DYE_BLOCKS = List.of(
            WHITE_DYE_BLOCK,
            LIGHT_GRAY_DYE_BLOCK,
            GRAY_DYE_BLOCK,
            BLACK_DYE_BLOCK,
            BROWN_DYE_BLOCK,
            RED_DYE_BLOCK,
            ORANGE_DYE_BLOCK,
            YELLOW_DYE_BLOCK,
            LIME_DYE_BLOCK,
            GREEN_DYE_BLOCK,
            CYAN_DYE_BLOCK,
            LIGHT_BLUE_DYE_BLOCK,
            BLUE_DYE_BLOCK,
            PURPLE_DYE_BLOCK,
            MAGENTA_DYE_BLOCK,
            PINK_DYE_BLOCK
        );

        APPLE_STORAGE_BLOCK = registerWithItem(ItemStorageBlock.makeId("apple"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.MELON).sounds(BlockSoundGroup.WOOD)).item(Items.APPLE).material("apple").materialName("Apple").tool(Tool.HOE), false, ItemStorageBlock.StorageModel.FACING), DEFAULT_STORAGE_BLOCK_SETTINGS);
        BEETROOT_SEEDS_BLOCK = registerWithItem(ItemStorageBlock.makeId("beetroot_seeds"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).nonOpaque().sounds(BlockSoundGroup.CROP)).item(Items.BEETROOT_SEEDS).material("beetroot_seeds").materialName("Beetroot Seeds").tool(Tool.HOE), true), DEFAULT_STORAGE_BLOCK_SETTINGS);
        BEETROOT_BLOCK = registerWithItem(ItemStorageBlock.makeId("beetroot"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).nonOpaque().sounds(BlockSoundGroup.CROP)).item(Items.BEETROOT).material("beetroot").materialName("Beetroot").tool(Tool.HOE), true), DEFAULT_STORAGE_BLOCK_SETTINGS);
        BLAZE_POWDER_BLOCK = registerWithItem(ItemStorageBlock.makeId("blaze_powder"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).sounds(BlockSoundGroup.NETHER_STEM)).item(Items.BLAZE_POWDER).material("blaze_powder").materialName("Blaze Powder").tool(Tool.SHOVEL)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        BLAZE_ROD_BLOCK = registerWithItem(ItemStorageBlock.makeId("blaze_rod"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).sounds(BlockSoundGroup.NETHER_STEM)).item(Items.BLAZE_ROD).material("blaze_rod").materialName("Blaze Rod").tool(Tool.AXE)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        BREEZE_ROD_BLOCK = registerWithItem(ItemStorageBlock.makeId("breeze_rod"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HEAVY_CORE).sounds(BlockSoundGroup.BASALT)).item(Items.BREEZE_ROD).material("breeze_rod").materialName("Breeze Rod").tool(Tool.PICKAXE)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        CARROT_BLOCK = registerWithItem(ItemStorageBlock.makeId("carrot"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).sounds(BlockSoundGroup.CROP)).item(Items.CARROT).material("carrot").materialName("Carrot").tool(Tool.HOE), true), DEFAULT_STORAGE_BLOCK_SETTINGS);
        CHARCOAL_BLOCK = registerWithItem(ItemStorageBlock.makeId("charcoal"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.COAL_BLOCK).sounds(BlockSoundGroup.TUFF)).item(Items.CHARCOAL).material("charcoal").name("Charcoal Block").tool(Tool.PICKAXE)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        CHORUS_FRUIT_BLOCK = registerWithItem(ItemStorageBlock.makeId("chorus_fruit"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.PURPUR_BLOCK).sounds(BlockSoundGroup.WOOD)).item(Items.CHORUS_FRUIT).material("chorus_fruit").materialName("Chorus Fruit").tool(Tool.AXE), true), DEFAULT_STORAGE_BLOCK_SETTINGS);
        ENDER_PEARL_BLOCK = registerWithItem(ItemStorageBlock.makeId("ender_pearl"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.PURPUR_BLOCK).sounds(BlockSoundGroup.SHROOMLIGHT)).item(Items.ENDER_PEARL).material("ender_pearl").materialName("Ender Pearl").tool(Tool.PICKAXE)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        FLINT_BLOCK = registerWithItem(ItemStorageBlock.makeId("flint"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.COBBLESTONE).sounds(BlockSoundGroup.STONE)).material("flint").item(Items.FLINT).materialName("Flint").tool(Tool.PICKAXE)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        GOLD_NUGGET_SACK = registerWithItem(ItemStorageBlock.makeId("gold_nugget"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL)).item(NuggetBags.GOLD_NUGGET_BAG).material("gold_nugget").name("Gold Nugget Sack").tool(Tool.PICKAXE).texture("contents", Identifier.of(ModInfo.MOD_ID, "block/storage/compressed/currency/gold_nugget_bag")).texture("all", Identifier.of(ModInfo.MOD_ID, "block/storage/compressed/currency/gold_nugget_bag")), true, ItemStorageBlock.StorageModel.CUSTOM), DEFAULT_STORAGE_BLOCK_SETTINGS);
        GOLDEN_APPLE_BLOCK = registerWithItem(ItemStorageBlock.makeId("golden_apple"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.MELON).sounds(BlockSoundGroup.WOOD)).item(Items.GOLDEN_APPLE).material("golden_apple").materialName("Golden Apple").tool(Tool.HOE), false, ItemStorageBlock.StorageModel.FACING), DEFAULT_STORAGE_BLOCK_SETTINGS);
        IRON_NUGGET_SACK = registerWithItem(ItemStorageBlock.makeId("iron_nugget"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL)).item(NuggetBags.IRON_NUGGET_BAG).material("iron_nugget").name("Iron Nugget Sack").tool(Tool.PICKAXE).texture("contents", Identifier.of(ModInfo.MOD_ID, "block/storage/compressed/currency/iron_nugget_bag")).texture("all", Identifier.of(ModInfo.MOD_ID, "block/storage/compressed/currency/iron_nugget_bag")), true, ItemStorageBlock.StorageModel.CUSTOM), DEFAULT_STORAGE_BLOCK_SETTINGS);
        LEATHER_BLOCK = registerWithItem(ItemStorageBlock.makeId("leather"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)).item(Items.LEATHER).material("leather").materialName("Leather").tool(Tool.SHEARS)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        MELON_SEEDS_BLOCK = registerWithItem(ItemStorageBlock.makeId("melon_seeds"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).nonOpaque().sounds(BlockSoundGroup.CROP)).item(Items.MELON_SEEDS).material("melon_seeds").materialName("Melon Seeds").tool(Tool.HOE), true), DEFAULT_STORAGE_BLOCK_SETTINGS);
        NETHER_STAR_BLOCK = registerWithItem(ItemStorageBlock.makeId("nether_star"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).sounds(BlockSoundGroup.METAL)).item(Items.NETHER_STAR).material("nether_star").materialName("Nether Star").tool(Tool.PICKAXE)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        PHANTOM_MEMBRANE_BLOCK = registerWithItem(ItemStorageBlock.makeId("phantom_membrane"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.NETHER_WART_BLOCK).sounds(BlockSoundGroup.NETHER_WART)).item(Items.PHANTOM_MEMBRANE).material("phantom_membrane").materialName("Phantom Membrane").tool(Tool.HOE), true), DEFAULT_STORAGE_BLOCK_SETTINGS);
        POTATO_BLOCK = registerWithItem(ItemStorageBlock.makeId("potato"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).sounds(BlockSoundGroup.CROP)).item(Items.POTATO).material("potato").materialName("Potato").tool(Tool.HOE), true), DEFAULT_STORAGE_BLOCK_SETTINGS);
        PUMPKIN_SEEDS_BLOCK = registerWithItem(ItemStorageBlock.makeId("pumpkin_seeds"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).nonOpaque().sounds(BlockSoundGroup.CROP)).item(Items.PUMPKIN_SEEDS).material("pumpkin_seeds").materialName("Pumpkin Seeds").tool(Tool.HOE), true), DEFAULT_STORAGE_BLOCK_SETTINGS);
        STICK_BLOCK = registerWithItem(ItemStorageBlock.makeId("stick"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD)).item(Items.STICK).material("stick").materialName("Stick").tool(Tool.AXE)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        SUGAR_BLOCK = registerWithItem(ItemStorageBlock.makeId("sugar"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).sounds(BlockSoundGroup.SAND)).item(Items.SUGAR).material("sugar").materialName("Sugar").tool(Tool.SHOVEL), true), DEFAULT_STORAGE_BLOCK_SETTINGS);
        SUGAR_CANE_BLOCK = registerWithItem(ItemStorageBlock.makeId("sugar_cane"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).nonOpaque().sounds(BlockSoundGroup.GRASS)).item(Items.SUGAR_CANE).material("sugar_cane").materialName("Sugar Cane").tool(Tool.AXE).renderType(BlockConfig.RenderType.TRANSLUCENT)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        TOTEM_BLOCK = registerWithItem(ItemStorageBlock.makeId("totem_of_undying"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL)).item(Items.TOTEM_OF_UNDYING).material("totem_of_undying").materialName("Totem of Undying").tool(Tool.PICKAXE), false, ItemStorageBlock.StorageModel.AXIS), DEFAULT_STORAGE_BLOCK_SETTINGS);
        WALLPAPER_BLOCK = registerWithItem(ItemStorageBlock.makeId("paper"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).sounds(BlockSoundGroup.NETHER_STEM)).item(Items.PAPER).material("paper").name("Wallpaper").tool(Tool.AXE)), DEFAULT_STORAGE_BLOCK_SETTINGS);
        WHEAT_SEEDS_BLOCK = registerWithItem(ItemStorageBlock.makeId("wheat_seeds"), () -> new ItemStorageBlock(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.HAY_BLOCK).nonOpaque().sounds(BlockSoundGroup.CROP)).item(Items.WHEAT_SEEDS).material("wheat_seeds").materialName("Wheat Seeds").tool(Tool.HOE), true), DEFAULT_STORAGE_BLOCK_SETTINGS);

        SET_OF_EGGS_BLOCK = registerWithItem(SetOfEggsBlock.BLOCK_ID, SetOfEggsBlock::new, DEFAULT_STORAGE_BLOCK_SETTINGS);

        STORAGE_BLOCKS = List.of(
            APPLE_STORAGE_BLOCK,
            BEETROOT_BLOCK,
            BEETROOT_SEEDS_BLOCK,
            BLAZE_POWDER_BLOCK,
            BLAZE_ROD_BLOCK,
            BREEZE_ROD_BLOCK,
            CARROT_BLOCK,
            CHARCOAL_BLOCK,
            CHORUS_FRUIT_BLOCK,
            ENDER_PEARL_BLOCK,
            FLINT_BLOCK,
            GOLD_NUGGET_SACK,
            GOLDEN_APPLE_BLOCK,
            IRON_NUGGET_SACK,
            LEATHER_BLOCK,
            MELON_SEEDS_BLOCK,
            NETHER_STAR_BLOCK,
            PHANTOM_MEMBRANE_BLOCK,
            POTATO_BLOCK,
            PUMPKIN_SEEDS_BLOCK,
            STICK_BLOCK,
            SUGAR_BLOCK,
            SUGAR_CANE_BLOCK,
            TOTEM_BLOCK,
            WALLPAPER_BLOCK,
            WHEAT_SEEDS_BLOCK
        );

        BAGGED_BLOCKS = List.of(
            BEETROOT_BLOCK,
            BEETROOT_SEEDS_BLOCK,
            CARROT_BLOCK,
            CHORUS_FRUIT_BLOCK,
            GOLD_NUGGET_SACK,
            IRON_NUGGET_SACK,
            MELON_SEEDS_BLOCK,
            PHANTOM_MEMBRANE_BLOCK,
            POTATO_BLOCK,
            PUMPKIN_SEEDS_BLOCK,
            SUGAR_BLOCK,
            WHEAT_SEEDS_BLOCK
        );

        BLOCKS.addAll(DYE_BLOCKS);
        BLOCKS.addAll(STORAGE_BLOCKS);
        BLOCKS.add(SET_OF_EGGS_BLOCK);
    }

//    @Environment(EnvType.CLIENT)
//    @Override
//    public void initializeClient() {
//        DYE_BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent()));
//        BAGGED_BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));
//
//        BlockRenderLayerMap.INSTANCE.putBlock(SET_OF_EGGS_BLOCK, RenderLayer.getCutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(SUGAR_CANE_BLOCK, RenderLayer.getTranslucent());
//    }

//    @Override
//    public void registerBlocks() {
//        MinekeaBlockCategory.super.registerBlocks();
//
//        GOLD_NUGGET_BAG.register();
//        IRON_NUGGET_BAG.register();
//    }
//
//    @Override
//    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
//        MinekeaBlockCategory.super.configureItemTags(registryLookup, getBuilder);
//
//        GOLD_NUGGET_BAG.configureItemTags(registryLookup, getBuilder);
//        IRON_NUGGET_BAG.configureItemTags(registryLookup, getBuilder);
//    }
//
//    @Override
//    public void configureRecipes(RecipeExporter exporter) {
//        MinekeaBlockCategory.super.configureRecipes(exporter);
//
//        GOLD_NUGGET_BAG.configureRecipes(exporter);
//        IRON_NUGGET_BAG.configureRecipes(exporter);
//    }
//
//    @Override
//    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
//        MinekeaBlockCategory.super.configureTranslations(registryLookup, translationBuilder);
//
//        GOLD_NUGGET_BAG.configureTranslations(registryLookup, translationBuilder);
//        IRON_NUGGET_BAG.configureTranslations(registryLookup, translationBuilder);
//    }
//
//    @Override
//    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
//        MinekeaBlockCategory.super.configureItemModels(itemModelGenerator);
//
//        GOLD_NUGGET_BAG.configureItemModels(itemModelGenerator);
//        IRON_NUGGET_BAG.configureItemModels(itemModelGenerator);
//    }
}
