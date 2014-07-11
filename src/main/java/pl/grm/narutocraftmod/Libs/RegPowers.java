package pl.grm.narutocraftmod.Libs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import pl.grm.narutocraftmod.Powers.KawarimiNoJutsu;
import pl.grm.narutocraftmod.Powers.Rasengan;
import pl.grm.narutocraftmod.Powers.Rasengan2;
import pl.grm.narutocraftmod.Powers.Rasengan3;
import pl.grm.narutocraftmod.Powers.Sharingan;
import pl.grm.narutocraftmod.Powers.ShunshinNoJutsu;

public class RegPowers {
	private static int id = 4600;
	public static Item KNoJutsu = new KawarimiNoJutsu(id);
    public static Item SNoJutsu = new ShunshinNoJutsu(id+1);
   	public static Item Sharingan = new Sharingan(id+2);
   	public static Item Rasengan = new Rasengan(id+3);
   	public static Item Rasengan2 = new Rasengan2(id+4);
   	public static Item Rasengan3 = new Rasengan3(id+5);
//	public static Item  = new (id+);
   	
   	
   	public static void RegPowersList() {
		GameRegistry.registerItem(KNoJutsu, "KawarimiNoJutsu");
		GameRegistry.registerItem(SNoJutsu, "ShunshinNoJutsu");
		GameRegistry.registerItem(Sharingan, "Sharingan");
		GameRegistry.registerItem(Rasengan, "Rasengan");
		GameRegistry.registerItem(Rasengan2, "OdamaRasengan");
		GameRegistry.registerItem(Rasengan3, "ChioOdamaRasengan");
		//GameRegistry.registerItem(, "");
   	}
}
