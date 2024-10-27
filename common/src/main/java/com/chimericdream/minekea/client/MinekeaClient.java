package com.chimericdream.minekea.client;

import com.chimericdream.lib.entities.SimpleSeatEntity;
import com.chimericdream.minekea.block.containers.crates.Crates;
import com.chimericdream.minekea.block.furniture.armoires.Armoires;
import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import com.chimericdream.minekea.block.furniture.seats.Seats;
import com.chimericdream.minekea.block.furniture.shelves.Shelves;
import com.chimericdream.minekea.client.render.block.ArmoireBlockEntityRenderer;
import com.chimericdream.minekea.client.render.block.DisplayCaseBlockEntityRenderer;
import com.chimericdream.minekea.client.render.block.ShelfBlockEntityRenderer;
import com.chimericdream.minekea.client.screen.BlockPainterScreen;
import com.chimericdream.minekea.client.screen.crate.CrateScreen;
import com.chimericdream.minekea.client.screen.crate.DoubleCrateScreen;
import com.chimericdream.minekea.item.Tools;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class MinekeaClient {
    public static void onInitializeClient() {
        HandledScreens.register(Crates.CRATE_SCREEN_HANDLER.get(), CrateScreen::new);
        HandledScreens.register(Crates.DOUBLE_CRATE_SCREEN_HANDLER.get(), DoubleCrateScreen::new);
        HandledScreens.register(Tools.BLOCK_PAINTER_SCREEN_HANDLER.get(), BlockPainterScreen::new);
        Keybindings.init();
        registerEntityRenderers();
    }

    public static void initializeClientRegistries() {
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(
            Seats.SEAT_ENTITY,
            SimpleSeatEntity.EmptyRenderer::new
        );

        BlockEntityRendererRegistry.register(
            Armoires.ARMOIRE_BLOCK_ENTITY.get(),
            ArmoireBlockEntityRenderer::new
        );

        BlockEntityRendererRegistry.register(
            DisplayCases.DISPLAY_CASE_BLOCK_ENTITY.get(),
            DisplayCaseBlockEntityRenderer::new
        );

        BlockEntityRendererRegistry.register(
            Shelves.SHELF_BLOCK_ENTITY.get(),
            ShelfBlockEntityRenderer::new
        );
    }
}
