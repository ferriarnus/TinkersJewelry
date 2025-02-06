package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.impl.BasicModifier;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierSlotModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.library.tools.SlotType;

public class JewelryModifierProvider extends AbstractModifierProvider {

    public JewelryModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {
        ModifierSlotModule UPGRADE = new ModifierSlotModule(SlotType.UPGRADE);
        ModifierSlotModule ABILITY = new ModifierSlotModule(SlotType.ABILITY);
        buildModifier(JewelryModifiers.PRECIOUS).tooltipDisplay(BasicModifier.TooltipDisplay.ALWAYS).levelDisplay(ModifierLevelDisplay.SINGLE_LEVEL).addModule(ABILITY);
        buildModifier(JewelryModifiers.POLISH).tooltipDisplay(BasicModifier.TooltipDisplay.ALWAYS).levelDisplay(ModifierLevelDisplay.SINGLE_LEVEL).addModule(UPGRADE);
    }

    @Override
    public String getName() {
        return "Tinkers's Jewelry Modifier Provider";
    }
}
