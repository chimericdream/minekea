package com.chimericdream.minekea.neoforge.client;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.client.Keybindings;
import com.chimericdream.minekea.client.MinekeaClient;
import com.chimericdream.minekea.item.containers.ContainerItems;
import com.chimericdream.minekea.neoforge.client.render.block.GlassJarBlockEntityRenderer;
import com.chimericdream.minekea.neoforge.client.render.item.GlassJarItemRenderer;
import com.chimericdream.minekea.network.CyclePainterColorPayload;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(modid = ModInfo.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class MinekeaNeoForgeClient {
    @SubscribeEvent
    public static void onClientSetup(RegisterEvent event) {
        MinekeaClient.initializeClientRegistries();
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        MinekeaClient.onInitializeClient();
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(
            ContainerBlocks.GLASS_JAR_BLOCK_ENTITY.get(),
            GlassJarBlockEntityRenderer::new
        );
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(
            new GlassJarItemRenderer.GlassJarItemRendererExtension(),
            ContainerItems.GLASS_JAR_ITEM.get()
        );
    }

    public static void onClientTick(ClientTickEvent.Post event) {
        if (Keybindings.CYCLE_PAINTER_COLOR.wasPressed()) {
            PacketDistributor.sendToServer(new CyclePainterColorPayload(true));
        }
    }
}
