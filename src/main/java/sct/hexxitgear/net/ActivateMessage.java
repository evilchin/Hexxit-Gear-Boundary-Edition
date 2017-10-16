package sct.hexxitgear.net;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sct.hexxitgear.core.AbilityHandler;

public class ActivateMessage implements IMessage {

	public ActivateMessage() {
	}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	@Override
	public void fromBytes(ByteBuf buf) {
	}

	public static class ActivateMessageHandler implements IMessageHandler<ActivateMessage, IMessage> {

		@Override
		public IMessage onMessage(ActivateMessage message, MessageContext ctx) {
			AbilityHandler.activateAbility(ctx.getServerHandler().player);
			return null;
		}

	}

}
