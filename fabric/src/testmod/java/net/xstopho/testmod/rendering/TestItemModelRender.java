package net.xstopho.testmod.rendering;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.xstopho.resourcelibrary.rendering.item.ItemModelRenderHelper;

public class TestItemModelRender {

    public static void init() {
        ItemModelRenderHelper.registerItemModel(Items.STICK, new ResourceLocation("diamond_pickaxe"));
    }
}
