package net.xstopho.testmod;

import net.fabricmc.api.ModInitializer;
import net.xstopho.testmod.registries.ItemGroupRegistry;
import net.xstopho.testmod.registries.ItemRegistry;

public class TestMod implements ModInitializer {
    @Override
    public void onInitialize() {
        ItemRegistry.init();
        ItemGroupRegistry.init();
    }
}
