package pl.grmdev.narutocraft.items;

import net.minecraft.item.Item;
import pl.grmdev.narutocraft.NarutoCraft;

public class NScroll extends Item {

	public NScroll() {
		this.setUnlocalizedName("NormalScroll");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}

}
