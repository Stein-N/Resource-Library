package net.xstopho.testmod;

import net.fabricmc.api.ModInitializer;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;
import net.xstopho.resourcelibrary.modifier.loot_tables.ChestLootTables;
import net.xstopho.resourcelibrary.modifier.loot_tables.EntityLootTables;
import net.xstopho.testmod.registries.BlockRegistry;
import net.xstopho.testmod.registries.ItemGroupRegistry;
import net.xstopho.testmod.registries.ItemRegistry;
import net.xstopho.testmod.rendering.TestItemModelRender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {

    private static Logger LOGGER = LoggerFactory.getLogger("Testmod");

    @Override
    public void onInitialize() {
        BlockRegistry.init();
        ItemRegistry.init();
        ItemGroupRegistry.init();

        LootTableModifier modifier = LootTableModifier.get();
        modifier.addToPool(ItemRegistry.TEST_RECIPE_REMAINDER, 1f, 1f, ChestLootTables.SPAWN_BONUS_CHEST);
        modifier.addToPool(ItemRegistry.TEST_RECIPE_REMAINDER, 1f, 1f, EntityLootTables.ZOMBIE);

        TestItemModelRender.init();
    }
}
