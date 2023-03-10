package com.ferri.arnus.tinkersjewelry.data;

import java.util.function.Consumer;

import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.data.BaseRecipeProvider;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class JewelryMaterialRecipe extends BaseRecipeProvider implements IMaterialRecipeHelper{

	public JewelryMaterialRecipe(DataGenerator generator) {
		super(generator);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getName() {
		return "Tinkers' Jewelry Material Recipe";
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		String folder = "tools/materials/";
		materialRecipe(consumer, JewelryMaterials.redstone, Ingredient.of(Items.REDSTONE), 1, 1, folder + "gems/redstone");
		materialRecipe(consumer, JewelryMaterials.bloodgem, Ingredient.of(ItemRegistry.BLOODGEM), 1, 1, folder + "gems/blood");
		materialRecipe(consumer, JewelryMaterials.lapis, Ingredient.of(Items.LAPIS_LAZULI), 1, 1, folder + "gems/lapis");
		materialRecipe(consumer, JewelryMaterials.netherstar, Ingredient.of(Items.NETHER_STAR), 1, 1, folder + "gems/netherstar");
		materialRecipe(consumer, JewelryMaterials.scute, Ingredient.of(Items.SCUTE), 1, 1, folder + "gems/scute");

		materialRecipe(consumer, MaterialIds.rock, Ingredient.of(Tags.Items.STONE), 1, 1, folder + "gems/stone");
		materialRecipe(consumer, MaterialIds.ichor, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(TConstruct.MOD_ID, "ichor_slime_crystal"))), 1, 1, folder + "gems/ichor_slime_crystal");
		materialRecipe(consumer, MaterialIds.flint, Ingredient.of(Items.FLINT), 1, 1, folder + "gems/flint");

	}


}
