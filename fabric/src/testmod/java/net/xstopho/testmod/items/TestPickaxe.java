package net.xstopho.testmod.items;

import net.minecraft.world.item.Tier;
import net.xstopho.resourcelibrary.items.ExcavatorItem;

public class TestPickaxe extends ExcavatorItem.Pickaxe {
    public TestPickaxe(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public int getRadius() {
        return 1;
    }
}
