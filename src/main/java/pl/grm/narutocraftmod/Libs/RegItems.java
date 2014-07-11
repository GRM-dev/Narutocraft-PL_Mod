package pl.grm.narutocraftmod.Libs;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Weapons.Kunai;
import pl.grm.narutocraftmod.Weapons.Senbon;
import pl.grm.narutocraftmod.Weapons.Shuriken;
import pl.grm.narutocraftmod.Weapons.WKunai;
import pl.grm.narutocraftmod.Weapons.Raitanto;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegItems extends NarutoCraftMod{
	private static int id = 4650;
	public static Item block;
	
   	public static Item Kunai = new Kunai(id);
   	public static Item WKunai = new WKunai(id+1);
   	public static Item Shuriken = new Shuriken(id+2);
   	public static Item Senbon = new Senbon(id+3);
   	public static Item Raitanto = new Raitanto(id+4);
//	public static Item  = new (id+);

	public static void RegItemsList() {


		GameRegistry.registerItem(Kunai, "Kunai");
		GameRegistry.registerItem(WKunai, "WybuchowyKunai");
		GameRegistry.registerItem(Shuriken, "Shuriken");
        GameRegistry.registerItem(Senbon, "Senbon");
        GameRegistry.registerItem(Raitanto, "Raitanto");
        //Item.itemRegistry.addObject(431, "Raitanto", block);
        //GameRegistry.registerItem(, "");
	}
   	
}
