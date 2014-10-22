package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.config.References;

public class NScroll extends Item {
	
	public NScroll() {
		this.setUnlocalizedName("NZwoj");
		this.setTextureName(References.ModTexturePath + "Zwoj");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
	
}
