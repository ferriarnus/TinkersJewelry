package com.ferri.arnus.tinkersarsenal.data;

import java.util.Objects;
import java.util.function.Consumer;

import com.ferri.arnus.tinkersarsenal.items.ItemRegistry;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.recipe.partbuilder.PartRecipeBuilder;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;

public class ArsenalToolsRecipe extends BaseRecipeProvider implements IMaterialRecipeHelper, IToolRecipeHelper {

	public ArsenalToolsRecipe(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		 String folder = "tools/building/";
		 toolBuilding(consumer, ItemRegistry.bow, folder);
		 toolBuilding(consumer, ItemRegistry.ring, folder);
		 partRecipes(consumer, ItemRegistry.gem.get(), 1, "tools/parts/");
		
	}

	@Override
	public String getName() {
	    return "Tinkers' Arsenal Tool Recipes";
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

}
