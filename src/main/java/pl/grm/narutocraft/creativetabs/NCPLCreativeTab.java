package pl.grm.narutocraft.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import pl.grm.narutocraft.registry.RegJutsus;

/**
 * Create Creative Tab
 */
public class NCPLCreativeTab extends CreativeTabs {
	private Item item;
	/**
	 * 
	 * @param par1 Creative Tab Id
	 * @param par2Str Tab Name
	 */
	public NCPLCreativeTab(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return (new ItemStack(RegJutsus.Sharingan));
	}

	@Override
	public Item getTabIconItem() {
		return item;
	}

	public String getTranslatedTabLabel() {
		return "NarutoCraft";
	}

}