package sct.hexxitgear.net.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sct.hexxitgear.core.ability.AbilityHandler;

public class AbilityMessage implements IMessage {

	int entityId;

	public AbilityMessage() {
	}

	public AbilityMessage(EntityPlayer player) {
		entityId = player.getEntityId();
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		buf.writeInt(entityId);

	}

	@Override
	public void toBytes(ByteBuf buf) {
		entityId = buf.readInt();

	}

	public static class AbiltiyMessageHandler implements IMessageHandler<AbilityMessage, IMessage> {

		@Override
		public IMessage onMessage(AbilityMessage message, MessageContext ctx) {
			Entity k = Minecraft.getMinecraft().world.getEntityByID(message.entityId);
			if (k instanceof EntityPlayer) {
				AbilityHandler.readAbilityPacket(EntityPlayer.getUUID(((EntityPlayer) k).getGameProfile()));
			}
			return null;
		}

	}

}
