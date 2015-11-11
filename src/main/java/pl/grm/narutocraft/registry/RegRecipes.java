package pl.grm.narutocraft.registry;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.items.weapons.ThreeProngedKnife;

public class RegRecipes extends NarutoCraft {

	public static ItemStack DiamondStack = new ItemStack(Items.diamond);

	public static ItemStack StickStack = new ItemStack(Items.stick);
	public static ItemStack IronIngotStack = new ItemStack(Items.iron_ingot);
	public static ItemStack String = new ItemStack(Items.string);
	public static ItemStack GoldenIngotStack = new ItemStack(Items.gold_ingot);
	public static ItemStack MetalCable = new ItemStack(RegItems.MetalCable);
	public static ItemStack Kama = new ItemStack(RegItems.Kama);
	public static ItemStack ThreeProngedKnife = new ItemStack(RegItems.ThreeProngedKnife);
	public static ItemStack Kunai = new ItemStack(RegItems.Kunai);
	public static ItemStack ExplosiveNote = new ItemStack(RegItems.ExplosiveNote);
	public static ItemStack Senbon = new ItemStack(RegItems.Senbon);
	public static ItemStack SpiderEye = new ItemStack(Items.spider_eye);
	public static ItemStack Shuriken = new ItemStack(RegItems.Shuriken);
	public static ItemStack TNT = new ItemStack(Blocks.tnt);
	public static ItemStack Kusarigamawithpiston = new ItemStack(RegItems.Kusarigamawithpiston);
	public static ItemStack Pasta = new ItemStack(RegItems.Pasta);
	public static ItemStack WaterBucket = new ItemStack(Items.water_bucket);
	public static ItemStack WoodenBowl = new ItemStack(Items.bowl);
	public static ItemStack Wheat = new ItemStack(Items.wheat);
	public static ItemStack Fish = new ItemStack(Items.fish);
	public static ItemStack NarutoMaki = new ItemStack(RegItems.NarutoMaki);
	public static ItemStack Egg = new ItemStack(Items.egg);
	public static ItemStack Beef = new ItemStack(Items.beef);
	
	
	public static void regRecipesList() {
		
//Swords
		GameRegistry.addRecipe(new ItemStack(RegItems.Nunchaku, 1), "x  ", " y ", "  x", 'x', DiamondStack, 'y',
				String);

	GameRegistry.addRecipe(new ItemStack(RegItems.SamuraiSword, 1), "x  ", " y ", "  z", 'x', StickStack, 'y',
				IronIngotStack, 'z', DiamondStack);

		GameRegistry.addRecipe(new ItemStack(RegItems.BushidoKatana, 1), "x  ", " y ", "  y", 'x', IronIngotStack, 'y',
				DiamondStack);
		
		GameRegistry.addRecipe(new ItemStack(RegItems.Nunchaku, 1), "x  ", " y ", "  x", 'x', DiamondStack, 'y', String);
		GameRegistry.addRecipe(new ItemStack(RegItems.Kama, 1), "xy ", " x ", "  z", 'x', StickStack, 'y', GoldenIngotStack, 'z', IronIngotStack);
		GameRegistry.addRecipe(new ItemStack(RegItems.Kusarigamawithpiston, 1), "x  ", " y ", "  z", 'x', IronIngotStack, 'y', MetalCable, 'z', Kama);;
		GameRegistry.addRecipe(new ItemStack(RegItems.DoubleKusarigama, 1), "x  ", " y ", "  z", 'x', Kama,'y', MetalCable, 'z', ThreeProngedKnife );
		GameRegistry.addRecipe(new ItemStack(RegItems.Kusarigama, 1), "x  ", " y ", 'x',MetalCable, 'y', Kama);
		//Throwable
		GameRegistry.addRecipe(new ItemStack(RegItems.Shuriken, 1), " x ", "xyx", " x ", 'x',IronIngotStack, 'y',
				StickStack);
		GameRegistry.addRecipe(new ItemStack(RegItems.Kunai, 2), "x  ", " y ", "  x", 'x', DiamondStack, 'y',
				StickStack);
		GameRegistry.addRecipe(new ItemStack(RegItems.ExplodeKunai, 1), "xy ", 'x', Kunai, 'y', ExplosiveNote);
		GameRegistry.addRecipe(new ItemStack(RegItems.PoisonedSenbon, 1), "xy ", 'x', Senbon, 'y', SpiderEye);
		GameRegistry.addRecipe(new ItemStack(RegItems.BigShuriken, 1), " x ", "xxx", " x ", 'x', Shuriken);
		GameRegistry.addRecipe(new ItemStack(RegItems.DoubleKunai, 1),"xx ", 'x',Shuriken);
		GameRegistry.addRecipe(new ItemStack(RegItems.Mine, 1), "xxx", "xyx", "xxx", 'x', IronIngotStack, 'y', TNT);
		GameRegistry.addRecipe(new ItemStack(RegItems.WarKunai, 1), "xxx", 'x', Kunai);
		GameRegistry.addRecipe(new ItemStack(RegItems.KusariFuuboo, 1), "xx ", 'x', Kusarigamawithpiston);
		//Others
		GameRegistry.addRecipe(new ItemStack(RegItems.ExplosiveNote, 1),"x",'x', TNT);
		GameRegistry.addRecipe(new ItemStack(RegItems.MetalCable, 1), "x  ", " y ", 'x', String, 'y', IronIngotStack);
		GameRegistry.addRecipe(new ItemStack(RegItems.Ringtones, 1), "xx ", 'x', IronIngotStack);
		GameRegistry.addRecipe(new ItemStack(RegItems.Ramen, 1),"xy ", 'x', Pasta, 'y', WaterBucket);
		GameRegistry.addRecipe(new ItemStack(RegItems.Pasta, 1), "xyz", 'x',WoodenBowl,'y',WaterBucket, 'z', Wheat);
		GameRegistry.addRecipe(new ItemStack(RegItems.NarutoMaki, 1), "xy ", 'x', Fish, 'y', GoldenIngotStack);
		GameRegistry.addRecipe(new ItemStack(RegItems.IchirakuRamen, 1),"xyz","abc","d  ", 'x',WoodenBowl,'y', Pasta, 'z',WaterBucket,'a',NarutoMaki,'b',Egg,'c',Fish,'d',Beef);
	
		// GameRegistry.addShapelessRecipe(ItemStack result, Object... recipe)
	}
}
