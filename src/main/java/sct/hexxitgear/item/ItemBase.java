package sct.hexxitgear.item;

import net.minecraft.item.Item;
import sct.hexxitgear.HexRegistry;
import sct.hexxitgear.HexxitGear;
import sct.hexxitgear.gui.HGCreativeTab;

public class ItemBase extends Item{

	public ItemBase(String regname) {
		setRegistryName(HexxitGear.MODID, regname);
		setUnlocalizedName(HexxitGear.MODID + "." + regname);
		setCreativeTab(HGCreativeTab.tab);
		HexRegistry.ITEMS.add(this);
	}

}
