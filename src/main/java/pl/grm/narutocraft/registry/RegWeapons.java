package pl.grm.narutocraft.registry;

import net.minecraft.item.*;
import pl.grm.narutocraft.items.weapons.*;
import pl.grm.narutocraft.items.weapons.projectiles.*;

public class RegWeapons extends RegItems {
	public static Item	Kunai			= new Kunai().setUnlocalizedName("Kunai").setFull3D();
	
	public static Item	WKunai			= new WKunai().setUnlocalizedName("WybuchowyKunai")
												.setFull3D();
	public static Item	Shuriken		= new Shuriken().setUnlocalizedName("Shuriken").setFull3D();
	public static Item	Senbon			= new Senbon().setUnlocalizedName("Senbon");
	public static Item	Raitanto		= new Raitanto().setUnlocalizedName("Raitanto");
	public static Item	KaMiecz			= new KaMiecz().setUnlocalizedName("KamienyMiecz");
	public static Item	Katana			= new Katana().setUnlocalizedName("Katana");
	public static Item	KBushido		= new KBushido().setUnlocalizedName("KBushido");
	public static Item	Kubiki			= new Kubiki().setUnlocalizedName("Kubiki");
	public static Item	Kurosawa		= new Kurosawa().setUnlocalizedName("Kurosawa");
	public static Item	RKatana			= new RKatana().setUnlocalizedName("RKatana");
	public static Item	Wakizashi		= new Wakizashi().setUnlocalizedName("Wakizashi");
	public static Item	MSamuraja		= new MSamuraja().setUnlocalizedName("MSamuraja");
	public static Item	ZRekawica		= new ZRekawica().setUnlocalizedName("ZRekawica");
	public static Item	Nunchaku		= new Nunchaku().setUnlocalizedName("Nunchaku");
	public static Item	ChioRyuuGatana	= new ChioRyuuGatana().setUnlocalizedName("ChioRyuuGatana");
	public static Item	Scalpel			= new Scalpel().setUnlocalizedName("Skalpel");
	
	public static void regWeaponsList() {
		registerItem(Kunai, "Kunai");
		registerItem(WKunai, "WybuchowyKunai");
		registerItem(Shuriken, "Shuriken");
		registerItem(Senbon, "Senbon");
		registerItem(Raitanto, "Raitanto");
		registerItem(KaMiecz, "KamiennyMiecz");
		registerItem(Katana, "Katana");
		registerItem(KBushido, "KatanaBushido");
		registerItem(Kubiki, "Kubikiribocho");
		registerItem(Kurosawa, "Kurosawa");
		registerItem(RKatana, "RyuuKatana");
		registerItem(Wakizashi, "Wakizashi");
		registerItem(MSamuraja, "MSamuraja");
		registerItem(ZRekawica, "ZRekawica");
		registerItem(Nunchaku, "Nunchaku");
		registerItem(ChioRyuuGatana, "ChioRyuuGatana");
		registerItem(Scalpel, "Skalpel");
	}
}
