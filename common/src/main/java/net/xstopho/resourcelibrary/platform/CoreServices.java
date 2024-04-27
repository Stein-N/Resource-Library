package net.xstopho.resourcelibrary.platform;

import net.xstopho.resourcelibrary.LibConstants;

import java.util.ServiceLoader;

public class CoreServices {

    public static final IPlatformHelper.Platforms PLATFORM = load(IPlatformHelper.class).getPlatform();

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        LibConstants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
