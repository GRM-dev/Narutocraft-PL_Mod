package pl.grm.narutocraftmod.libs.registry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraftmod.NarutoCraftMod;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegRecipes extends NarutoCraftMod {
	public static ItemStack diamondStack = new ItemStack(Items.diamond);
    public static ItemStack stickStack = new ItemStack(Items.stick);
    public static ItemStack stringStack = new ItemStack(Items.string);
    public static ItemStack ironingotStack = new ItemStack(Items.iron_ingot);
    
	public static void RegRecipesList() {
        GameRegistry.addRecipe(new ItemStack(RegItems.Kunai, 2), 
        		"x  ", 
        		" y ", 
        		"  x",
                'x', diamondStack, 'y', stickStack);
	
            
			/* GameRegistry.addRecipe(new ItemStack(RegItems.Nunchaku, 1), 
            	   "x  ", 
            		" y ", 
            		 "  x",
                    'x', diamondStack, 'y', stringStack);
			*/
			GameRegistry.addRecipe(new ItemStack(RegItems.MSamuraja, 1),
					"x  ",
					" y ",
					"  z",
					'x', stickStack, 'y', ironingotStack, 'z', diamondStack);
			
			GameRegistry.addRecipe(new ItemStack(RegItems.KBushido, 1),
					"x  ",
					" y ",
					"  y",
					'x',ironingotStack, 'y', diamondStack
					);
			GameRegistry.addRecipe(new ItemStack(RegItems.Shuriken, 1),
					" x ",
					 "xyx",
					" x ",
					'x',ironingotStack, 'y', stickStack);
			
        //GameRegistry.addShapelessRecipe(ItemStack result, Object... recipe)
	}
}
