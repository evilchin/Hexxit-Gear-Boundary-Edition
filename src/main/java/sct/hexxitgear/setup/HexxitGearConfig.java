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

package sct.hexxitgear.setup;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sct.hexxitgear.HexxitGear;

public class HexxitGearConfig {

	public static File configFolder;

	public static Configuration config;

	public static void loadCommonConfig(FMLPreInitializationEvent evt) {
		config = new Configuration(evt.getSuggestedConfigurationFile());
		config.load();

		registerDimBlacklist(config.getStringList("Dimensional Blacklist", "worldgen", new String[0], "Newline list of all blacklisted dimension IDs"));

		if (config.hasChanged()) config.save();
	}

	private static void registerDimBlacklist(String[] parsed) {
		for (String dim : parsed) {
			Integer dimID = Integer.parseInt(dim);
			HexxitGear.addToDimBlacklist(dimID);
		}
	}
}
