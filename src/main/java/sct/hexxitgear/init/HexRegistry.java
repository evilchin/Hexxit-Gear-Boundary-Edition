package sct.hexxitgear.init;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import sct.hexxitgear.HexxitGear;
import sct.hexxitgear.block.BlockHexbiscus;
import sct.hexxitgear.item.ItemMagicianArmor;
import sct.hexxitgear.item.ItemScaleArmor;
import sct.hexxitgear.item.ItemThiefArmor;
import sct.hexxitgear.item.ItemTribalArmor;
import shadows.placebo.util.PlaceboUtil;
import shadows.placebo.util.RecipeHelper;

@ObjectHolder(HexxitGear.MODID)
public class HexRegistry extends RecipeHelper {

	public static final BlockHexbiscus HEXBISCUS = new BlockHexbiscus();

	public static final Item HEXICAL_ESSENCE = PlaceboUtil.initItem(new Item(), HexxitGear.MODID, "hexical_essence");
	public static final Item HEXICAL_DIAMOND = PlaceboUtil.initItem(new Item(), HexxitGear.MODID, "hexical_diamond");

	public static final ItemTribalArmor TRIBAL_HELMET = new ItemTribalArmor("tribal_helmet", EntityEquipmentSlot.HEAD);
	public static final ItemTribalArmor TRIBAL_CHEST = new ItemTribalArmor("tribal_chest", EntityEquipmentSlot.CHEST);
	public static final ItemTribalArmor TRIBAL_LEGS = new ItemTribalArmor("tribal_legs", EntityEquipmentSlot.LEGS);
	public static final ItemTribalArmor TRIBAL_BOOTS = new ItemTribalArmor("tribal_boots", EntityEquipmentSlot.FEET);

	public static final ItemThiefArmor THIEF_HELMET = new ItemThiefArmor("thief_helmet", EntityEquipmentSlot.HEAD);
	public static final ItemThiefArmor THIEF_CHEST = new ItemThiefArmor("thief_chest", EntityEquipmentSlot.CHEST);
	public static final ItemThiefArmor THIEF_LEGS = new ItemThiefArmor("thief_legs", EntityEquipmentSlot.LEGS);
	public static final ItemThiefArmor THIEF_BOOTS = new ItemThiefArmor("thief_boots", EntityEquipmentSlot.FEET);

	public static final ItemScaleArmor SCALE_HELMET = new ItemScaleArmor("scale_helmet", EntityEquipmentSlot.HEAD);
	public static final ItemScaleArmor SCALE_CHEST = new ItemScaleArmor("scale_chest", EntityEquipmentSlot.CHEST);
	public static final ItemScaleArmor SCALE_LEGS = new ItemScaleArmor("scale_legs", EntityEquipmentSlot.LEGS);
	public static final ItemScaleArmor SCALE_BOOTS = new ItemScaleArmor("scale_boots", EntityEquipmentSlot.FEET);

	public static final ItemMagicianArmor SAGE_HELMET = new ItemMagicianArmor("sage_helmet", EntityEquipmentSlot.HEAD);
	public static final ItemMagicianArmor SAGE_CHEST = new ItemMagicianArmor("sage_chest", EntityEquipmentSlot.CHEST);
	public static final ItemMagicianArmor SAGE_LEGS = new ItemMagicianArmor("sage_legs", EntityEquipmentSlot.LEGS);
	public static final ItemMagicianArmor SAGE_BOOTS = new ItemMagicianArmor("sage_boots", EntityEquipmentSlot.FEET);

	public HexRegistry() {
		super(HexxitGear.MODID, HexxitGear.MODNAME);
	}

	@SubscribeEvent
	public void items(Register<Item> event) {
		event.getRegistry().registerAll(HEXICAL_ESSENCE, HEXICAL_DIAMOND);
		event.getRegistry().registerAll(HexxitGear.ARMOR_LIST.toArray(new Item[0]));
	}

	@SubscribeEvent
	public void blocks(Register<Block> event) {
		event.getRegistry().register(PlaceboUtil.initBlock(HEXBISCUS, HexxitGear.MODID, "hexbiscus", 0, 0));
	}

