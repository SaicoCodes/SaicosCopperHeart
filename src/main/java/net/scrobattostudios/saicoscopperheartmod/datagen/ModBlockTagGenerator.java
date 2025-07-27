package net.scrobattostudios.saicoscopperheartmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
                        ModBlocks.REINFORCED_COPPER_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COPPER_GRATE.get(),
                        ModBlocks.EXPOSED_COPPER_GRATE.get(),
                        ModBlocks.WEATHERED_COPPER_GRATE.get(),
                        ModBlocks.OXIDIZED_COPPER_GRATE.get(),
                        ModBlocks.REINFORCED_COPPER_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.COPPER_GRATE.get(),
                        ModBlocks.EXPOSED_COPPER_GRATE.get(),
                        ModBlocks.WEATHERED_COPPER_GRATE.get(),
                        ModBlocks.OXIDIZED_COPPER_GRATE.get(),
                        ModBlocks.REINFORCED_COPPER_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.REINFORCED_COPPER_BLOCK.get());
    }
}
