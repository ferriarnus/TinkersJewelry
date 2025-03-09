package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.entity.BeaconBlockEntity;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class FlyGemModifier extends AbstractGemModifier {

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack, ModifierEntry modifierEntry) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = HashMultimap.create();
        attributeModifiers.put(ALObjects.Attributes.CREATIVE_FLIGHT.get(), new AttributeModifier(uuid,"tinkersjewelry:flight",  1, AttributeModifier.Operation.ADDITION));
        return attributeModifiers;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack, ModifierEntry entry) {
        LivingEntity entity = slotContext.entity();
        if (!entity.hasEffect(ALObjects.MobEffects.FLYING.get()) || entity.getEffect(ALObjects.MobEffects.FLYING.get()).getDuration() < 220) {
            entity.addEffect(new MobEffectInstance(ALObjects.MobEffects.FLYING.get(), 400, 0, false, false));
        }
        if (slotContext.entity() instanceof Player player && player.getAbilities().flying && player.level().getGameTime() % 20 == 3
                && player.getAttributes().getValue(ALObjects.Attributes.CREATIVE_FLIGHT.get()) <= 1.0) {
            damageTool(stack, 1, player);
        }
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//        float amp = iToolStackView.getMultiplier(JewelryToolStats.AMPLIFICATION);
//        int effect = (int) (1 * amp);
//        list.add(addDiscription(TranslationKeys.FLIGHT, ""));
    }

    @Override
    public Component getDisplayName(int level) {
        // display name without the level
        return super.getDisplayName();
    }
}
