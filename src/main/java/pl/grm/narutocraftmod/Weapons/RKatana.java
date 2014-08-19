package pl.grm.narutocraftmod.Weapons;

import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.Materials;

public class RKatana extends SwordMain {
	public RKatana (int i) {
		super(Materials.smoczastal);

		this.setUnlocalizedName("RKatana");
		this.setTextureName("narutocraftmod:RyuuKatana");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}