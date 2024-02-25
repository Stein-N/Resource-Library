package net.xstopho.resourcelibrary.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public final class MiningLevelUtil {

    /**
     * For now only Vanilla Mining Levels are Supported<br>
     * By default it returns the Diamond Mining Level
     */
    public static int getMiningLevel(BlockState state) {
        if (state.is(BlockTags.NEEDS_STONE_TOOL)) return 1;
        if (state.is(BlockTags.NEEDS_IRON_TOOL)) return 2;
        if (state.is(BlockTags.NEEDS_DIAMOND_TOOL)) return 3;
        return 0;
    }

    /**
     * For now only Vanilla Mining Levels are Supported
     */
    public static TagKey<Block> getBlockTag(int miningLevel) {
        if (miningLevel <= 0) throw new IllegalArgumentException("Mining Level can't be 0 or below!");

        return switch (miningLevel) {
            case 1 -> BlockTags.NEEDS_STONE_TOOL;
            case 2 -> BlockTags.NEEDS_IRON_TOOL;
            case 3 -> BlockTags.NEEDS_DIAMOND_TOOL;
            default -> throw new IllegalStateException("Unexpected value: " + miningLevel);
        };
    }

    // will be changed
    public static boolean isCorrectToolForMining(ItemStack stack, int miningLevel) {
        if (stack.getItem() instanceof DiggerItem item) {
            return item.getTier().getLevel() >= miningLevel;
        } else throw new IllegalArgumentException("The given Item isn't a Tool Item!");
    }

    public static int getToolTier(Item item) {
        if (item instanceof DiggerItem) {
            return ((DiggerItem) item).getTier().getLevel();
        } else throw new IllegalArgumentException("The given Item isn't a Tool Item!");
    }

    public static int getToolTier(ItemStack stack) {
        return getToolTier(stack.getItem());
    }
}
