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

package sct.hexxitgear.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import sct.hexxitgear.HexRegistry;
import sct.hexxitgear.HexxitGear;
import sct.hexxitgear.gui.HGCreativeTab;
import sct.hexxitgear.util.IHasModel;

public class BlockHexbiscus extends BlockBush implements IHasModel {

	public BlockHexbiscus() {
		setCreativeTab(HGCreativeTab.tab);
		setRegistryName("hexbiscus");
		setUnlocalizedName(HexxitGear.MODID + ".hexbiscus");
		HexRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}

	public Item getItemDropped(int p_149650_1_, Random rand, int p_149650_3_) {
		return HexRegistry.HEXICAL_ESSENCE;
	}

	public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> items) {
		items.add(new ItemStack(this));
	}

	@Override
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
