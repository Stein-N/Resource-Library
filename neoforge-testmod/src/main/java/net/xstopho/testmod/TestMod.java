package net.xstopho.testmod;

import net.neoforged.fml.common.Mod;
import net.xstopho.testmod.registries.BlockRegistry;
import net.xstopho.testmod.registries.ItemGroupRegistry;
import net.xstopho.testmod.registries.ItemRegistry;

@Mod("testmod")
public class TestMod {

    public TestMod() {
        BlockRegistry.init();
        ItemRegistry.init();
        ItemGroupRegistry.init();
    }
}
