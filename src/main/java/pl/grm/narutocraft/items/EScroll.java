package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;

public class EScroll extends Item {

	public EScroll() {
		this.setUnlocalizedName("EarthScroll");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}

}
