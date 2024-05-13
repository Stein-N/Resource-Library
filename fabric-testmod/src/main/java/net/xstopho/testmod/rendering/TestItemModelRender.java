package net.xstopho.testmod.rendering;


import net.minecraft.resources.ResourceLocation;
import net.xstopho.resourcelibrary.rendering.item.ItemModelRenderHelper;
import net.xstopho.testmod.registries.ItemRegistry;

public class TestItemModelRender {

    public static void init() {
        ItemModelRenderHelper.registerItemModel(ItemRegistry.SCYTHE_NETHERITE.get(), new ResourceLocation("testmod", "in_hand/scythe_netherite"));
    }
}
