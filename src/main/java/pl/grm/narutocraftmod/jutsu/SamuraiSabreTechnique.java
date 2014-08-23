package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class SamuraiSabreTechnique extends Item {

	public SamuraiSabreTechnique(int i) {
		this.setUnlocalizedName("SamuraiSabreTechnique");
		this.setTextureName("narutocraftmod:SamuraiSabreTechnique");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}