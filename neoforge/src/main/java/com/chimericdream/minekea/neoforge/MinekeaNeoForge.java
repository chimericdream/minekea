package com.chimericdream.minekea.neoforge;

import net.neoforged.fml.common.Mod;

import com.chimericdream.minekea.MinekeaMod;

@Mod(MinekeaMod.MOD_ID)
public final class MinekeaNeoForge {
    public MinekeaNeoForge() {
        // Run our common setup.
        MinekeaMod.init();
    }
}
