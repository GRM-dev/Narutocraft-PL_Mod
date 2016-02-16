package pl.grmdev.narutocraft.items.weapons;

import net.minecraft.item.Item;
import pl.grmdev.narutocraft.NarutoCraft;

public class SmokeBomb extends Item {
	public SmokeBomb(){
		this.setUnlocalizedName("SmokeBomb");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
	
}
