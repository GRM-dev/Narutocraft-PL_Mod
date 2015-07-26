package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;

public class DScroll extends Item {

	public DScroll() {
		this.setUnlocalizedName("DotonScroll");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}

}
