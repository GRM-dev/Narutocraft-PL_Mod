package pl.grm.narutocraftmod.Weapons;

import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.Materials;

public class Wakizashi extends SwordMain {
	public Wakizashi (int i) {
		super(Materials.tytan);

		this.setUnlocalizedName("Wakizashi");
		this.setTextureName("narutocraftmod:Wakizashi");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}