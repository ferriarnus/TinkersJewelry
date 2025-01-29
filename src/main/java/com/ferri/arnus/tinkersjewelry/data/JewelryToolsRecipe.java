package com.ferri.arnus.tinkersjewelry.data;

import java.util.Objects;
import java.util.function.Consumer;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.recipe.partbuilder.PartRecipeBuilder;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;

public class JewelryToolsRecipe extends RecipeProvider implements IMaterialRecipeHelper, IToolRecipeHelper {

	public JewelryToolsRecipe(PackOutput output) {
		super(output);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		String partFolder = "tools/parts/";
		String castFolder = "smeltery/casts/";
		String folder = "tools/building/";
		toolBuilding(consumer, ItemRegistry.RING, folder);
		//partRecipes(consumer, ItemRegistry.BLANK_BAND.get(), null, 1, partFolder, castFolder);
		uncastablePart(consumer, ItemRegistry.GEM.get(), 1, null, partFolder);

	}

	@Override
	public String getName() {
	    return "Tinkers' Jewelry Tool Recipes";
	}

	@Override
	public String getModId() {
		return TinkersJewelry.MODID;
	}
}
