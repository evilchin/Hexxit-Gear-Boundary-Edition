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

package sct.hexxitgear.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import sct.hexxitgear.control.HexKeybinds;
import sct.hexxitgear.init.HexRegistry;
import sct.hexxitgear.util.IHasModel;

@EventBusSubscriber(Side.CLIENT)
public class ClientProxy implements IProxy {

	@Override
	public void registerKeybinds() {
		MinecraftForge.EVENT_BUS.register(new HexKeybinds());
	}

	@SubscribeEvent
	public static void modelRegistry(ModelRegistryEvent e) {
		for (Item i : HexRegistry.ITEMS)
			if (i instanceof IHasModel) ((IHasModel) i).initModel();
		HexRegistry.HEXBISCUS.initModel();
	}

	@Override
	public void setActionText(ITextComponent message) {
		Minecraft.getMinecraft().ingameGUI.setOverlayMessage(message, false);
	}

}
