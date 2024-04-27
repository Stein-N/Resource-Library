package net.xstopho.testmod;

import net.fabricmc.api.ModInitializer;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;
import net.xstopho.testmod.registries.ItemGroupRegistry;
import net.xstopho.testmod.registries.ItemRegistry;

public class TestMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ItemRegistry.init();
        ItemGroupRegistry.init();

        LootTableModifier modifier = LootTableModifier.get();
        modifier.addToPool(ItemRegistry.TEST_RECIPE_REMAINDER, 1f, 1f, ChestLootTables.SPAWN_BONUS_CHEST);
        modifier.addToPool(ItemRegistry.TEST_RECIPE_REMAINDER, 1f, 1f, EntityLootTables.ZOMBIE);
    }
}
