package com.ferri.arnus.tinkersjewelry.data;

import java.util.function.Consumer;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.items.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class JewelryMaterialRecipe extends RecipeProvider implements IMaterialRecipeHelper{

	public JewelryMaterialRecipe(PackOutput output) {
		super(output);
	}
	
	@Override
	public String getName() {
		return "Tinkers' Jewelry Material Recipe";
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		String folder = "tools/materials/";
		materialRecipe(consumer, JewelryMaterials.redstone, Ingredient.of(Items.REDSTONE), 1, 1, folder + "gems/redstone");
		materialRecipe(consumer, JewelryMaterials.blood_gem, Ingredient.of(ItemRegistry.BLOOD_GEM), 1, 1, folder + "gems/blood");
		materialRecipe(consumer, JewelryMaterials.lapis, Ingredient.of(Items.LAPIS_LAZULI), 1, 1, folder + "gems/lapis");
		materialRecipe(consumer, JewelryMaterials.netherstar, Ingredient.of(Items.NETHER_STAR), 1, 1, folder + "gems/netherstar");
		materialRecipe(consumer, JewelryMaterials.scute, Ingredient.of(Items.SCUTE), 1, 1, folder + "gems/scute");
		materialRecipe(consumer, JewelryMaterials.diamond, Ingredient.of(Items.DIAMOND), 1, 1, folder + "gems/diamond");
		materialRecipe(consumer, JewelryMaterials.quartz, Ingredient.of(Items.QUARTZ), 1, 1, folder + "gems/quartz");
		materialRecipe(consumer, JewelryMaterials.amethyst, Ingredient.of(Items.AMETHYST_SHARD), 1, 1, folder + "gems/amethyst");
		materialRecipe(consumer, JewelryMaterials.emerald, Ingredient.of(Items.EMERALD), 1, 1, folder + "gems/emerald");
		materialRecipe(consumer, JewelryMaterials.prismarine, Ingredient.of(Items.PRISMARINE_SHARD), 1, 1, folder + "gems/prismarine");

		materialRecipe(consumer, JewelryMaterials.poison_gem, Ingredient.of(ItemRegistry.POISON_GEM), 1, 1, folder + "gems/poison");
		materialRecipe(consumer, JewelryMaterials.blazing_gem, Ingredient.of(ItemRegistry.BLAZING_GEM), 1, 1, folder + "gems/blaze");
		materialRecipe(consumer, JewelryMaterials.speed_gem, Ingredient.of(ItemRegistry.SPEED_GEM), 1, 1, folder + "gems/speed");
		materialRecipe(consumer, JewelryMaterials.cleanse_gem, Ingredient.of(ItemRegistry.CLEANSE_GEM), 1, 1, folder + "gems/cleanse");
		materialRecipe(consumer, JewelryMaterials.nightvision_gem, Ingredient.of(ItemRegistry.NIGHTVISION_GEM), 1, 1, folder + "gems/nightvision");
		materialRecipe(consumer, JewelryMaterials.exp_gem, Ingredient.of(ItemRegistry.EXP_GEM), 1, 1, folder + "gems/exp");
		materialRecipe(consumer, JewelryMaterials.health_gem, Ingredient.of(ItemRegistry.HEALTH_GEM), 1, 1, folder + "gems/health");

		materialRecipe(consumer, MaterialIds.rock, Ingredient.of(Tags.Items.STONE), 1, 1, folder + "gems/stone");
		materialRecipe(consumer, MaterialIds.flint, Ingredient.of(Items.FLINT), 1, 1, folder + "gems/flint");
		materialRecipe(consumer, MaterialIds.ichor, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(TConstruct.MOD_ID, "ichor_slime_crystal"))), 1, 1, folder + "gems/ichor_slime_crystal");
		materialRecipe(consumer, MaterialIds.earthslime, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(TConstruct.MOD_ID, "earth_slime_crystal"))), 1, 1, folder + "gems/earth_slime_crystal");
		materialRecipe(consumer, MaterialIds.skyslime, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(TConstruct.MOD_ID, "sky_slime_crystal"))), 1, 1, folder + "gems/sky_slime_crystal");
		materialRecipe(consumer, MaterialIds.enderslime, Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(TConstruct.MOD_ID, "ender_slime_crystal"))), 1, 1, folder + "gems/ender_slime_crystal");
		materialRecipe(consumer, MaterialIds.obsidian, Ingredient.of(Items.OBSIDIAN), 1, 1, folder + "gems/obsidian");
	}

	@Override
	public String getModId() {
		return TinkersJewelry.MODID;
	}
}
