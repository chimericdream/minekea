package com.chimericdream.minekea.fabric.data.blockstate.suppliers;

import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.BlockStateVariantMap;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.Optional;

/*
 * @TODO: abstract this out to chimericlib where I can add more custom model registration methods
 */
public class CustomCropSupplier {
    private static final Model CUSTOM_CROP = new CustomCropModel();

    public static void registerCrop(BlockStateModelGenerator generator, Block crop, Property<Integer> ageProperty, int... ageTextureIndices) {
        if (ageProperty.getValues().size() != ageTextureIndices.length) {
            throw new IllegalArgumentException();
        } else {
            Int2ObjectMap<Identifier> int2ObjectMap = new Int2ObjectOpenHashMap<>();
            BlockStateVariantMap blockStateVariantMap = BlockStateVariantMap.create(ageProperty).register((integer) -> {
                int i = ageTextureIndices[integer];
                Identifier identifier = int2ObjectMap.computeIfAbsent(i, (j) -> {
                    return generator.createSubModel(crop, "_stage" + i, CUSTOM_CROP, TextureMap::crop);
                });
                return BlockStateVariant.create().put(VariantSettings.MODEL, identifier);
            });
            generator.registerItemModel(crop.asItem());
            generator.blockStateCollector.accept(VariantsBlockStateSupplier.create(crop).coordinate(blockStateVariantMap));
        }
    }

    /*
     * @TODO: abstract this out to chimericlib and make it more generic; i.e. support the rest of the render types in NeoForge
     *   @see https://docs.neoforged.net/docs/resources/client/models/#render-types
     */
    private static class CustomCropModel extends Model {
        public CustomCropModel() {
            super(Optional.of(Identifier.ofVanilla("block/crop")), Optional.empty(), TextureKey.CROP);
        }

        @Override
        public JsonObject createJson(Identifier id, Map<TextureKey, Identifier> textures) {
            JsonObject jsonObject = super.createJson(id, textures);
            jsonObject.addProperty("render_type", "minecraft:cutout");

            return jsonObject;
        }
    }
}
