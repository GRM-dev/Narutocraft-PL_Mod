package pl.grm.narutocraftmod.Items;

import pl.grm.narutocraftmod.NarutoCraftMod;
import net.minecraft.item.Item;

public class Rasengan extends Item{

	public Rasengan(int i) {
		this.setUnlocalizedName("Rasengan");
		this.setTextureName("narutocraftmod:Rasengan");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}
	
}
