package pl.grm.narutocraftmod.Weapons;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Blocks.Materials;

public class Kubiki extends ItemSword {
	public static Item Kubikiribocho;
	public static Object instance;
	
	public Kubiki(int i) {
		super(Materials.metalshinobi);

		this.setUnlocalizedName("Kubikiribocho");
		this.setTextureName("narutocraftmod:Kubikiribocho");
		this.setCreativeTab(NarutoCraftMod.mTabNarutoCraftMod);

	}
}