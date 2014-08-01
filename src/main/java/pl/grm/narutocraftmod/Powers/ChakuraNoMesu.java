package pl.grm.narutocraftmod.Powers;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class ChakuraNoMesu extends Item {

	public ChakuraNoMesu(int i) {
		this.setUnlocalizedName("Chakura No Mesu");
		this.setTextureName("narutocraftmod:NoJutsu");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 64;
	}

}