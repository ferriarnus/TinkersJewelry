package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.playerattributes.CustomAttributeModifier;
import com.ferri.arnus.playerattributes.attributes.AttributeRegistry;
import com.ferri.arnus.playerattributes.operations.OperationRegistry;
import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class PiercingGemModifier extends AbstractGemModifier{

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
        ToolStack toolStack = ToolStack.from(stack);
        float amp = toolStack.getMultiplier(JewelryToolStats.AMPLIFICATION);
        int level = 0;
        for (ModifierEntry entry : toolStack.getModifiers().getModifiers()) {
            if (entry.getModifier().equals(this)) {
                level = entry.getLevel() - 1;
            }
        }
        double effect = (0.1 + level * 0.05)* amp;
        attributeModifiers.put(AttributeRegistry.PIERCING.get(), new CustomAttributeModifier(uuid, "tinkersjewelry:fireresistancegem", effect, OperationRegistry.MAXVALUE.get()));
        return attributeModifiers;
    }

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.HURT_ENTITY;
    }

}
