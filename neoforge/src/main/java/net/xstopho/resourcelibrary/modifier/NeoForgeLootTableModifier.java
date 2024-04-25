package net.xstopho.resourcelibrary.modifier;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import net.xstopho.resourcelibrary.ResourceLibraryConstants;
import net.xstopho.resourcelibrary.registration.RegistryObject;

import java.util.LinkedList;
import java.util.List;

@EventBusSubscriber(modid = ResourceLibraryConstants.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class NeoForgeLootTableModifier implements LootTableModifier {

    private static final List<Modifier> lootModifier = new LinkedList<>();
    private static final List<RangedModifier> rangedLootModifier = new LinkedList<>();
    private record Modifier(RegistryObject<Item> item, float amount, float chance, ResourceKey<LootTable> lootTable) {}

    private record RangedModifier(RegistryObject<Item> item, float minAmount, float maxAmount, float chance, ResourceKey<LootTable> lootTable) {}

    @SafeVarargs
    @Override
    public final void addToPool(RegistryObject<Item> item, float amount, float chance, ResourceKey<LootTable>... lootTables) {
        for (ResourceKey<LootTable> lootTable : lootTables) {
            lootModifier.add(new Modifier(item, amount, chance, lootTable));
        }
    }

    @SafeVarargs
    @Override
    public final void addToPool(RegistryObject<Item> item, float minAmount, float maxAmount, float chance, ResourceKey<LootTable>... lootTables) {
        for (ResourceKey<LootTable> lootTable : lootTables) {
            rangedLootModifier.add(new RangedModifier(item, minAmount, maxAmount, chance, lootTable));
        }
    }

    @SubscribeEvent
    public static void init(LootTableLoadEvent event) {
        for (Modifier modifier : lootModifier) {
            if (event.getName().equals(modifier.lootTable().location())) {
                event.getTable().addPool(LootTableModifier.createLootPool(modifier.item().get(), modifier.chance(), modifier.amount()).build());
            }
        }
        for (RangedModifier modifier : rangedLootModifier) {
            if (event.getName().equals(modifier.lootTable().location())) {
                event.getTable().addPool(LootTableModifier.createLootPool(modifier.item().get(), modifier.chance(), modifier.minAmount(), modifier.maxAmount()).build());
            }
        }
    }
}
