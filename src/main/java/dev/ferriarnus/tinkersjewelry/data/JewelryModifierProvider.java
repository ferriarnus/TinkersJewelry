package dev.ferriarnus.tinkersjewelry.data;

import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.modifiers.impl.BasicModifier;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierRequirementsModule;
import slimeknights.tconstruct.library.modifiers.modules.build.ModifierSlotModule;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.data.ModifierIds;

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
    }

    @Override
    public String getName() {
        return "Tinkers's Jewelry Modifier Provider";
    }
}
