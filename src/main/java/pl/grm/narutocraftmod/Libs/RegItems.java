package pl.grm.narutocraftmod.Libs;

import net.minecraft.item.Item;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Weapons.KBushido;
import pl.grm.narutocraftmod.Weapons.KaMiecz;
import pl.grm.narutocraftmod.Weapons.Katana;
import pl.grm.narutocraftmod.Weapons.Kubiki;
import pl.grm.narutocraftmod.Weapons.Kurosawa;
import pl.grm.narutocraftmod.Weapons.RKatana;
import pl.grm.narutocraftmod.Weapons.Raitanto;
import pl.grm.narutocraftmod.Weapons.Wakizashi;
import pl.grm.narutocraftmod.Weapons.Projectiles.Kunai;
import pl.grm.narutocraftmod.Weapons.Projectiles.Senbon;
import pl.grm.narutocraftmod.Weapons.Projectiles.Shuriken;
import pl.grm.narutocraftmod.Weapons.Projectiles.WKunai;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegItems extends NarutoCraftMod{
	private static int id = 4650;
	public static Item block;
	
   	public static Item Kunai = new Kunai(id);
   	public static Item WKunai = new WKunai(id+1);
   	public static Item Shuriken = new Shuriken(id+2);
   	public static Item Senbon = new Senbon(id+3);
   	public static Item Raitanto = new Raitanto(id+4);
   	public static Item KaMiecz = new KaMiecz(id+5);
   	public static Item Katana = new Katana(id+6);
   	public static Item KBushido = new KBushido(id+7);
   	public static Item Kubiki = new Kubiki(id+8);
   	public static Item Kurosawa = new Kurosawa(id+9);
   	public static Item RKatana = new RKatana(id+10);
   	public static Item  Wakizashi= new Wakizashi(id+11);
//	public static Item  = new (id+);

	public static void RegItemsList() {

		GameRegistry.registerItem(Kunai, "Kunai");
		GameRegistry.registerItem(WKunai, "WybuchowyKunai");
		GameRegistry.registerItem(Shuriken, "Shuriken");
        GameRegistry.registerItem(Senbon, "Senbon");
        GameRegistry.registerItem(Raitanto, "Raitanto");
        GameRegistry.registerItem(KaMiecz, "KamiennyMiecz");
        GameRegistry.registerItem(Katana, "Katana");
        GameRegistry.registerItem(KBushido, "KatanaBushido");
        GameRegistry.registerItem(Kubiki, "Kubikiribocho");
        GameRegistry.registerItem(Kurosawa, "Kurosawa");
        GameRegistry.registerItem(RKatana, "RyuuKatana");
        GameRegistry.registerItem(Wakizashi, "Wakizashi");
        //GameRegistry.registerItem(, "");
        //GameRegistry.registerItem(, "");
        //GameRegistry.registerItem(, "");
        //GameRegistry.registerItem(, "");
	}
   	
}
