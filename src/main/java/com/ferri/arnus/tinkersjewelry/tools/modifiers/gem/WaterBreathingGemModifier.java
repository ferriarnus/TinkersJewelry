package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.playerattributes.CustomAttributeModifier;
import com.ferri.arnus.playerattributes.attributes.AttributeRegistry;
import com.ferri.arnus.playerattributes.operations.OperationRegistry;
import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.UUID;

public class WaterBreathingGemModifier extends AbstractGemModifier{

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
        ToolStack toolStack = ToolStack.from(stack);
        float amp = toolStack.getMultiplier(JewelryToolStats.AMPLIFICATION);
        double effect = 1 * amp;
        attributeModifiers.put(AttributeRegistry.WATERBREATHING.get(), new CustomAttributeModifier(uuid, "tinkersjewelry:waterbreathinggem", effect, OperationRegistry.MAXVALUE.get()));
        return attributeModifiers;
    }

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.MOB_EFFECT;
    }

    @Override
    public void damageTool(ItemStack stack, int amount, @Nullable LivingEntity entity, MobEffect effect) {
        if (effect == MobEffects.WATER_BREATHING) {
            super.damageTool(stack, amount, entity, effect);
        }
    }

}
