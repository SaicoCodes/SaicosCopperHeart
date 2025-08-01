package net.scrobattostudios.saicoscopperheartmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.scrobattostudios.saicoscopperheartmod.SaicosCopperHeartMod;
import net.scrobattostudios.saicoscopperheartmod.block.ModBlocks;
import net.scrobattostudios.saicoscopperheartmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SaicosCopperHeartMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.CUSTOM_COPPER_BLOCKS)
                .add(ModBlocks.COPPER_GRATE.get(),
                        ModBlocks.EXPOSED_COPPER_GRATE.get(),
                        ModBlocks.WEATHERED_COPPER_GRATE.get(),
                        ModBlocks.OXIDIZED_COPPER_GRATE.get(),

                        ModBlocks.REINFORCED_COPPER_BLOCK.get(),
                        ModBlocks.REINFORCED_COPPER_PANEL_BLOCK.get(),

                        ModBlocks.CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.EXPOSED_CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.WEATHERED_CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.OXIDIZED_CHISELED_COPPER_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COPPER_GRATE.get(),
                        ModBlocks.EXPOSED_COPPER_GRATE.get(),
                        ModBlocks.WEATHERED_COPPER_GRATE.get(),
                        ModBlocks.OXIDIZED_COPPER_GRATE.get(),
                        ModBlocks.REINFORCED_COPPER_BLOCK.get(),
                        ModBlocks.REINFORCED_COPPER_PANEL_BLOCK.get(),
                        ModBlocks.CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.EXPOSED_CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.WEATHERED_CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.OXIDIZED_CHISELED_COPPER_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.COPPER_GRATE.get(),
                        ModBlocks.EXPOSED_COPPER_GRATE.get(),
                        ModBlocks.WEATHERED_COPPER_GRATE.get(),
                        ModBlocks.OXIDIZED_COPPER_GRATE.get(),
                        ModBlocks.REINFORCED_COPPER_BLOCK.get(),
                        ModBlocks.CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.EXPOSED_CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.WEATHERED_CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.OXIDIZED_CHISELED_COPPER_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.REINFORCED_COPPER_BLOCK.get(),
                        ModBlocks.REINFORCED_COPPER_PANEL_DOOR.get(),
                        ModBlocks.REINFORCED_COPPER_PANEL_TRAPDOOR.get(),
                        ModBlocks.REINFORCED_COPPER_PANEL_BLOCK.get());

        this.tag(ModTags.Blocks.SCYTHE_HARVESTABLE)
                .add(
                        Blocks.WHEAT,
                        Blocks.CARROTS,
                        Blocks.POTATOES,
                        Blocks.BEETROOTS,
                        Blocks.GRASS,
                        Blocks.TALL_GRASS,
                        Blocks.FERN,
                        Blocks.LARGE_FERN,
                        Blocks.SUGAR_CANE,
                        Blocks.BAMBOO,
                        Blocks.PUMPKIN_STEM,
                        Blocks.MELON_STEM,
                        Blocks.NETHER_WART
                );

    }
}
