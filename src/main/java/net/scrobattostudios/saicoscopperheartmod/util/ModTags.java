package net.scrobattostudios.saicoscopperheartmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.scrobattostudios.saicoscopperheartmod.SaicosCopperHeartMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CUSTOM_COPPER_BLOCKS = tag("custom_copper_blocks");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(SaicosCopperHeartMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(SaicosCopperHeartMod.MOD_ID, name));
        }
    }
}
