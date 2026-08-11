package com.chimabank;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.villager.PointOfInterestHelper;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.village.VillagerProfession;

/**
 * 「銀行員(banker)」という新しい村人の職業。
 * ModBlocks.MONEY_COUNTER を仕事場ブロックとして必要とする。
 */
public class ModProfessions {

	// 仕事場ブロック(MONEY_COUNTER)に対応する Point Of Interest を登録
	public static final PointOfInterestType MONEY_COUNTER_POI = PointOfInterestHelper.register(
			new Identifier(ChimaBank.MOD_ID, "money_counter_poi"),
			1, // 検索半径
			1, // 同時に使えるチケット数(1体の村人がこの仕事場を専有する)
			ModBlocks.MONEY_COUNTER
	);

	// 銀行員の職業本体
	public static final VillagerProfession BANKER = Registry.register(
			Registries.VILLAGER_PROFESSION,
			new Identifier(ChimaBank.MOD_ID, "banker"),
			new VillagerProfession(
					"banker",
					entry -> entry.value() == MONEY_COUNTER_POI,
					entry -> entry.value() == MONEY_COUNTER_POI,
					ImmutableSet.of(),
					ImmutableSet.of(),
					SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN
			)
	);

	public static void register() {
		// このメソッドを呼び出すことで、上記の static フィールドが初期化(=登録)される
		ChimaBank.LOGGER.info("[ちま銀行] 銀行員(banker)の職業を登録しました");
	}
}
