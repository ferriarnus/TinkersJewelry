package com.ferri.arnus.tinkersjewelry.items;

import java.util.ArrayList;
import java.util.List;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.tools.JewelryDefinitions;
import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.RingPartMaterialStats;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import slimeknights.mantle.item.TooltipItem;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.mantle.util.SupplierCreativeTab;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.IMaterial;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;

public class ItemRegistry {
	
	public static final CreativeModeTab TAB_TOOL_PARTS = new SupplierCreativeTab(TinkersJewelry.MODID, "tool_parts", () -> {
		List<IMaterial> materials = new ArrayList<>(MaterialRegistry.getInstance().getVisibleMaterials());
		if (materials.isEmpty()) {
			return new ItemStack(ItemRegistry.BOWHANDLE);
		}
		return ItemRegistry.BOWHANDLE.get().withMaterial(materials.get(TConstruct.RANDOM.nextInt(materials.size())).getIdentifier());
	});
	private static final Item.Properties PARTS_PROPS = new Item.Properties().tab(TAB_TOOL_PARTS);
	
	private static final ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(TinkersJewelry.MODID);
	
	
	public static void registerItems() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	//Materials
	public static final ItemObject<Item> BLOODGEM = ITEMS.register("bloodgem", () -> new TooltipItem(new Item.Properties().tab(TAB_TOOL_PARTS)));
	
	//Toolparts
	public static final ItemObject<ToolPartItem> BOWHANDLE = ITEMS.register("bowhandle", () -> new ToolPartItem(PARTS_PROPS, HeadMaterialStats.ID));
	public static final ItemObject<ToolPartItem> RINGPART = ITEMS.register("ringpart", () -> new ToolPartItem(PARTS_PROPS, RingPartMaterialStats.ID));
	public static final ItemObject<ToolPartItem> GEM = ITEMS.register("gem", () -> new ToolPartItem(PARTS_PROPS, GemMaterialStats.ID));

	//Tools
	public static final ItemObject<ModifiableItem> BOW = ITEMS.register("bow", () -> new ModifiableItem(PARTS_PROPS, JewelryDefinitions.BOW));
	public static final ItemObject<CuriosRingItem> RING = ITEMS.register("ring", () -> new CuriosRingItem(PARTS_PROPS, JewelryDefinitions.RING));
}
