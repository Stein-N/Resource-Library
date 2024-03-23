package net.xstopho.resourcelibrary.platform;

public class FabricPlatformHelper implements IPlatformHelper {
    @Override
    public Enum<?> getPlatform() {
        return Platforms.FABRIC;
    }
}
