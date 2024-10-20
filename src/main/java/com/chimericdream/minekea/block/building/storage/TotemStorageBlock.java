package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.ModelUtils;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class TotemStorageBlock extends GenericStorageBlock {
    public TotemStorageBlock() {
        super(new BlockConfig().settings(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK).sounds(BlockSoundGroup.METAL)).item(Items.TOTEM_OF_UNDYING).material("totem_of_undying"));
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.PICKAXE_MINEABLE)
            .setReplace(false)
            .add(this);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Compressed Totem of Undying");
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.END, Identifier.of(ModInfo.MOD_ID, String.format("block/%s_end", BLOCK_ID.getPath())))
            .put(TextureKey.SIDE, Identifier.of(ModInfo.MOD_ID, String.format("block/%s_side", BLOCK_ID.getPath())));

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", COMPRESSED_COLUMN_BLOCK_MODEL, unused -> textures);

        ModelUtils.registerBlockWithAxis(blockStateModelGenerator, AXIS, this, subModelId);
    }
}
