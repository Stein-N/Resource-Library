package net.xstopho.resourcelibrary.platform;

import net.xstopho.resourcelibrary.ResourceLibraryConstants;

import java.util.ServiceLoader;

public class Services {

    public static final Enum<?> PLATFORM = Services.load(IPlatformHelper.class).getPlatform();

    public static <T> T load(Class<T> clazz) {
        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        ResourceLibraryConstants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}