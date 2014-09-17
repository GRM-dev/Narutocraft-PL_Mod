package pl.grm.narutocraft.registry;

import net.minecraft.item.ItemArmor;
import pl.grm.narutocraft.armor.NCPLItemArmor;

public class RegArmor extends RegItems {
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
	public static final ItemArmor helmetAnbu1 = (ItemArmor) (new NCPLItemArmor(
			Anbu, 4, 0)).setUnlocalizedName("helmetAnbu1");
	public static final ItemArmor helmetAnbu2 = (ItemArmor) (new NCPLItemArmor(
			Anbu, 4, 0)).setUnlocalizedName("HelmetAnbu2");
	public static final ItemArmor helmetAnbu3 = (ItemArmor) (new NCPLItemArmor(
			Anbu, 4, 0)).setUnlocalizedName("HelmetAnbu3");
	public static final ItemArmor helmetAnbu4 = (ItemArmor) (new NCPLItemArmor(
			Anbu, 4, 0)).setUnlocalizedName("HelmetAnbu4");
	public static final ItemArmor plateAnbu = (ItemArmor) (new NCPLItemArmor(
			Anbu, 4, 1)).setUnlocalizedName("plateAnbu");
	public static final ItemArmor legsAnbu = (ItemArmor) (new NCPLItemArmor(
			Anbu, 4, 2)).setUnlocalizedName("legginsAnbu");
	public static final ItemArmor bootsAnbu = (ItemArmor) (new NCPLItemArmor(
			Anbu, 4, 3)).setUnlocalizedName("bootsAnbu");
	public static final ItemArmor plateKiri = (ItemArmor) (new NCPLItemArmor(
			Kiri, 4, 2)).setUnlocalizedName("plateKiri");
	public static final ItemArmor legsKiri = (ItemArmor) (new NCPLItemArmor(
			Kiri, 4, 3)).setUnlocalizedName("legginsKiri");
	public static final ItemArmor plateSuna = (ItemArmor) (new NCPLItemArmor(
			Suna, 4, 3)).setUnlocalizedName("plateSuna");
	public static final ItemArmor legsSuna = (ItemArmor) (new NCPLItemArmor(
			Suna, 4, 3)).setUnlocalizedName("legginsSuna");
	public static final ItemArmor helmetAkatsuki = (ItemArmor) (new NCPLItemArmor(
			Akatsuki, 4, 0)).setUnlocalizedName("helmentAkatsuki");
	public static final ItemArmor plateAkatsuki = (ItemArmor) (new NCPLItemArmor(
			Akatsuki, 4, 1)).setUnlocalizedName("plateAkatsuki");
	public static final ItemArmor plateAkatsuki2 = (ItemArmor) (new NCPLItemArmor(
			Akatsuki, 4, 1)).setUnlocalizedName("plateAkatsuki2");
	public static final ItemArmor plateAkatsuki3 = (ItemArmor) (new NCPLItemArmor(
			Akatsuki, 4, 1)).setUnlocalizedName("plateAkatsuki3");
	public static final ItemArmor legsAkatsuki = (ItemArmor) (new NCPLItemArmor(
			Akatsuki, 4, 2)).setUnlocalizedName("legginsAkatsuki");
	public static final ItemArmor bootsAkatsuki = (ItemArmor) (new NCPLItemArmor(
			Akatsuki, 4, 3)).setUnlocalizedName("bootsAkatsuki");

	public static void regArmorList() {
		registerItem(helmetBushido, "HelmetBushido");
		registerItem(plateBushido, "PlateBushido");
		registerItem(legsBushido, "LegsBushido");
		registerItem(bootsBushido, "BootsBushido");
		registerItem(helmetAnbu1, "HelmetAnbu");
		registerItem(helmetAnbu2, "HelmetAnbu2");
		registerItem(helmetAnbu3, "HelmetAnbu3");
		registerItem(helmetAnbu4, "HelmetAnbu4");
		registerItem(plateAnbu, "PlateAnbu");
		registerItem(legsAnbu, "LegsAnbu");
		registerItem(bootsAnbu, "BootsAnbu");
		registerItem(plateKiri, "PlateKiri");
		registerItem(legsKiri, "LegsKiri");
		registerItem(plateSuna, "PlateSuna");
		registerItem(legsSuna, "LegsSuna");
		registerItem(helmetAkatsuki, "HelmetAkatsuki");
		registerItem(plateAkatsuki, "PlateAkatsuki");
		registerItem(plateAkatsuki2, "PlateAkatsuki2");
		registerItem(plateAkatsuki3, "PlateAkatsuki3");
		registerItem(legsAkatsuki, "LegsAkatsuki");
		registerItem(bootsAkatsuki, "BootsAkatsuki");
	}
}