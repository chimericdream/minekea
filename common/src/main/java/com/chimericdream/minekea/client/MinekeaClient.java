package com.chimericdream.minekea.client;

import com.chimericdream.lib.entities.SimpleSeatEntity;
import com.chimericdream.minekea.block.furniture.armoires.Armoires;
import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import com.chimericdream.minekea.block.furniture.seats.Seats;
import com.chimericdream.minekea.client.render.block.ArmoireBlockEntityRenderer;
import com.chimericdream.minekea.client.render.block.DisplayCaseBlockEntityRenderer;
import com.chimericdream.minekea.client.screen.BlockPainterScreen;
import com.chimericdream.minekea.item.Tools;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class MinekeaClient {
    public static void onInitializeClient() {
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
    }
}
