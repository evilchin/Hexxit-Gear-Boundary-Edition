package sct.hexxitgear.net.packets;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class HexxitGearPacketBase {
	public abstract void write(ByteArrayDataOutput out);

	public abstract void read(ByteArrayDataInput in);

	@SideOnly(Side.CLIENT)
	public abstract void handleClient(World world, EntityPlayer player);

	public abstract void handleServer(World world, EntityPlayerMP player);
}
