package pl.grm.narutocraft.items.weapons;

import pl.grm.narutocraft.NarutoCraft;
import net.minecraft.item.Item;

public class Knuckleduster extends Item{
	public Knuckleduster(){
		this.setUnlocalizedName("Knuckleduster");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}

}
