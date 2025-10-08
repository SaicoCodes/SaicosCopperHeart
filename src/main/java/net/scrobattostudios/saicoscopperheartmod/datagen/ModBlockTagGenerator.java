package net.scrobattostudios.saicoscopperheartmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.scrobattostudios.saicoscopperheartmod.SaicosCopperHeartMod;
import net.scrobattostudios.saicoscopperheartmod.block.ModBlocks;
import net.scrobattostudios.saicoscopperheartmod.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SaicosCopperHeartMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
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
                        ModBlocks.EXPOSED_COPPER_GRATE.get(), ModBlocks.WEATHERED_COPPER_GRATE.get(),
                        ModBlocks.OXIDIZED_COPPER_GRATE.get(), ModBlocks.REINFORCED_COPPER_BLOCK.get(),
                        ModBlocks.REINFORCED_COPPER_PANEL_BLOCK.get(), ModBlocks.CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.EXPOSED_CHISELED_COPPER_BLOCK.get(), ModBlocks.WEATHERED_CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.OXIDIZED_CHISELED_COPPER_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.COPPER_GRATE.get(),
                        ModBlocks.EXPOSED_COPPER_GRATE.get(), ModBlocks.WEATHERED_COPPER_GRATE.get(),
                        ModBlocks.OXIDIZED_COPPER_GRATE.get(), ModBlocks.REINFORCED_COPPER_BLOCK.get(),
                        ModBlocks.CHISELED_COPPER_BLOCK.get(), ModBlocks.EXPOSED_CHISELED_COPPER_BLOCK.get(),
                        ModBlocks.WEATHERED_CHISELED_COPPER_BLOCK.get(), ModBlocks.OXIDIZED_CHISELED_COPPER_BLOCK.get());

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

        this.tag(ModTags.Blocks.SMELTABLE_BLOCKS)
                .add(Blocks.SAND, Blocks.SANDSTONE,
                        Blocks.CLAY, Blocks.STONE,
                        Blocks.COBBLESTONE,
                        Blocks.NETHERRACK, Blocks.BASALT,
                        Blocks.RED_SANDSTONE, Blocks.RED_SAND,

                        Blocks.IRON_ORE, Blocks.GOLD_ORE,
                        Blocks.COPPER_ORE, Blocks.NETHER_GOLD_ORE,
                        Blocks.NETHER_QUARTZ_ORE, Blocks.DEEPSLATE_IRON_ORE,
                        Blocks.DEEPSLATE_GOLD_ORE, Blocks.DEEPSLATE_COPPER_ORE,

                        Blocks.TERRACOTTA,
                        Blocks.WHITE_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA,
                        Blocks.LIGHT_BLUE_TERRACOTTA, Blocks.GRAY_TERRACOTTA,
                        Blocks.BLUE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA,
                        Blocks.RED_TERRACOTTA, Blocks.PINK_TERRACOTTA,
                        Blocks.BLACK_TERRACOTTA, Blocks.BROWN_TERRACOTTA,
                        Blocks.LIME_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA,
                        Blocks.GREEN_TERRACOTTA, Blocks.YELLOW_TERRACOTTA,
                        Blocks.CYAN_TERRACOTTA, Blocks.PURPLE_TERRACOTTA,

                        Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_WOOD,
                        Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_WOOD,
                        Blocks.STRIPPED_CHERRY_LOG, Blocks.STRIPPED_CHERRY_WOOD,
                        Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_WOOD,
                        Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_OAK_WOOD,
                        Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_WOOD,
                        Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_WOOD,
                        Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_WOOD,

                        Blocks.ACACIA_LOG, Blocks.ACACIA_WOOD,
                        Blocks.BIRCH_LOG, Blocks.BIRCH_WOOD,
                        Blocks.CHERRY_LOG, Blocks.CHERRY_WOOD,
                        Blocks.JUNGLE_LOG, Blocks.JUNGLE_WOOD,
                        Blocks.OAK_LOG, Blocks.OAK_WOOD,
                        Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_WOOD,
                        Blocks.SPRUCE_LOG, Blocks.SPRUCE_WOOD,
                        Blocks.MANGROVE_LOG, Blocks.MANGROVE_WOOD);

        this.tag(ModTags.Blocks.FUEL_BLOCKS)
                .add(Blocks.COAL_BLOCK)
                .addTag(BlockTags.ALL_SIGNS)
                .addTag(BlockTags.WOODEN_DOORS)
                .addTag(BlockTags.WOODEN_SLABS)
                .addTag(BlockTags.WOODEN_FENCES)
                .addTag(BlockTags.WOODEN_STAIRS)
                .addTag(BlockTags.LOGS_THAT_BURN)
                .addTag(BlockTags.WOODEN_BUTTONS)
                .addTag(BlockTags.WOODEN_TRAPDOORS)
                .addTag(BlockTags.WOODEN_PRESSURE_PLATES)
                .addTag(BlockTags.PLANKS);
    }
}
