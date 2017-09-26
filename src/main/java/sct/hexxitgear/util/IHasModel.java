package sct.hexxitgear.util;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sct.hexxitgear.HexxitGear;

public interface IHasModel {

	@SideOnly(Side.CLIENT)
	default public void initModel() {
		if (this instanceof Item) sMRL("items", (Item) this, 0, "item=" + ((Item) this).getRegistryName().getResourcePath());
		else throw new IllegalStateException("wat are u doin");
	}

	@SideOnly(Side.CLIENT)
	public static void sMRL(String statePath, Item k, int meta, String variant) {
		ModelLoader.setCustomModelResourceLocation(k, meta, new ModelResourceLocation(HexxitGear.MODID + ":" + statePath, variant));
	}

}
