package net.xstopho.resourcelibrary.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public abstract class ResourceModelProvider extends FabricModelProvider {

    public ResourceModelProvider(FabricDataOutput output) {
        super(output);
    }

    /**
     * Helper method that fills the gap for furnace like blocks.
     * @param generator {@link BlockModelGenerators} passed down inside the Model Provider
     * @param block Your furnace like Block
     */
    public void createFurnaceLikeBlock(BlockModelGenerators generator, Block block) {
        TextureMapping map = new TextureMapping();
        Optional<ResourceLocation> parent = Optional.of(new ResourceLocation("block/orientable"));

        map.put(TextureSlot.FRONT, getBlockKey(block));
        map.put(TextureSlot.SIDE, modifyBlockKey(block, "_side"));
        map.put(TextureSlot.TOP, modifyBlockKey(block, "_top"));

        ResourceLocation model = new ModelTemplate(parent, Optional.empty(), TextureSlot.FRONT, TextureSlot.SIDE, TextureSlot.TOP)
                .create(block, map, generator.modelOutput);
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, model));
    }

    /**
     * Helper method to generate alternate Item Models when hold in Main/Off-hand. <br>
     * Generated json Files get saved in assets/mod_id/models/item/in_hand
     * @param generator {@link ItemModelGenerators} passed down inside Model Provider
     * @param item base item that gets alternative models
     * @param parent Your custom Model Template
     */
    public void createInHandItemModel(ItemModelGenerators generator, Item item, ResourceLocation parent) {
        new ModelTemplate(Optional.of(parent), Optional.empty(), TextureSlot.LAYER0)
                .create(modifyItemKey(item), TextureMapping.layer0(modifyItemKey(item)), generator.output);
    }

    private ResourceLocation modifyBlockKey(Block block, String texturePosition) {
        String[] parts = getBlockKey(block).toString().split(":");
        return new ResourceLocation(parts[0], "block/" + parts[1] + texturePosition);
    }

    private ResourceLocation modifyItemKey(Item item) {
        String[] parts = getItemKey(item).toString().split(":");
        return new ResourceLocation(parts[0], "item/in_hand/" + parts[1]);
    }

    private ResourceLocation getBlockKey(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private ResourceLocation getItemKey(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
