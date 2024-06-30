package net.xstopho.resourcelibrary;

import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLLoader;
import net.xstopho.resourcelibrary.test.LibraryTest;

@Mod(LibConstants.MOD_ID)
public class ResourceLibrary {

    public ResourceLibrary() {
        if (!FMLLoader.isProduction()) {
            LibraryTest.init();
        }
    }
}