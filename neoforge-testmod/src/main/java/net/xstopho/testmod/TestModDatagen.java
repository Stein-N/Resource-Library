package net.xstopho.testmod;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.xstopho.testmod.datagen.BlockStateProv;
import net.xstopho.testmod.datagen.ItemModelProv;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = "testmod", bus = EventBusSubscriber.Bus.MOD)
public class TestModDatagen {

    @SubscribeEvent
    public static void data(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new BlockStateProv(output, fileHelper));
        generator.addProvider(event.includeServer(), new ItemModelProv(output, fileHelper));
    }
}
