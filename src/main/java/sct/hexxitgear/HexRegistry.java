package sct.hexxitgear;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sct.hexxitgear.block.BlockHexbiscus;
import sct.hexxitgear.item.ItemBase;
import sct.hexxitgear.item.ItemMagicianArmor;
import sct.hexxitgear.item.ItemScaleArmor;
import sct.hexxitgear.item.ItemThiefArmor;
import sct.hexxitgear.item.ItemTribalArmor;

@EventBusSubscriber
public class HexRegistry {

	public static final List<Item> ITEMS = new ArrayList<>();

	public static final BlockHexbiscus HEXBISCUS = new BlockHexbiscus();

	public static final Item HEXICAL_ESSENCE = new ItemBase("hexical_essence");
	public static final Item HEXICAL_DIAMOND = new ItemBase("hexical_diamond");

	public static final ItemTribalArmor TRIBAL_HELMET = new ItemTribalArmor("tribal_helmet", EntityEquipmentSlot.HEAD);
	public static final ItemTribalArmor TRIBAL_CHEST = new ItemTribalArmor("tribal_chest", EntityEquipmentSlot.CHEST);
	public static final ItemTribalArmor TRIBAL_LEGS = new ItemTribalArmor("tribal_legs", EntityEquipmentSlot.LEGS);
	public static final ItemTribalArmor TRIBAL_BOOTS = new ItemTribalArmor("tribal_boots", EntityEquipmentSlot.FEET);

	public static final Item THIEF_HELMET = new ItemThiefArmor("thief_helmet", EntityEquipmentSlot.HEAD);
	public static final Item THIEF_CHEST = new ItemThiefArmor("thief_chest", EntityEquipmentSlot.CHEST);
	public static final Item THIEF_LEGS = new ItemThiefArmor("thief_legs", EntityEquipmentSlot.LEGS);
	public static final Item THIEF_BOOTS = new ItemThiefArmor("thief_boots", EntityEquipmentSlot.FEET);

	public static final Item SCALE_HELMET = new ItemScaleArmor("scale_helmet", EntityEquipmentSlot.HEAD);
	public static final Item SCALE_CHEST = new ItemScaleArmor("scale_chest", EntityEquipmentSlot.CHEST);
	public static final Item SCALE_LEGS = new ItemScaleArmor("scale_legs", EntityEquipmentSlot.LEGS);
	public static final Item SCALE_BOOTS = new ItemScaleArmor("scale_boots", EntityEquipmentSlot.FEET);

	public static final Item MAGIC_HELMET = new ItemMagicianArmor("magic_helmet", EntityEquipmentSlot.HEAD);
	public static final Item MAGIC_CHEST = new ItemMagicianArmor("magic_chest", EntityEquipmentSlot.CHEST);
	public static final Item MAGIC_LEGS = new ItemMagicianArmor("magic_legs", EntityEquipmentSlot.LEGS);
	public static final Item MAGIC_BOOTS = new ItemMagicianArmor("magic_boots", EntityEquipmentSlot.FEET);

	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		event.getRegistry().registerAll(ITEMS.toArray(new Item[ITEMS.size()]));
	}

	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		event.getRegistry().register(HEXBISCUS);
	}

}
