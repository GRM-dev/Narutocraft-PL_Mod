package pl.grm.narutocraft.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import pl.grm.narutocraft.libs.ExtendedProperties;
import pl.grm.narutocraft.libs.References;

/**
 * Creative Tab for Jutsus
 */
public class NCJutsuTab extends CreativeTabs {
	/**
	 * @param id
	 *            Creative Tab Id
	 * @param unlocalizedName
	 *            Tab Name
	 */
	public NCJutsuTab(int id, String unlocalizedName) {
		super(id, unlocalizedName);
		this.setBackgroundImageName(References.GuiTexturePath + "cTabGui2.png");
	}
	
	@Override
	public Item getTabIconItem() {
		System.out.println(ExtendedProperties.jutsuList.size());
		// return (Item)
		// ExtendedProperties.jutsuList.get(JutsuEnum.RASENGAN.getJutsuID());
		return Items.apple;
	}
	
	@Override
	public String getTranslatedTabLabel() {
		return "NarutoCraft Jutsu's";
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
}