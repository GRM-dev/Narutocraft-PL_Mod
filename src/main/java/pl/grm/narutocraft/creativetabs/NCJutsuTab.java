package pl.grm.narutocraft.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import pl.grm.narutocraft.jutsu.JutsuParams;
import pl.grm.narutocraft.player.ExtendedProperties;

/**
 * Creative Tab for Jutsus
 */
public class NCJutsuTab extends CreativeTabs {
	private int	iconJutsuID	= JutsuParams.RASENGAN.getJutsuID();
	
	/**
	 * @param id
	 *            Creative Tab Id
	 * @param unlocalizedName
	 *            Tab Name
	 */
	public NCJutsuTab(int id, String unlocalizedName) {
		super(id, unlocalizedName);
		this.setBackgroundImageName("item_search.png");
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
		return "NC Jutsu's";
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
}