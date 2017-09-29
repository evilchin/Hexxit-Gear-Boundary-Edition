package sct.hexxitgear.net;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sct.hexxitgear.HexxitGear;
import sct.hexxitgear.core.ability.Ability;

public class ActionTextMessage implements IMessage {

	private int messageId;
	private int abilityId;

	public ActionTextMessage() {
	}

	public ActionTextMessage(int id1, int id2) {
		messageId = id1;
		abilityId = id2;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(messageId);
		buf.writeInt(abilityId);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		messageId = buf.readInt();
		abilityId = buf.readInt();
	}

	public static class ActionTextHandler implements IMessageHandler<ActionTextMessage, IMessage> {

		@Override
		public IMessage onMessage(ActionTextMessage message, MessageContext ctx) {
			Ability ability = Ability.ABILITIES.get(message.abilityId);
			if (ability.isInstant() && message.messageId == 2) return null;
			switch (message.messageId) {
			case 0:
				HexxitGear.proxy.setActionText(new TextComponentTranslation("ability.hexxitgear.cooldown", new TextComponentTranslation(ability.getName())));
				break;
			case 1:
				HexxitGear.proxy.setActionText(new TextComponentTranslation("ability.hexxitgear.activated", new TextComponentTranslation(ability.getName())));
				break;
			case 2:
				HexxitGear.proxy.setActionText(new TextComponentTranslation("ability.hexxitgear.ended", new TextComponentTranslation(ability.getName())));
				break;
			case 3:
				HexxitGear.proxy.setActionText(new TextComponentTranslation("ability.hexxitgear.refreshed", new TextComponentTranslation(ability.getName())));
				break;
			default:
				break;
			}

			return null;
		}

	}

}
