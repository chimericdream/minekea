package com.chimericdream.minekea.registry;

import com.chimericdream.minekea.MinekeaMod;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.ModBlocks;
import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.furniture.tables.Tables;
import com.chimericdream.minekea.crop.ModCrops;
import com.chimericdream.minekea.fluid.ModFluids;
import com.chimericdream.minekea.item.ModItems;
import dev.architectury.platform.Platform;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ModRegistries {
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ModInfo.MOD_ID, (RegistryKey<Registry<Fluid>>) Registries.FLUID.getKey());
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ModInfo.MOD_ID, (RegistryKey<Registry<Block>>) Registries.BLOCK.getKey());
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ModInfo.MOD_ID, (RegistryKey<Registry<BlockEntityType<?>>>) Registries.BLOCK_ENTITY_TYPE.getKey());
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ModInfo.MOD_ID, (RegistryKey<Registry<Item>>) Registries.ITEM.getKey());
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<ItemGroup> ITEM_GROUPS = DeferredRegister.create(ModInfo.MOD_ID, (RegistryKey<Registry<ItemGroup>>) Registries.ITEM_GROUP.getKey());
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ModInfo.MOD_ID, (RegistryKey<Registry<EntityType<?>>>) Registries.ENTITY_TYPE.getKey());
    @SuppressWarnings("unchecked")
    public static final DeferredRegister<ScreenHandlerType<?>> SCREEN_HANDLERS = DeferredRegister.create(ModInfo.MOD_ID, (RegistryKey<Registry<ScreenHandlerType<?>>>) Registries.SCREEN_HANDLER.getKey());

    public static final RegistrySupplier<ItemGroup> BEAMS_ITEM_GROUP = ITEM_GROUPS.register(
        "item_group.minekea.blocks.building.beams",
        () -> CreativeTabRegistry.create(
            Text.translatable("item_group.minekea.blocks.building.beams"),
            () -> new ItemStack(Beams.BLOCKS.getFirst().get())
        )
    );

    public static final RegistrySupplier<ItemGroup> COMPRESSED_BLOCK_ITEM_GROUP = ITEM_GROUPS.register(
        "item_group.minekea.blocks.building.compressed",
        () -> CreativeTabRegistry.create(
            Text.translatable("item_group.minekea.blocks.building.compressed"),
            () -> new ItemStack(CompressedBlocks.BLOCKS.getFirst().get())
        )
    );

    public static final RegistrySupplier<ItemGroup> COVERS_ITEM_GROUP = ITEM_GROUPS.register(
        "item_group.minekea.blocks.building.covers",
        () -> CreativeTabRegistry.create(
            Text.translatable("item_group.minekea.blocks.building.covers"),
            () -> new ItemStack(Covers.BLOCKS.getFirst().get())
        )
    );

    public static RegistrySupplier<ItemGroup> DYED_BLOCK_ITEM_GROUP = ITEM_GROUPS.register(
        "item_group.minekea.blocks.building.dyed",
        () -> CreativeTabRegistry.create(
            Text.translatable("item_group.minekea.blocks.building.dyed"),
            () -> new ItemStack(DyedBlocks.BLOCKS.getFirst().get())
        )
    );

    public static final RegistrySupplier<ItemGroup> FURNITURE_ITEM_GROUP = ITEM_GROUPS.register(
        "item_group.minekea.blocks.furniture",
        () -> CreativeTabRegistry.create(
            Text.translatable("item_group.minekea.blocks.furniture"),
            () -> new ItemStack(Tables.BLOCKS.getFirst().get())
        )
    );

    public static void init() {
        ModFluids.init();
        ModBlocks.init();
        ModCrops.init();
        ModItems.init();

        ColoredBlocksRegistry.init();

        MinekeaMod.LOGGER.debug("Registering fluids");
        FLUIDS.register();

        MinekeaMod.LOGGER.debug("Registering blocks");
        BLOCKS.register();

        MinekeaMod.LOGGER.debug("Registering block entities");
        BLOCK_ENTITY_TYPES.register();

        MinekeaMod.LOGGER.debug("Registering items");
        ITEMS.register();

        MinekeaMod.LOGGER.debug("Registering item groups");
        ITEM_GROUPS.register();

        MinekeaMod.LOGGER.debug("Registering entities");
        ENTITY_TYPES.register();

        MinekeaMod.LOGGER.debug("Registering screen handlers");
        SCREEN_HANDLERS.register();
    }

    public static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(final String name, final Supplier<T> supplier) {
        return registerBlockEntity(Identifier.of(ModInfo.MOD_ID, name), supplier);
    }

    public static <T extends BlockEntityType<?>> RegistrySupplier<T> registerBlockEntity(final Identifier id, final Supplier<T> supplier) {
        Registrar<BlockEntityType<?>> registrar = BLOCK_ENTITY_TYPES.getRegistrar();

        return registrar.register(id, supplier);
    }

    public static RegistrySupplier<Block> registerWithItem(String name, Supplier<Block> supplier) {
        return registerWithItem(name, supplier, new Item.Settings());
    }

    public static RegistrySupplier<Block> registerWithItem(Identifier id, Supplier<Block> supplier) {
        return registerWithItem(id, supplier, new Item.Settings());
    }

    public static RegistrySupplier<Block> registerWithItem(String name, Supplier<Block> supplier, Item.Settings itemSettings) {
        return registerWithItem(Identifier.of(ModInfo.MOD_ID, name), supplier, itemSettings);
    }

    public static RegistrySupplier<Block> registerWithItem(Identifier id, Supplier<Block> supplier, Item.Settings itemSettings) {
        RegistrySupplier<Block> block = registerBlock(id, supplier);

        registerItem(id, () -> new BlockItem(block.get(), itemSettings));

        return block;
    }

    public static <T extends Block> RegistrySupplier<T> registerBlock(Identifier path, Supplier<T> block) {
        Registrar<Block> registrar = BLOCKS.getRegistrar();

        if (Platform.isNeoForge()) {
            return BLOCKS.register(path.getPath(), block);
        }

        return registrar.register(path, block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(Identifier path, Supplier<T> itemSupplier) {
        Registrar<Item> registrar = ITEMS.getRegistrar();

        if (Platform.isNeoForge()) {
            return ITEMS.register(path.getPath(), itemSupplier);
        }

        return registrar.register(path, itemSupplier);
    }

    public static <T extends EntityType<?>> RegistrySupplier<T> registerEntityType(Identifier path, Supplier<T> entitySupplier) {
        Registrar<EntityType<?>> registrar = ENTITY_TYPES.getRegistrar();

        if (Platform.isNeoForge()) {
            return ENTITY_TYPES.register(path.getPath(), entitySupplier);
        }

        return registrar.register(path, entitySupplier);
    }

    public static <T extends ScreenHandlerType<?>> RegistrySupplier<T> registerScreenHandler(Identifier path, Supplier<T> screenHandlerSupplier) {
        Registrar<ScreenHandlerType<?>> registrar = SCREEN_HANDLERS.getRegistrar();

        if (Platform.isNeoForge()) {
            return SCREEN_HANDLERS.register(path.getPath(), screenHandlerSupplier);
        }

        return registrar.register(path, screenHandlerSupplier);
    }
}
