package com.chimabank;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * 銀行員の村人が仕事場として使う「両替カウンター」ブロック。
 * 見た目は木材(oak_planks)のテクスチャを流用したシンプルなブロック。
 */
public class ModBlocks {

	public static final Block MONEY_COUNTER = registerBlock(
			"money_counter",
			new Block(AbstractBlock.Settings.copy(Blocks.LECTERN))
	);

	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, new Identifier(ChimaBank.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block) {
		return Registry.register(
				Registries.ITEM,
				new Identifier(ChimaBank.MOD_ID, name),
				new BlockItem(block, new Item.Settings())
		);
	}

	public static void registerBlocks() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(MONEY_COUNTER));
	}
}
