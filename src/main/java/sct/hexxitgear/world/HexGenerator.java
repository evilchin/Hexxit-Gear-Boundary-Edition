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

package sct.hexxitgear.world;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sct.hexxitgear.init.HexConfig;
import sct.hexxitgear.init.HexRegistry;

public class HexGenerator {

	@SubscribeEvent
	public void generate(DecorateBiomeEvent.Decorate event) {
		if (event.getType() != DecorateBiomeEvent.Decorate.EventType.FLOWERS) return;
		World world = event.getWorld();
		BlockPos start = event.getChunkPos().getBlock(8, 0, 8);
		Random random = event.getRand();

		if (HexConfig.getDimBlacklist().contains(world.provider.getDimension())) return;
		int tries = random.nextInt(2);

		for (int i = 0; i < tries; i++) {
			int x = start.getX() + random.nextInt(6) - random.nextInt(6);
			int z = start.getZ() + random.nextInt(6) - random.nextInt(6);
			BlockPos pos = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z));
			if ((world.getBlockState(pos).getBlock().isReplaceable(world, pos)) && HexRegistry.HEXBISCUS.canBlockStay(world, pos, HexRegistry.HEXBISCUS.getDefaultState())) {
				if (random.nextInt(HexConfig.getHexbiscusChance()) > 1) continue;
				world.setBlockState(pos, HexRegistry.HEXBISCUS.getDefaultState());
			}
		}
	}
}
