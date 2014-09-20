package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.References;

public class RScroll extends Item {
	
	public RScroll() {
		this.setUnlocalizedName("RZwoj");
		this.setTextureName(References.ModTexturePath + "Zwoj Raiton");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
	
}
