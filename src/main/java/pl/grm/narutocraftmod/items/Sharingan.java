package pl.grm.narutocraftmod.Items;

import pl.grm.narutocraftmod.NarutoCraftMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Sharingan extends Item{

	public Sharingan(int i) {
		this.setUnlocalizedName("Sharingan");
		this.setTextureName("narutocraftmod:Sharingan");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}
	
}