	@Override
	public void addRecipes() {
		ItemStack rWool = new ItemStack(Blocks.WOOL, 1, 14);
		addShaped(HEXICAL_DIAMOND, 3, 3, null, HEXICAL_ESSENCE, null, HEXICAL_ESSENCE, Items.DIAMOND, HEXICAL_ESSENCE, null, HEXICAL_ESSENCE, null);
		addShaped(TRIBAL_HELMET, 3, 2, Items.BONE, Items.BONE, Items.BONE, Items.BONE, HEXICAL_DIAMOND, Items.BONE);
		addShaped(TRIBAL_CHEST, 3, 3, "ingotIron", null, "ingotIron", Items.LEATHER, HEXICAL_DIAMOND, Items.LEATHER, "ingotIron", Items.LEATHER, "ingotIron");
		addShaped(TRIBAL_LEGS, 3, 3, Items.LEATHER, Items.LEATHER, Items.LEATHER, "ingotIron", HEXICAL_DIAMOND, "ingotIron", Items.LEATHER, null, Items.LEATHER);
		addShaped(TRIBAL_BOOTS, 3, 2, Items.STRING, HEXICAL_DIAMOND, Items.STRING, Items.LEATHER, null, Items.LEATHER);
		addShaped(THIEF_HELMET, 3, 2, rWool, rWool, rWool, rWool, HEXICAL_DIAMOND, rWool);
		addShaped(THIEF_CHEST, 3, 3, rWool, null, rWool, Items.LEATHER, HEXICAL_DIAMOND, Items.LEATHER, Items.LEATHER, Items.LEATHER, Items.LEATHER);
		addShaped(THIEF_LEGS, 3, 3, Items.LEATHER, Items.STRING, Items.LEATHER, Items.LEATHER, HEXICAL_DIAMOND, Items.LEATHER, Items.LEATHER, null, Items.LEATHER);
		addShaped(THIEF_BOOTS, 3, 2, Items.LEATHER, HEXICAL_DIAMOND, Items.LEATHER, new ItemStack(Blocks.WOOL, 1, 7), null, new ItemStack(Blocks.WOOL, 1, 7));
		addShaped(SCALE_HELMET, 3, 2, "ingotGold", Blocks.OBSIDIAN, "ingotGold", Blocks.OBSIDIAN, HEXICAL_DIAMOND, Blocks.OBSIDIAN);
		addShaped(SCALE_CHEST, 3, 3, "ingotGold", null, "ingotGold", Blocks.OBSIDIAN, HEXICAL_DIAMOND, Blocks.OBSIDIAN, "ingotGold", Blocks.OBSIDIAN, "ingotGold");
		addShaped(SCALE_LEGS, 3, 3, Blocks.OBSIDIAN, Blocks.OBSIDIAN, Blocks.OBSIDIAN, "ingotGold", HEXICAL_DIAMOND, "ingotGold", Blocks.OBSIDIAN, null, Blocks.OBSIDIAN);
		addShaped(SCALE_BOOTS, 3, 2, Blocks.OBSIDIAN, HEXICAL_DIAMOND, Blocks.OBSIDIAN, Blocks.OBSIDIAN, null, Blocks.OBSIDIAN);
		addShaped(SAGE_HELMET, 3, 3, null, Items.BOOK, null, Blocks.OBSIDIAN, HEXICAL_DIAMOND, Blocks.OBSIDIAN, Blocks.WOOL, null, Blocks.WOOL);
		addShaped(SAGE_CHEST, 3, 3, "ingotGold", null, "ingotGold", Blocks.WOOL, HEXICAL_DIAMOND, Blocks.WOOL, "ingotGold", Items.BOOK, "ingotGold");
		addShaped(SAGE_LEGS, 3, 3, "ingotGold", Items.BOOK, "ingotGold", Blocks.WOOL, HEXICAL_DIAMOND, Blocks.WOOL, "ingotGold", null, "ingotGold");
		addShaped(SAGE_BOOTS, 3, 2, Blocks.WOOL, HEXICAL_DIAMOND, Blocks.WOOL, "ingotGold", null, "ingotGold");
	}

}
