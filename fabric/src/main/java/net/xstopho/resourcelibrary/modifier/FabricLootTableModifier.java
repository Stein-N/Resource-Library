package net.xstopho.resourcelibrary.modifier;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootTable;
import net.xstopho.resourcelibrary.registration.RegistryObject;

public class FabricLootTableModifier implements LootTableModifier {

    @Override
    public final void addToPool(RegistryObject<Item> item, float amount, float chance, ResourceKey<LootTable>... lootTables) {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            for (ResourceKey<LootTable> table : lootTables) {
                if (key.equals(table)) tableBuilder.withPool(LootTableModifier.createLootPool(item.get(), chance, 1));
            }
        });
    }

    @Override
    public final void addToPool(RegistryObject<Item> item, float minAmount, float maxAmount, float chance, ResourceKey<LootTable>... lootTables) {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            for (ResourceKey<LootTable> table : lootTables) {
                if (key.equals(table)) tableBuilder.withPool(LootTableModifier.createLootPool(item.get(), chance, minAmount, maxAmount));
            }
        });
    }
}
