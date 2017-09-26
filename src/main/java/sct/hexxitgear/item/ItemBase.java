package sct.hexxitgear.item;

import net.minecraft.item.Item;
import sct.hexxitgear.HexRegistry;
import sct.hexxitgear.HexxitGear;
import sct.hexxitgear.gui.HGCreativeTab;
import sct.hexxitgear.util.IHasModel;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String regname) {
		setRegistryName(HexxitGear.MODID, regname);
		setUnlocalizedName(HexxitGear.MODID + "." + regname);
		setCreativeTab(HGCreativeTab.tab);
		HexRegistry.ITEMS.add(this);
	}

}
