package net.xstopho.resourcelibrary.test;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.xstopho.resourcelibrary.test.datagen.*;

public class TestDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(TestTagProv.ItemTags::new);
        pack.addProvider(TestTagProv.BlockTags::new);
        pack.addProvider(TestTagProv.FluidTags::new);
        pack.addProvider(TestTagProv.EnchantmentTags::new);
        pack.addProvider(TestTagProv.BlockEntityTypeTags::new);
        pack.addProvider(TestTagProv.EntityTypeTags::new);

        pack.addProvider(TestModelProv::new);
    }
}
