package pl.grm.narutocraftmod.jutsu;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;

public class InyuShometsu extends Item {

	public InyuShometsu(int i) {
		this.setUnlocalizedName("InyuShometsu");
		this.setTextureName("narutocraftmod:InyuShometsu");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
		maxStackSize = 1;
	}

}