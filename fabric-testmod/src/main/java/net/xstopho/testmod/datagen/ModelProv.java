package net.xstopho.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.xstopho.resourcelibrary.datagen.ResourceModelProvider;
import net.xstopho.testmod.registries.BlockRegistry;
import net.xstopho.testmod.registries.ItemRegistry;

public class ModelProv extends ResourceModelProvider {
    public ModelProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators gen) {
        createFurnaceLikeBlock(gen, BlockRegistry.LAVA_SPRING.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators gen) {
        ResourceLocation parentLocation = new ResourceLocation("testmod", "item/in_hand/handheld_large");

        gen.generateFlatItem(ItemRegistry.SCYTHE_NETHERITE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        createInHandItemModel(gen, ItemRegistry.SCYTHE_NETHERITE.get(), parentLocation);
    }
}
