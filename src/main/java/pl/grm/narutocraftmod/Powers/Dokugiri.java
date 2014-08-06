package pl.grm.narutocraftmod.Powers;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class Dokugiri extends Item {

	public Dokugiri(int i) {
		this.setUnlocalizedName("Dokugiri");
		this.setTextureName("narutocraftmod:Dokugiri");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}