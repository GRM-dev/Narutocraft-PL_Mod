package pl.grmdev.narutocraft.items;

import net.minecraft.item.Item;
import pl.grmdev.narutocraft.NarutoCraft;

public class FScroll extends Item {

	public FScroll() {
		this.setUnlocalizedName("FutonScroll");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}

}
