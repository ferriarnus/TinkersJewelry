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
import slimeknights.tconstruct.common.registration.CastItemObject;
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
	public static final ItemObject<Item> BLOOD_GEM = ITEMS.register("blood_gem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> BLAZING_GEM = ITEMS.register("blazing_gem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> POISON_GEM = ITEMS.register("poison_gem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> SPEED_GEM = ITEMS.register("speed_gem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> CLEANSE_GEM = ITEMS.register("cleanse_gem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> NIGHTVISION_GEM = ITEMS.register("nightvision_gem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> EXP_GEM = ITEMS.register("exp_gem", () -> new TooltipItem(new Item.Properties()));
	public static final ItemObject<Item> HEALTH_GEM = ITEMS.register("health_gem", () -> new TooltipItem(new Item.Properties()));

	//Toolparts
	public static final ItemObject<ToolPartItem> BLANK_BAND = ITEMS.register("blank_band", () -> new ToolPartItem(PARTS_PROPS, BlankBandMaterialStats.ID));
	public static final ItemObject<ToolPartItem> GEM = ITEMS.register("gem", () -> new ToolPartItem(PARTS_PROPS, GemMaterialStats.ID));

	//Casts
	public static final CastItemObject BLANK_BAND_CAST = ITEMS.registerCast(BLANK_BAND, PARTS_PROPS);

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
		output.accept(new ItemStack(BLOOD_GEM.get()));
		output.accept(new ItemStack(BLAZING_GEM.get()));
		output.accept(new ItemStack(POISON_GEM.get()));
		output.accept(new ItemStack(SPEED_GEM.get()));
		output.accept(new ItemStack(CLEANSE_GEM.get()));
		output.accept(new ItemStack(NIGHTVISION_GEM.get()));
		output.accept(new ItemStack(EXP_GEM.get()));
		output.accept(new ItemStack(HEALTH_GEM.get()));
		output.accept(new ItemStack(BLANK_BAND_CAST.get()));
		output.accept(new ItemStack(BLANK_BAND_CAST.getSand()));
		output.accept(new ItemStack(BLANK_BAND_CAST.getRedSand()));
	}

	private static void acceptTool(Consumer<ItemStack> output, Supplier<? extends IModifiable> tool) {
		ToolBuildHandler.addVariants(output, tool.get(), "");
	}

	private static void accept(Consumer<ItemStack> output, Supplier<? extends IMaterialItem> item) {
		item.get().addVariants(output, "");
	}
}
