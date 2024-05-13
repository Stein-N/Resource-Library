package net.xstopho.testmod.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;
import net.xstopho.testmod.items.*;

public class ItemRegistry {

    static final RegistryProvider<Item> ITEMS = RegistryProvider.get(Registries.ITEM, "testmod");

    public static final RegistryObject<Item> TEST_RECIPE_REMAINDER = ITEMS.register("test_recipe_remainder", TestRecipeRemainder::new);

    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation("testmod", id), item);
    }

    public static void init() {}
}
