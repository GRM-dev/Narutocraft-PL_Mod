package pl.grmdev.narutocraft.items.weapons;

import net.minecraft.item.Item;
import pl.grmdev.narutocraft.NarutoCraft;

public class LightBomb extends Item{
	public LightBomb(){
		this.setUnlocalizedName("LightBomb");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
}
