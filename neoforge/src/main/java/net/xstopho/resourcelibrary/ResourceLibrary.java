package net.xstopho.resourcelibrary;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.xstopho.resourcelibrary.modifier.LootTableModifier;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

@Mod(LibConstants.MOD_ID)
public class ResourceLibrary {

    final RegistryProvider<Item> ITEMS = RegistryProvider.get(Registries.ITEM, LibConstants.MOD_ID);
    final RegistryObject<Item> TEST = ITEMS.register("test_item", () -> new Item(new Item.Properties()));

    public ResourceLibrary(IEventBus eventBus) {
        LootTableModifier modifier = LootTableModifier.get();

        modifier.addToPool(TEST, 1f, 1f, ChestLootTables.SPAWN_BONUS_CHEST);
    }
}