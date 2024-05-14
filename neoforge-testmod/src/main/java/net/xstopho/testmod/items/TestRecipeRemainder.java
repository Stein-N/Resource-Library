package net.xstopho.testmod.items;

import net.minecraft.world.item.ItemStack;
import net.xstopho.resourcelibrary.items.RecipeRemainder;

public class TestRecipeRemainder extends RecipeRemainder {
    public TestRecipeRemainder() {
        super(new Properties().durability(64));
    }

    @Override
    public ItemStack getRemainingItem(ItemStack stack) {
        if (stack.getDamageValue() < stack.getMaxDamage() - 1) {
            ItemStack moreDamaged = stack.copy();
            moreDamaged.setDamageValue(stack.getDamageValue() + 1);
            return moreDamaged;
        }
        return ItemStack.EMPTY;
    }
}
