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

package sct.hexxitgear.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import sct.hexxitgear.core.ArmorSet;

public class PlayerEventHandler {

	private int ticks = 0;

	@SubscribeEvent
	public void playerUpdate(LivingEvent.LivingUpdateEvent event) {
		if (ticks > 16) {
			if (event.getEntityLiving() != null && event.getEntityLiving() instanceof EntityPlayer) {
				if (!event.getEntityLiving().world.isRemote) return;
			}
			ticks = 0;
		}
		ticks++;
	}

	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
		ArmorSet.getMatchingSet(event.player);
	}
}
