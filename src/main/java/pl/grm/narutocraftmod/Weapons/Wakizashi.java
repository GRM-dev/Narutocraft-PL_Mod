package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.Materials;

public class Wakizashi extends ItemSword {
	public static Item Wakizashi;
	public static Object instance;
	
	public Wakizashi (int i) {
		super(Materials.tytan);

		this.setUnlocalizedName("Wakizashi");
		this.setTextureName("narutocraftmod:Wakizashi");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}