package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class Koukongarasu extends Item {

	public Koukongarasu(int i) {
		this.setUnlocalizedName("Koukongarasu");
		this.setTextureName("narutocraftmod:Koukongarasu");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}