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

package sct.hexxitgear.core.ability;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import sct.hexxitgear.core.ArmorSet;
import sct.hexxitgear.net.HexxitGearNetwork;
import sct.hexxitgear.net.packets.AbilityMessage;

public class AbilityHandler {

	public static Map<UUID, AbilityHandler> buffHandlers = new HashMap<>();

	private int activeTime = 0;
	private int cooldownTime = 0;
	private Ability ability;

	public static Map<UUID, AbilityHandler> getBuffHandlers() {
		return buffHandlers;
	}

	public static AbilityHandler getPlayerAbilityHandler(UUID playerId) {
		return buffHandlers.get(playerId);
	}

	public static void removePlayer(EntityPlayer player) {
		buffHandlers.remove(EntityPlayer.getUUID(player.getGameProfile()));
		if (!player.world.isRemote) HexxitGearNetwork.INSTANCE.sendToAll(new AbilityMessage(player));
	}

	public static void readAbilityPacket(UUID playerId) {
		if (!buffHandlers.containsKey(playerId)) buffHandlers.put(playerId, new AbilityHandler(playerId));
		else buffHandlers.remove(playerId);
	}

	public AbilityHandler(UUID playerId) {
		this.ability = ArmorSet.getPlayerArmorSet(playerId).getAbility();
		this.activeTime = ability.getActive();
		this.cooldownTime = ability.getCooldown();
	}

	public void onTick(EntityPlayer player) {
		if (activeTime > 0) {
			if (ability != null) {
				if (ability.getActive() == activeTime) {
					player.sendMessage(new TextComponentTranslation("ability.hexxitgear.activated", ability.getName()));
				}

				ability.start(player);
				if (ability.isInstant()) activeTime = 0;
			}
			activeTime--;
		} else if (cooldownTime > 0) {
			if (ability != null) {
				ability.end(player);
			}
			cooldownTime--;
		} else {
			player.sendMessage(new TextComponentTranslation("ability.hexxitgear.refreshed"));
			removePlayer(player);
		}
	}
}
