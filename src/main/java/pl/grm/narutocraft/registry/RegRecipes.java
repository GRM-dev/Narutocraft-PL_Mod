package pl.grm.narutocraft.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraft.NarutoCraft;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegRecipes extends NarutoCraft {
	public static ItemStack	diamondStack	= new ItemStack(Items.diamond);
	
	public static ItemStack	stickStack		= new ItemStack(Items.stick);
	public static ItemStack	stringStack		= new ItemStack(Items.string);
	public static ItemStack	ironingotStack	= new ItemStack(Items.iron_ingot);
	
	public static void regRecipesList() {
		GameRegistry.addRecipe(new ItemStack(RegWeapons.Kunai, 2), "x  ", " y ", "  x",
				'x', diamondStack, 'y', stickStack);
		
		GameRegistry.addRecipe(new ItemStack(RegWeapons.Nunchaku, 1), "x  ", " y ",
				"  x", 'x', diamondStack, 'y', stringStack);
		
		GameRegistry.addRecipe(new ItemStack(RegWeapons.MSamuraja, 1), "x  ", " y ",
				"  z", 'x', stickStack, 'y', ironingotStack, 'z', diamondStack);
		
		GameRegistry.addRecipe(new ItemStack(RegWeapons.KBushido, 1), "x  ", " y ",
				"  y", 'x', ironingotStack, 'y', diamondStack);
		GameRegistry.addRecipe(new ItemStack(RegWeapons.Shuriken, 1), " x ", "xyx",
				" x ", 'x', ironingotStack, 'y', stickStack);
		
		// GameRegistry.addShapelessRecipe(ItemStack result, Object... recipe)
	}
}
