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

package sct.hexxitgear.item;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sct.hexxitgear.HexRegistry;
import sct.hexxitgear.model.ModelScaleHelmet;

public class ItemScaleArmor extends ItemHexxitArmor {

	public ItemScaleArmor(String regname, EntityEquipmentSlot slot) {
		super(regname, ArmorMaterial.DIAMOND, 1, slot);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (slot == EntityEquipmentSlot.HEAD) return "hexxitgear:textures/maps/ScaleHelmet.png";

		if (stack.getItem() == HexRegistry.SCALE_LEGS) return "hexxitgear:textures/armor/scale2.png";

		return "hexxitgear:textures/armor/scale.png";
	}

	@SideOnly(Side.CLIENT)
	private static ModelScaleHelmet scaleHelmet;

	@SideOnly(Side.CLIENT)
	private ModelBiped getHelmet() {
		if (scaleHelmet == null) scaleHelmet = new ModelScaleHelmet();
		return scaleHelmet;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
		if (armorSlot == EntityEquipmentSlot.HEAD) {
			ModelBiped helmet = getHelmet();
			helmet.isSneak = entityLiving.isSneaking();
			return helmet;
		}
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> infoList, boolean par4) {
		infoList.add(TextFormatting.DARK_PURPLE + I18n.format("gui.hexxitgear.set.scale"));
	}
}
