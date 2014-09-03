package pl.grm.narutocraft.items;

import pl.grm.narutocraft.NarutoCraftMod;
import net.minecraft.item.Item;

public class DZwoj extends Item {

	public DZwoj(int i) {
		this.setUnlocalizedName("DZwoj");
		this.setTextureName("narutocraftmod:Zwoj Doton");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 64;
	}

}
