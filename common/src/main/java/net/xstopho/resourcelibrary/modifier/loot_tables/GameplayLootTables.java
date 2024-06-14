package net.xstopho.resourcelibrary.modifier.loot_tables;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public class GameplayLootTables {

    public static final ResourceKey<LootTable> FISHING_FISH = getLootTableId("fishing/fish");
    public static final ResourceKey<LootTable> FISHING_JUNK = getLootTableId("fishing/junk");
    public static final ResourceKey<LootTable> FISHING_TREASURE = getLootTableId("fishing/treasure");

    public static final ResourceKey<LootTable> ARMORER_GIFT = getLootTableId("hero_of_the_village/armorer_gift");
    public static final ResourceKey<LootTable> BUTCHER_GIFT = getLootTableId("hero_of_the_village/butcher_gift");
    public static final ResourceKey<LootTable> CARTOGRAPHER_GIFT = getLootTableId("hero_of_the_village/cartographer_gift");
    public static final ResourceKey<LootTable> CLERIC_GIFT = getLootTableId("hero_of_the_village/cleric_gift");
    public static final ResourceKey<LootTable> FARMER_GIFT = getLootTableId("hero_of_the_village/farmer_gift");
    public static final ResourceKey<LootTable> FISHERMAN_GIFT = getLootTableId("hero_of_the_village/fisherman_gift");
    public static final ResourceKey<LootTable> FLETCHER_GIFT = getLootTableId("hero_of_the_village/fletcher_gift");
    public static final ResourceKey<LootTable> LEATHERWORKER_GIFT = getLootTableId("hero_of_the_village/leatherworker_gift");
    public static final ResourceKey<LootTable> LIBRARIAN_GIFT = getLootTableId("hero_of_the_village/librarian_gift");
    public static final ResourceKey<LootTable> MASON_GIFT = getLootTableId("hero_of_the_village/mason_gift");
    public static final ResourceKey<LootTable> SHEPARD_GIFT = getLootTableId("hero_of_the_village/shepard_gift");
    public static final ResourceKey<LootTable> TOOLSMITH_GIFT = getLootTableId("hero_of_the_village/toolsmith_gift");
    public static final ResourceKey<LootTable> WEAPONSMITH_GIFT = getLootTableId("hero_of_the_village/weaponsmith_gift");

    public static final ResourceKey<LootTable> CAT_MORNING_GIFT = getLootTableId("cat_morning_gift");
    public static final ResourceKey<LootTable> FISHING = getLootTableId("fishing");
    public static final ResourceKey<LootTable> PANDA_SNEEZE = getLootTableId("panda_sneeze");
    public static final ResourceKey<LootTable> PIGLIN_BARTERING = getLootTableId("piglin_bartering");
    public static final ResourceKey<LootTable> SNIFFER_DIGING = getLootTableId("sniffer_digging");

    private static ResourceKey<LootTable> getLootTableId(String id) {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace("gameplay/" + id));
    }
}
