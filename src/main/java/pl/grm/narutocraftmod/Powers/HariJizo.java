package pl.grm.narutocraftmod.Powers;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class HariJizo extends Item {

	public HariJizo(int i) {
		this.setUnlocalizedName("HariJizo");
		this.setTextureName("narutocraftmod:HariJizo");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}