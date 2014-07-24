package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Blocks.Materials;

public class KaMiecz extends ItemSword {
	public static Item KamiennyMiecz;
	public static Object instance;
	
	public KaMiecz (int i) {
		super(Materials.kamien);

		this.setUnlocalizedName("KaMiecz");
		this.setTextureName("narutocraftmod:Kamienny Miecz");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}