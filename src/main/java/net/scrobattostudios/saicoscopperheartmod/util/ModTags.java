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

        public static final TagKey<Block> NEEDS_REINFORCED_COPPER_TOOL = tag("needs_reinforced_copper_tool");

        public static final TagKey<Block> SCYTHE_HARVESTABLE = tag("scythe_harvestable");

        public static final TagKey<Block> SMELTABLE_BLOCKS = tag("smeltable_blocks");
        public static final TagKey<Block> FUEL_BLOCKS = tag("fuel_blocks");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(SaicosCopperHeartMod.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> FUEL_ITEMS = tag("fuel_items");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(SaicosCopperHeartMod.MOD_ID, name));
        }
    }
}
