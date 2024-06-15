package net.xstopho.resourcelibrary.rendering.item;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.xstopho.resourcelibrary.LibConstants;
import net.xstopho.resourcelibrary.platform.IPlatformHelper;
import net.xstopho.resourcelibrary.service.CoreServices;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ItemModelRenderHelper {

    private static final HashMap<Item, ModelResourceLocation> ITEM_MODELS = new LinkedHashMap<>();

    public static void registerItemModel(Item item, ResourceLocation itemTexturePath) {
        if (CoreServices.PLATFORM == IPlatformHelper.Platforms.FORGE) {
            LibConstants.LOG.error("Registering Custom Item Model isn't working in Forge");
        }
        ITEM_MODELS.putIfAbsent(item, location(itemTexturePath));
    }

    public static HashMap<Item, ModelResourceLocation> getItemModels() {
        return ITEM_MODELS;
    }

    private static ModelResourceLocation location(ResourceLocation itemTexturePath) {
        return new ModelResourceLocation(itemTexturePath, "inventory");
    }
}
