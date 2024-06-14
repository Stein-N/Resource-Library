package net.xstopho.resourcelibrary.test;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.xstopho.resourcelibrary.LibConstants;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import net.xstopho.resourcelibrary.registration.RegistryProvider;

import java.util.function.Supplier;

public class TestBlocks {

    public static final RegistryProvider<Block> BLOCKS = RegistryProvider.get(BuiltInRegistries.BLOCK, LibConstants.MOD_ID);

    public static final RegistryObject<Block> TEST_BLOCK = register("test_block");

    public static RegistryObject<Block> register(String id, Supplier<Block> block) {
        RegistryObject<Block> toReturn = BLOCKS.register(id, block);
        TestItems.register(id, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    public static RegistryObject<Block> register(String id) {
        return register(id, () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    }

    public static void init() {}
}
