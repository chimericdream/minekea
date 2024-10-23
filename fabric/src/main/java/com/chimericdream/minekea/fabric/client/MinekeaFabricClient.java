package com.chimericdream.minekea.fabric.client;

import com.chimericdream.minekea.block.building.storage.StorageBlocks;
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

        StorageBlocks.DYE_BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderLayer.getTranslucent()));
        StorageBlocks.BAGGED_BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderLayer.getCutout()));

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getTranslucent(),
            StorageBlocks.SUGAR_CANE_BLOCK.get()
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getCutout(),
            StorageBlocks.SET_OF_EGGS_BLOCK.get(),
            WARPED_WART_PLANT_BLOCK.get()
        );
    }
}
