package pl.grm.narutocraft.creativetabs;

import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import pl.grm.narutocraft.jutsu.*;
import pl.grm.narutocraft.player.*;

/**
 * Create Creative Tab
 */
public class NCMainTab extends CreativeTabs {
	private int	iconJutsuID	= JutsuParams.SHARINGAN.getJutsuID();
	
	/**
	 * @param id
	 *            Creative Tab Id
	 * @param unlocalizedName
	 *            Tab Name
	 */
	public NCMainTab(int id, String unlocalizedName) {
		super(id, unlocalizedName);
	}
	
	@Override
	public Item getTabIconItem() {
		if (ExtendedProperties.jutsuList.containsKey(iconJutsuID)) {
			Item item = (Item) ExtendedProperties.jutsuList.get(iconJutsuID);
			return item;
		}
		return Items.apple;
	}
	
	@Override
	public String getTranslatedTabLabel() {
		return "NarutoCraft";
	}
}