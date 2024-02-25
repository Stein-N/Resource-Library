package net.xstopho.resourcelibrary.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class RecipeRemainder extends Item implements IRecipeRemainder {

    public RecipeRemainder(Properties properties) {
        super(properties);
    }

    public abstract ItemStack getRemainingItem(ItemStack itemStack);

    @Override
    public boolean hasCraftingRemainingItem() {
        return true;
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack itemStack) {
        return getRemainingItem(itemStack);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return getRemainingItem(itemStack);
    }
}
