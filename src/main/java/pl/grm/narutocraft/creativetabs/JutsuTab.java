package pl.grm.narutocraft.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pl.grm.narutocraft.registry.RegJutsus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Create Creative Tab
 */
public class JutsuTab extends CreativeTabs {
	private Item item;
	/**
	 * 
	 * @param par1
	 *            Creative Tab Id
	 * @param par2Str
	 *            Tab Name
	 */
	public JutsuTab(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return (new ItemStack(RegJutsus.Rasengan));
	}

	@Override
	public Item getTabIconItem() {
		return item;
	}

	@Override
	public String getTranslatedTabLabel() {
		return "NarutoCraft Jutsu's";
	}

}