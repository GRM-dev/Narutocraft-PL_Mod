package pl.grm.narutocraftmod.Powers;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class KokuangyoNoJutsu extends Item {

	public KokuangyoNoJutsu(int i) {
		this.setUnlocalizedName("Kokuangyo No Jutsu");
		this.setTextureName("narutocraftmod:NoJutsu");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 64;
	}

}