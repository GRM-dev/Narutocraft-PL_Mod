package pl.grm.narutocraft.libs.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.armor.NCPLItemArmor;
import pl.grm.narutocraft.items.DZwoj;
import pl.grm.narutocraft.items.FZwoj;
import pl.grm.narutocraft.items.KZwoj;
import pl.grm.narutocraft.items.NZwoj;
import pl.grm.narutocraft.items.RZwoj;
import pl.grm.narutocraft.items.SZwoj;
import pl.grm.narutocraft.libs.Materials;
import pl.grm.narutocraft.libs.References;
import pl.grm.narutocraft.weapons.KBushido;
import pl.grm.narutocraft.weapons.KaMiecz;
import pl.grm.narutocraft.weapons.Katana;
import pl.grm.narutocraft.weapons.Kubiki;
import pl.grm.narutocraft.weapons.Kurosawa;
import pl.grm.narutocraft.weapons.MSamuraja;
import pl.grm.narutocraft.weapons.Nunchaku;
import pl.grm.narutocraft.weapons.RKatana;
import pl.grm.narutocraft.weapons.Raitanto;
import pl.grm.narutocraft.weapons.Wakizashi;
import pl.grm.narutocraft.weapons.ZRekawica;
import pl.grm.narutocraft.weapons.projectiles.Kunai;
import pl.grm.narutocraft.weapons.projectiles.Senbon;
import pl.grm.narutocraft.weapons.projectiles.Shuriken;
import pl.grm.narutocraft.weapons.projectiles.WKunai;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegItems extends NarutoCraft {
	public static Item block;

	// The Id's where not needed so I removed those and re done how Weapons are
	// defined.

	/** Weapons **/
	public static Item Kunai = new Kunai().setUnlocalizedName("Kunai")
			.setTextureName(References.ModTexturePath + "weapons/Kunai")
			.setFull3D();
	public static Item WKunai = new WKunai()
			.setUnlocalizedName("WybuchowyKunai")
			.setTextureName(
					References.ModTexturePath + "weapons/Wybuchowy Kunai")
			.setFull3D();
	// the zeros are just for the constructor placeholder, I am slowly fixing
	// these to work correctly
	public static Item Shuriken = new Shuriken().setUnlocalizedName("Shuriken")
			.setTextureName(References.ModTexturePath + "weapons/Shuriken")
			.setFull3D();
	public static Item Senbon = new Senbon().setUnlocalizedName("Senbon")
			.setTextureName(References.ModTexturePath + "weapons/Senbon");
	public static Item Raitanto = new Raitanto().setUnlocalizedName("Raitanto")
			.setTextureName(References.ModTexturePath + "weapons/Raitanto");
	public static Item KaMiecz = new KaMiecz().setUnlocalizedName("KaMiecz")
			.setTextureName(
					References.ModTexturePath + "weapons/Kamienny Miecz");
	public static Item Katana = new Katana().setUnlocalizedName("Katana")
			.setTextureName(References.ModTexturePath + "weapons/Katana");
	public static Item KBushido = new KBushido().setUnlocalizedName("KBushido")
			.setTextureName(
					References.ModTexturePath + "weapons/Katana Bushido");
	public static Item Kubiki = new Kubiki()
			.setUnlocalizedName("Kubiki")
			.setTextureName(References.ModTexturePath + "weapons/Kubikiribocho");
	public static Item Kurosawa = new Kurosawa().setUnlocalizedName("Kurosawa")
			.setTextureName(References.ModTexturePath + "weapons/Kurosawa");
	public static Item RKatana = new RKatana().setUnlocalizedName("RKatana")
			.setTextureName(References.ModTexturePath + "weapons/RyuuKatana");
	public static Item Wakizashi = new Wakizashi().setUnlocalizedName(
			"Wakizashi").setTextureName(
			References.ModTexturePath + "weapons/Wakizashi");
	public static Item MSamuraja = new MSamuraja().setUnlocalizedName(
			"MSamuraja").setTextureName(
			References.ModTexturePath + "weapons/Miecz Samuraja");
	public static Item ZRekawica = new ZRekawica().setUnlocalizedName(
			"ZRekawica").setTextureName(
			References.ModTexturePath + "weapons/Zelazna Rekawica");
	public static Item Nunchaku = new Nunchaku().setUnlocalizedName("Nunchaku")
			.setTextureName(References.ModTexturePath + "weapons/Nunchaku");

	/** Not sure what these are **/
	public static Item FZwoj = new FZwoj();
	public static Item KZwoj = new KZwoj();
	public static Item DZwoj = new DZwoj();
	public static Item SZwoj = new SZwoj();
	public static Item RZwoj = new RZwoj();
	public static Item NZwoj = new NZwoj();

	public static ArmorMaterial Bushido = Materials.armorBUSHIDO;
	public static ArmorMaterial Anbu = Materials.armorANBU;
	public static ArmorMaterial Kiri = Materials.armorKIRI;
	public static ArmorMaterial Suna = Materials.armorSUNA;
	public static ArmorMaterial Akatsuki = Materials.armorAKATSUKI;
	// public static int renderBushidoArmor = proxy.addArmor("Bushido");

	public static final ItemArmor helmetBushido = (ItemArmor) (new NCPLItemArmor(
			Bushido, 4, 0, "Test", "BushidoArmor"))
			.setUnlocalizedName("helmetBushido");
	public static final ItemArmor plateBushido = (ItemArmor) (new NCPLItemArmor(
			Bushido, 4, 1, "Test", "BushidoArmor"))
			.setUnlocalizedName("chestplateBushido");
	public static final ItemArmor legsBushido = (ItemArmor) (new NCPLItemArmor(
			Bushido, 4, 2, "Test", "BushidoArmor"))
			.setUnlocalizedName("leggingsBushido");
	public static final ItemArmor bootsBushido = (ItemArmor) (new NCPLItemArmor(
			Bushido, 4, 3, "Test", "BushidoArmor"))
			.setUnlocalizedName("bootsBushido");
	/*
	 * public static final ItemArmor helmetAnbu1 = (ItemArmor) (new
	 * NCPLItemArmor(Anbu, 4, 0)).setUnlocalizedName("helmetAnbu1"); public
	 * static final ItemArmor helmetAnbu2 = (ItemArmor) (new NCPLItemArmor(Anbu,
	 * 4, 0)).setUnlocalizedName("HelmetAnbu2"); public static final ItemArmor
	 * helmetAnbu3 = (ItemArmor) (new NCPLItemArmor(Anbu, 4,
	 * 0)).setUnlocalizedName("HelmetAnbu3"); public static final ItemArmor
	 * helmetAnbu4 = (ItemArmor) (new NCPLItemArmor(Anbu, 4,
	 * 0)).setUnlocalizedName("HelmetAnbu4"); public static final ItemArmor
	 * plateAnbu = (ItemArmor) (new NCPLItemArmor(Anbu, 4,
	 * 1)).setUnlocalizedName("plateAnbu"); public static final ItemArmor
	 * legsAnbu = (ItemArmor) (new NCPLItemArmor(Anbu, 4,
	 * 2)).setUnlocalizedName("legginsAnbu"); public static final ItemArmor
	 * bootsAnbu = (ItemArmor) (new NCPLItemArmor(Anbu, 4,
	 * 3)).setUnlocalizedName("bootsAnbu"); public static final ItemArmor
	 * plateKiri = (ItemArmor) (new NCPLItemArmor(Kiri, 4,
	 * 2)).setUnlocalizedName("plateKiri"); public static final ItemArmor
	 * legsKiri = (ItemArmor) (new NCPLItemArmor(Kiri, 4,
	 * 3)).setUnlocalizedName("legginsKiri"); public static final ItemArmor
	 * plateSuna = (ItemArmor) (new NCPLItemArmor(Suna, 4,
	 * 3)).setUnlocalizedName("plateSuna"); public static final ItemArmor
	 * legsSuna = (ItemArmor) (new NCPLItemArmor(Suna, 4,
	 * 3)).setUnlocalizedName("legginsSuna"); public static final ItemArmor
	 * helmetAkatsuki = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4,
	 * 0)).setUnlocalizedName("helmentAkatsuki"); public static final ItemArmor
	 * plateAkatsuki = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4,
	 * 1)).setUnlocalizedName("plateAkatsuki"); public static final ItemArmor
	 * plateAkatsuki2 = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4,
	 * 1)).setUnlocalizedName("plateAkatsuki2"); public static final ItemArmor
	 * plateAkatsuki3 = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4,
	 * 1)).setUnlocalizedName("plateAkatsuki3"); public static final ItemArmor
	 * legsAkatsuki = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4,
	 * 2)).setUnlocalizedName("legginsAkatsuki"); public static final ItemArmor
	 * bootsAkatsuki = (ItemArmor) (new NCPLItemArmor(Akatsuki, 4,
	 * 3)).setUnlocalizedName("bootsAkatsuki");
	 */
	// public static Item = new (id+);

	public static void RegItemsList() {
		// Bronie
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

		// GameRegistry.registerItem(, "");
		// Itemy
		GameRegistry.registerItem(FZwoj, "FZwoj");
		GameRegistry.registerItem(KZwoj, "KZwoj");
		GameRegistry.registerItem(DZwoj, "DZwoj");
		GameRegistry.registerItem(SZwoj, "SZwoj");
		GameRegistry.registerItem(RZwoj, "RZwoj");
		GameRegistry.registerItem(NZwoj, "NZwoj");
		// Zbroja
		GameRegistry.registerItem(helmetBushido, "HelmetBushido");
		GameRegistry.registerItem(plateBushido, "PlateBushido");
		GameRegistry.registerItem(legsBushido, "LegsBushido");
		GameRegistry.registerItem(bootsBushido, "BootsBushido");
		/*
		 * GameRegistry.registerItem(helmetAnbu1, "HelmetAnbu");
		 * GameRegistry.registerItem(helmetAnbu2, "HelmetAnbu2");
		 * GameRegistry.registerItem(helmetAnbu3, "HelmetAnbu3");
		 * GameRegistry.registerItem(helmetAnbu4, "HelmetAnbu4");
		 * GameRegistry.registerItem(plateAnbu, "PlateAnbu");
		 * GameRegistry.registerItem(legsAnbu, "LegsAnbu");
		 * GameRegistry.registerItem(bootsAnbu, "BootsAnbu");
		 * GameRegistry.registerItem(plateKiri, "PlateKiri");
		 * GameRegistry.registerItem(legsKiri, "LegsKiri");
		 * GameRegistry.registerItem(plateSuna, "PlateSuna");
		 * GameRegistry.registerItem(legsSuna, "LegsSuna");
		 * GameRegistry.registerItem(helmetAkatsuki, "HelmetAkatsuki");
		 * GameRegistry.registerItem(plateAkatsuki, "PlateAkatsuki");
		 * GameRegistry.registerItem(plateAkatsuki2, "PlateAkatsuki2");
		 * GameRegistry.registerItem(plateAkatsuki3, "PlateAkatsuki3");
		 * GameRegistry.registerItem(legsAkatsuki, "LegsAkatsuki");
		 * GameRegistry.registerItem(bootsAkatsuki, "BootsAkatsuki");
		 */

		// GameRegistry.registerItem(, "");
	}

}
