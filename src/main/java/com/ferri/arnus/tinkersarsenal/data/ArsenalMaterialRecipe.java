package com.ferri.arnus.tinkersarsenal.data;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;

public class ArsenalMaterialRecipe extends BaseRecipeProvider implements IMaterialRecipeHelper{

	public ArsenalMaterialRecipe(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getName() {
		return "Tinkers' Arsenal Material Recipe";
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		String folder = "tools/materials/";
		materialRecipe(consumer, ArsenalMaterials.redstone, Ingredient.of(Items.REDSTONE), 1, 1, folder + "gems/redstone");
		
	}


}
