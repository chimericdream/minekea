package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.*;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.devtech.arrp.json.tags.JTag;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Objects;

public class DyedBlock extends Block implements MinekeaBlock {
    public DyedBlock(DyedBlockSettings settings) {
        super(settings);
    }

    public DyedBlockSettings getSettings() {
        return (DyedBlockSettings) this.settings;
    }

    @Override
    public Identifier getBlockID() {
        return ((MinekeaBlockSettings<?>) this.settings).getBlockId();
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        setupResources();
    }

    @Override
    public void setupResources() {
        DyedBlockSettings settings = (DyedBlockSettings) this.settings;
        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
        if (settings.getBlockTag() != null) {
            settings.getBlockTag().add(getBlockID());
        }

        MinekeaResourcePack.EN_US.blockRespect(
            this,
            String.format(settings.getNamePattern(), settings.getColorName(), settings.getIngredientName(false))
        );

        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        Identifier dye = settings.getDye();

        Identifier ingredient = settings.getMaterial("ingredient");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("###", "#D#", "###"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item(ingredient.toString()))
                    .key("D", JIngredient.ingredient().item(dye.toString())),
                JResult.stackedResult(getBlockID().toString(), 8)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_all")
                .textures(new JTextures().var("all", Texture.getBlockTextureID(getBlockID()).toString())),
            MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
            getBlockID()
        );
    }

    public static class DyedBlockSettings extends MinekeaBlockSettings<DyedBlockSettings> {
        protected String color = "";
        protected String colorName = "";
        protected Identifier dye = null;
        protected JTag blockTag = null;

        public DyedBlockSettings(DefaultSettings settings) {
            super(settings);
        }

        public String getColor() {
            return this.color;
        }

        public DyedBlockSettings color(String color) {
            this.color = color;
            return this;
        }

        public String getColorName() {
            return this.colorName;
        }

        public DyedBlockSettings colorName(String colorName) {
            this.colorName = colorName;
            return this;
        }

        public Identifier getDye() {
            return this.dye;
        }

        public DyedBlockSettings dye(Identifier dye) {
            this.dye = dye;
            return this;
        }

        public JTag getBlockTag() {
            return this.blockTag;
        }

        public DyedBlockSettings blockTag(JTag blockTag) {
            this.blockTag = blockTag;
            return this;
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Dyed %s");
        }

        @Override
        public Identifier getBlockId() {

            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("building/dyed/%s/%s", getMaterial("ingredient").getPath(), color));
            }

            return blockId;
        }
    }
}
