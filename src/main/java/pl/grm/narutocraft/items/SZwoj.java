package pl.grm.narutocraft.items;

import pl.grm.narutocraft.NarutoCraftMod;
import net.minecraft.item.Item;

public class SZwoj extends Item {

	public SZwoj(int i) {
		this.setUnlocalizedName("SZwoj");
		this.setTextureName("narutocraftmod:Zwoj Suiton");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 64;
	}

}
