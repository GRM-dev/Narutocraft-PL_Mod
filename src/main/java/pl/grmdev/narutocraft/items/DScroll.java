package pl.grmdev.narutocraft.items;

import net.minecraft.item.Item;
import pl.grmdev.narutocraft.NarutoCraft;

public class DScroll extends Item {

	public DScroll() {
		this.setUnlocalizedName("DotonScroll");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}

}
