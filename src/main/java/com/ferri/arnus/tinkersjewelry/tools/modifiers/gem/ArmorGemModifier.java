package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class ArmorGemModifier extends AbstractGemModifier {

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
        ToolStack toolStack = ToolStack.from(stack);
        //Level will always be 1 for now
        int level = 0;
        for (ModifierEntry entry : toolStack.getModifiers().getModifiers()) {
            if (entry.getModifier().equals(this)) {
                level = entry.getLevel();
            }
        }
        //
        float amp = toolStack.getMultiplier(JewelryToolStats.AMPLIFICATION);
        double effect = level > 0 ? (1.25D + 0.25 * level) * amp : 0;
        attributeModifiers.put(Attributes.ARMOR, new AttributeModifier(uuid, "tinkersjewelry:armorgem", effect, AttributeModifier.Operation.MULTIPLY_BASE));
        return attributeModifiers;
    }

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.HURT_PLAYER;
    }
}
