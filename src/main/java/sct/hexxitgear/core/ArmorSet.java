/*
 * HexxitGear
 * Copyright (C) 2013  Ryan Cohen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package sct.hexxitgear.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sct.hexxitgear.HexRegistry;
import sct.hexxitgear.core.ability.Ability;
import sct.hexxitgear.core.ability.AbilityInvisibility;
import sct.hexxitgear.core.ability.AbilityKnockback;
import sct.hexxitgear.core.ability.AbilityRegeneration;
import sct.hexxitgear.core.ability.AbilityShield;
import sct.hexxitgear.core.buff.BuffMagicianSet;
import sct.hexxitgear.core.buff.BuffScaleSet;
import sct.hexxitgear.core.buff.BuffThiefSet;
import sct.hexxitgear.core.buff.BuffTribalSet;
import sct.hexxitgear.core.buff.IBuffHandler;
import sct.hexxitgear.util.HexUtils;

public class ArmorSet {

	public static ArmorSet tribalSet = new ArmorSet("Tribal", Arrays.asList(HexRegistry.TRIBAL_HELMET, HexRegistry.TRIBAL_CHEST, HexRegistry.TRIBAL_LEGS, HexRegistry.TRIBAL_BOOTS), new BuffTribalSet(), new AbilityKnockback());
	public static ArmorSet thiefSet = new ArmorSet("Thief", Arrays.asList(HexRegistry.THIEF_HELMET, HexRegistry.THIEF_CHEST, HexRegistry.THIEF_LEGS, HexRegistry.THIEF_BOOTS), new BuffThiefSet(), new AbilityInvisibility());
	public static ArmorSet scaleSet = new ArmorSet("Scale", Arrays.asList(HexRegistry.SCALE_HELMET, HexRegistry.SCALE_CHEST, HexRegistry.SCALE_LEGS, HexRegistry.SCALE_BOOTS), new BuffScaleSet(), new AbilityShield());
	public static ArmorSet magicSet = new ArmorSet("Magician", Arrays.asList(HexRegistry.MAGIC_HELMET, HexRegistry.MAGIC_CHEST, HexRegistry.MAGIC_LEGS, HexRegistry.MAGIC_BOOTS), new BuffMagicianSet(), new AbilityRegeneration());
	private static List<ArmorSet> armorSets;
	private static Map<String, ArmorSet> playerMap = new HashMap<String, ArmorSet>();
	private static List<String> activeArmors = new ArrayList<String>();

	private List<Item> armors = new ArrayList<Item>();
	private String name;
	private IBuffHandler buffHandler;
	private Ability ability;

	public static List<ArmorSet> getArmorSets() {
		return armorSets;
	}

	public static ArmorSet getArmorSetAtIndex(int index) {
		return armorSets.get(index);
	}

	public static void getMatchingSet(EntityPlayer player) {
		List<Item> playerSet = getPlayerArmors(player);

		boolean foundMatch = false;

		for (ArmorSet armorSet : getArmorSets()) {
			int matched = 0;
			for (Item armor : armorSet.getArmors()) {
				if (playerSet.contains(armor)) {
					matched++;
				}
			}
			if (matched == 4) {
				if (getPlayerArmorSet(player.getDisplayName().getFormattedText()) == null || !getPlayerArmorSet(player.getDisplayName().getFormattedText()).equals(armorSet)) {
					addPlayerArmorSet(player.getDisplayName().getFormattedText(), armorSet);
				}
				foundMatch = true;
			}
		}

		if (!foundMatch && getPlayerArmorSet(player.getDisplayName().getFormattedText()) != null) {
			ArmorSet as = getPlayerArmorSet(player.getDisplayName().getFormattedText());
			removePlayerArmorSet(player.getDisplayName().getFormattedText());
			as.removeBuffs(player);
		}
	}

	private static List<Item> getPlayerArmors(EntityPlayer player) {
		List<Item> playerSet = new ArrayList<Item>(4);

		for (ItemStack armor : player.getArmorInventoryList()) {
			if (!HexUtils.isEmpty(armor)) {
				playerSet.add(armor.getItem());
			}
		}

		return playerSet;
	}

	public static ArmorSet getPlayerArmorSet(String playerName) {
		return playerMap.get(playerName);
	}

	public static void addPlayerArmorSet(String playerName, ArmorSet armorSet) {
		playerMap.put(playerName, armorSet);
	}

	public static void removePlayerArmorSet(String playerName) {
		playerMap.remove(playerName);
	}

	public static void readArmorPacket(String playerName) {
		ArmorSet as = getPlayerArmorSet(playerName);
		if (as != null && !activeArmors.contains(playerName)) {
			activeArmors.add(playerName);
		}
	}

	public ArmorSet(String name, List<Item> armor, IBuffHandler buffHandler, Ability ability) {
		this.name = name;
		this.armors = armor;
		this.buffHandler = buffHandler;
		this.ability = ability;

		if (armorSets == null) armorSets = new ArrayList<ArmorSet>();

		armorSets.add(this);
	}

	public String getName() {
		return name;
	}

	public List<Item> getArmors() {
		return armors;
	}

	public Ability getAbility() {
		return ability;
	}

	public void applyBuffs(EntityPlayer player) {
		buffHandler.applyPlayerBuffs(player);
	}

	public void removeBuffs(EntityPlayer player) {
		buffHandler.removePlayerBuffs(player);
	}
}
