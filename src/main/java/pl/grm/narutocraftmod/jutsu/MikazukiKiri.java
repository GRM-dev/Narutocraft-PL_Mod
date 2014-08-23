package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class MikazukiKiri extends Item {

	public MikazukiKiri(int i) {
		this.setUnlocalizedName("Mikazuki Kiri");
		this.setTextureName("narutocraftmod:Mikazuki Kiri");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}