package net.xstopho.resourcelibrary.test;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.xstopho.resourcelibrary.LibConstants;
import net.xstopho.resourcelibrary.test.datagen.TestBlockStateProv;
import net.xstopho.resourcelibrary.test.datagen.TestItemModelProv;
import net.xstopho.resourcelibrary.test.datagen.TestTagProvider;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = LibConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestDatagen {

    @SubscribeEvent
    public static void data(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new TestBlockStateProv(output, fileHelper));
        generator.addProvider(event.includeServer(), new TestItemModelProv(output, fileHelper));

        TestTagProvider.BlockTags blockTags = generator.addProvider(event.includeServer(), new TestTagProvider.BlockTags(output, provider, fileHelper));
        generator.addProvider(event.includeServer(), new TestTagProvider.ItemTags(output, provider, blockTags.contentsGetter(), fileHelper));
        generator.addProvider(event.includeServer(), new TestTagProvider.EnchantmentTags(output, provider));
        generator.addProvider(event.includeServer(), new TestTagProvider.FluidTags(output, provider, fileHelper));
    }
}
