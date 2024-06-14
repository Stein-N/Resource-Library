package net.xstopho.resourcelibrary.test;

import net.minecraft.resources.ResourceLocation;
import net.xstopho.resourcelibrary.rendering.item.ItemModelRenderHelper;

public class LibraryTest {

    public static void init() {
        TestBlocks.init();
        TestItems.init();
        initRendering();
    }

    private static void initRendering() {
        ItemModelRenderHelper.registerItemModel(TestItems.TEST_RECIPE_REMAINDER.get(), ResourceLocation.withDefaultNamespace("diamond"));
    }
}
