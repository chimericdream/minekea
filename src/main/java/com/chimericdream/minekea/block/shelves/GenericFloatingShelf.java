package com.chimericdream.minekea.block.shelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Texture;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Map;

public class GenericFloatingShelf extends GenericShelf {
    public GenericFloatingShelf(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials);
    }

    public GenericFloatingShelf(String woodType, String modId, Map<String, Identifier> materials) {
        super(woodType, modId, materials, new Identifier(modId, String.format("shelves/%s%s_floating_shelf", ModInfo.getModPrefix(modId), woodType)));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction wall = state.get(WALL_SIDE);

        switch (wall) {
            case EAST:
                return Block.createCuboidShape(0.0, 7.0, 0.0, 7.0, 9.0, 16.0);

            case SOUTH:
                return Block.createCuboidShape(0.0, 7.0, 0.0, 16.0, 9.0, 7.0);

            case WEST:
                return Block.createCuboidShape(9.0, 7.0, 0.0, 16.0, 9.0, 16.0);

            case NORTH:
            default:
                return Block.createCuboidShape(0.0, 7.0, 9.0, 16.0, 9.0, 16.0);
        }
    }

    @Override
    public void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"slab"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);

        setupResources();
    }

    @Override
    public void setupResources() {
        Identifier planks = materials.get("planks");
        Identifier slab = materials.get("slab");

        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/shelves/%s%s_floating_shelf", ModInfo.getModPrefix(modId), woodType));
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/shelves/%s%s_floating_shelf", ModInfo.getModPrefix(modId), woodType));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("XXX", "# #", "XXX"),
                JKeys.keys()
                    .key("X", JIngredient.ingredient().item(slab.toString()))
                    .key("#", JIngredient.ingredient().item("minecraft:iron_ingot")),
                JResult.stackedResult(BLOCK_ID.toString(), 3)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel
                .model(ModInfo.MOD_ID + ":block/floating_shelf")
                .textures(new JTextures().var("planks", Texture.getBlockTextureID(planks).toString())),
            MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("wall_side=north", new JBlockModel(MODEL_ID))
                    .put("wall_side=east", new JBlockModel(MODEL_ID).y(90))
                    .put("wall_side=south", new JBlockModel(MODEL_ID).y(180))
                    .put("wall_side=west", new JBlockModel(MODEL_ID).y(270))
            ),
            BLOCK_ID
        );
    }
}