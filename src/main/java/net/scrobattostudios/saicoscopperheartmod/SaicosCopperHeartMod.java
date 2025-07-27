package net.scrobattostudios.saicoscopperheartmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
import net.scrobattostudios.saicoscopperheartmod.item.ModCreativeModTabs;
import net.scrobattostudios.saicoscopperheartmod.item.ModItems;
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

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

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
        }
    }
}
