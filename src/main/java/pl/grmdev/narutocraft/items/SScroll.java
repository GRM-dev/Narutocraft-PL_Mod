package pl.grmdev.narutocraft.items;

import net.minecraft.item.Item;
import pl.grmdev.narutocraft.NarutoCraft;

public class SScroll extends Item {

	public SScroll() {
		this.setUnlocalizedName("SuitonScroll");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}

}
