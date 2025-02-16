package dev.ferriarnus.tinkersjewelry.data;

import java.util.function.Consumer;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.items.ItemRegistry;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.CompoundIngredient;
import slimeknights.mantle.recipe.helper.ItemOutput;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.recipe.partbuilder.ItemPartRecipeBuilder;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

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
