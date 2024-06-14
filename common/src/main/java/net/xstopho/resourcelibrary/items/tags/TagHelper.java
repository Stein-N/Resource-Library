package net.xstopho.resourcelibrary.items.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.xstopho.resourcelibrary.service.CoreServices;

public class TagHelper {

    public static TagKey<Item> createPlatformTag(String id) {
        return switch (CoreServices.PLATFORM) {
            case FABRIC, NEOFORGE -> createTag("c", id);
            case FORGE -> createTag("forge", id);
            case NO_LOADER -> throw new IllegalStateException("No Mod Loader defined or you are in an non Mod Environment!");
        };
    }

    static TagKey<Item> createTag(String prefix, String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(prefix, id));
    }
}
