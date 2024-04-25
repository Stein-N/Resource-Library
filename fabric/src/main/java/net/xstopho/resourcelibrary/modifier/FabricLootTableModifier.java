package net.xstopho.resourcelibrary.modifier;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootTable;
import net.xstopho.resourcelibrary.registration.RegistryObject;

public class FabricLootTableModifier implements LootTableModifier {

    @SafeVarargs
    @Override
    public final void addToPool(RegistryObject<Item> item, float amount, float chance, ResourceKey<LootTable>... lootTables) {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            for (ResourceKey<LootTable> lootKey : lootTables) {
                if (key.equals(lootKey)) tableBuilder.withPool(LootTableModifier.createLootPool(item.get(), chance, 1));
            }
        });
    }

    @SafeVarargs
    @Override
    public final void addToPool(RegistryObject<Item> item, float minAmount, float maxAmount, float chance, ResourceKey<LootTable>... lootTables) {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            for (ResourceKey<LootTable> lootKey : lootTables) {
                if (key.equals(lootKey)) tableBuilder.withPool(LootTableModifier.createLootPool(item.get(), chance, minAmount, maxAmount));
            }
        });
    }
}
