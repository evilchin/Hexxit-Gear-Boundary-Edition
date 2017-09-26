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
import net.minecraft.entity.player.EntityPlayerMP;
import sct.hexxitgear.core.ArmorSet;
import sct.hexxitgear.net.ActionTextMessage;
import sct.hexxitgear.net.HexNetwork;

public class AbilityHandler {

	private int activeTime;
	private int cooldownTime;
	private Ability ability;
	private boolean ended = false;

	private static final Map<UUID, AbilityHandler> CURRENT = new HashMap<>();

	private AbilityHandler(EntityPlayer player) {
		if (player.world.isRemote) throw new IllegalArgumentException("Ability handler has been constructed on a client world, please report this!");
		this.ability = ArmorSet.getCurrentArmorSet(player).getAbility();
		this.activeTime = ability.getActive();
		this.cooldownTime = ability.getCooldown();
	}

	public static AbilityHandler getActiveAbility(EntityPlayer player) {
		if (player.world.isRemote) return null;
		return CURRENT.get(player.getUniqueID());
	}

	public static void activateAbility(EntityPlayer player) {
		if (CURRENT.get(player.getUniqueID()) != null) {
			Ability ability = CURRENT.get(player.getUniqueID()).ability;
			HexNetwork.INSTANCE.sendTo(new ActionTextMessage(0, ability.getId()), (EntityPlayerMP) player);
			return;
		}
		AbilityHandler handler = new AbilityHandler(player);
		CURRENT.put(player.getUniqueID(), handler);
	}

	public void onTick(EntityPlayer player) {
		if (activeTime > 0) {
			if (ability != null) {
				if (ability.getActive() == activeTime || ability.isInstant()) {
					HexNetwork.INSTANCE.sendTo(new ActionTextMessage(1, ability.getId()), (EntityPlayerMP) player);
				}
				ability.start(player);
				if (ability.isInstant()) activeTime = 0;
			}
			activeTime--;
		} else if (cooldownTime > 0) {
			if (ability != null && !ended) {
				ability.end(player);
				ended = true;
				HexNetwork.INSTANCE.sendTo(new ActionTextMessage(2, ability.getId()), (EntityPlayerMP) player);
			}
			cooldownTime--;
		} else {
			HexNetwork.INSTANCE.sendTo(new ActionTextMessage(3, ability.getId()), (EntityPlayerMP) player);
			ability = null;
			CURRENT.remove(player.getUniqueID());
		}
	}
}
