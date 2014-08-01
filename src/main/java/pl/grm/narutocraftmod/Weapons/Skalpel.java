package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class Skalpel extends Item {

	public Skalpel(int i) {
		this.setUnlocalizedName("Skalpel");
		this.setTextureName("narutocraftmod:Skalpel");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 64;
	}

}