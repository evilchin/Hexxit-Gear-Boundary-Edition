package sct.hexxitgear.net.packets;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sct.hexxitgear.core.ability.AbilityHandler;

public class AbilityActivateMessage implements IMessage {

	int id;
	
	public AbilityActivateMessage() {
		id = Minecraft.getMinecraft().player.getEntityId();
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		buf.writeInt(id);
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		id = buf.readInt();
		
	}
	
	public static class AbilityActivateHandler implements IMessageHandler<AbilityActivateMessage, IMessage> {

		@Override
		public IMessage onMessage(AbilityActivateMessage message, MessageContext ctx) {
			UUID playerId = EntityPlayer.getUUID(ctx.getServerHandler().playerEntity.getGameProfile());
			AbilityHandler.buffHandlers.put(playerId, new AbilityHandler(playerId));
			return null;
		}
		
	}

}
