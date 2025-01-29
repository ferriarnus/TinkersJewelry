package com.ferri.arnus.tinkersjewelry.tools.modifiers.gem;

import com.ferri.arnus.tinkersjewelry.items.CuriosDamageTypes;
import com.ferri.arnus.tinkersjewelry.tools.modifiers.JewelryModifiers;
import com.ferri.arnus.tinkersjewelry.tools.stats.JewelryToolStats;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
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

public class FortuneGemModifier extends AbstractGemModifier{

    @Override
    public CuriosDamageTypes getDamageType() {
        return CuriosDamageTypes.BLOCK_BREAK;
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
//        CompoundTag tag = slotContext.entity().getMainHandItem().getTag();
//        ToolStack toolStack = ToolStack.from(stack);
//        int toolLevel = toolStack.getModifierLevel(JewelryModifiers.FORTUNEGEM.getId());
//        CompoundTag fortune = new CompoundTag();
//        fortune.putInt("level", toolLevel);
//        if (tag.contains(slotContext.entity().getStringUUID())) {
//            CompoundTag ability = tag.getCompound(slotContext.entity().getStringUUID());
//            if (ability.contains("fortune")) {
//                int level = ability.contains("fortune") ? ability.getCompound("fortune").getInt("level") : 0;
//                if (toolLevel > level) {
//                    ability.getCompound("fortune").putInt("level", toolLevel);
//                }
//            } else {
//                ability.put("fortune", fortune);
//            }
//        } else {
//            CompoundTag ability = new CompoundTag();
//            ability.put("fortune", fortune);
//            tag.put(slotContext.entity().getStringUUID(), ability);
//        }
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
//        CompoundTag tag = slotContext.entity().getMainHandItem().getTag();
//        ToolStack toolStack = ToolStack.from(stack);
//        int toolLevel = toolStack.getModifierLevel(JewelryModifiers.FORTUNEGEM.getId());
//        CompoundTag fortune = new CompoundTag();
//        fortune.putInt("level", toolLevel);
//        if (tag.contains(slotContext.entity().getStringUUID())) {
//            CompoundTag ability = tag.getCompound(slotContext.entity().getStringUUID());
//            if (ability.contains("fortune")) {
//                int level = ability.contains("fortune") ? ability.getCompound("fortune").getInt("level") : 0;
//                if (toolLevel > level) {
//                    ability.getCompound("fortune").putInt("level", level);
//                } else {
//                    ability.remove("fortune");
//                }
//            }
//        }
    }

    @Override
    public void addTooltip(IToolStackView iToolStackView, ModifierEntry modifierEntry, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
//        float amp = tool.getMultiplier(JewelryToolStats.AMPLIFICATION);
//        int effect = (int) (1 * amp);
//        tooltip.add(addDiscription(TranslationKeys.FORTUNE, effect));
    }
}
