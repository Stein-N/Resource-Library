package net.xstopho.resourcelibrary.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public abstract class ResourceItemModelProvider extends ItemModelProvider {
    public ResourceItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    public ItemModelBuilder createInHandItem(Item item, ResourceLocation parent) {
        return this.getBuilder(modifyItemKey(item).toString()).parent(new ModelFile.UncheckedModelFile(parent))
                        .texture("layer0", modifyItemKey(item));
    }

    private ResourceLocation modifyItemKey(Item item) {
        String[] parts = getItemKey(item).toString().split(":");
        return new ResourceLocation(parts[0], "item/in_hand/" + parts[1]);
    }

    private ResourceLocation getItemKey(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }
}
