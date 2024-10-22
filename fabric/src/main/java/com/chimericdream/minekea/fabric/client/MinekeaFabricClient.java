package com.chimericdream.minekea.fabric.client;

import com.chimericdream.minekea.client.MinekeaClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import static com.chimericdream.minekea.crop.ModCrops.WARPED_WART_PLANT_BLOCK;

public final class MinekeaFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MinekeaClient.initializeClientRegistries();
        MinekeaClient.onInitializeClient();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), WARPED_WART_PLANT_BLOCK.get());
    }
}
