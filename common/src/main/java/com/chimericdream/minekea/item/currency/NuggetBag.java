package com.chimericdream.minekea.item.currency;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;

public class NuggetBag extends Item {
    public final Identifier ITEM_ID;

    protected final String material;
    protected final Item ingredient;

    public NuggetBag(String material, Item ingredient) {
        super(new Item.Settings().arch$tab(ItemGroups.INGREDIENTS));

        ITEM_ID = makeId(material);

        this.material = material;
        this.ingredient = ingredient;
    }

    public static Identifier makeId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("currency/%s_nugget_bag", material));
    }

//    @Override
//    public void register() {
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
//            .register(itemGroup -> itemGroup.add(this));
//    }
//
//    @Override
//    public void configureRecipes(RecipeExporter exporter) {
//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, this, 1)
//            .pattern("##")
//            .pattern("##")
//            .input('#', ingredient)
//            .criterion(FabricRecipeProvider.hasItem(ingredient),
//                FabricRecipeProvider.conditionsFromItem(ingredient))
//            .offerTo(exporter);
//
//        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ingredient, 4)
//            .input(this)
//            .criterion(FabricRecipeProvider.hasItem(this),
//                FabricRecipeProvider.conditionsFromItem(this))
//            .offerTo(exporter, Registries.ITEM.getId(ingredient).withSuffixedPath("_from_bag"));
//    }
//
//    @Override
//    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
//        translationBuilder.add(this, String.format("%s Nugget Bag", material));
//    }
}
