package com.chimabank;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * 銀行家シリーズの防具一式(ネザライト相当)とエリトラ。
 * ※エリトラは装備中(背中)の見た目を差し替えるには専用の描画コードが必要なため、
 *   本MODではアイテムアイコンのみ変更し、装備中の見た目はバニラのエリトラのままになる。
 */
public class ModArmorItems {

	public static final Item BANKER_HELMET = registerItem("banker_helmet",
			new ArmorItem(ModArmorMaterial.BANKER, ArmorItem.Type.HELMET, new Item.Settings().fireproof()));
	public static final Item BANKER_CHESTPLATE = registerItem("banker_chestplate",
			new ArmorItem(ModArmorMaterial.BANKER, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()));
	public static final Item BANKER_LEGGINGS = registerItem("banker_leggings",
			new ArmorItem(ModArmorMaterial.BANKER, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()));
	public static final Item BANKER_BOOTS = registerItem("banker_boots",
			new ArmorItem(ModArmorMaterial.BANKER, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()));
	public static final Item BANKER_ELYTRA = registerItem("banker_elytra",
			new ElytraItem(new Item.Settings().maxDamage(432).fireproof()));

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(ChimaBank.MOD_ID, name), item);
	}

	public static void registerItems() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.add(BANKER_HELMET);
			entries.add(BANKER_CHESTPLATE);
			entries.add(BANKER_LEGGINGS);
			entries.add(BANKER_BOOTS);
			entries.add(BANKER_ELYTRA);
		});
	}
}
