package pl.grm.narutocraft.registry;

import net.minecraft.item.Item;
import pl.grm.narutocraft.items.weapons.ChioRyuuGatana;
import pl.grm.narutocraft.items.weapons.KBushido;
import pl.grm.narutocraft.items.weapons.KaMiecz;
import pl.grm.narutocraft.items.weapons.Katana;
import pl.grm.narutocraft.items.weapons.Kubiki;
import pl.grm.narutocraft.items.weapons.Kurosawa;
import pl.grm.narutocraft.items.weapons.MSamuraja;
import pl.grm.narutocraft.items.weapons.Nunchaku;
import pl.grm.narutocraft.items.weapons.RKatana;
import pl.grm.narutocraft.items.weapons.Raitanto;
import pl.grm.narutocraft.items.weapons.Scalpel;
import pl.grm.narutocraft.items.weapons.Wakizashi;
import pl.grm.narutocraft.items.weapons.ZRekawica;
import pl.grm.narutocraft.items.weapons.projectiles.Kunai;
import pl.grm.narutocraft.items.weapons.projectiles.Senbon;
import pl.grm.narutocraft.items.weapons.projectiles.Shuriken;
import pl.grm.narutocraft.items.weapons.projectiles.WKunai;

public class RegWeapons extends RegItems {

	public static Item Kunai = new Kunai().setUnlocalizedName("Kunai").setFull3D();

	public static Item WKunai = new WKunai().setUnlocalizedName("WybuchowyKunai").setFull3D();
	public static Item Shuriken = new Shuriken().setUnlocalizedName("Shuriken").setFull3D();
	public static Item Senbon = new Senbon().setUnlocalizedName("Senbon");
	public static Item Raitanto = new Raitanto().setUnlocalizedName("Raitanto");
	public static Item KaMiecz = new KaMiecz().setUnlocalizedName("KamienyMiecz");
	public static Item Katana = new Katana().setUnlocalizedName("Katana");
	public static Item KBushido = new KBushido().setUnlocalizedName("KBushido");
	public static Item Kubiki = new Kubiki().setUnlocalizedName("Kubiki");
	public static Item Kurosawa = new Kurosawa().setUnlocalizedName("Kurosawa");
	public static Item RKatana = new RKatana().setUnlocalizedName("RKatana");
	public static Item Wakizashi = new Wakizashi().setUnlocalizedName("Wakizashi");
	public static Item MSamuraja = new MSamuraja().setUnlocalizedName("MSamuraja");
	public static Item ZRekawica = new ZRekawica().setUnlocalizedName("ZRekawica");
	public static Item Nunchaku = new Nunchaku().setUnlocalizedName("Nunchaku");
	public static Item ChioRyuuGatana = new ChioRyuuGatana().setUnlocalizedName("ChioRyuuGatana");
	public static Item Scalpel = new Scalpel().setUnlocalizedName("Skalpel");

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
