package net.scrobattostudios.saicoscopperheartmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.scrobattostudios.saicoscopperheartmod.SaicosCopperHeartMod;
import net.scrobattostudios.saicoscopperheartmod.block.ModBlocks;
import net.scrobattostudios.saicoscopperheartmod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> COPPER_ALLOY_SMELTABLE = List.of(ModItems.COPPER_ALLOY.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        oreSmelting(pWriter, COPPER_ALLOY_SMELTABLE, RecipeCategory.MISC, ModItems.REINFORCED_COPPER_INGOT.get(), 0.45f, 200, "reinforced_copper_ingot");
        oreBlasting(pWriter, COPPER_ALLOY_SMELTABLE, RecipeCategory.MISC, ModItems.REINFORCED_COPPER_INGOT.get(), 0.45f, 100, "reinforced_copper_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.REINFORCED_COPPER_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.REINFORCED_COPPER_INGOT.get())
                .unlockedBy(getHasName(ModItems.REINFORCED_COPPER_INGOT.get()), has(ModItems.REINFORCED_COPPER_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.REINFORCED_COPPER_INGOT.get(), 9)
                .requires(ModBlocks.REINFORCED_COPPER_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.REINFORCED_COPPER_BLOCK.get()), has(ModBlocks.REINFORCED_COPPER_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COPPER_GRATE.get())
                .pattern("R R")
                .pattern(" N ")
                .pattern("R R")
                .define('R', ModItems.REINFORCED_COPPER_INGOT.get())
                .define('N', ModItems.COPPER_NUGGET.get())
                .unlockedBy(getHasName(ModItems.REINFORCED_COPPER_INGOT.get()), has(ModItems.REINFORCED_COPPER_INGOT.get()))
                .unlockedBy(getHasName(ModItems.COPPER_NUGGET.get()), has(ModItems.REINFORCED_COPPER_INGOT.get()))
                .save(pWriter);

    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, SaicosCopperHeartMod.MOD_ID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
