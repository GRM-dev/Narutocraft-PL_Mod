package pl.grm.narutocraftmod.Powers;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class JikukanKekkai extends Item {

	public JikukanKekkai(int i) {
		this.setUnlocalizedName("Jikukan Kekkai");
		this.setTextureName("narutocraftmod:NoJutsu");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 64;
	}

}