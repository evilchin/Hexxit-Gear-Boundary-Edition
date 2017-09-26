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

package sct.hexxitgear.setup;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import sct.hexxitgear.HexRegistry;

public class HexxitGearRegistry {

	public static void init() {
		registerRecipes();
	}

	public static void registerRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.HEXICAL_DIAMOND), " I ", "IDI", " I ", 'I', HexRegistry.HEXICAL_ESSENCE, 'D', Items.DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.TRIBAL_HELMET), "BBB", "BHB", "   ", 'B', Items.BONE, 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.TRIBAL_CHEST), "I I", "LHL", "ILI", 'I', "ingotIron", 'L', Items.LEATHER, 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.TRIBAL_LEGS), "LLL", "IHI", "L L", 'I', "ingotIron", 'L', Items.LEATHER, 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.TRIBAL_BOOTS), "   ", "SHS", "L L", 'S', Items.STRING, 'L', Items.LEATHER, 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.THIEF_HELMET), "RRR", "RHR", "   ", 'R', new ItemStack(Blocks.WOOL, 1, 14), 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.THIEF_CHEST), "R R", "LHL", "LLL", 'R', new ItemStack(Blocks.WOOL, 1, 14), 'L', Items.LEATHER, 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.THIEF_LEGS), "LSL", "LHL", "L L", 'L', Items.LEATHER, 'S', Items.STRING, 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.THIEF_BOOTS), "   ", "LHL", "B B", 'L', Items.LEATHER, 'H', HexRegistry.HEXICAL_DIAMOND, 'B', new ItemStack(Blocks.WOOL, 1, 7)));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.SCALE_HELMET), "GOG", "OHO", "   ", 'G', "ingotGold", 'O', Blocks.OBSIDIAN, 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.SCALE_CHEST), "G G", "OHO", "GOG", 'G', "ingotGold", 'O', Blocks.OBSIDIAN, 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.SCALE_LEGS), "OOO", "GHG", "O O", 'O', Blocks.OBSIDIAN, 'G', "ingotGold", 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.SCALE_BOOTS), "   ", "OHO", "O O", 'O', Blocks.OBSIDIAN, 'H', HexRegistry.HEXICAL_DIAMOND));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.MAGIC_HELMET), " B ", "OHO", "W W", 'B', Items.BOOK, 'O', Blocks.OBSIDIAN, 'H', HexRegistry.HEXICAL_DIAMOND, 'W', Blocks.WOOL));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.MAGIC_CHEST), "G G", "WHW", "GBG", 'G', "ingotGold", 'W', Blocks.WOOL, 'H', HexRegistry.HEXICAL_DIAMOND, 'B', Items.BOOK));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.MAGIC_LEGS), "GBG", "WHW", "G G", 'G', "ingotGold", 'W', Blocks.WOOL, 'H', HexRegistry.HEXICAL_DIAMOND, 'B', Items.BOOK));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(HexRegistry.MAGIC_BOOTS), "WHW", "G G", 'G', "ingotGold", 'W', Blocks.WOOL, 'H', HexRegistry.HEXICAL_DIAMOND));

		/* Add repair recipes */
		GameRegistry.addShapelessRecipe(new ItemStack(HexRegistry.TRIBAL_HELMET, 1, 0), new ItemStack(HexRegistry.TRIBAL_HELMET, 1, OreDictionary.WILDCARD_VALUE), HexRegistry.HEXICAL_ESSENCE);
	}
}
