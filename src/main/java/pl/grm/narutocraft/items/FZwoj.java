package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.References;

public class FZwoj extends Item {
	
	public FZwoj() {
		this.setUnlocalizedName("FZwoj");
		this.setTextureName(References.ModTexturePath + "Zwoj Fuuton");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
	
}
