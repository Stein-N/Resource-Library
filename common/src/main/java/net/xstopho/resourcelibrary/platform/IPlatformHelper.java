package net.xstopho.resourcelibrary.platform;

public interface IPlatformHelper {

    Platforms getPlatform();

    enum Platforms {
        FORGE, FABRIC, NEOFORGE;
    }
}
