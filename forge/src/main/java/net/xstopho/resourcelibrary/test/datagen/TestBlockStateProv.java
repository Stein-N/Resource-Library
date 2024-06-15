package net.xstopho.resourcelibrary.test.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xstopho.resourcelibrary.LibConstants;
import net.xstopho.resourcelibrary.datagen.ResourceBlockStateProvider;
import net.xstopho.resourcelibrary.test.TestBlocks;

public class TestBlockStateProv extends ResourceBlockStateProvider {

    public TestBlockStateProv(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LibConstants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createFurnaceLikeBlock(TestBlocks.TEST_FURNACE_LIKE_BLOCK.get());
    }
}
