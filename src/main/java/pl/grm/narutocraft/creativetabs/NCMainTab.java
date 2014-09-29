package pl.grm.narutocraft.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Create Creative Tab
 */
public class NCMainTab extends CreativeTabs {
	private Item	item;
	
	/**
	 * @param par1
	 *            Creative Tab Id
	 * @param par2Str
	 *            Tab Name
	 */
	public NCMainTab(int par1, String par2Str) {
		super(par1, par2Str);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return (new ItemStack(JutsuEnum.SHARINGAN.getJutsu()));
	}
	
	@Override
	public Item getTabIconItem() {
		return this.item;
	}
	
	@Override
	public String getTranslatedTabLabel() {
		return "NarutoCraft";
	}
	
}