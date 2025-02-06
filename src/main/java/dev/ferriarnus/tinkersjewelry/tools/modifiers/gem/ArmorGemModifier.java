package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import dev.ferriarnus.tinkersjewelry.items.CuriosDamageTypes;
import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import dev.ferriarnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
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

public class ArmorGemModifier extends AbstractGemModifier {

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
        ToolStack toolStack = ToolStack.from(stack);
        int level = toolStack.getModifierLevel(JewelryModifiers.ARMOR_GEM.getId());
        float amp = toolStack.getMultiplier(JewelryToolStats.AMPLIFICATION);
        double effect = ( 2.5D * level) * amp;
        attributeModifiers.put(Attributes.ARMOR, new AttributeModifier(uuid, "tinkersjewelry:armorgem", effect, AttributeModifier.Operation.ADDITION));
        return attributeModifiers;
    }

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.HURT_PLAYER;
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//        float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
//        double effect =  (1.25D + 0.25 * level) * amp;
//        tooltip.add(addDiscription(TranslationKeys.ARMOR, effect));
    }
}
