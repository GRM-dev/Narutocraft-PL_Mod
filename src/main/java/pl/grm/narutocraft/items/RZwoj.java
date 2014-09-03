package pl.grm.narutocraft.items;

import pl.grm.narutocraft.NarutoCraftMod;
import net.minecraft.item.Item;

public class RZwoj extends Item {

	public RZwoj(int i) {
		this.setUnlocalizedName("RZwoj");
		this.setTextureName("narutocraftmod:Zwoj Raiton");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 64;
	}

}
