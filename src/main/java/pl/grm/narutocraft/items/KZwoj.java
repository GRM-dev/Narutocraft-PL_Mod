package pl.grm.narutocraft.items;

import pl.grm.narutocraft.NarutoCraftMod;
import net.minecraft.item.Item;

public class KZwoj extends Item {

	public KZwoj(int i) {
		this.setUnlocalizedName("KZwoj");
		this.setTextureName("narutocraftmod:Zwoj Katon");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 64;
	}

}
