package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.playerattributes.TranslationKeys;
import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public class CleanseGemModifier extends AbstractGemModifier{
    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.MOB_EFFECT;
    }

    @Override
    public void damageTool(ItemStack stack, int amount, LivingEntity entity, MobEffect effect) {
        if (!effect.isBeneficial()) {
            MobEffectInstance instance = entity.getEffect(effect);
            if (instance == null) {
                return;
            }
            int level = instance.getAmplifier();
            int duration = instance.getDuration();
            entity.removeEffect(effect);
            super.damageTool(stack, 5*level* (duration/100), entity, effect);
        }
    }

    @Override
    public void addInformation(IToolStackView tool, int level, @Nullable Player player, List<Component> tooltip, slimeknights.tconstruct.library.utils.TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
        int effect = (int) (1 * amp);
        tooltip.add(addDiscription("stats.tinkersjewelry.clensegem", ""));
    }

    @Override
    public Component getDisplayName(int level) {
        // display name without the level
        return super.getDisplayName();
    }
}
