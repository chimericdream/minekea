//package com.chimericdream.minekea.block.building.stairs;
//
//import com.chimericdream.minekea.block.building.stairs.GenericBookshelfStairs.BookshelfStairsSettings;
//import com.chimericdream.minekea.block.building.stairs.GenericStairsBlock.StairsSettings;
//import com.chimericdream.minekea.block.building.stairs.GenericVerticalBookshelfStairs.VerticalBookshelfStairsSettings;
//import com.chimericdream.minekea.block.building.stairs.GenericVerticalStairsBlock.VerticalStairsSettings;
//import com.chimericdream.minekea.settings.BaseBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
//import com.chimericdream.minekea.util.MinekeaBlockCategory;
//import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
//import net.minecraft.client.render.RenderLayer;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class Stairs implements MinekeaBlockCategory {
//    public static final Map<String, GenericStairsBlock> STAIRS = new LinkedHashMap<>();
//    public static final Map<String, GenericBookshelfStairs> BOOKSHELF_STAIRS = new LinkedHashMap<>();
//    public static final Map<String, GenericVerticalStairsBlock> VERTICAL_STAIRS = new LinkedHashMap<>();
//    public static final Map<String, GenericVerticalBookshelfStairs> VERTICAL_BOOKSHELF_STAIRS = new LinkedHashMap<>();
//
//    static {
//        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
//            if (settings.hasStairs()) {
//                STAIRS.put(settings.getMainMaterial(), new GenericStairsBlock(new StairsSettings(settings)));
//            }
//
//            if (settings.hasBookshelfStairs()) {
//                BOOKSHELF_STAIRS.put(
//                    settings.getMainMaterial(),
//                    new GenericBookshelfStairs(
//                        new BookshelfStairsSettings(settings)
//                            .addMaterial("bookshelf", settings.getBookshelfId())
//                            .addMaterial("model", settings.getBookshelfModel())
//                    )
//                );
//            }
//
//            if (settings.hasVerticalStairs()) {
//                VERTICAL_STAIRS.put(settings.getMainMaterial(), new GenericVerticalStairsBlock(new VerticalStairsSettings(settings)));
//            }
//
//            if (settings.hasVerticalBookshelfStairs()) {
//                VERTICAL_BOOKSHELF_STAIRS.put(
//                    settings.getMainMaterial(),
//                    new GenericVerticalBookshelfStairs(
//                        new VerticalBookshelfStairsSettings(settings)
//                            .addMaterial("bookshelf", settings.getBookshelfId())
//                            .addMaterial("model", settings.getBookshelfModel())
//                    )
//                );
//            }
//        }
//    }
//
//    @Override
//    public void initializeClient() {
//        for (GenericStairsBlock block : STAIRS.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            if (settings.isTranslucent()) {
//                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
//            }
//        }
//
//        for (GenericVerticalStairsBlock block : VERTICAL_STAIRS.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            if (settings.isTranslucent()) {
//                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
//            }
//        }
//    }
//
//    @Override
//    public void registerBlocks() {
//        for (GenericStairsBlock block : STAIRS.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            block.register(settings.isFlammable());
//        }
//
//        for (GenericBookshelfStairs block : BOOKSHELF_STAIRS.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            block.register(settings.isFlammable());
//        }
//
//        for (GenericVerticalStairsBlock block : VERTICAL_STAIRS.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            block.register(settings.isFlammable());
//        }
//
//        for (GenericVerticalBookshelfStairs block : VERTICAL_BOOKSHELF_STAIRS.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            block.register(settings.isFlammable());
//        }
//    }
//
//    @Override
//    public void registerBlockEntities() {
//    }
//
//    @Override
//    public void registerEntities() {
//    }
//
//    @Override
//    public void setupResources() {
//    }
//}
