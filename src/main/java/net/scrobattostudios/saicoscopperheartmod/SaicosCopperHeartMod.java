package net.scrobattostudios.saicoscopperheartmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.scrobattostudios.saicoscopperheartmod.block.ModBlocks;
import net.scrobattostudios.saicoscopperheartmod.block.entity.ModBlocksEntities;
import net.scrobattostudios.saicoscopperheartmod.client.renderer.CopperArrowRenderer;
import net.scrobattostudios.saicoscopperheartmod.entity.ModEntityType;
import net.scrobattostudios.saicoscopperheartmod.entity.projectile.CopperArrowEntity;
import net.scrobattostudios.saicoscopperheartmod.event.ArrowEventHandler;
import net.scrobattostudios.saicoscopperheartmod.event.ModEvents;
import net.scrobattostudios.saicoscopperheartmod.event.ScytheHarvestHandler;
import net.scrobattostudios.saicoscopperheartmod.item.ModCreativeModTabs;
import net.scrobattostudios.saicoscopperheartmod.item.ModItems;
import net.scrobattostudios.saicoscopperheartmod.screen.ModMenuTypes;
import net.scrobattostudios.saicoscopperheartmod.screen.ReinforcedCopperCrateMenu;
import net.scrobattostudios.saicoscopperheartmod.screen.ReinforcedCopperCrateScreen;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SaicosCopperHeartMod.MOD_ID)
public class SaicosCopperHeartMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "saicoscopperheartmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public SaicosCopperHeartMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModEntityType.ENTITY_TYPES.register(modEventBus);
        ModBlocksEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(ModEvents.class);
        MinecraftForge.EVENT_BUS.register(ScytheHarvestHandler.class);
        MinecraftForge.EVENT_BUS.register(new ArrowEventHandler());

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_GRATE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_COPPER_GRATE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_COPPER_GRATE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.OXIDIZED_COPPER_GRATE.get(), RenderType.translucent());

            event.enqueueWork(() -> {
                EntityRenderers.register(ModEntityType.COPPER_ARROW.get(), CopperArrowRenderer::new);
            });
        }
    }
}
