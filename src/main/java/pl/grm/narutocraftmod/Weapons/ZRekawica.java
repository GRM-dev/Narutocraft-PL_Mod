package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Blocks.Materials;

public class ZRekawica extends ItemSword {
	public static Item ZelaznaRekawica;
	public static Object instance;
	
	public ZRekawica (int i) {
		super(Materials.stal);
		
		this.setUnlocalizedName("¯ela¿na Rêkawica");
		this.setTextureName("narutocraftmod:Zelazna Rekawica");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}