package pl.grm.narutocraft.items.weapons;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;

public class Weights extends Item{
	public Weights() {
		this.setUnlocalizedName("Weights");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
}
