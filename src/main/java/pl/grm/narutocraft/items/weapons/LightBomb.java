package pl.grm.narutocraft.items.weapons;

import pl.grm.narutocraft.NarutoCraft;
import net.minecraft.item.Item;

public class LightBomb extends Item{
	public LightBomb(){
		this.setUnlocalizedName("LightBomb");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
}
