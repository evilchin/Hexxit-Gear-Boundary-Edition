package sct.hexxitgear.net;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sct.hexxitgear.client.HexClient;
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
			Minecraft.getMinecraft().addScheduledTask(() -> {
				Ability ability = Ability.ABILITIES.get(message.abilityId);
				if (ability.isInstant() && message.messageId == 2) return;
				switch (message.messageId) {
				case 0:
					HexClient.setActionText(new TextComponentTranslation("ability.hexxitgear.cooldown", new TextComponentTranslation(ability.getUnlocalizedName())));
					break;
				case 1:
					HexClient.setActionText(new TextComponentTranslation("ability.hexxitgear.activated", new TextComponentTranslation(ability.getUnlocalizedName())));
					break;
				case 2:
					HexClient.setActionText(new TextComponentTranslation("ability.hexxitgear.ended", new TextComponentTranslation(ability.getUnlocalizedName())));
					break;
				case 3:
					HexClient.setActionText(new TextComponentTranslation("ability.hexxitgear.refreshed", new TextComponentTranslation(ability.getUnlocalizedName())));
					break;
				case 4:
					HexClient.setActionText(new TextComponentTranslation("ability.hexxitgear.needxp", new TextComponentTranslation(ability.getUnlocalizedName())));
					break;
				case 5:
					HexClient.setActionText(new TextComponentTranslation("ability.hexxitgear.needfood", new TextComponentTranslation(ability.getUnlocalizedName())));
					break;
				default:
					break;
				}
			});
			return null;
		}

	}

}
