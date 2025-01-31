package com.ferri.arnus.tinkersjewelry.data;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;

import java.util.function.Consumer;

public class JewelrySmeltryRecipe extends RecipeProvider implements ISmelteryRecipeHelper {
    public JewelrySmeltryRecipe(PackOutput output) {
        super(output);
    }

    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        castingRecipes(consumer);
    }

    public void castingRecipes(Consumer<FinishedRecipe> consumer) {
        String folder = "smeltery/casting/";
        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.BLOOD_GEM)
                .setFluidAndTime(TinkerFluids.meatSoup, FluidValues.BOWL)
                .setCast(Items.DIAMOND, true)
                .save(consumer, location(folder + "blood/bloodgem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.BLAZING_GEM)
                .setFluidAndTime(TinkerFluids.blazingBlood, FluidValues.GEM)
                .setCast(Items.GLOWSTONE_DUST, true)
                .save(consumer, location(folder + "blazingblood/blazinggem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.POISON_GEM)
                .setFluidAndTime(TinkerFluids.venom, FluidValues.GEM)
                .setCast(Items.EMERALD, true)
                .save(consumer, location(folder + "venom/spidergem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.SPEED_GEM)
                .setFluidAndTime(TinkerFluids.honey, FluidValues.GEM)
                .setCast(Items.SUGAR, true)
                .save(consumer, location(folder + "honey/speedgem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.CLEANSE_GEM)
                .setFluidAndTime(new FluidStack(ForgeMod.MILK.get(), FluidType.BUCKET_VOLUME))
                .setCast(Items.QUARTZ, true)
                .save(consumer, location(folder + "milk/cleansegem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.NIGHTVISION_GEM)
                .setFluidAndTime(TinkerFluids.moltenObsidian, FluidValues.GLASS_BLOCK)
                .setCast(Items.GLOWSTONE_DUST, true)
                .save(consumer, location(folder + "obsidian/nightvisiongem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.EXP_GEM)
                .setFluidAndTime(TinkerFluids.moltenEmerald, FluidValues.GEM)
                .setCast(Items.EXPERIENCE_BOTTLE, true)
                .save(consumer, location(folder + "moltenemerald/expgem"));

        ItemCastingRecipeBuilder.tableRecipe(ItemRegistry.HEALTH_GEM)
                .setFluidAndTime(TinkerFluids.beetrootSoup, FluidValues.BOWL)
                .setCast(Items.APPLE, true)
                .save(consumer, location(folder + "beetrootsoup/healthgem"));
    }

    @Override
    public String getModId() {
        return TinkersJewelry.MODID;
    }
}
