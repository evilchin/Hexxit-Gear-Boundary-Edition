package sct.hexxitgear.net;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import sct.hexxitgear.HexxitGear;
import sct.hexxitgear.net.packets.AbilityActivateMessage;
import sct.hexxitgear.net.packets.AbilityMessage;
import sct.hexxitgear.net.packets.AbilityActivateMessage.AbilityActivateHandler;
import sct.hexxitgear.net.packets.AbilityMessage.AbiltiyMessageHandler;

public class HexxitGearNetwork {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(HexxitGear.MODID);
	static int discrim = 0;
	
	public static void init() {
		INSTANCE.registerMessage(AbiltiyMessageHandler.class, AbilityMessage.class, discrim++, Side.CLIENT);
		INSTANCE.registerMessage(AbilityActivateHandler.class, AbilityActivateMessage.class, discrim++, Side.SERVER);
	}
}