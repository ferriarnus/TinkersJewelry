package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import dev.ferriarnus.tinkersjewelry.tools.stats.JewelryToolStats;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.variable.tool.ToolStatVariable;
import slimeknights.tconstruct.library.json.variable.tool.ToolVariable;
import slimeknights.tconstruct.library.modifiers.impl.BasicModifier;
import slimeknights.tconstruct.library.modifiers.modules.behavior.ConditionalStatModule;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierRequirementsModule;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierSlotModule;
import slimeknights.tconstruct.library.modifiers.modules.build.StatBoostModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.data.ModifierIds;

import static slimeknights.tconstruct.library.json.math.ModifierFormula.*;

public class JewelryModifierProvider extends AbstractModifierProvider {

    public JewelryModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {
        ModifierSlotModule UPGRADE = new ModifierSlotModule(SlotType.UPGRADE);
        ModifierSlotModule ABILITY = new ModifierSlotModule(SlotType.ABILITY);

        buildModifier(JewelryModifiers.PRECIOUS)
                .tooltipDisplay(BasicModifier.TooltipDisplay.ALWAYS)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .addModule(ABILITY);

        buildModifier(JewelryModifiers.POLISH)
                .tooltipDisplay(BasicModifier.TooltipDisplay.ALWAYS)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .addModule(UPGRADE);

        buildModifier(JewelryModifiers.UNDYING)
                .tooltipDisplay(BasicModifier.TooltipDisplay.ALWAYS)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .addModule(ModifierRequirementsModule.builder()
                        .requireModifier(ModifierIds.soulbound, 1)
                        .modifierKey(JewelryModifiers.UNDYING)
                        .build());

        buildModifier(JewelryModifiers.MAINTAINED)
                .addModule(ConditionalStatModule.stat(JewelryToolStats.AMPLIFICATION)
                        .customVariable("durability", ToolVariable.CURRENT_DURABILITY)
                        .customVariable("max_durability", new ToolStatVariable(ToolStats.DURABILITY))
                        .formula()
                        .customVariable("max_durability").constant(0.5f).multiply().duplicate()
                        .customVariable("durability").subtractFlipped()
                        .nonNegative().divideFlipped()
                        .variable(LEVEL).multiply()
                        .constant(1.1f).multiply()
                        .variable(MULTIPLIER).multiply()
                        .variable(VALUE).multiply().build())
                .tooltipDisplay(BasicModifier.TooltipDisplay.ALWAYS);

        buildModifier(JewelryModifiers.DUCTILE)
                .addModule(StatBoostModule.multiplyBase(JewelryToolStats.AMPLIFICATION).eachLevel(0.07f))
                .addModule(StatBoostModule.multiplyBase(ToolStats.DURABILITY).eachLevel(0.1f));
    }

    @Override
    public String getName() {
        return "Tinkers's Jewelry Modifier Provider";
    }
}
