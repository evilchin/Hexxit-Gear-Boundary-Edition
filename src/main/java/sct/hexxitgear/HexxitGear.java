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

import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sct.hexxitgear.event.PlayerEventHandler;
import sct.hexxitgear.net.HexxitGearNetwork;
import sct.hexxitgear.setup.HexxitGearConfig;
import sct.hexxitgear.setup.HexxitGearRegistry;
import sct.hexxitgear.world.HGWorldGen;

@Mod(modid = HexxitGear.MODID, name = HexxitGear.NAME, useMetadata = true, version = HexxitGear.VERSION)
public class HexxitGear {

	public static final String MODID = "hexxitgear";
	public static final String NAME = "Hexxit Gear";
	public static final String VERSION = "2.0.0";

	@Instance
	public static HexxitGear instance;

	@SidedProxy(clientSide = "sct.hexxitgear.ClientProxy", serverSide = "sct.hexxitgear.CommonProxy")
	public static CommonProxy proxy;

	public static Logger logger;
	public static PlayerEventHandler playerEventHandler;

	public static List<Integer> dimensionalBlacklist = new ArrayList<Integer>();

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
		HexxitGearConfig.loadCommonConfig(evt);
		HexxitGearConfig.registerDimBlacklist();

		logger = evt.getModLog();
		playerEventHandler = new PlayerEventHandler();
		MinecraftForge.EVENT_BUS.register(playerEventHandler);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent evt) {
		HexxitGearNetwork.init();
		GameRegistry.registerWorldGenerator(new HGWorldGen(), 100);
		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent evt) {
		HexxitGearRegistry.init();
	}

	public static void addToDimBlacklist(int dimID) {
		if (!dimensionalBlacklist.contains(dimID)) dimensionalBlacklist.add(dimID);
	}

	public static List<Integer> getDimBlacklist() {
		return dimensionalBlacklist;
	}

	@SideOnly(Side.CLIENT)
	public static void translateAndAdd(String key, List<String> list) {
		for (int i = 0; i < 10; i++) {
			list.add(I18n.format(key + i));
		}
	}

}
