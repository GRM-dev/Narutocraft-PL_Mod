package pl.grm.narutocraftmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraftmod.Libs.Registry.RegPowers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Create Creative Tab
 */
public class TabClass extends CreativeTabs {
	private Item item;
	/**
	 * 
	 * @param par1 Creative Tab Id
	 * @param par2Str Tab Name
	 */
	public TabClass(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return (new ItemStack(RegPowers.Sharingan));
	}

	@Override
	public Item getTabIconItem() {
		return item;
	}

	public String getTranslatedTabLabel() {
		return "NarutoCraft";
	}

}