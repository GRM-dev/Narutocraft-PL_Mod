package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.References;

public class NZwoj extends Item {

	public NZwoj() {
		this.setUnlocalizedName("NZwoj");
		this.setTextureName(References.ModTexturePath + "Zwoj");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraftMod);
		maxStackSize = 64;
	}

}
