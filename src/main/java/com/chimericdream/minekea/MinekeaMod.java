package com.chimericdream.minekea;

import com.chimericdream.minekea.block.barrels.Barrels;
import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.crates.Crates;
import com.chimericdream.minekea.block.decorations.DecorationBlocks;
import com.chimericdream.minekea.block.displaycases.DisplayCases;
import com.chimericdream.minekea.block.doors.Doors;
import com.chimericdream.minekea.block.scales.ScaledBlocks;
import com.chimericdream.minekea.block.shelves.Shelves;
import com.chimericdream.minekea.block.slabs.BookshelfSlabs;
import com.chimericdream.minekea.block.stairs.BookshelfStairs;
import com.chimericdream.minekea.block.tables.Tables;
import com.chimericdream.minekea.block.trapdoors.Trapdoors;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.compat.byg.BygBlocks;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.tag.MinekeaTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MinekeaMod implements ModInitializer {
    public static final Logger LOGGER;

    public static final Bookshelves BOOKSHELVES;
    public static final Doors DOORS;
    public static final Trapdoors TRAPDOORS;
    public static final Crates CRATES;
    public static final Barrels BARRELS;
    public static final DisplayCases DISPLAY_CASES;
    public static final BookshelfStairs BOOKSHELF_STAIRS;
    public static final BookshelfSlabs BOOKSHELF_SLABS;
    public static final Shelves SHELVES;
    public static final DecorationBlocks DECORATION_BLOCKS;
    public static final Tables TABLES;
    public static final ScaledBlocks SCALED_BLOCKS;

    public static final MinekeaTags TAGS;
    public static final MinekeaResourcePack RESOURCES;
    public static final List<ModCompatLayer> OTHER_MODS = new ArrayList<>();

    static {
        LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);
        BOOKSHELVES = new Bookshelves();
        DOORS = new Doors();
        TRAPDOORS = new Trapdoors();
        CRATES = new Crates();
        BARRELS = new Barrels();
        DISPLAY_CASES = new DisplayCases();
        BOOKSHELF_STAIRS = new BookshelfStairs();
        BOOKSHELF_SLABS = new BookshelfSlabs();
        SHELVES = new Shelves();
        DECORATION_BLOCKS = new DecorationBlocks();
        TABLES = new Tables();
        SCALED_BLOCKS = new ScaledBlocks();

        TAGS = new MinekeaTags();
        RESOURCES = new MinekeaResourcePack();

        FabricLoader loader = FabricLoader.getInstance();

        if (loader.isModLoaded("byg")) {
            OTHER_MODS.add(new BygBlocks());
        }
    }

    /*
     * Inspiration:
     * https://www.curseforge.com/minecraft/mc-mods/bookshelving
     * https://www.curseforge.com/minecraft/mc-mods/market-crates
     * https://www.curseforge.com/minecraft/mc-mods/secret-bookshelf
     * https://www.curseforge.com/minecraft/mc-mods/giacomos-bookshelf
     * https://www.curseforge.com/minecraft/mc-mods/bookinit
     * https://www.curseforge.com/minecraft/mc-mods/beholders-bookshelves
     *
     * [ ] iron shelves
     * [x] variant bookshelves
     * [x]   - works for enchanting
     * [x] storage version of all bookshelves
     * [x]   - works for enchanting
     * [ ]   - works for enchanting (variable power based on contents)
     * [x] secret door bookshelves in all wood types
     * [x] crates in all wood types
     * [x] variant barrels
     * [ ] variant crafting tables
     * [ ] variant ladders
     * [ ] bookshelves in non-wood varieties
     * [ ]   - quartz
     * [ ]   - smooth quartz
     * [ ]   - smooth stone
     * [ ]   - polished granite
     * [ ]   - polished andesite
     * [ ]   - polished diorite
     * [ ]   - polished blackstone
     * [ ]   - polished blackstone bricks
     * [ ]   - polished deepslate
     * [ ]   - polished basalt
     * [ ]   - stone bricks
     * [ ]   - deepslate bricks
     * [ ]   - endstone bricks
     * [ ]   - nether bricks
     * [ ]   - red nether bricks
     * [ ]   - prismarine bricks
     * [ ]   - quartz bricks
     * [ ]   - purpur
     * [ ]   - bone
     * [ ]   - prismarine
     * [ ]   - dark prismarine
     */

    @Override
    public void onInitialize() {
        LOGGER.info("[minekea] Registering block and item tags");
        TAGS.init();

        LOGGER.info("[minekea] Registering blocks");
        BOOKSHELVES.register();
        DOORS.register();
        TRAPDOORS.register();
        CRATES.register();
        BARRELS.register();
        DISPLAY_CASES.register();
        BOOKSHELF_STAIRS.register();
        BOOKSHELF_SLABS.register();
        SHELVES.register();
        DECORATION_BLOCKS.register();
        TABLES.register();
        SCALED_BLOCKS.register();

        for (ModCompatLayer mod : OTHER_MODS) {
            mod.register();
        }

        // This must be the last thing
        RESOURCES.register();
    }

    @Environment(EnvType.CLIENT)
    public static void onInitializeClient() {
        LOGGER.info("[minekea] Initializing client code");

        BOOKSHELVES.onInitializeClient();
        DOORS.onInitializeClient();
        TRAPDOORS.onInitializeClient();
        CRATES.onInitializeClient();
        BARRELS.onInitializeClient();
        DISPLAY_CASES.onInitializeClient();
        BOOKSHELF_STAIRS.onInitializeClient();
        BOOKSHELF_SLABS.onInitializeClient();
        SHELVES.onInitializeClient();
        DECORATION_BLOCKS.onInitializeClient();
        TABLES.onInitializeClient();
        SCALED_BLOCKS.onInitializeClient();
    }
}
