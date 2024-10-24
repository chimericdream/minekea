package com.chimericdream.minekea.client;

import com.chimericdream.lib.entities.SimpleSeatEntity;
import com.chimericdream.minekea.block.furniture.seats.Seats;
import com.chimericdream.minekea.client.screen.BlockPainterScreen;
import com.chimericdream.minekea.item.Tools;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class MinekeaClient {
    public static void onInitializeClient() {
        HandledScreens.register(Tools.BLOCK_PAINTER_SCREEN_HANDLER.get(), BlockPainterScreen::new);
        Keybindings.init();
    }

    public static void initializeClientRegistries() {
        registerEntityRenderers();
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(
            Seats.SEAT_ENTITY::get,
            SimpleSeatEntity.EmptyRenderer::new
        );
    }
}
