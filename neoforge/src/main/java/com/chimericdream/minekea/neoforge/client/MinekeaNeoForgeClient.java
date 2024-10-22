package com.chimericdream.minekea.neoforge.client;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.client.MinekeaClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
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
}
