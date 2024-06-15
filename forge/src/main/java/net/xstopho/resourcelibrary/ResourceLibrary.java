package net.xstopho.resourcelibrary;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;
import net.xstopho.resourcelibrary.test.LibraryTest;

@Mod(LibConstants.MOD_ID)
public class ResourceLibrary {

    public ResourceLibrary() {
        if (!FMLLoader.isProduction()) {
            LibraryTest.init();
        }
    }
}
