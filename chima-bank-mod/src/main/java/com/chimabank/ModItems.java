package com.chimabank;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * 「ちま銀行券」の4種類の紙幣(100円/1000円/5000円/10000円)と、
 * ネザライト相当の性能を持つ「銀行家シリーズ」の道具・武器。
 * 道具類はアイコンに小さな赤いスタンプ(bank_stamp_overlay)を重ねて、
 * 見た目を通常のネザライト装備と少し変えている。
 */
public class ModItems {

	// ===== 紙幣 =====
	public static final Item NOTE_100 = registerItem("note_100", new Item(new Item.Settings().maxCount(64)));
	public static final Item NOTE_1000 = registerItem("note_1000", new Item(new Item.Settings().maxCount(64)));
	public static final Item NOTE_5000 = registerItem("note_5000", new Item(new Item.Settings().maxCount(64)));
	public static final Item NOTE_10000 = registerItem("note_10000", new Item(new Item.Settings().maxCount(64)));

	// ===== 銀行家シリーズ 道具・武器(ネザライト相当の性能) =====
	public static final Item BANKER_SWORD = registerItem("banker_sword",
			new SwordItem(ToolMaterials.NETHERITE, 3, -2.4F, new Item.Settings().fireproof()));
	public static final Item BANKER_PICKAXE = registerItem("banker_pickaxe",
			new PickaxeItem(ToolMaterials.NETHERITE, 1, -2.8F, new Item.Settings().fireproof()));
	public static final Item BANKER_AXE = registerItem("banker_axe",
			new AxeItem(ToolMaterials.NETHERITE, 6.0F, -3.0F, new Item.Settings().fireproof()));
	public static final Item BANKER_SHOVEL = registerItem("banker_shovel",
			new ShovelItem(ToolMaterials.NETHERITE, 1.5F, -3.0F, new Item.Settings().fireproof()));
	public static final Item BANKER_HOE = registerItem("banker_hoe",
			new HoeItem(ToolMaterials.NETHERITE, -3, 0.0F, new Item.Settings().fireproof()));
	public static final Item BANKER_BOW = registerItem("banker_bow",
			new BowItem(new Item.Settings().maxDamage(384).fireproof()));
	public static final Item BANKER_TRIDENT = registerItem("banker_trident",
			new TridentItem(new Item.Settings().maxDamage(250).fireproof()));

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(ChimaBank.MOD_ID, name), item);
	}

	public static void registerItems() {
		// クリエイティブタブ「道具・材料」に紙幣を追加
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.add(NOTE_100);
			entries.add(NOTE_1000);
			entries.add(NOTE_5000);
			entries.add(NOTE_10000);
		});

		// クリエイティブタブ「戦闘」に銀行家シリーズの道具・武器を追加
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.add(BANKER_SWORD);
			entries.add(BANKER_AXE);
			entries.add(BANKER_BOW);
			entries.add(BANKER_TRIDENT);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
			entries.add(BANKER_PICKAXE);
			entries.add(BANKER_SHOVEL);
			entries.add(BANKER_HOE);
		});
	}
}
