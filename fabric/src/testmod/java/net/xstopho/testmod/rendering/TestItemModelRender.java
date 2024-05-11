package net.xstopho.testmod.rendering;


import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.xstopho.resourcelibrary.rendering.ModelRenderHelper;

public class TestItemModelRender {

    public static void init() {
        ModelRenderHelper.registerItemModel(Items.STICK, new ResourceLocation("diamond_pickaxe"));
    }
}
