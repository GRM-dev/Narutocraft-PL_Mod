package pl.grmdev.narutocraft.items.weapons;

import net.minecraft.item.Item;
import pl.grmdev.narutocraft.NarutoCraft;

public class Mine extends Item{
	public Mine() {
		this.setUnlocalizedName("Mine");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
}
