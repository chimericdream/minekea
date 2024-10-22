package com.chimericdream.minekea.client;

import com.chimericdream.lib.entities.SimpleSeatEntity;
import com.chimericdream.minekea.block.furniture.seats.Seats;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class MinekeaClient {
    public static void onInitializeClient() {
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
