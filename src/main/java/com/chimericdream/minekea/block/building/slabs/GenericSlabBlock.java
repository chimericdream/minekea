//package com.chimericdream.minekea.block.building.slabs;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.resource.LootTable;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.resource.MinekeaTags;
//import com.chimericdream.minekea.resource.Model;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.util.MinekeaBlock;
//import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
//import net.fabricmc.fabric.api.registry.FuelRegistry;
//import net.minecraft.block.SlabBlock;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//import java.util.Objects;
//
//public class GenericSlabBlock extends SlabBlock implements MinekeaBlock {
//    public GenericSlabBlock(SlabSettings settings) {
//        super(settings);
//    }
//
//    @Override
//    public Identifier getBlockID() {
//        return ((SlabSettings) this.settings).getBlockId();
//    }
//
//    @Override
//    public void register() {
//        register(false);
//    }
//
//    public void register(boolean isFlammable) {
//        Registry.register(Registries.BLOCK, getBlockID(), this);
//        Registry.register(Registries.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
//
//        if (isFlammable) {
//            FuelRegistry.INSTANCE.add(this, 300);
//            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
//        }
//
//        setupResources();
//    }
//
//    @Override
//    public void setupResources() {
//        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        MinekeaTags.SLABS.add(getBlockID(), settings.isWooden());
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));
//
//        Identifier ingredient = settings.getMaterial("ingredient");
//        Identifier endTexture = settings.getBlockTexture("end");
//        Identifier sideTexture = settings.getBlockTexture("main");
//
//        Identifier SLAB_MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier TOP_SLAB_MODEL_ID = Identifier.of(ModInfo.MOD_ID, SLAB_MODEL_ID.getPath() + "_top");
//        Identifier DOUBLE_MODEL_ID = Model.getItemModelID(ingredient);
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            getBlockID(),
//            JRecipe.shaped(
//                JPattern.pattern("###"),
//                JKeys.keys().key("#", JIngredient.ingredient().item(ingredient.toString())),
//                JResult.stackedResult(getBlockID().toString(), 6)
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(getBlockID()), LootTable.slabLootTable(getBlockID()));
//
//        JTextures textures = new JTextures()
//            .var("bottom", endTexture.toString())
//            .var("top", endTexture.toString())
//            .var("side", sideTexture.toString());
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minecraft:block/slab").textures(textures),
//            SLAB_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minecraft:block/slab_top").textures(textures),
//            TOP_SLAB_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(SLAB_MODEL_ID), ITEM_MODEL_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("type=bottom", new JBlockModel(SLAB_MODEL_ID))
//                    .put("type=double", new JBlockModel(DOUBLE_MODEL_ID))
//                    .put("type=top", new JBlockModel(TOP_SLAB_MODEL_ID))
//            ),
//            getBlockID()
//        );
//    }
//
//    public static class SlabSettings extends MinekeaBlockSettings<SlabSettings> {
//        public SlabSettings(DefaultSettings settings) {
//            super((DefaultSettings) settings.nonOpaque());
//        }
//
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "%s Slab");
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            if (blockId == null) {
//                blockId = Identifier.of(ModInfo.MOD_ID, String.format("%sbuilding/slabs/%s", ModInfo.getModPrefix(modId), mainMaterial));
//            }
//
//            return blockId;
//        }
//    }
//}
