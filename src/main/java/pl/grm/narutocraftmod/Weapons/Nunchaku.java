package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.ItemSword;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.Materials;

public class Nunchaku extends ItemSword {
	public Nunchaku (int i) {
		super(Materials.stal);

		this.setUnlocalizedName("Nunchaku");
		this.setTextureName("narutocraftmod:Nunchaku");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
	}
}
