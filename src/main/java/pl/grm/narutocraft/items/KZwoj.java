package pl.grm.narutocraft.items;

import net.minecraft.item.Item;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.References;

public class KZwoj extends Item {

	public KZwoj() {
		this.setUnlocalizedName("KZwoj");
		this.setTextureName(References.ModTexturePath + "Zwoj Katon");
		this.setCreativeTab(NarutoCraft.mTabNarutoCraft);
		maxStackSize = 64;
	}

}
