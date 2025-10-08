package net.scrobattostudios.saicoscopperheartmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.scrobattostudios.saicoscopperheartmod.SaicosCopperHeartMod;
import net.scrobattostudios.saicoscopperheartmod.item.ModItems;
import net.scrobattostudios.saicoscopperheartmod.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, SaicosCopperHeartMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.REINFORCED_COPPER_BOOTS.get());

        this.tag(ItemTags.ARROWS)
                .add(ModItems.REINFORCED_COPPER_ARROW.get());

        this.tag(ModTags.Items.FUEL_ITEMS)
                .add(Items.COAL,
                        Items.BOW,
                        Items.COAL,
                        Items.STICK,
                        Items.LADDER,
                        Items.BAMBOO,
                        Items.SHIELD,
                        Items.CROSSBOW,
                        Items.CHARCOAL,
                        Items.WOODEN_AXE,
                        Items.WOODEN_HOE,
                        Items.DRIED_KELP,
                        Items.FISHING_ROD,
                        Items.LAVA_BUCKET,
                        Items.WOODEN_SWORD,
                        Items.WOODEN_SHOVEL,
                        Items.WOODEN_PICKAXE,
                        Items.DRIED_KELP_BLOCK,
                        Items.BLAZE_ROD);
    }
}
