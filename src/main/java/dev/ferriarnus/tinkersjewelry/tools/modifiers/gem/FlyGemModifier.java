package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import com.google.common.collect.Multimap;
import dev.shadowsoffire.attributeslib.api.ALObjects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class FlyGemModifier extends AbstractGemModifier {

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
        attributeModifiers.put(ALObjects.Attributes.CREATIVE_FLIGHT.get(), new AttributeModifier(uuid,"tinkersjewelry:flight",  1, AttributeModifier.Operation.ADDITION));
        return attributeModifiers;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (slotContext.entity() instanceof Player player && player.getAbilities().flying && player.level().getGameTime() % 20 == 10) {
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
