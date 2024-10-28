package com.chimericdream.minekea.fabric.client;

import com.chimericdream.minekea.block.building.storage.StorageBlocks;
import com.chimericdream.minekea.block.decorations.candles.VotiveCandles;
import com.chimericdream.minekea.block.decorations.lighting.Lanterns;
import com.chimericdream.minekea.block.furniture.armoires.Armoires;
import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import com.chimericdream.minekea.client.MinekeaClient;
import com.chimericdream.minekea.fabric.client.render.block.GlassJarBlockEntityRenderer;
import com.chimericdream.minekea.fabric.client.render.item.GlassJarItemRenderer;
import com.chimericdream.minekea.network.CyclePainterColorPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

import static com.chimericdream.minekea.block.containers.ContainerBlocks.GLASS_JAR;
import static com.chimericdream.minekea.block.containers.ContainerBlocks.GLASS_JAR_BLOCK_ENTITY;
import static com.chimericdream.minekea.client.Keybindings.CYCLE_PAINTER_COLOR;
import static com.chimericdream.minekea.crop.ModCrops.WARPED_WART_PLANT_BLOCK;
import static com.chimericdream.minekea.item.containers.ContainerItems.GLASS_JAR_ITEM;

public final class MinekeaFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MinekeaClient.initializeClientRegistries();
        MinekeaClient.onInitializeClient();

        initializeBlockRenderLayers();
        initializeKeybindings();
    }

    private void initializeBlockRenderLayers() {
        Armoires.BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderLayer.getCutout()));
        DisplayCases.BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderLayer.getCutout()));
        StorageBlocks.DYE_BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderLayer.getTranslucent()));
        StorageBlocks.BAGGED_BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderLayer.getCutout()));
        Lanterns.BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderLayer.getCutout()));
        VotiveCandles.BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block.get(), RenderLayer.getTranslucent()));

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), GLASS_JAR.get());

        BlockEntityRendererFactories.register(GLASS_JAR_BLOCK_ENTITY.get(), GlassJarBlockEntityRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register(GLASS_JAR_ITEM.get(), new GlassJarItemRenderer());

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

    private void initializeKeybindings() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (CYCLE_PAINTER_COLOR.wasPressed()) {
                ClientPlayNetworking.send(new CyclePainterColorPayload(true));
            }
        });
    }
}
