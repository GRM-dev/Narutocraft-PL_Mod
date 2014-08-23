package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class Hadan extends Item {

	public Hadan(int i) {
		this.setUnlocalizedName("Hadan");
		this.setTextureName("narutocraftmod:Hadan");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}