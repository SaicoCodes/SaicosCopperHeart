package net.scrobattostudios.saicoscopperheartmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.scrobattostudios.saicoscopperheartmod.SaicosCopperHeartMod;
import net.scrobattostudios.saicoscopperheartmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SaicosCopperHeartMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.REINFORCED_COPPER_BLOCK);
        blockWithItem(ModBlocks.COPPER_GRATE);
        blockWithItem(ModBlocks.EXPOSED_COPPER_GRATE);
        blockWithItem(ModBlocks.WEATHERED_COPPER_GRATE);
        blockWithItem(ModBlocks.OXIDIZED_COPPER_GRATE);

        blockWithItem(ModBlocks.CHISELED_COPPER_BLOCK);
        blockWithItem(ModBlocks.EXPOSED_CHISELED_COPPER_BLOCK);
        blockWithItem(ModBlocks.WEATHERED_CHISELED_COPPER_BLOCK);
        blockWithItem(ModBlocks.OXIDIZED_CHISELED_COPPER_BLOCK);

        blockWithItem(ModBlocks.REINFORCED_COPPER_PANEL_BLOCK);

        horizontalBlock(ModBlocks.REINFORCED_KILN_BLOCK.get(),
                state -> {
                    boolean lit = state.getValue(BlockStateProperties.LIT);
                    String suffix = lit ? "_on" : "_off";

                    return models().cube("reinforced_kiln_block" + suffix,
                            modLoc("block/reinforced_kiln_bottom"),
                            modLoc("block/reinforced_kiln_top"),
                            modLoc("block/reinforced_kiln_front" + suffix),
                            modLoc("block/reinforced_kiln_side"),
                            modLoc("block/reinforced_kiln_side"),
                            modLoc("block/reinforced_kiln_side"))
                            .texture("particle", modLoc("block/reinforced_kiln_side"));
                });

        /** getVariantBuilder(ModBlocks.REINFORCED_COPPER_CRATE.get()).forAllStates(state -> {
            boolean isOpen = state.getValue(BlockStateProperties.OPEN);
            ResourceLocation model = modLoc("block/reinforced_copper_crate_" + (isOpen ? "open" : "closed"));
            return ConfiguredModel.builder().modelFile(new ModelFile.UncheckedModelFile(model)).build();
        }); **/


        doorBlockWithRenderType(((DoorBlock) ModBlocks.REINFORCED_COPPER_PANEL_DOOR.get()),
                modLoc("block/reinforced_copper_panel_door_bottom"), modLoc("block/reinforced_copper_panel_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.REINFORCED_COPPER_PANEL_TRAPDOOR.get()),
                modLoc("block/reinforced_copper_panel_trapdoor"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
