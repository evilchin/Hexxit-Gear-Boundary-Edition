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

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import sct.hexxitgear.HexRegistry;
import sct.hexxitgear.HexxitGear;
import sct.hexxitgear.core.AbilityHandler;
import sct.hexxitgear.core.ArmorSet;
import sct.hexxitgear.gui.HGCreativeTab;
import sct.hexxitgear.util.HexUtils;
import sct.hexxitgear.util.IHasModel;

public class ItemHexxitArmor extends ItemArmor implements ISpecialArmor, IHasModel {

	public ItemHexxitArmor(String regname, ArmorMaterial material, int renderindex, EntityEquipmentSlot slot) {
		super(material, renderindex, slot);
		setCreativeTab(HGCreativeTab.tab);
		setRegistryName(HexxitGear.MODID, regname);
		setUnlocalizedName(HexxitGear.MODID + "." + regname);
		HexRegistry.ITEMS.add(this);
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		return new ArmorProperties(1, damageReduceAmount / 22D, armor.getMaxDamage() + 1);
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return damageReduceAmount;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		if (entity instanceof EntityPlayer && !(((EntityPlayer) entity).capabilities.isCreativeMode)) {
			if (stack.getItemDamage() < stack.getMaxDamage()) {
				stack.setItemDamage(stack.getItemDamage() + 1);
			} else {
				HexUtils.setEmpty(stack);
			}
		}
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (world.isRemote) return;
		if (this.armorType != EntityEquipmentSlot.HEAD) return;

		ArmorSet set = ArmorSet.getCurrentArmorSet(player);
		if (set != null) set.applyBuffs(player);

		AbilityHandler handler = AbilityHandler.getActiveAbility(player);

		if (handler != null) {
			handler.onTick(player);
		}

		if (set != null) ArmorSet.CACHED_SETS.put(player.getUniqueID(), set);
	}

	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {
		return TextFormatting.YELLOW + super.getItemStackDisplayName(par1ItemStack);
	}
}
