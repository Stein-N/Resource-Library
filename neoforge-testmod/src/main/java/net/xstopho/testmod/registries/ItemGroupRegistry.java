package net.xstopho.testmod.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

public class ItemGroupRegistry {

    private static final RegistryProvider<CreativeModeTab> CREATIVE_TABS = RegistryProvider.get(Registries.CREATIVE_MODE_TAB, "testmod");

    public static final RegistryObject<CreativeModeTab> TESTMOD = CREATIVE_TABS.register("item_group",
            () -> CreativeModeTab.builder(null, -1).title(Component.translatable("item_group.resource_cracker"))
                    .icon(() -> new ItemStack(ItemRegistry.SCYTHE_NETHERITE.get())).displayItems((itemDisplayParameters, output) -> {

                        output.accept(ItemRegistry.TEST_RECIPE_REMAINDER.get());
                        output.accept(ItemRegistry.SCYTHE_NETHERITE.get());
                        output.accept(BlockRegistry.LAVA_SPRING.get());

                    }).build());

    public static void init() {}
}