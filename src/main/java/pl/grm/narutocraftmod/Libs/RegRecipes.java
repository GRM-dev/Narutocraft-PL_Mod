package pl.grm.narutocraftmod.Libs;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class RegRecipes extends NarutoCraftMod {
	public static ItemStack diamondStack = new ItemStack(Items.diamond);
    public static ItemStack stickStack = new ItemStack(Items.stick);
    
	public static void RegRecipesList() {
        GameRegistry.addRecipe(new ItemStack(RegItems.Kunai, 2), 
        		"x  ", 
        		" y ", 
        		"  x",
                'x', diamondStack, 'y', stickStack);
        //GameRegistry.addShapelessRecipe(ItemStack result, Object... recipe)
	}
}
