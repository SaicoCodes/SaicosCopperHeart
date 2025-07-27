package net.scrobattostudios.saicoscopperheartmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scrobattostudios.saicoscopperheartmod.SaicosCopperHeartMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SaicosCopperHeartMod.MOD_ID);

    public static final RegistryObject<Item> COPPER_ALLOY = ITEMS.register("copper_alloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_COPPER_INGOT = ITEMS.register("reinforced_copper_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
