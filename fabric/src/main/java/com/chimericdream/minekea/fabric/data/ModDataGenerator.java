package com.chimericdream.minekea.fabric.data;

import com.chimericdream.minekea.fabric.block.ModBlockDataGenerators;
import com.chimericdream.minekea.fabric.item.ModItemDataGenerators;
import com.chimericdream.minekea.fabric.registry.ModRegistryDataGenerator;
import com.chimericdream.minekea.fabric.util.BlockDataGeneratorGroup;
import com.chimericdream.minekea.fabric.util.ItemDataGeneratorGroup;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(MinekeaModelGenerator::new);
        pack.addProvider(MinekeaBlockLootTables::new);
        pack.addProvider(MinekeaRecipeGenerator::new);
        pack.addProvider(MinekeaEnglishLangProvider::new);
        pack.addProvider(MinekeaBlockTagGenerator::new);
        pack.addProvider(MinekeaItemTagGenerator::new);

        if (JarAccess.canLoad()) {
            new TextureGenerator(pack);

            ModBlockDataGenerators.BLOCK_GROUPS.forEach(BlockDataGeneratorGroup::generateTextures);
            ModItemDataGenerators.ITEM_GROUPS.forEach(ItemDataGeneratorGroup::generateTextures);
        }
    }

    private static class MinekeaRecipeGenerator extends FabricRecipeProvider {
        public MinekeaRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        public void generate(RecipeExporter exporter) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureRecipes(exporter);
            }

            for (ItemDataGeneratorGroup group : ModItemDataGenerators.ITEM_GROUPS) {
                group.configureRecipes(exporter);
            }

//            MinekeaMod.ITEMS.configureRecipes(exporter);
        }
    }

    private static class MinekeaBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
        public MinekeaBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureBlockTags(arg, this::getOrCreateTagBuilder);
            }

//            MinekeaMod.ITEMS.configureBlockTags(arg, this::getOrCreateTagBuilder);
        }
    }

    private static class MinekeaItemTagGenerator extends FabricTagProvider.ItemTagProvider {
        public MinekeaItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureItemTags(arg, this::getOrCreateTagBuilder);
            }

            for (ItemDataGeneratorGroup group : ModItemDataGenerators.ITEM_GROUPS) {
                group.configureItemTags(arg, this::getOrCreateTagBuilder);
            }

//            MinekeaMod.ITEMS.configureItemTags(arg, this::getOrCreateTagBuilder);
        }
    }

    private static class MinekeaEnglishLangProvider extends FabricLanguageProvider {
        protected MinekeaEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureTranslations(registryLookup, translationBuilder);
            }

            for (ItemDataGeneratorGroup group : ModItemDataGenerators.ITEM_GROUPS) {
                group.configureTranslations(registryLookup, translationBuilder);
            }

            ModRegistryDataGenerator.configureTranslations(registryLookup, translationBuilder);

//            MinekeaMod.ITEMS.configureTranslations(registryLookup, translationBuilder);
        }
    }

    private static class MinekeaBlockLootTables extends FabricBlockLootTableProvider {
        protected MinekeaBlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generate() {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureBlockLootTables(this.registryLookup, this);
            }

//            MinekeaMod.ITEMS.configureBlockLootTables(this.registryLookup, this);
        }
    }

    private static class MinekeaModelGenerator extends FabricModelProvider {
        private MinekeaModelGenerator(FabricDataOutput generator) {
            super(generator);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureBlockStateModels(blockStateModelGenerator);
            }

//            MinekeaMod.ITEMS.configureBlockStateModels(blockStateModelGenerator);
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureItemModels(itemModelGenerator);
            }

            for (ItemDataGeneratorGroup group : ModItemDataGenerators.ITEM_GROUPS) {
                group.configureItemModels(itemModelGenerator);
            }

//            MinekeaMod.ITEMS.configureItemModels(itemModelGenerator);
        }
    }
}
