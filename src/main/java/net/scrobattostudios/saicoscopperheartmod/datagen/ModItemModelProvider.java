package net.scrobattostudios.saicoscopperheartmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scrobattostudios.saicoscopperheartmod.SaicosCopperHeartMod;
import net.scrobattostudios.saicoscopperheartmod.block.ModBlocks;
import net.scrobattostudios.saicoscopperheartmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SaicosCopperHeartMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.COPPER_ALLOY);
        simpleItem(ModItems.COPPER_NUGGET);
        simpleItem(ModItems.REINFORCED_COPPER_INGOT);
        simpleItem(ModItems.REINFORCED_COPPER_SCYTHE);

        simpleBlockItem(ModBlocks.REINFORCED_COPPER_PANEL_DOOR);
        trapdoorItem(ModBlocks.REINFORCED_COPPER_PANEL_TRAPDOOR);

    }
    @SuppressWarnings("removal")
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SaicosCopperHeartMod.MOD_ID, "item/" + item.getId().getPath()));
    }
    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(SaicosCopperHeartMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    @SuppressWarnings("removal")
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return  withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SaicosCopperHeartMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
