package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fluids.FluidAttributes;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;

import java.util.function.Consumer;

public class JewelrySmeltryRecipe extends RecipeProvider implements ISmelteryRecipeHelper {
    public JewelrySmeltryRecipe(DataGenerator pGenerator) {
        super(pGenerator);
    }

    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        castingRecipes(consumer);

    }

    public void castingRecipes(Consumer<FinishedRecipe> consumer) {
        String folder = "smeltery/casting/";
        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.BLOODGEM)
                .setFluidAndTime(TinkerFluids.blood, false, FluidValues.GEM)
                .setCast(Items.DIAMOND, true)
                .save(consumer, modResource(folder + "blood/bloodgem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.BLAZINGGEM)
                .setFluidAndTime(TinkerFluids.blazingBlood, false, FluidValues.GEM)
                .setCast(Items.GLOWSTONE_DUST, true)
                .save(consumer, modResource(folder + "blazingblood/blazinggem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.POISONGEM)
                .setFluidAndTime(TinkerFluids.venom, false, FluidValues.GEM)
                .setCast(Items.EMERALD, true)
                .save(consumer, modResource(folder + "venom/spidergem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.SPEEDGEM)
                .setFluidAndTime(TinkerFluids.honey, false, FluidValues.GEM)
                .setCast(Items.SUGAR, true)
                .save(consumer, modResource(folder + "honey/speedgem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.CLEANSEGEM)
                .setFluidAndTime(ForgeMod.MILK.get(), Tags.Fluids.MILK, FluidAttributes.BUCKET_VOLUME)
                .setCast(Items.QUARTZ, true)
                .save(consumer, modResource(folder + "milk/cleansegem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.NIGHTVISIONGEM)
                .setFluidAndTime(TinkerFluids.moltenObsidian, false, FluidAttributes.BUCKET_VOLUME)
                .setCast(Items.GLOWSTONE_DUST, true)
                .save(consumer, modResource(folder + "obsidian/nightvisiongem"));
    }

    @Override
    public String getModId() {
        return TinkersJewelry.MODID;
    }
}
