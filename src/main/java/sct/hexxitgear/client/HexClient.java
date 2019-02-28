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

package sct.hexxitgear.client;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import sct.hexxitgear.HexxitGear;
import sct.hexxitgear.core.ArmorSet;
import sct.hexxitgear.init.HexRegistry;
import sct.hexxitgear.net.ActivateMessage;
import sct.hexxitgear.net.HexNetwork;
import shadows.placebo.util.PlaceboUtil;

@EventBusSubscriber(modid = HexxitGear.MODID, value = Side.CLIENT)
public class HexClient {

	public static KeyBinding activateHexxitArmor = new KeyBinding("Activate Hexxit Gear Armor", Keyboard.KEY_X, "Hexxit Gear");
	public static KeyBinding[] keybindArray = new KeyBinding[] { activateHexxitArmor };
	public static boolean[] repeats = new boolean[keybindArray.length];

	static {
		ClientRegistry.registerKeyBinding(activateHexxitArmor);
	}

	@SubscribeEvent
	public void keyEvent(InputEvent.KeyInputEvent event) {
		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class) && activateHexxitArmor.isPressed() && ArmorSet.getCurrentArmorSet(Minecraft.getMinecraft().player) != null) HexNetwork.INSTANCE.sendToServer(new ActivateMessage());
	}

	@SubscribeEvent
	public static void modelRegistry(ModelRegistryEvent e) {
		for (Item i : HexxitGear.ARMOR_LIST)
			PlaceboUtil.sMRL(i, 0, "inventory");
		PlaceboUtil.sMRL(HexRegistry.HEXICAL_DIAMOND, 0, "inventory");
		PlaceboUtil.sMRL(HexRegistry.HEXICAL_ESSENCE, 0, "inventory");
		PlaceboUtil.sMRL(HexRegistry.HEXBISCUS, 0, "inventory");
	}

	public static void setActionText(ITextComponent message) {
		Minecraft.getMinecraft().ingameGUI.setOverlayMessage(message, false);
	}

}
