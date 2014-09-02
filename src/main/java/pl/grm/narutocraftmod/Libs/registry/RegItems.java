package pl.grm.narutocraftmod.libs.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.armor.NCPLItemArmor;
import pl.grm.narutocraftmod.items.DZwoj;
import pl.grm.narutocraftmod.items.FZwoj;
import pl.grm.narutocraftmod.items.KZwoj;
import pl.grm.narutocraftmod.items.NZwoj;
import pl.grm.narutocraftmod.items.RZwoj;
import pl.grm.narutocraftmod.items.SZwoj;
import pl.grm.narutocraftmod.libs.Materials;
import pl.grm.narutocraftmod.libs.References;
import pl.grm.narutocraftmod.weapons.KBushido;
import pl.grm.narutocraftmod.weapons.KaMiecz;
import pl.grm.narutocraftmod.weapons.Katana;
import pl.grm.narutocraftmod.weapons.Kubiki;
import pl.grm.narutocraftmod.weapons.Kurosawa;
import pl.grm.narutocraftmod.weapons.MSamuraja;
import pl.grm.narutocraftmod.weapons.Nunchaku;
import pl.grm.narutocraftmod.weapons.RKatana;
import pl.grm.narutocraftmod.weapons.Raitanto;
import pl.grm.narutocraftmod.weapons.Wakizashi;
import pl.grm.narutocraftmod.weapons.ZRekawica;
import pl.grm.narutocraftmod.weapons.projectiles.Kunai;
import pl.grm.narutocraftmod.weapons.projectiles.Senbon;
import pl.grm.narutocraftmod.weapons.projectiles.Shuriken;
import pl.grm.narutocraftmod.weapons.projectiles.WKunai;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegItems extends NarutoCraftMod
{
	public static Item block;
	
	//The Id's where not needed so I removed those and re done how Weapons are defined.
	
	/**Weapons**/
   	public static Item Kunai = new Kunai().setUnlocalizedName("Kunai").setTextureName(References.ModTexturePath+"weapons/Kunai");
   	public static Item WKunai = new WKunai().setUnlocalizedName("WybuchowyKunai").setTextureName(References.ModTexturePath+"weapons/Wybuchowy Kunai");
   	//the zeros are just for the constructor placeholder, I am slowly fixing these to work correctly
   	public static Item Shuriken = new Shuriken().setUnlocalizedName("Shuriken").setTextureName(References.ModTexturePath+"weapons/Shuriken");
   	public static Item Senbon = new Senbon(0);
   	public static Item Raitanto = new Raitanto(0);
   	public static Item KaMiecz = new KaMiecz(0);
   	public static Item Katana = new Katana(0);
   	public static Item KBushido = new KBushido(0);
   	public static Item Kubiki = new Kubiki(0);
   	public static Item Kurosawa = new Kurosawa(0);
   	public static Item RKatana = new RKatana(0);
   	public static Item Wakizashi = new Wakizashi(0);
   	public static Item MSamuraja = new MSamuraja(0);
   	public static Item ZRekawica = new ZRekawica(0);
   	public static Item Nunchaku = new Nunchaku(0);
   	
   	/** Not sure what these are **/
   	public static Item FZwoj = new FZwoj(0);
   	public static Item KZwoj = new KZwoj(0);
   	public static Item DZwoj = new DZwoj(0);
   	public static Item SZwoj = new SZwoj(0);
   	public static Item RZwoj = new RZwoj(0);
   	public static Item NZwoj = new NZwoj(0);
   	
	public static ArmorMaterial Bushido = Materials.armorBUSHIDO;
	public static ArmorMaterial Anbu = Materials.armorANBU;
	public static ArmorMaterial Kiri = Materials.armorKIRI;
	public static ArmorMaterial Suna = Materials.armorSUNA;
	public static ArmorMaterial Akatsuki =Materials.armorAKATSUKI;
	//public static int renderBushidoArmor = proxy.addArmor("Bushido");
   	
   	public static final ItemArmor helmetBushido = (ItemArmor) (new NCPLItemArmor(Bushido, 4, 0)).setUnlocalizedName("helmetBushido");
	public static final ItemArmor plateBushido = (ItemArmor) (new NCPLItemArmor(Bushido, 4, 1)).setUnlocalizedName("chestplateBushido");
	public static final ItemArmor legsBushido = (ItemArmor) (new NCPLItemArmor(Bushido, 4, 2)).setUnlocalizedName("leggingsBushido");
	public static final ItemArmor bootsBushido = (ItemArmor) (new NCPLItemArmor(Bushido, 4, 3)).setUnlocalizedName("bootsBushido");
	public static final ItemArmor helmetAnbu1  = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 0)).setUnlocalizedName("helmetAnbu1");
	public static final ItemArmor helmetAnbu2 = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 0)).setUnlocalizedName("HelmetAnbu2");
	public static final ItemArmor helmetAnbu3 = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 0)).setUnlocalizedName("HelmetAnbu3");
	public static final ItemArmor helmetAnbu4 = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 0)).setUnlocalizedName("HelmetAnbu4");
	public static final ItemArmor plateAnbu = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 1)).setUnlocalizedName("plateAnbu");
    public static final ItemArmor legsAnbu = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 2)).setUnlocalizedName("legginsAnbu");
    public static final ItemArmor bootsAnbu = (ItemArmor) (new NCPLItemArmor(Anbu, 4, 3)).setUnlocalizedName("bootsAnbu");
    public static final ItemArmor plateKiri = (ItemArmor) (new NCPLItemArmor(Kiri, 4, 2)).setUnlocalizedName("plateKiri");
    public static final ItemArmor legsKiri = (ItemArmor) (new NCPLItemArmor(Kiri, 4,  3)).setUnlocalizedName("legginsKiri");
    public static final ItemArmor plateSuna = (ItemArmor) (new NCPLItemArmor(Suna, 4, 3)).setUnlocalizedName("plateSuna");
    public static final ItemArmor legsSuna = (ItemArmor) (new NCPLItemArmor(Suna, 4, 3)).setUnlocalizedName("legginsSuna");
    public static final ItemArmor helmetAkatsuki = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4, 0)).setUnlocalizedName("helmentAkatsuki");
    public static final ItemArmor plateAkatsuki = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4, 1)).setUnlocalizedName("plateAkatsuki");
    public static final ItemArmor plateAkatsuki2 = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4, 1)).setUnlocalizedName("plateAkatsuki2");
    public static final ItemArmor plateAkatsuki3 = (ItemArmor)  (new NCPLItemArmor(Akatsuki, 4, 1)).setUnlocalizedName("plateAkatsuki3");
    public static final ItemArmor legsAkatsuki = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4, 2)).setUnlocalizedName("legginsAkatsuki");
    public static final ItemArmor bootsAkatsuki = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4, 3)).setUnlocalizedName("bootsAkatsuki");
