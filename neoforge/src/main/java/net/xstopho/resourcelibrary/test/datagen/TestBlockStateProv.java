package net.xstopho.resourcelibrary.test.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resourcelibrary.LibConstants;
import net.xstopho.resourcelibrary.datagen.ResourceBlockStateProvider;

public class TestBlockStateProv extends ResourceBlockStateProvider {

    public TestBlockStateProv(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LibConstants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
