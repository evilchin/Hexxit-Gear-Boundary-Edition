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

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public abstract class Ability {
	
	public static final List<Ability> ABILITIES = new ArrayList<>();
	private static int curId = 0;

	private final String name;
	private final int active;
	private final int cooldown;
	private final boolean instant;
	private final int id;

	/**
	 * Generates an ability
	 * @param name The ability name
	 * @param active The active duration (in ticks)
	 * @param cooldown The cooldown (in ticks)
	 */
	public Ability(String name, int active, int cooldown) {
		this.name = name;
		this.active = active;
		this.cooldown = cooldown;
		this.instant = false;
		id = curId++;
		ABILITIES.add(this);
	}
	
	/**
	 * Generates an instant ability
	 * @param name The ability name
	 * @param cooldown The cooldown (in ticks)
	 */
	public Ability(String name, int cooldown) {
		this.name = name;
		this.active = 1;
		this.cooldown = cooldown;
		this.instant = true;
		id = curId++;
		ABILITIES.add(this);
	}

	public String getName() {
		return name;
	}

	public int getActive() {
		return active;
	}

	public int getCooldown() {
		return cooldown;
	}

	public boolean isInstant() {
		return instant;
	}
	
	public int getId() {
		return id;
	}

	public abstract void start(EntityPlayer player);

	public abstract void end(EntityPlayer player);
}
