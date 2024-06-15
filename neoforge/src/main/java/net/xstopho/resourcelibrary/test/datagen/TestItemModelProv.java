package net.xstopho.resourcelibrary.test.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resourcelibrary.LibConstants;
import net.xstopho.resourcelibrary.datagen.ResourceItemModelProvider;
import net.xstopho.resourcelibrary.test.TestItems;

public class TestItemModelProv extends ResourceItemModelProvider {
    public TestItemModelProv(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LibConstants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(TestItems.TEST_RECIPE_REMAINDER.get());
        simpleItem(TestItems.TEST_IN_HAND_ITEM.get());
        createInHandItem(TestItems.TEST_IN_HAND_ITEM.get(), ResourceLocation.fromNamespaceAndPath(LibConstants.MOD_ID, "item/in_hand/handheld_large"));
    }
}
