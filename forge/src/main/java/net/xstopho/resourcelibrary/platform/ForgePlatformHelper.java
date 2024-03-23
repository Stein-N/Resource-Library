package net.xstopho.resourcelibrary.platform;

public class ForgePlatformHelper implements IPlatformHelper {
    @Override
    public Enum<?> getPlatform() {
        return Platforms.FORGE;
    }
}
