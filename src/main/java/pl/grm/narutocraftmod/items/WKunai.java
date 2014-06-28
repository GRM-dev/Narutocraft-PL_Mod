package pl.grm.narutocraftmod.Items;

import pl.grm.narutocraftmod.NarutoCraftMod;
import net.minecraft.item.Item;

public class WKunai extends Item {
	public WKunai(int i) {
		this.setUnlocalizedName("WybuchowyKunai");
		this.setTextureName("narutocraftmod:Kunai");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}
}
