package pl.grm.narutocraftmod.Powers;

import pl.grm.narutocraftmod.NarutoCraftMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ShunshinNoJutsu extends Item{
	
	public ShunshinNoJutsu(int i) {
		this.setUnlocalizedName("SNoJutsu");
		this.setTextureName("narutocraftmod:NoJutsu");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}
	
}
