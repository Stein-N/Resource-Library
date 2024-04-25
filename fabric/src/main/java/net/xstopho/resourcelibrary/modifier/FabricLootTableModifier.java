package net.xstopho.resourcelibrary.modifier;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.xstopho.resourcelibrary.registration.RegistryObject;

public class FabricLootTableModifier implements LootTableModifier {

    //TODO: switch to ResourceKeys
    @Override
    public void addToPool(RegistryObject<Item> item, float amount, float chance, ResourceLocation... lootTables) {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            for (ResourceLocation loc : lootTables) {
                if (key.equals(loc)) tableBuilder.withPool(LootTableModifier.createLootPool(item.get(), chance, 1));
            }
        });
    }

    @Override
    public void addToPool(RegistryObject<Item> item, float minAmount, float maxAmount, float chance, ResourceLocation... lootTables) {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
            for (ResourceLocation loc : lootTables) {
                if (key.equals(loc)) tableBuilder.withPool(LootTableModifier.createLootPool(item.get(), chance, minAmount, maxAmount));
            }
        });
    }
}
