package sct.hexxitgear.util;

import net.minecraft.item.ItemStack;

public class HexUtils {

	public static boolean isEmpty(ItemStack stack) {
		return stack == null;
	}

	public static void setEmpty(ItemStack stack) {
		stack = null;
	}

}
