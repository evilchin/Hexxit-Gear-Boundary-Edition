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

package sct.hexxitgear.core.buff;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public class BuffMagicianSet implements IBuffHandler {

	@Override
	public void applyPlayerBuffs(EntityPlayer player) {
		player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 45, 4, false, false));
		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 410, 0, false, false));
	}

	@Override
	public void removePlayerBuffs(EntityPlayer player) {
		player.removePotionEffect(MobEffects.JUMP_BOOST);
		player.removePotionEffect(MobEffects.NIGHT_VISION);
	}
}
