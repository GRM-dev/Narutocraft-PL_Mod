package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Libs.Materials;

public class ChioRyuuGatana extends ItemSword {
	public static Item ChioRyuuGatana;
	public static Object instance;
	
	public ChioRyuuGatana (int i) {
		super(Materials.metalshinobi2);
		
		this.setUnlocalizedName("Chio Ryuu Gatana");
		this.setTextureName("narutocraftmod:Chio Ryuu Gatana");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}