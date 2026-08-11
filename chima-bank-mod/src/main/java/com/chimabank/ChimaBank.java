package com.chimabank;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ちま銀行 MOD のエントリーポイント。
 * アイテム(紙幣)・ブロック(両替カウンター)・村人の職業・取引を登録する。
 */
public class ChimaBank implements ModInitializer {
	public static final String MOD_ID = "chimabank";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModArmorItems.registerItems();
		ModBlocks.registerBlocks();
		ModProfessions.register();
		ModTrades.registerTrades();

		LOGGER.info("[ちま銀行] MOD を読み込みました");
	}
}
