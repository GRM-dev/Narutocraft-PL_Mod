package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.Materials;

public class Kurosawa extends ItemSword {	
	public Kurosawa (int i) {
		super(Materials.metalsamurajow);
		
		this.setUnlocalizedName("Kurosawa");
		this.setTextureName("narutocraftmod:Kurosawa");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}