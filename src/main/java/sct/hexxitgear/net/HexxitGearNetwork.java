package sct.hexxitgear.net;

import java.util.EnumMap;

import com.google.common.collect.Maps;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.FMLEmbeddedChannel;
import net.minecraftforge.fml.common.network.FMLIndexedMessageToMessageCodec;
import net.minecraftforge.fml.common.network.FMLOutboundHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sct.hexxitgear.net.packets.ArmorAbilityPacket;
import sct.hexxitgear.net.packets.CapeChangePacket;
import sct.hexxitgear.net.packets.CapeJoinPacket;
import sct.hexxitgear.net.packets.HexxitGearPacketBase;

@ChannelHandler.Sharable
public class HexxitGearNetwork extends FMLIndexedMessageToMessageCodec<HexxitGearPacketBase> {

    private static final HexxitGearNetwork INSTANCE = new HexxitGearNetwork();
    private static final EnumMap<Side, FMLEmbeddedChannel> channels = Maps.newEnumMap(Side.class);

    public static void init() {
        if (!channels.isEmpty())
            return;

        INSTANCE.addDiscriminator(0, CapeChangePacket.class);
        INSTANCE.addDiscriminator(1, CapeJoinPacket.class);
        INSTANCE.addDiscriminator(2, ArmorAbilityPacket.class);

        channels.putAll(NetworkRegistry.INSTANCE.newChannel("HexxitGear", INSTANCE));
    }

    public void encodeInto(ChannelHandlerContext ctx, HexxitGearPacketBase msg, ByteBuf target) throws Exception {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        msg.write(out);
        target.writeBytes(out.toByteArray());
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, HexxitGearPacketBase msg) {
        ByteArrayDataInput in = ByteStreams.newDataInput(source.array());

        in.skipBytes(1);
        msg.read(in);

        if (FMLCommonHandler.instance().getEffectiveSide().isClient())
            handleClient(msg);
        else
            handleServer(ctx, msg);
    }

    @SideOnly(Side.CLIENT)
    private void handleClient(HexxitGearPacketBase msg) {
        msg.handleClient(Minecraft.getMinecraft().theWorld, Minecraft.getMinecraft().thePlayer);
    }

    private void handleServer(ChannelHandlerContext ctx, HexxitGearPacketBase msg) {
        EntityPlayerMP player = ((NetHandlerPlayServer) ctx.channel().attr(NetworkRegistry.NET_HANDLER).get()).playerEntity;
        msg.handleServer(player.worldObj, player);
    }

    public static void sendToServer(HexxitGearPacketBase packet) {
        channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
        channels.get(Side.CLIENT).writeAndFlush(packet);
    }

    public static void sendToPlayer(HexxitGearPacketBase packet, EntityPlayer player) {
        channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
        channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
        channels.get(Side.SERVER).writeAndFlush(packet);
    }

    public static void sendToAllPlayers(HexxitGearPacketBase packet) {
        channels.get(Side.SERVER).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
        channels.get(Side.SERVER).writeAndFlush(packet);
    }
}