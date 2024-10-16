package com.chimericdream.minekea.neoforge;

import com.chimericdream.minekea.ModInfo;
import net.neoforged.fml.common.Mod;

import com.chimericdream.minekea.MinekeaMod;

@Mod(ModInfo.MOD_ID)
public final class MinekeaNeoForge {
    public MinekeaNeoForge() {
        // Run our common setup.
        MinekeaMod.init();
    }
}
