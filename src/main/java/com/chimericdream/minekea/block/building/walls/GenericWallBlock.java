//package com.chimericdream.minekea.block.building.walls;
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
//import net.minecraft.block.WallBlock;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//import java.util.Objects;
//
//public class GenericWallBlock extends WallBlock implements MinekeaBlock {
//    public GenericWallBlock(WallSettings settings) {
//        super(settings);
//    }
//
//    @Override
//    public Identifier getBlockID() {
//        return ((WallSettings) this.settings).getBlockId();
//    }
//
//    @Override
//    public void register() {
//        register(false);
//    }
//
//    public void register(boolean isFlammable) {
//        Registry.register(Registries.BLOCK, getBlockID(), this);
//        Registry.register(Registries.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));
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
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));
//
//        MinekeaTags.WALLS.add(getBlockID(), settings.isWooden());
//
//        Identifier ingredient = settings.getMaterial("ingredient");
//        Identifier mainTexture = settings.getBlockTexture("main");
//
//        Identifier BASE_MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//
//        Identifier INVENTORY_MODEL_ID = Identifier.of(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_inventory");
//        Identifier POST_MODEL_ID = Identifier.of(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_post");
//        Identifier SIDE_MODEL_ID = Identifier.of(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_side");
//        Identifier SIDE_TALL_MODEL_ID = Identifier.of(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_side_tall");
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            getBlockID(),
//            JRecipe.shaped(
//                JPattern.pattern("###", "###"),
//                JKeys.keys()
//                    .key("#", JIngredient.ingredient().item(ingredient.toString())),
//                JResult.stackedResult(getBlockID().toString(), 6)
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));
//
//        JTextures textures = new JTextures().var("wall", mainTexture.toString());
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minecraft:block/wall_inventory").textures(textures),
//            INVENTORY_MODEL_ID
//        );
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minecraft:block/template_wall_post").textures(textures),
//            POST_MODEL_ID
//        );
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minecraft:block/template_wall_side").textures(textures),
//            SIDE_MODEL_ID
//        );
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minecraft:block/template_wall_side_tall").textures(textures),
//            SIDE_TALL_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(INVENTORY_MODEL_ID), ITEM_MODEL_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.multipart(new JBlockModel(POST_MODEL_ID))
//                    .when(new JWhen().add("up", "true")),
//                JState.multipart(new JBlockModel(SIDE_MODEL_ID).uvlock())
//                    .when(new JWhen().add("north", "low")),
//                JState.multipart(new JBlockModel(SIDE_MODEL_ID).y(90).uvlock())
//                    .when(new JWhen().add("east", "low")),
//                JState.multipart(new JBlockModel(SIDE_MODEL_ID).y(180).uvlock())
//                    .when(new JWhen().add("south", "low")),
//                JState.multipart(new JBlockModel(SIDE_MODEL_ID).y(270).uvlock())
//                    .when(new JWhen().add("west", "low")),
//                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).uvlock())
//                    .when(new JWhen().add("north", "tall")),
//                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).y(90).uvlock())
//                    .when(new JWhen().add("east", "tall")),
//                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).y(180).uvlock())
//                    .when(new JWhen().add("south", "tall")),
//                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).y(270).uvlock())
//                    .when(new JWhen().add("west", "tall"))
//            ),
//            getBlockID()
//        );
//    }
//
//    public static class WallSettings extends MinekeaBlockSettings<WallSettings> {
//        public WallSettings(DefaultSettings settings) {
//            super((DefaultSettings) settings.nonOpaque());
//        }
//
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "%s Wall");
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            if (blockId == null) {
//                blockId = Identifier.of(ModInfo.MOD_ID, String.format("%sbuilding/walls/%s", ModInfo.getModPrefix(modId), mainMaterial));
//            }
//
//            return blockId;
//        }
//    }
//}
