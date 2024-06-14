package net.xstopho.resourcelibrary;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.xstopho.resourcelibrary.test.LibraryTest;

public class ResourceLibrary implements ModInitializer {
    
    @Override
    public void onInitialize() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            LibraryTest.init();
        }
    }
}
