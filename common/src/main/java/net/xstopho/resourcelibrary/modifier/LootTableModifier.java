package net.xstopho.resourcelibrary.modifier;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.xstopho.resourcelibrary.service.CoreServices;
import net.xstopho.resourcelibrary.registration.RegistryObject;

public interface LootTableModifier {

    static LootTableModifier get() {
        return CoreServices.load(LootTableModifier.class);
    }

    void addToPool(RegistryObject<Item> item, float amount, float chance, ResourceKey<LootTable>... lootTables);

    void addToPool(RegistryObject<Item> item, float minAmount, float maxAmount, float chance, ResourceKey<LootTable>... lootTables);

    static LootPool.Builder createLootPool(ItemLike item, float chance, float amount) {
        return LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1f))
                .when(LootItemRandomChanceCondition.randomChance(value(chance)))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(amount)));
    }

    static LootPool.Builder createLootPool(ItemLike item, float chance, float minAmount, float maxAmount) {
        return LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1f))
                .when(LootItemRandomChanceCondition.randomChance(value(chance)))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minAmount, maxAmount)));
    }

    static float value(float chance) {
        return Math.min(1.0f, Math.max(0.0f, chance));
    }
}
