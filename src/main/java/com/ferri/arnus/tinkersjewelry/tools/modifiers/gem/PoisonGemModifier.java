package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class PoisonGemModifier extends AbstractGemModifier{

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.HURT_ENTITY;
    }

    @Override
    public void hurtEnemy(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable LivingEntity attacker) {
        if (attacker == null || attacker.hasEffect(MobEffects.POISON)) {
            return;
        }
        attacker.addEffect(new MobEffectInstance(MobEffects.POISON, 200));
        damageTool(stack, 1, attacker);
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//        foltip.add(addloat amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
////        double effect = 1 * amp * 3;
////        toDiscription(TranslationKeys.POISON, effect+"s"));
    }
}
