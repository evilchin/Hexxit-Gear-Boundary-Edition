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

package sct.hexxitgear;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sct.hexxitgear.core.ArmorSet;
import sct.hexxitgear.init.HexConfig;
import sct.hexxitgear.init.HexRegistry;
import sct.hexxitgear.item.ItemHexxitArmor;
import sct.hexxitgear.net.HexNetwork;
import sct.hexxitgear.world.HexGenerator;

@Mod(modid = HexxitGear.MODID, name = HexxitGear.MODNAME, version = HexxitGear.VERSION, dependencies = "required-after:placebo@[2.0.0,)")
public class HexxitGear {

	public static final String MODID = "hexxitgear";
	public static final String MODNAME = "Hexxit Gear";
	public static final String VERSION = "3.0.0";

	public static final Logger LOGGER = LogManager.getLogger(MODID);
	public static final List<ItemHexxitArmor> ARMOR_LIST = new ArrayList<>();

	@EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
		HexConfig.load(new Configuration(evt.getSuggestedConfigurationFile()));
		MinecraftForge.EVENT_BUS.register(new HexRegistry());
	}

	@EventHandler
	public void init(FMLInitializationEvent evt) {
		HexNetwork.init();
		MinecraftForge.TERRAIN_GEN_BUS.register(new HexGenerator());
		MinecraftForge.EVENT_BUS.register(ArmorSet.class);
	}

}
