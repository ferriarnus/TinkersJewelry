package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.TinkersJewelry;
import dev.ferriarnus.tinkersjewelry.items.ItemRegistry;
import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import dev.ferriarnus.tinkersjewelry.tools.stats.JewelryToolStats;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import slimeknights.mantle.recipe.data.IRecipeHelper;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;

import java.util.function.Consumer;

public class JewelryModifierRecipe extends RecipeProvider implements IConditionBuilder, IRecipeHelper {

    public JewelryModifierRecipe(PackOutput generator) {
        super(generator);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        String slotlessFolder = "tools/modifiers/slotless/";
        String abilitySalvage = "tools/modifiers/salvage/ability/";

        ModifierRecipeBuilder.modifier(JewelryModifiers.POLISH)
                .setTools(Ingredient.of(ItemRegistry.RING))
                .addInput(Items.CHARCOAL)
                .addInput(Items.HONEYCOMB)
                .addInput(Items.GLOWSTONE_DUST)
                .addInput(ItemTags.SAND)
                .addInput(Tags.Items.LEATHER)
                .setMaxLevel(1)
                .save(consumer, prefix(JewelryModifiers.POLISH, slotlessFolder));

        ModifierRecipeBuilder.modifier(JewelryModifiers.UNDYING)
                .setTools(Ingredient.of(ItemRegistry.RING))
                .addInput(Items.TOTEM_OF_UNDYING)
                .setSlots(SlotType.ABILITY, 1)
                .setMaxLevel(1)
                .saveSalvage(consumer, prefix(JewelryModifiers.UNDYING, abilitySalvage))
                .save(consumer, prefix(JewelryModifiers.UNDYING, slotlessFolder));
    }

    @Override
    public String getName() {
        return "Tinkers's Jewelry Modifier Recipe";
    }

    @Override
    public String getModId() {
        return TinkersJewelry.MODID;
    }
}
