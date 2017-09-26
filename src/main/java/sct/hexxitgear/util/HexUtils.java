package sct.hexxitgear.util;

import net.minecraft.item.ItemStack;

public class HexUtils {

	public static boolean isEmpty(ItemStack stack) {
		return stack != null && stack.stackSize > 0 && stack.getItem() != null;
	}

}
