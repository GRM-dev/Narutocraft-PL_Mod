package pl.grm.narutocraftmod.Weapons;

import pl.grm.narutocraftmod.NarutoCraftMod;
import net.minecraft.item.Item;

public class Shuriken extends Item {
	public Shuriken(int i) {
		this.setUnlocalizedName("Shuriken");
		this.setTextureName("narutocraftmod:Shuriken");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 10;
		
	}
}
