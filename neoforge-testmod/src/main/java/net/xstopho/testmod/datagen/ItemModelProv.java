package net.xstopho.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resourcelibrary.datagen.ResourceItemModelProvider;
import net.xstopho.testmod.registries.ItemRegistry;

public class ItemModelProv extends ResourceItemModelProvider {
    public ItemModelProv(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "testmod", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        createInHandItem(ItemRegistry.SCYTHE_NETHERITE.get(), new ResourceLocation("testmod", "item/in_hand/handheld_large"));
    }
}
