package sct.hexxitgear.net;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sct.hexxitgear.core.ability.Ability;

public class AbilityRenderMessage implements IMessage {

	public AbilityRenderMessage() {
	}

	private int messageId;
	private int abilityId;
	private int player;
	private int duration;

	public AbilityRenderMessage(int messageId, int abilityId, EntityPlayer player, int duration) {
		this.messageId = messageId;
		this.abilityId = abilityId;
		this.player = player.getEntityId();
		this.duration = duration;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(messageId);
		buf.writeInt(abilityId);
		buf.writeInt(player);
		buf.writeInt(duration);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		messageId = buf.readInt();
		abilityId = buf.readInt();
		player = buf.readInt();
		duration = buf.readInt();
	}

	public static class AbilityRenderHandler implements IMessageHandler<AbilityRenderMessage, IMessage> {

		@Override
		public IMessage onMessage(AbilityRenderMessage message, MessageContext ctx) {
			EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().world.getEntityByID(message.player);

			if (message.messageId == 0) Ability.ABILITIES.get(message.abilityId).renderFirst(player);
			else Ability.ABILITIES.get(message.abilityId).renderAt(player, message.duration);
			return null;
		}

	}

}
