package net.scrobattostudios.saicoscopperheartmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.scrobattostudios.saicoscopperheartmod.SaicosCopperHeartMod;
import net.scrobattostudios.saicoscopperheartmod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SaicosCopperHeartMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> COPPERHEART_TAB = CREATIVE_MODE_TABS.register("copperheart_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_ALLOY.get()))
                    .title(Component.translatable("creativetab.copperheart_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COPPER_ALLOY.get());
                        output.accept(ModItems.REINFORCED_COPPER_INGOT.get());
                        output.accept(ModItems.COPPER_NUGGET.get());
                        output.accept(ModItems.REINFORCED_COPPER_NUGGET.get());

                        output.accept(ModItems.REINFORCED_COPPER_SCYTHE.get());

                        output.accept(ModItems.REINFORCED_COPPER_BOOTS.get());

                        output.accept(ModBlocks.REINFORCED_COPPER_BLOCK.get());
                        output.accept(ModBlocks.REINFORCED_COPPER_PANEL_BLOCK.get());

                        output.accept(ModBlocks.REINFORCED_COPPER_PANEL_DOOR.get());
                        output.accept(ModBlocks.REINFORCED_COPPER_PANEL_TRAPDOOR.get());

                        output.accept(ModBlocks.COPPER_GRATE.get());
                        output.accept(ModBlocks.EXPOSED_COPPER_GRATE.get());
                        output.accept(ModBlocks.WEATHERED_COPPER_GRATE.get());
                        output.accept(ModBlocks.OXIDIZED_COPPER_GRATE.get());

                        output.accept(ModBlocks.CHISELED_COPPER_BLOCK.get());
                        output.accept(ModBlocks.EXPOSED_CHISELED_COPPER_BLOCK.get());
                        output.accept(ModBlocks.WEATHERED_CHISELED_COPPER_BLOCK.get());
                        output.accept(ModBlocks.OXIDIZED_CHISELED_COPPER_BLOCK.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
