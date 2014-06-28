package pl.grm.narutocraftmod.Items;

import pl.grm.narutocraftmod.NarutoCraftMod;
import net.minecraft.item.Item;

public class Kunai extends Item{
	public Kunai(int i) {
		this.setUnlocalizedName("Kunai");
		this.setTextureName("narutocraftmod:Kunai");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 30;
	}

}
