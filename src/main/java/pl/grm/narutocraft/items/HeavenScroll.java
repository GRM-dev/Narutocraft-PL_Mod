package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;

public class HeavenScroll extends Item {

	public HeavenScroll() {
		this.setUnlocalizedName("HScroll");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}

}
