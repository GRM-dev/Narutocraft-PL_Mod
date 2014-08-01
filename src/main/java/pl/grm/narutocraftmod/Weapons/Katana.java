package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.Materials;

public class Katana extends ItemSword {	
	public Katana (int i) {
		super(Materials.tytan3);

		this.setUnlocalizedName("Katana");
		this.setTextureName("narutocraftmod:Katana");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}