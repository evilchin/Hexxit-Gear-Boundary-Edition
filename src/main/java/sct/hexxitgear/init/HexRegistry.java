package sct.hexxitgear.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import sct.hexxitgear.HexxitGear;
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

	public static final Item SAGE_HELMET = new ItemMagicianArmor("sage_helmet", EntityEquipmentSlot.HEAD);
	public static final Item SAGE_CHEST = new ItemMagicianArmor("sage_chest", EntityEquipmentSlot.CHEST);
	public static final Item SAGE_LEGS = new ItemMagicianArmor("sage_legs", EntityEquipmentSlot.LEGS);
	public static final Item SAGE_BOOTS = new ItemMagicianArmor("sage_boots", EntityEquipmentSlot.FEET);

	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		event.getRegistry().registerAll(ITEMS.toArray(new Item[ITEMS.size()]));
		registerRecipes();
	}

	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		event.getRegistry().register(HEXBISCUS);
	}

	private static void registerRecipes() {
		int j = 0;
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.HEXICAL_DIAMOND), " I ", "IDI", " I ", 'I', HexRegistry.HEXICAL_ESSENCE, 'D', Items.DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.TRIBAL_HELMET), "BBB", "BHB", "   ", 'B', Items.BONE, 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.TRIBAL_CHEST), "I I", "LHL", "ILI", 'I', "ingotIron", 'L', Items.LEATHER, 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.TRIBAL_LEGS), "LLL", "IHI", "L L", 'I', "ingotIron", 'L', Items.LEATHER, 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.TRIBAL_BOOTS), "   ", "SHS", "L L", 'S', Items.STRING, 'L', Items.LEATHER, 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.THIEF_HELMET), "RRR", "RHR", "   ", 'R', new ItemStack(Blocks.WOOL, 1, 14), 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.THIEF_CHEST), "R R", "LHL", "LLL", 'R', new ItemStack(Blocks.WOOL, 1, 14), 'L', Items.LEATHER, 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.THIEF_LEGS), "LSL", "LHL", "L L", 'L', Items.LEATHER, 'S', Items.STRING, 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.THIEF_BOOTS), "   ", "LHL", "B B", 'L', Items.LEATHER, 'H', HexRegistry.HEXICAL_DIAMOND, 'B', new ItemStack(Blocks.WOOL, 1, 7));
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.SCALE_HELMET), "GOG", "OHO", "   ", 'G', "ingotGold", 'O', Blocks.OBSIDIAN, 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.SCALE_CHEST), "G G", "OHO", "GOG", 'G', "ingotGold", 'O', Blocks.OBSIDIAN, 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.SCALE_LEGS), "OOO", "GHG", "O O", 'O', Blocks.OBSIDIAN, 'G', "ingotGold", 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.SCALE_BOOTS), "   ", "OHO", "O O", 'O', Blocks.OBSIDIAN, 'H', HexRegistry.HEXICAL_DIAMOND);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.SAGE_HELMET), " B ", "OHO", "W W", 'B', Items.BOOK, 'O', Blocks.OBSIDIAN, 'H', HexRegistry.HEXICAL_DIAMOND, 'W', Blocks.WOOL);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.SAGE_CHEST), "G G", "WHW", "GBG", 'G', "ingotGold", 'W', Blocks.WOOL, 'H', HexRegistry.HEXICAL_DIAMOND, 'B', Items.BOOK);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.SAGE_LEGS), "GBG", "WHW", "G G", 'G', "ingotGold", 'W', Blocks.WOOL, 'H', HexRegistry.HEXICAL_DIAMOND, 'B', Items.BOOK);
		GameRegistry.addShapedRecipe(new ResourceLocation(HexxitGear.MODID, "recipe" + j++), null, new ItemStack(HexRegistry.SAGE_BOOTS), "WHW", "G G", 'G', "ingotGold", 'W', Blocks.WOOL, 'H', HexRegistry.HEXICAL_DIAMOND);
	}

}
