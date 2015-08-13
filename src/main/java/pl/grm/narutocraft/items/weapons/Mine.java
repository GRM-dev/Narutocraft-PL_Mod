package pl.grm.narutocraft.items.weapons;

import pl.grm.narutocraft.NarutoCraft;
import net.minecraft.item.Item;

public class Mine extends Item{
	public Mine() {
		this.setUnlocalizedName("Mine");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
}
