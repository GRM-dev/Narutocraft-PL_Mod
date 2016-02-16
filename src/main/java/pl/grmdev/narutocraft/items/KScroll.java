package pl.grmdev.narutocraft.items;

import net.minecraft.item.Item;
import pl.grmdev.narutocraft.NarutoCraft;

public class KScroll extends Item {

	public KScroll() {
		this.setUnlocalizedName("KatonScroll");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}

}
