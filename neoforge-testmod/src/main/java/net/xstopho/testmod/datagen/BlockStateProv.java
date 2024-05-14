package net.xstopho.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resourcelibrary.datagen.ResourceBlockStateProvider;
import net.xstopho.testmod.registries.BlockRegistry;

public class BlockStateProv extends ResourceBlockStateProvider {
    public BlockStateProv(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, "testmod", exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createFurnaceLikeBlock(BlockRegistry.LAVA_SPRING.get());
    }
}
