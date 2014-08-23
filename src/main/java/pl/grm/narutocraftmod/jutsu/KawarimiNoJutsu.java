package pl.grm.narutocraftmod.jutsu;

import pl.grm.narutocraftmod.NarutoCraftMod;
import net.minecraft.item.Item;

public class KawarimiNoJutsu extends Item {

	public KawarimiNoJutsu(int i) {
		this.setUnlocalizedName("KNoJutsu");
		this.setTextureName("narutocraftmod:NoJutsu");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		 maxStackSize = 1;
	}
	
}
