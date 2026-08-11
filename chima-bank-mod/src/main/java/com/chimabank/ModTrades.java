package com.chimabank;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;

/**
 * 銀行員(banker)の取引内容。
 *
 * レベル1(見習い): ダイヤ・鉄・紙幣同士の両替
 * レベル2(見習い上位): 小物の防具・道具(5000円)
 * レベル3(一人前)     : 武器・道具(10000円)
 * レベル4(熟練)       : 大型防具(10000円×2)
 * レベル5(達人)       : トライデント・エリトラ(10000円×2、レア枠)
 */
public class ModTrades {

	public static void registerTrades() {

		// ===== レベル1: 見習い =====
		TradeOfferHelper.registerVillagerOffers(ModProfessions.BANKER, 1, factories -> {

			// ダイヤ ⇔ 壱万円札
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 1),
					new ItemStack(ModItems.NOTE_10000, 1),
					8, 20, 0.05f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_10000, 1),
					new ItemStack(Items.DIAMOND, 1),
					8, 20, 0.05f));

			// 鉄インゴット ⇔ 千円札
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.IRON_INGOT, 1),
					new ItemStack(ModItems.NOTE_1000, 1),
					16, 5, 0.05f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_1000, 1),
					new ItemStack(Items.IRON_INGOT, 1),
					16, 5, 0.05f));

			// 紙幣同士の両替
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_100, 10),
					new ItemStack(ModItems.NOTE_1000, 1),
					32, 2, 0.02f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_1000, 1),
					new ItemStack(ModItems.NOTE_100, 10),
					32, 2, 0.02f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_1000, 5),
					new ItemStack(ModItems.NOTE_5000, 1),
					32, 2, 0.02f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_5000, 1),
					new ItemStack(ModItems.NOTE_1000, 5),
					32, 2, 0.02f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_5000, 2),
					new ItemStack(ModItems.NOTE_10000, 1),
					16, 5, 0.02f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_10000, 1),
					new ItemStack(ModItems.NOTE_5000, 2),
					16, 5, 0.02f));
		});

		// ===== レベル2: 小物の防具・道具 (5000円) =====
		TradeOfferHelper.registerVillagerOffers(ModProfessions.BANKER, 2, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_5000, 1),
					new ItemStack(ModArmorItems.BANKER_HELMET, 1),
					4, 15, 0.05f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_5000, 1),
					new ItemStack(ModArmorItems.BANKER_BOOTS, 1),
					4, 15, 0.05f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_5000, 1),
					new ItemStack(ModItems.BANKER_HOE, 1),
					4, 10, 0.05f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_5000, 1),
					new ItemStack(ModItems.BANKER_SHOVEL, 1),
					4, 10, 0.05f));
		});

		// ===== レベル3: 武器・主要な道具 (10000円) =====
		TradeOfferHelper.registerVillagerOffers(ModProfessions.BANKER, 3, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_10000, 1),
					new ItemStack(ModItems.BANKER_SWORD, 1),
					4, 30, 0.05f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_10000, 1),
					new ItemStack(ModItems.BANKER_AXE, 1),
					4, 30, 0.05f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_10000, 1),
					new ItemStack(ModItems.BANKER_PICKAXE, 1),
					4, 20, 0.05f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_10000, 1),
					new ItemStack(ModItems.BANKER_BOW, 1),
					4, 20, 0.05f));
		});

		// ===== レベル4: 大型防具 (10000円 × 2) =====
		TradeOfferHelper.registerVillagerOffers(ModProfessions.BANKER, 4, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_10000, 2),
					new ItemStack(ModArmorItems.BANKER_CHESTPLATE, 1),
					3, 30, 0.05f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_10000, 2),
					new ItemStack(ModArmorItems.BANKER_LEGGINGS, 1),
					3, 30, 0.05f));
		});

		// ===== レベル5: 達人限定のレアアイテム (10000円 × 2、少ない在庫) =====
		TradeOfferHelper.registerVillagerOffers(ModProfessions.BANKER, 5, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_10000, 2),
					new ItemStack(ModItems.BANKER_TRIDENT, 1),
					2, 30, 0.05f));
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NOTE_10000, 2),
					new ItemStack(ModArmorItems.BANKER_ELYTRA, 1),
					2, 30, 0.05f));
		});
	}
}
