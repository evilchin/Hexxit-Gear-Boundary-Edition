/*
 * HexxitGear
 * Copyright (C) 2013  Ryan Cohen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package sct.hexxitgear.core.ability;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AbilityLift extends Ability {

	public AbilityLift() {
		super("ability.hexxitgear.lift", 5, 900);
	}

	@Override
	public void start(EntityPlayer player) {
		Vec3i lookVec = player.getHorizontalFacing().getDirectionVec();
		BlockPos pos2 = player.getPosition().add(lookVec);
		AxisAlignedBB box = new AxisAlignedBB(pos2.getX(), pos2.getY(), pos2.getZ(), pos2.getX() + lookVec.getX()*5, pos2.getY() + 2, pos2.getZ() + lookVec.getZ()*5).expand(3, 0, 3);
		for (EntityLivingBase e : player.world.getEntitiesWithinAABB(EntityLivingBase.class, box)) {
			if (e != player) e.addVelocity(0, 2, 0);
		}
	}

	@Override
	public void end(EntityPlayer player) {
	}

	@Override
	public void tick(EntityPlayer player, int duration) {
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void renderFirst(EntityPlayer player) {
		BlockPos pos = player.getPosition();
		renderAt(player, 0);
		player.world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_PORTAL_TRIGGER, SoundCategory.PLAYERS, 1, 1, false);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderAt(EntityPlayer player, int duration) {
		Vec3i lookVec = player.getHorizontalFacing().getDirectionVec();
		BlockPos pos2 = player.getPosition().add(lookVec.getX() * duration, 0, lookVec.getZ() * duration);
		for (int k = -1; k < 2; k++)
			for (int i = 0; i < 10; i++)
				player.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, pos2.getX() + 0.5 + k, pos2.getY(), pos2.getZ() + 0.5 + k, 0, (i + 1) * 0.1, 0);
	}
}
