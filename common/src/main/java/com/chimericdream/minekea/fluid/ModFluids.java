package com.chimericdream.minekea.fluid;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.HoneyCauldronBlock;
import com.chimericdream.minekea.block.containers.MilkCauldronBlock;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import static com.chimericdream.minekea.registry.ModRegistries.BLOCKS;
import static com.chimericdream.minekea.registry.ModRegistries.FLUIDS;
import static com.chimericdream.minekea.registry.ModRegistries.ITEMS;

public class ModFluids implements ModThingGroup {
    public static final RegistrySupplier<FlowableFluid> HONEY_FLUID = FLUIDS.register(Identifier.of(ModInfo.MOD_ID, "fluids/honey"), HoneyFluid::new);
    public static final RegistrySupplier<FlowableFluid> FLOWING_HONEY = FLUIDS.register(Identifier.of(ModInfo.MOD_ID, "fluids/honey/flowing"), HoneyFluid.Flowing::new);
    public static final RegistrySupplier<FluidBlock> HONEY_SOURCE_BLOCK = BLOCKS.register(Identifier.of(ModInfo.MOD_ID, "fluids/honey/source"), HoneyFluid.Block::new);
    public static final RegistrySupplier<Item> HONEY_BUCKET = ITEMS.register(Identifier.of(ModInfo.MOD_ID, "containers/honey_bucket"), HoneyFluid.Bucket::new);
    public static final RegistrySupplier<Block> HONEY_CAULDRON = BLOCKS.register(Identifier.of(ModInfo.MOD_ID, "containers/cauldrons/honey"), HoneyCauldronBlock::new);

    public static final RegistrySupplier<FlowableFluid> MILK_FLUID = FLUIDS.register(Identifier.of(ModInfo.MOD_ID, "fluids/milk"), MilkFluid::new);
    public static final RegistrySupplier<FlowableFluid> FLOWING_MILK = FLUIDS.register(Identifier.of(ModInfo.MOD_ID, "fluids/milk/flowing"), MilkFluid.Flowing::new);
    public static final RegistrySupplier<FluidBlock> MILK_SOURCE_BLOCK = BLOCKS.register(Identifier.of(ModInfo.MOD_ID, "fluids/milk/source"), MilkFluid.Block::new);
    public static final RegistrySupplier<Block> MILK_CAULDRON = BLOCKS.register(Identifier.of(ModInfo.MOD_ID, "containers/cauldrons/milk"), MilkCauldronBlock::new);

    public static void init() {
    }
}
