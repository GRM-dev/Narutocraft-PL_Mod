package pl.grm.narutocraft.items.weapons;

import pl.grm.narutocraft.NarutoCraft;
import net.minecraft.item.Item;

public class SmokeBomb extends Item {
	public SmokeBomb(){
		this.setUnlocalizedName("SmokeBomb");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
	
}
