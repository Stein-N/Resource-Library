package net.xstopho.resourcelibrary.test;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.xstopho.resourcelibrary.LibConstants;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

public class TestCreativeTab {

    private static final RegistryProvider<CreativeModeTab> CREATIVE_MODE_TABS = RegistryProvider.get(BuiltInRegistries.CREATIVE_MODE_TAB, LibConstants.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RESOURCE_LIBRARY = CREATIVE_MODE_TABS.register("item_group", () -> CreativeModeTab.builder(null, -1)
            .title(Component.translatable("resourcelibrary.item_group")).icon(() -> new ItemStack(TestItems.TEST_RECIPE_REMAINDER.get()))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(TestItems.TEST_IN_HAND_ITEM.get());
                output.accept(TestItems.TEST_RECIPE_REMAINDER.get());

                output.accept(TestBlocks.TEST_FURNACE_LIKE_BLOCK.get());
            }).build());

    public static void init() {}
}
