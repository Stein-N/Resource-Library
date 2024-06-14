package net.xstopho.resourcelibrary.test.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.xstopho.resourcelibrary.datagen.ResourceModelProvider;

public class TestModelProv extends ResourceModelProvider {
    public TestModelProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }
}
