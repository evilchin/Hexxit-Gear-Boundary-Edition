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

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import sct.hexxitgear.core.ArmorSet;
import sct.hexxitgear.net.HexNetwork;
import sct.hexxitgear.proxy.IProxy;
import sct.hexxitgear.init.HexConfig;
import sct.hexxitgear.world.HGWorldGen;

@Mod(modid = HexxitGear.MODID, name = HexxitGear.NAME, useMetadata = true, version = HexxitGear.VERSION)
public class HexxitGear {

	public static final String MODID = "hexxitgear";
	public static final String NAME = "Hexxit Gear";
	public static final String VERSION = "2.3.0";

	@Instance
	public static HexxitGear instance;

	@SidedProxy(clientSide = "sct.hexxitgear.proxy.ClientProxy", serverSide = "sct.hexxitgear.proxy.ServerProxy")
	public static IProxy proxy;

	public static Logger logger;

	public static final List<Integer> DIM_BLACKLIST = new ArrayList<Integer>();

	@EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
		HexConfig.loadCommonConfig(evt);
		logger = evt.getModLog();
	}

	@EventHandler
	public void init(FMLInitializationEvent evt) {
		HexNetwork.init();
		GameRegistry.registerWorldGenerator(new HGWorldGen(), 100);
		proxy.registerKeybinds();
		MinecraftForge.EVENT_BUS.register(ArmorSet.class);
	}

	public static void addToDimBlacklist(int id) {
		if (!DIM_BLACKLIST.contains(id)) DIM_BLACKLIST.add(id);
	}

	public static List<Integer> getDimBlacklist() {
		return DIM_BLACKLIST;
	}

}
