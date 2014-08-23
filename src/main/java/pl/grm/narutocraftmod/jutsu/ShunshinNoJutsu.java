package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;

import pl.grm.narutocraftmod.NarutoCraftMod;

public class ShunshinNoJutsu extends Item{
	
	public ShunshinNoJutsu(int i) {
		this.setUnlocalizedName("SNoJutsu");
		this.setTextureName("narutocraftmod:NoJutsu");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}
	
}
