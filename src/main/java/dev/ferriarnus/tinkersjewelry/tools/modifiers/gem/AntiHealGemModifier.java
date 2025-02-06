package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import dev.ferriarnus.tinkersjewelry.items.CuriosDamageTypes;
import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
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

public class AntiHealGemModifier extends AbstractGemModifier {

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.HURT_ENTITY;
    }

    @Override
    public void hurtEnemy(ItemStack stack, DamageSource source, double damage, @Nullable LivingEntity defender, @Nullable LivingEntity attacker) {
        if (defender == null || defender.hasEffect(ALObjects.MobEffects.GRIEVOUS.get())) {
            return;
        }
        defender.addEffect(new MobEffectInstance(ALObjects.MobEffects.GRIEVOUS.get(), 100));
        damageTool(stack, 1, attacker);
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {

    }
}
