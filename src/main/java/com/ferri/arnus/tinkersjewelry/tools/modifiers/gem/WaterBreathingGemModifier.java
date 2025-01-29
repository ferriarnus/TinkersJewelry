package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;

public class WaterBreathingGemModifier extends AbstractGemModifier{

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.NONE;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (entity.isUnderWater() && !entity.hasEffect(MobEffects.WATER_BREATHING)) {
            entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 200));
            damageTool(stack, 1, entity, MobEffects.WATER_BREATHING);
        }
    }

    @Override
    public void damageTool(ItemStack stack, int amount, LivingEntity entity, MobEffect effect) {
        if (effect == MobEffects.WATER_BREATHING) {
            super.damageTool(stack, amount, entity, effect);
        }
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//        float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
//        double effect = level * amp;
//        tooltip.add(addDiscription(TranslationKeys.WATERBREATHING, effect));
    }

}
