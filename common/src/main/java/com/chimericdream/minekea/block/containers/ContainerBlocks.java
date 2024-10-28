package com.chimericdream.minekea.block.containers;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.barrels.Barrels;
import com.chimericdream.minekea.block.containers.crates.Crates;
import com.chimericdream.minekea.entity.block.containers.GlassJarBlockEntity;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.registry.ModRegistries.registerBlock;
import static com.chimericdream.minekea.registry.ModRegistries.registerBlockEntity;

public class ContainerBlocks implements ModThingGroup {
    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    public static final RegistrySupplier<Block> GLASS_JAR = registerBlock(GlassJarBlock.BLOCK_ID, GlassJarBlock::new);

    public static final Identifier GLASS_JAR_BLOCK_ENTITY_ID = Identifier.of(ModInfo.MOD_ID, "entities/blocks/containers/glass_jar");
    public static RegistrySupplier<BlockEntityType<GlassJarBlockEntity>> GLASS_JAR_BLOCK_ENTITY;

    static {
        BLOCKS.addAll(Barrels.BLOCKS);
        BLOCKS.addAll(Crates.BLOCKS);
        BLOCKS.add(GLASS_JAR);

        GLASS_JAR_BLOCK_ENTITY = registerBlockEntity(
            GLASS_JAR_BLOCK_ENTITY_ID,
            () -> BlockEntityType.Builder.create(GlassJarBlockEntity::new, GLASS_JAR.get()).build(null)
        );
    }
}