//	public static Item  = new (id+);

	public static void RegItemsList() {
		//Bronie
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
        GameRegistry.registerItem(Nunchaku, "Nunchaku");
        
        //GameRegistry.registerItem(, "");
        //Itemy
        GameRegistry.registerItem(FZwoj, "FZwoj");
        GameRegistry.registerItem(KZwoj, "KZwoj");
        GameRegistry.registerItem(DZwoj, "DZwoj");
        GameRegistry.registerItem(SZwoj, "SZwoj");
        GameRegistry.registerItem(RZwoj, "RZwoj");
        GameRegistry.registerItem(NZwoj, "NZwoj");
        //Zbroja
        GameRegistry.registerItem(helmetBushido, "HelmetBushido");
        GameRegistry.registerItem(plateBushido, "PlateBushido");
        GameRegistry.registerItem(legsBushido, "LegsBushido");
        GameRegistry.registerItem(bootsBushido, "BootsBushido");
        GameRegistry.registerItem(helmetAnbu1, "HelmetAnbu");
        GameRegistry.registerItem(helmetAnbu2, "HelmetAnbu2");
        GameRegistry.registerItem(helmetAnbu3, "HelmetAnbu3");
        GameRegistry.registerItem(helmetAnbu4, "HelmetAnbu4");
        GameRegistry.registerItem(plateAnbu, "PlateAnbu");
        GameRegistry.registerItem(legsAnbu, "LegsAnbu");
        GameRegistry.registerItem(bootsAnbu, "BootsAnbu");
        GameRegistry.registerItem(plateKiri, "PlateKiri");
        GameRegistry.registerItem(legsKiri, "LegsKiri");
        GameRegistry.registerItem(plateSuna, "PlateSuna");
        GameRegistry.registerItem(legsSuna, "LegsSuna");
        GameRegistry.registerItem(helmetAkatsuki, "HelmetAkatsuki");
        GameRegistry.registerItem(plateAkatsuki, "PlateAkatsuki");
        GameRegistry.registerItem(plateAkatsuki2, "PlateAkatsuki2");
        GameRegistry.registerItem(plateAkatsuki3, "PlateAkatsuki3");
        GameRegistry.registerItem(legsAkatsuki, "LegsAkatsuki");
        GameRegistry.registerItem(bootsAkatsuki, "BootsAkatsuki");
        
        //GameRegistry.registerItem(, "");
	}
   	
}
