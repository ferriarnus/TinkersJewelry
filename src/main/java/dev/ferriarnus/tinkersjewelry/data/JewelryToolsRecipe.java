package dev.ferriarnus.tinkersjewelry.data;

import java.util.function.Consumer;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.items.ItemRegistry;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;

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
		partRecipes(consumer, ItemRegistry.PLAIN_RING.get(), ItemRegistry.PLAIN_RING_CAST, 1, partFolder, castFolder);
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
