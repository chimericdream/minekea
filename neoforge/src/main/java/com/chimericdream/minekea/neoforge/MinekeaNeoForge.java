package com.chimericdream.minekea.neoforge;

import com.chimericdream.minekea.MinekeaMod;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.neoforge.client.MinekeaNeoForgeClient;
import com.chimericdream.minekea.neoforge.network.NeoForgeServerNetworking;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;

@Mod(ModInfo.MOD_ID)
public final class MinekeaNeoForge {
    public MinekeaNeoForge() {
        MinekeaMod.init();
        NeoForgeServerNetworking.init();

        NeoForge.EVENT_BUS.addListener(MinekeaNeoForgeClient::onClientTick);
    }
}
