package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;

public class EarthScroll extends Item {

	public EarthScroll() {
		this.setUnlocalizedName("EScroll");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}

}
