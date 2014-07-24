package pl.grm.narutocraftmod.Libs;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Weapons.KBushido;
import pl.grm.narutocraftmod.Weapons.KaMiecz;
import pl.grm.narutocraftmod.Weapons.Katana;
import pl.grm.narutocraftmod.Weapons.Kubiki;
import pl.grm.narutocraftmod.Weapons.Kurosawa;
import pl.grm.narutocraftmod.Weapons.MSamuraja;
import pl.grm.narutocraftmod.Weapons.RKatana;
import pl.grm.narutocraftmod.Weapons.Raitanto;
import pl.grm.narutocraftmod.Weapons.Wakizashi;
import pl.grm.narutocraftmod.Weapons.ZRekawica;
import pl.grm.narutocraftmod.Weapons.Projectiles.Kunai;
import pl.grm.narutocraftmod.Weapons.Projectiles.Senbon;
import pl.grm.narutocraftmod.Weapons.Projectiles.Shuriken;
import pl.grm.narutocraftmod.Weapons.Projectiles.WKunai;
import pl.grm.narutocraftmod.Armor.NCPLItemArmor;
import pl.grm.narutocraftmod.Blocks.Materials;
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
   	public static Item Wakizashi= new Wakizashi(id+11);
   	public static Item MSamuraja= new MSamuraja(id+12);
   	public static Item ZRekawica= new ZRekawica(id+13);
   	
	public static ArmorMaterial Bushido = Materials.armorBUSHIDO;
	public static ArmorMaterial Anbu = Materials.armorANBU;
	//public static int renderBushidoArmor = proxy.addArmor("Bushido");
   	
   	public static final ItemArmor helmetBushido = (ItemArmor) (new NCPLItemArmor(Bushido, 4, 0)).setUnlocalizedName("helmetBushido");
	public static final ItemArmor plateBushido = (ItemArmor) (new NCPLItemArmor(Bushido, 4, 1)).setUnlocalizedName("chestplateBushido");
	public static final ItemArmor legsBushido = (ItemArmor) (new NCPLItemArmor(Bushido, 4, 2)).setUnlocalizedName("leggingsBushido");
	public static final ItemArmor bootsBushido = (ItemArmor) (new NCPLItemArmor(Bushido, 4, 3)).setUnlocalizedName("bootsBushido");
	public static final ItemArmor helmetAnbu  = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 0)).setUnlocalizedName("helmetAnbu");
    public static final ItemArmor plateAnbu = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 1)).setUnlocalizedName("plateAnbu");
    public static final ItemArmor legsAnbu = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 2)).setUnlocalizedName("legginsAnbu");
    public static final ItemArmor bootsAnbu = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 3)).setUnlocalizedName("bootsAnbu");
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
        GameRegistry.registerItem(MSamuraja, "MSamuraja");
        GameRegistry.registerItem(ZRekawica, "ZRekawica");
        //GameRegistry.registerItem(, "");
        GameRegistry.registerItem(helmetBushido, "HelmetBushido");
        GameRegistry.registerItem(plateBushido, "PlateBushido");
        GameRegistry.registerItem(legsBushido, "LegsBushido");
        GameRegistry.registerItem(bootsBushido, "BootsBushido");
        GameRegistry.registerItem(helmetAnbu, "HelmetAnbu");
        GameRegistry.registerItem(plateAnbu, "PlateAnbu");
        GameRegistry.registerItem(legsAnbu, "LegsAnbu");
        GameRegistry.registerItem(bootsAnbu, "BootsAnbu");
        //GameRegistry.registerItem(, "");
	}
   	
}
