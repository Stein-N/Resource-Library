package net.xstopho.resourcelibrary.platform;

public interface IPlatformHelper {

    Enum<?> getPlatform();

    enum Platforms {
        FORGE, FABRIC, NEOFORGE;
    }
}
