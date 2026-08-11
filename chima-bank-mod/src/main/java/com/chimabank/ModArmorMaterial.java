package com.chimabank;

import java.util.EnumMap;
import java.util.function.Supplier;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

/**
 * 銀行家シリーズ防具の素材。数値はネザライトと同じ(耐久・防御力・靭性など)にして、
 * 見た目(装備テクスチャ)だけ独自のものに差し替えている。
 * 装備中の見た目は assets/chimabank/textures/models/armor/chimabank_banker_layer_1(2).png を参照する。
 */
public enum ModArmorMaterial implements ArmorMaterial {
	BANKER(
			"chimabank_banker",
			37, // ネザライトと同じ耐久倍率
			Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 3);
				map.put(ArmorItem.Type.LEGGINGS, 6);
				map.put(ArmorItem.Type.CHESTPLATE, 8);
				map.put(ArmorItem.Type.HELMET, 3);
			}),
			15,
			SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
			3.0F,
			0.1F,
			() -> Ingredient.ofItems(Items.NETHERITE_INGOT)
	);

	private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 13);
		map.put(ArmorItem.Type.LEGGINGS, 15);
		map.put(ArmorItem.Type.CHESTPLATE, 16);
		map.put(ArmorItem.Type.HELMET, 11);
	});

	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<ArmorItem.Type, Integer> protectionAmounts;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairIngredientSupplier;

	ModArmorMaterial(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionAmounts,
					  int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance,
					  Supplier<Ingredient> repairIngredientSupplier) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.protectionAmounts = protectionAmounts;
		this.enchantability = enchantability;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredientSupplier = repairIngredientSupplier;
	}

	@Override
	public int getDurability(ArmorItem.Type type) {
		return BASE_DURABILITY.get(type) * this.durabilityMultiplier;
	}

	@Override
	public int getProtectionAmount(ArmorItem.Type type) {
		return this.protectionAmounts.get(type);
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredientSupplier.get();
	}

	@Override
	public String getName() {
		// namespace:path の形式で返すことで、専用テクスチャ
		// (chimabank:textures/models/armor/chimabank_banker_layer_1.png など)が参照される
		return ChimaBank.MOD_ID + ":" + this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
