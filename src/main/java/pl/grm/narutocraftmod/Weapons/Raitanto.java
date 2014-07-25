package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.Materials;

public class Raitanto extends SwordMain {
	public static Item Raitanto;
	public static Object instance;
	
	public Raitanto(int i) {
		super(Materials.smoczastal4);		
		this.setUnlocalizedName("Raitanto");
		this.setTextureName("narutocraftmod:Raitanto");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);
	}
}
