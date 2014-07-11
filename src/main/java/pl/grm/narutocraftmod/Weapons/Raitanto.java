package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Blocks.Materials;

public class Raitanto extends ItemSword {
	public static Item Raitanto;
	public static Object instance;
	
	public Raitanto(int i) {
		super(Materials.stal);
		
		Raitanto = new ItemSword(Materials.stal);
		
		this.setUnlocalizedName("Raitanto");
		this.setTextureName("narutocraftmod:Raitanto");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}
