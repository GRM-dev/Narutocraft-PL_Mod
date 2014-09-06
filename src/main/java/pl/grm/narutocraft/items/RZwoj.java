package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.References;

public class RZwoj extends Item {

	public RZwoj() {
		this.setUnlocalizedName("RZwoj");
		this.setTextureName(References.ModTexturePath + "Zwoj Raiton");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		maxStackSize = 64;
	}

}
