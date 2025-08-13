package net.scrobattostudios.saicoscopperheartmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scrobattostudios.saicoscopperheartmod.SaicosCopperHeartMod;
import net.scrobattostudios.saicoscopperheartmod.block.custom.ChiseledCopperBlock;
import net.scrobattostudios.saicoscopperheartmod.block.custom.CopperGrateBlock;
import net.scrobattostudios.saicoscopperheartmod.block.custom.ReinforcedCopperCrateBlock;
import net.scrobattostudios.saicoscopperheartmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SaicosCopperHeartMod.MOD_ID);

    public static final RegistryObject<Block> REINFORCED_COPPER_BLOCK = registerBlock("reinforced_copper_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));

    public static final RegistryObject<Block> COPPER_GRATE = registerBlock("copper_grate",
            () -> new CopperGrateBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> EXPOSED_COPPER_GRATE = registerBlock("exposed_copper_grate",
            () -> new CopperGrateBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER)));
    public static final RegistryObject<Block> WEATHERED_COPPER_GRATE = registerBlock("weathered_copper_grate",
            () -> new CopperGrateBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER)));
    public static final RegistryObject<Block> OXIDIZED_COPPER_GRATE = registerBlock("oxidized_copper_grate",
            () -> new CopperGrateBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER)));

    public static final RegistryObject<Block> CHISELED_COPPER_BLOCK = registerBlock("chiseled_copper_block",
            () -> new ChiseledCopperBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));
    public static final RegistryObject<Block> EXPOSED_CHISELED_COPPER_BLOCK = registerBlock("exposed_chiseled_copper_block",
            () -> new ChiseledCopperBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER)));
    public static final RegistryObject<Block> WEATHERED_CHISELED_COPPER_BLOCK = registerBlock("weathered_chiseled_copper_block",
            () -> new ChiseledCopperBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER)));
    public static final RegistryObject<Block> OXIDIZED_CHISELED_COPPER_BLOCK = registerBlock("oxidized_chiseled_copper_block",
            () -> new ChiseledCopperBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER)));

    public static final RegistryObject<Block> REINFORCED_COPPER_PANEL_BLOCK = registerBlock("reinforced_copper_panel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));

    public static final RegistryObject<Block> REINFORCED_COPPER_CRATE = registerBlock("reinforced_copper_crate",
            () -> new ReinforcedCopperCrateBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));

    public static final RegistryObject<Block> REINFORCED_COPPER_PANEL_DOOR = registerBlock("reinforced_copper_panel_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(ModBlocks.REINFORCED_COPPER_PANEL_BLOCK.get()).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> REINFORCED_COPPER_PANEL_TRAPDOOR = registerBlock("reinforced_copper_panel_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(ModBlocks.REINFORCED_COPPER_PANEL_BLOCK.get()).noOcclusion(), BlockSetType.IRON));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
