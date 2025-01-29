package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
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

public class CleanseGemModifier extends AbstractGemModifier{

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.NONE;
    }

    public void damageTool(ItemStack stack, int amount, LivingEntity entity, MobEffect effect) {
        if (!effect.isBeneficial()) {
            MobEffectInstance instance = entity.getEffect(effect);
            if (instance == null) {
                return;
            }
            int level = instance.getAmplifier();
            int duration = instance.getDuration();
            entity.removeEffect(effect);
            damageTool(stack, 5*level* (duration/100), entity);
        }
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (entity == null) {
            return;
        }
        for (MobEffectInstance effect : entity.getActiveEffects()) {
            if (!effect.getEffect().isBeneficial()) {
                int level = effect.getAmplifier();
                int duration = effect.getDuration();
                entity.removeEffect(effect.getEffect());
                damageTool(stack, 5*level* (duration/100), entity, effect.getEffect());
            }
        }
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//        float amp = iToolStackView.getMultiplier(JewelryToolStats.AMPLIFICATION);
//        int effect = (int) (1 * amp);
//        list.add(addDiscription("stats.tinkersjewelry.clensegem", ""));
    }

    @Override
    public Component getDisplayName(int level) {
        // display name without the level
        return super.getDisplayName();
    }
}
