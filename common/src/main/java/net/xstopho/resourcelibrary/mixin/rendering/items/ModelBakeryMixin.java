package net.xstopho.resourcelibrary.mixin.rendering.items;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.xstopho.resourcelibrary.rendering.ModelRenderHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(ModelBakery.class)
public abstract class ModelBakeryMixin {
    @Shadow
    protected abstract void loadTopLevel(ModelResourceLocation modelId);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/ModelBakery;loadTopLevel(Lnet/minecraft/client/resources/model/ModelResourceLocation;)V", ordinal = 3, shift = At.Shift.AFTER))
    public void addInHandModel(BlockColors blockColors, ProfilerFiller profiler, Map<ResourceLocation, BlockModel> jsonUnbakedModels, Map<ResourceLocation, List<ModelBakery.LoadedJson>> blockStates, CallbackInfo ci) {
        HashMap<Item, ModelResourceLocation> map = ModelRenderHelper.getItemModels();

        for (ModelResourceLocation location : map.values()) {
            this.loadTopLevel(location);
        }
    }
}
