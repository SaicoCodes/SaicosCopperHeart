package net.scrobattostudios.saicoscopperheartmod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.scrobattostudios.saicoscopperheartmod.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.REINFORCED_COPPER_BLOCK.get());
        this.dropSelf(ModBlocks.COPPER_GRATE.get());
        this.dropSelf(ModBlocks.EXPOSED_COPPER_GRATE.get());
        this.dropSelf(ModBlocks.WEATHERED_COPPER_GRATE.get());
        this.dropSelf(ModBlocks.OXIDIZED_COPPER_GRATE.get());
        this.dropSelf(ModBlocks.CHISELED_COPPER_BLOCK.get());
        this.dropSelf(ModBlocks.EXPOSED_CHISELED_COPPER_BLOCK.get());
        this.dropSelf(ModBlocks.WEATHERED_CHISELED_COPPER_BLOCK.get());
        this.dropSelf(ModBlocks.OXIDIZED_CHISELED_COPPER_BLOCK.get());
        this.dropSelf(ModBlocks.REINFORCED_COPPER_PANEL_BLOCK.get());
        this.dropSelf(ModBlocks.REINFORCED_COPPER_CRATE.get());

        this.dropSelf(ModBlocks.REINFORCED_COPPER_PANEL_TRAPDOOR.get());
        this.add(ModBlocks.REINFORCED_COPPER_PANEL_DOOR.get(),
                block -> createDoorTable(ModBlocks.REINFORCED_COPPER_PANEL_DOOR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
