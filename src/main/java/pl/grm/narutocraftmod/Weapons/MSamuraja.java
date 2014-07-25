package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.Materials;

public class MSamuraja extends ItemSword {
	public static Item MieczSamuraja;
	public static Object instance;
	
	public MSamuraja (int i) {
		super(Materials.stal3);

		this.setUnlocalizedName("MSamuraja");
		this.setTextureName("narutocraftmod:Miecz Samuraja");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}