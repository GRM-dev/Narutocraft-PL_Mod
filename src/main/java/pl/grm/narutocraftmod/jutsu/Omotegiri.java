package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class Omotegiri extends Item {

	public Omotegiri(int i) {
		this.setUnlocalizedName("Omotegiri");
		this.setTextureName("narutocraftmod:Omotegiri");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}