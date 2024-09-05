//package com.chimericdream.minekea.block.furniture.shelves;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.item.ItemGroups;
//import com.chimericdream.minekea.resource.LootTable;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.resource.MinekeaTags;
//import com.chimericdream.minekea.resource.Model;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
//import net.fabricmc.fabric.api.registry.FuelRegistry;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.ShapeContext;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.shape.VoxelShape;
//import net.minecraft.world.BlockView;
//
//import java.util.Objects;
//
//public class GenericFloatingShelf extends GenericShelf {
//    public GenericFloatingShelf(FloatingShelfSettings settings) {
//        super(settings);
//    }
//
//    @Override
//    public Identifier getBlockID() {
//        return ((FloatingShelfSettings) this.settings).getBlockId();
//    }
//
//    @Override
//    public void register() {
//        register(false);
//    }
//
//    public void register(boolean isFlammable) {
//        Registry.register(Registries.BLOCK, getBlockID(), this);
//        Registry.register(Registries.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroups.FURNITURE)));
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
//    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        Direction wall = state.get(WALL_SIDE);
//
//        switch (wall) {
//            case EAST:
//                return Block.createCuboidShape(0.0, 7.0, 0.0, 7.0, 9.0, 16.0);
//
//            case SOUTH:
//                return Block.createCuboidShape(0.0, 7.0, 0.0, 16.0, 9.0, 7.0);
//
//            case WEST:
//                return Block.createCuboidShape(9.0, 7.0, 0.0, 16.0, 9.0, 16.0);
//
//            case NORTH:
//            default:
//                return Block.createCuboidShape(0.0, 7.0, 9.0, 16.0, 9.0, 16.0);
//        }
//    }
//
//    @Override
//    public void setupResources() {
//        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        MinekeaTags.FLOATING_SHELVES.add(getBlockID(), settings.isWooden());
//        MinekeaTags.SHELVES.add(getBlockID(), settings.isWooden());
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));
//
//        Identifier slab = settings.getMaterial("slab");
//
//        Identifier plankTexture = settings.getBlockTexture("planks");
//
//        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            getBlockID(),
//            JRecipe.shaped(
//                JPattern.pattern("XXX", "# #", "XXX"),
//                JKeys.keys()
//                    .key("X", JIngredient.ingredient().item(slab.toString()))
//                    .key("#", JIngredient.ingredient().item("minecraft:iron_ingot")),
//                JResult.stackedResult(getBlockID().toString(), 3)
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel
//                .model(ModInfo.MOD_ID + ":block/furniture/shelves/floating")
//                .textures(new JTextures().var("planks", plankTexture.toString())),
//            MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("wall_side=north", new JBlockModel(MODEL_ID))
//                    .put("wall_side=east", new JBlockModel(MODEL_ID).y(90))
//                    .put("wall_side=south", new JBlockModel(MODEL_ID).y(180))
//                    .put("wall_side=west", new JBlockModel(MODEL_ID).y(270))
//            ),
//            getBlockID()
//        );
//    }
//
//    public static class FloatingShelfSettings extends SupportedShelfSettings {
//        public FloatingShelfSettings(DefaultSettings settings) {
//            super((DefaultSettings) settings.nonOpaque());
//        }
//
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "%s Floating Shelf");
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            if (blockId == null) {
//                blockId = Identifier.of(ModInfo.MOD_ID, String.format("%sfurniture/shelves/floating/%s", ModInfo.getModPrefix(modId), mainMaterial));
//            }
//
//            return blockId;
//        }
//    }
//}
