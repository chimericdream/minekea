package com.chimericdream.minekea.neoforge;

import com.chimericdream.minekea.MinekeaMod;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.neoforge.client.MinekeaNeoForgeClient;
import com.chimericdream.minekea.neoforge.network.NeoForgeServerNetworking;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(ModInfo.MOD_ID)
@EventBusSubscriber(modid = ModInfo.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class MinekeaNeoForge {
    public MinekeaNeoForge() {
        MinekeaMod.init();
        NeoForgeServerNetworking.init();

        NeoForge.EVENT_BUS.addListener(MinekeaNeoForgeClient::onClientTick);
    }

    @SubscribeEvent
    public static void onSetup(FMLCommonSetupEvent event) {
        MinekeaMod.initVillagerPois();
    }
}
