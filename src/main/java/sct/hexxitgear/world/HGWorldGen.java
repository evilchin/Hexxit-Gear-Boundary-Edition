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
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import sct.hexxitgear.HexRegistry;
import sct.hexxitgear.HexxitGear;

public class HGWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		if (HexxitGear.getDimBlacklist().contains(world.provider.getDimension())) return;

		if (world.getWorldInfo().getTerrainType().getName().equals("flat")) return;

		int xMin = chunkX << 4;
		int zMin = chunkZ << 4;

		int startX = xMin + random.nextInt(16);
		int startZ = zMin + random.nextInt(16);

		int tries = random.nextInt(2);

		for (int i = 0; i < tries; i++) {
			int x = startX + random.nextInt(8) - random.nextInt(8);
			int z = startZ + random.nextInt(8) - random.nextInt(8);
			BlockPos pos = world.getTopSolidOrLiquidBlock(new BlockPos(x, 0, z));

			if ((world.getBlockState(pos).getBlock().isReplaceable(world, pos)) && HexRegistry.HEXBISCUS.canBlockStay(world, pos, HexRegistry.HEXBISCUS.getDefaultState())) {
				if (random.nextInt(50) > 1) continue;

				world.setBlockState(pos, HexRegistry.HEXBISCUS.getDefaultState());
			}
		}
	}
}
