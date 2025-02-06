package dev.ferriarnus.tinkersjewelry.tools.modifiers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import top.theillusivec4.curios.api.CuriosApi;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UndyingModifier extends Modifier {

    @Override
    public Component getDisplayName(int level) {
        // display name without the level
        return super.getDisplayName();
    }

    @SubscribeEvent
    static void undying(LivingDeathEvent event) {
        if (event.isCanceled()) {
            return;
        }
        LivingEntity entity = event.getEntity();
        if (entity.isDeadOrDying()) {
            CuriosApi.getCuriosHelper().getEquippedCurios(entity).ifPresent(curios -> {
                for (int i=0; i < curios.getSlots(); i++) {
                    ItemStack stackInSlot = curios.getStackInSlot(i);
                    ToolStack tool = ToolStack.from(stackInSlot);
                    if (!tool.isBroken() && tool.getModifierLevel(JewelryModifiers.UNDYING.getId()) > 0) {
                        entity.setHealth(1.0F);
                        entity.removeAllEffects();
                        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
                        entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                        entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
                        ToolDamageUtil.damage(tool, 300, entity, stackInSlot);
                        event.setCanceled(true);
                    }
                }
            });
        }
    }
}
