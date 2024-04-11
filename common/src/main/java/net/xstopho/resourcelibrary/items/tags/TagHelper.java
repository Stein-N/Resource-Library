package net.xstopho.resourcelibrary.items.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.xstopho.resourcelibrary.platform.CoreServices;

public class TagHelper {

    TagKey<Item> createPlatformTags(String commonId, String forgeId) {
        TagKey<Item> key = switch (CoreServices.PLATFORM) {
            case FABRIC, NEOFORGE -> getCommonTag(commonId);
            case FORGE -> getForgeTag(forgeId);
        };
        if (key == null) throw new IllegalStateException("Can't create a Tag for a non mod-loader environment or the current Mod loader isn't supported yet!");

        return key;
    }

    TagKey<Item> getCommonTag(String id) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("c", id));
    }

    TagKey<Item> getForgeTag(String id) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("forge", id));
    }
}
