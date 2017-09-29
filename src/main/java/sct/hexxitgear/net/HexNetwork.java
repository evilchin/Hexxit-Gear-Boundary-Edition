package sct.hexxitgear.net;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import sct.hexxitgear.HexxitGear;
import sct.hexxitgear.net.AbilityRenderMessage.AbilityRenderHandler;
import sct.hexxitgear.net.ActionTextMessage.ActionTextHandler;
import sct.hexxitgear.net.ActivateMessage.ActivateMessageHandler;

public class HexNetwork {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(HexxitGear.MODID);
	static int discrim = 0;

	public static void init() {
		INSTANCE.registerMessage(ActivateMessageHandler.class, ActivateMessage.class, discrim++, Side.SERVER);
		INSTANCE.registerMessage(ActionTextHandler.class, ActionTextMessage.class, discrim++, Side.CLIENT);
		INSTANCE.registerMessage(AbilityRenderHandler.class, AbilityRenderMessage.class, discrim++, Side.CLIENT);
	}
}