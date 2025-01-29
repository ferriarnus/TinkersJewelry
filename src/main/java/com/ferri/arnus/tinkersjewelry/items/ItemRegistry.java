package com.ferri.arnus.tinkersjewelry.items;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.ferri.arnus.tinkersjewelry.TinkersJewelry;
import com.ferri.arnus.tinkersjewelry.tools.JewelryDefinitions;
import com.ferri.arnus.tinkersjewelry.tools.stats.GemMaterialStats;
import com.ferri.arnus.tinkersjewelry.tools.stats.BlankBandMaterialStats;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.item.TooltipItem;
import slimeknights.mantle.registration.deferred.SynchronizedDeferredRegister;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.MaterialVariantId;
import slimeknights.tconstruct.library.tools.helper.ToolBuildHandler;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;
import slimeknights.tconstruct.library.tools.part.ToolPartItem;
import slimeknights.tconstruct.tables.TinkerTables;

public class ItemRegistry {

	protected static final SynchronizedDeferredRegister<CreativeModeTab> CREATIVE_TABS = SynchronizedDeferredRegister.create(Registries.CREATIVE_MODE_TAB, TinkersJewelry.MODID);

	private static final Item.Properties PARTS_PROPS = new Item.Properties();
	
	private static final ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(TinkersJewelry.MODID);
	
	
	public static void registerItems() {
		CREATIVE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	//Materials
	public static final ItemObject<Item> BLOODGEM = ITEMS.register("bloodgem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> BLAZINGGEM = ITEMS.register("blazinggem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> POISONGEM = ITEMS.register("poisongem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> SPEEDGEM = ITEMS.register("speedgem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> CLEANSEGEM = ITEMS.register("cleansegem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> NIGHTVISIONGEM = ITEMS.register("nightvisiongem", () -> new TooltipItem(new Item.Properties()));

	//Toolparts
	public static final ItemObject<ToolPartItem> BLANK_BAND = ITEMS.register("blank_band", () -> new ToolPartItem(PARTS_PROPS, BlankBandMaterialStats.ID));
	public static final ItemObject<ToolPartItem> GEM = ITEMS.register("gem", () -> new ToolPartItem(PARTS_PROPS, GemMaterialStats.ID));

	//Tools
	public static final ItemObject<CuriosRingItem> RING = ITEMS.register("ring", () -> new CuriosRingItem(PARTS_PROPS, JewelryDefinitions.RING));

	public static final RegistryObject<CreativeModeTab> tabTools = CREATIVE_TABS.register(
			"tools", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + TinkersJewelry.MODID + ".all"))
					.icon(() -> {
						MaterialVariantId material;
						if (MaterialRegistry.isFullyLoaded()) {
							material = ToolBuildHandler.RANDOM.getMaterial(GemMaterialStats.ID, RandomSource.create());
						} else {
							material = ToolBuildHandler.getRenderMaterial(0);
						}
						return GEM.get().withMaterialForDisplay(material);
					})
					.displayItems(ItemRegistry::addTabItems)
					.withTabsBefore(TinkerTables.tabTables.getId())
					.build());

	private static void addTabItems(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output tab) {
		Consumer<ItemStack> output = tab::accept;
		acceptTool(output, RING);
		accept(output, BLANK_BAND);
		accept(output, GEM);
	}

	private static void acceptTool(Consumer<ItemStack> output, Supplier<? extends IModifiable> tool) {
		ToolBuildHandler.addVariants(output, tool.get(), "");
	}

	private static void accept(Consumer<ItemStack> output, Supplier<? extends IMaterialItem> item) {
		item.get().addVariants(output, "");
	}
}
