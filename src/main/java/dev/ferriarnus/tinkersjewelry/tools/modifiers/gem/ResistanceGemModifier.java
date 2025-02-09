package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import dev.ferriarnus.tinkersjewelry.items.CuriosDamageTypes;
import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import dev.ferriarnus.tinkersjewelry.tools.stats.JewelryToolStats;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
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

public class ResistanceGemModifier extends AbstractGemModifier {

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.HURT_PLAYER;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (!entity.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
            ToolStack tool = ToolStack.from(stack);
            int level = tool.getModifierLevel(JewelryModifiers.RESISTANCE_GEM.getId());
            float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, Math.round(amp * level)));
        }
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {

    }
}
