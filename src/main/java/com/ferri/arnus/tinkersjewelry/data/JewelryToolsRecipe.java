package com.ferri.arnus.tinkersjewelry.data;

import java.util.Objects;
import java.util.function.Consumer;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.recipe.partbuilder.PartRecipeBuilder;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;

public class JewelryToolsRecipe extends RecipeProvider implements IMaterialRecipeHelper, IToolRecipeHelper {

	public JewelryToolsRecipe(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		 String folder = "tools/building/";
		 toolBuilding(consumer, ItemRegistry.BOW, folder);
		 toolBuilding(consumer, ItemRegistry.RING, folder);
		 partRecipes(consumer, ItemRegistry.GEM.get(), 1, "tools/parts/");
		
	}

	@Override
	public String getName() {
	    return "Tinkers' Jewelry Tool Recipes";
	}
	
	/**
	 * Adds a recipe to craft a material item
	 * @param consumer Recipe consumer
	 * @param part     Part to be crafted
	 * @param cast     Part cast
	 * @param cost     Part cost
	 * @param partFolder   Folder for recipes
	 */
	public void partRecipes(Consumer<FinishedRecipe> consumer, IMaterialItem part, int cost, String partFolder) {
		String name = Objects.requireNonNull(part.asItem().getRegistryName()).getPath();
		
		// Part Builder
		PartRecipeBuilder.partRecipe(part)
		.setPattern(modResource(name))
		.setCost(cost)
		.save(consumer, modResource(partFolder + "builder/" + name));
	}

	@Override
	public String getModId() {
		return TinkersJewelry.MODID;
	}
}
