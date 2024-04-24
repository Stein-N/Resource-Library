package net.xstopho.testmod.items;

import net.minecraft.world.item.Tier;

public class TestShovel extends ExcavatorItem.Shovel {
    public TestShovel(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public int getRadius() {
        return 1;
    }
}
