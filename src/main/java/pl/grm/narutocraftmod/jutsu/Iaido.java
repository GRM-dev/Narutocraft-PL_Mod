package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class Iaido extends Item {

	public Iaido(int i) {
		this.setUnlocalizedName("Iaido");
		this.setTextureName("narutocraftmod:Iaido");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}