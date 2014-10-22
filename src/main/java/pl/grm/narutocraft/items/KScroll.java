package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.config.References;

public class KScroll extends Item {
	
	public KScroll() {
		this.setUnlocalizedName("KZwoj");
		this.setTextureName(References.ModTexturePath + "Zwoj Katon");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		this.maxStackSize = 64;
	}
	
}
