package net.xstopho.resourcelibrary.test.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.xstopho.resourcelibrary.LibConstants;
import net.xstopho.resourcelibrary.datagen.ResourceModelProvider;
import net.xstopho.resourcelibrary.test.TestBlocks;
import net.xstopho.resourcelibrary.test.TestItems;

public class TestModelProv extends ResourceModelProvider {
    public TestModelProv(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        createFurnaceLikeBlock(blockStateModelGenerator, TestBlocks.TEST_FURNACE_LIKE_BLOCK.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(TestItems.TEST_RECIPE_REMAINDER.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(TestItems.TEST_IN_HAND_ITEM.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        createInHandItemModel(itemModelGenerator, TestItems.TEST_IN_HAND_ITEM.get(), ResourceLocation.fromNamespaceAndPath(LibConstants.MOD_ID, "item/in_hand/handheld_large"));
    }
}
