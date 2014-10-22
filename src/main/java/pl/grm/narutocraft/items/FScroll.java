package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.config.References;

public class FScroll extends Item {
	
	public FScroll() {
		this.setUnlocalizedName("FZwoj");
		this.setTextureName(References.ModTexturePath + "Zwoj Fuuton");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
	
}
