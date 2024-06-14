package net.xstopho.resourcelibrary.test;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.xstopho.resourcelibrary.LibConstants;
import net.xstopho.resourcelibrary.items.RecipeRemainder;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

import java.util.function.Supplier;

public class TestItems {

    public static final RegistryProvider<Item> ITEMS = RegistryProvider.get(BuiltInRegistries.ITEM, LibConstants.MOD_ID);

    public static final RegistryObject<Item> TEST_RECIPE_REMAINDER = register("recipe_remainder", () -> new TestRecipeRemainingItem(new Item.Properties()));

    public static RegistryObject<Item> register(String id, Supplier<Item> item) {
        return ITEMS.register(id, item);
    }

    public static RegistryObject<Item> register(String id) {
        return register(id, () -> new Item(new Item.Properties()));
    }

    public static void init() {}

    private static class TestRecipeRemainingItem extends RecipeRemainder {

        public TestRecipeRemainingItem(Properties properties) {
            super(properties);
        }

        @Override
        public ItemStack getRemainingItem(ItemStack itemStack) {
            return null;
        }
    }
}
