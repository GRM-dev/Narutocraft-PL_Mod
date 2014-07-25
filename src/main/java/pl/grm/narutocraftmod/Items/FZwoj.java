package pl.grm.narutocraftmod.Items;

import pl.grm.narutocraftmod.NarutoCraftMod;
import net.minecraft.item.Item;

public class FZwoj extends Item {

	public FZwoj(int i) {
		this.setUnlocalizedName("FZwoj");
		this.setTextureName("narutocraftmod:Zwoj Fuuton");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 64;
	}

}
