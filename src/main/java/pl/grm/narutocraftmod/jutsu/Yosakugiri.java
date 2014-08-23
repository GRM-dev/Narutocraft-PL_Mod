package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class Yosakugiri extends Item {

	public Yosakugiri(int i) {
		this.setUnlocalizedName("Yosakugiri");
		this.setTextureName("narutocraftmod:Yosakugiri");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}