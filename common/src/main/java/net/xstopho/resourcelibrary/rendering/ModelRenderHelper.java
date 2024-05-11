package net.xstopho.resourcelibrary.rendering;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ModelRenderHelper {

    private static final HashMap<Item, ModelResourceLocation> ITEM_MODELS = new LinkedHashMap<>();

    public static void registerItemModel(Item item, ResourceLocation itemTexturePath) {
        ITEM_MODELS.putIfAbsent(item, location(itemTexturePath));
    }

    public static HashMap<Item, ModelResourceLocation> getItemModels() {
        return ITEM_MODELS;
    }

    private static ModelResourceLocation location(ResourceLocation itemTexturePath) {
        return new ModelResourceLocation(itemTexturePath, "inventory");
    }
}
