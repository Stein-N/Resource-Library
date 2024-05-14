package net.xstopho.testmod.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;
import net.xstopho.testmod.blocks.SpringBlock;

import java.util.function.Supplier;

public class BlockRegistry {

    public static final RegistryProvider<Block> BLOCKS = RegistryProvider.get(Registries.BLOCK, "testmod");

    public static final RegistryObject<Block> LAVA_SPRING = register("lava_spring", () -> new SpringBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    private static RegistryObject<Block> register(String id, Supplier<Block> supplier) {
        RegistryObject<Block> toReturn = BLOCKS.register(id, supplier);
        ItemRegistry.ITEMS.register(id, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    public static void init() {}
}
