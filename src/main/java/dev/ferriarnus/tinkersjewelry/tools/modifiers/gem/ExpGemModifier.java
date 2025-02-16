package dev.ferriarnus.tinkersjewelry.tools.modifiers.gem;

import dev.ferriarnus.tinkersjewelry.items.CuriosDamageTypes;
import dev.ferriarnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import dev.ferriarnus.tinkersjewelry.tools.stats.JewelryToolStats;
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
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ExpGemModifier extends AbstractGemModifier{

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.BLOCK_BREAK;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> attributeModifiers = super.getAttributeModifiers(slotContext, uuid, stack);
        ToolStack toolStack = ToolStack.from(stack);
        int level = toolStack.getModifierLevel(JewelryModifiers.EXP_GEM.getId());
        float amp = toolStack.getStats().get(JewelryToolStats.AMPLIFICATION);
        double effect = 0.20 * level * amp;
        attributeModifiers.put(ALObjects.Attributes.EXPERIENCE_GAINED.get(), new AttributeModifier(uuid, "tinkersjewelry:expgem", effect, AttributeModifier.Operation.ADDITION));
        return attributeModifiers;
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {

    }
}
