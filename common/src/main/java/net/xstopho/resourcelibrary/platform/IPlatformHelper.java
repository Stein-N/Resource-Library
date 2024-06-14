package net.xstopho.resourcelibrary.platform;

public interface IPlatformHelper {

    default Platforms getPlatform() {
        return Platforms.NO_LOADER;
    }

    enum Platforms {
        FORGE, FABRIC, NEOFORGE, NO_LOADER
    }
}
