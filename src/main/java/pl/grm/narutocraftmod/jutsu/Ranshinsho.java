package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class Ranshinsho extends Item {

	public Ranshinsho(int i) {
		this.setUnlocalizedName("Ranshinsho");
		this.setTextureName("narutocraftmod:Ranshinsho");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}