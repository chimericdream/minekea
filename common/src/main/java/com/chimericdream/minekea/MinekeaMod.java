package com.chimericdream.minekea;

import com.chimericdream.minekea.network.ServerNetworking;
import com.chimericdream.minekea.registry.ModRegistries;
import com.chimericdream.minekea.world.poi.MinekeaPointOfInterestTypes;
import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.RegistrarManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public final class MinekeaMod {
    public static final Logger LOGGER;
    public static Supplier<RegistrarManager> MANAGER;

    static {
        LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);
    }

    public static void init() {
        MANAGER = Suppliers.memoize(() -> RegistrarManager.get(ModInfo.MOD_ID));

        LOGGER.info("Initializing server networking");
        ServerNetworking.init();

        ModRegistries.init();
    }

    public static void initVillagerPois() {
        LOGGER.info("Registering villager points of interest");
        MinekeaPointOfInterestTypes.init();
    }
}
