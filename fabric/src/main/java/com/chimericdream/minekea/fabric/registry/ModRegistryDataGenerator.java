package com.chimericdream.minekea.fabric.registry;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import static com.chimericdream.minekea.fluid.ModFluids.HONEY_BUCKET;
import static com.chimericdream.minekea.fluid.ModFluids.HONEY_CAULDRON;
import static com.chimericdream.minekea.fluid.ModFluids.HONEY_SOURCE_BLOCK;
import static com.chimericdream.minekea.fluid.ModFluids.MILK_CAULDRON;
import static com.chimericdream.minekea.fluid.ModFluids.MILK_SOURCE_BLOCK;

public class ModRegistryDataGenerator {
    public static void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add("item_group.minekea.blocks.building.beams", "Minekea: Beams");
        translationBuilder.add("item_group.minekea.blocks.building.compressed", "Minekea: Compressed Blocks");
        translationBuilder.add("item_group.minekea.blocks.building.covers", "Minekea: Covers");
        translationBuilder.add("item_group.minekea.blocks.building.dyed", "Minekea: Dyed Blocks");
        translationBuilder.add("item_group.minekea.blocks.furniture", "Minekea: Furniture");

        translationBuilder.add(HONEY_BUCKET.get(), "Honey Bucket");
        translationBuilder.add(HONEY_SOURCE_BLOCK.get(), "Honey");
        translationBuilder.add(HONEY_CAULDRON.get(), "Honey Cauldron");
        translationBuilder.add(MILK_CAULDRON.get(), "Milk Cauldron");
        translationBuilder.add(MILK_SOURCE_BLOCK.get(), "Milk");
    }
}
