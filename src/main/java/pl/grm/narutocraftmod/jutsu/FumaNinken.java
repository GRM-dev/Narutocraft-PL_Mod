package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class FumaNinken extends Item {

	public FumaNinken(int i) {
		this.setUnlocalizedName("Fuma Ninken");
		this.setTextureName("narutocraftmod:Fuma Ninken");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}