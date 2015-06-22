package pl.grm.narutocraft.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import pl.grm.narutocraft.items.weapons.IronGlove;
import pl.grm.narutocraft.items.weapons.projectiles.*;
import pl.grm.narutocraft.libs.config.References;

public class RegWeapons extends RegItems {

	//public static Item Kunai = new Kunai().setUnlocalizedName("Kunai").setFull3D();

	//public static Item WKunai = new WKunai().setUnlocalizedName("WybuchowyKunai").setFull3D();
	//public static Item Shuriken = new Shuriken().setUnlocalizedName("Shuriken").setFull3D();
	//public static Item Senbon = new Senbon().setUnlocalizedName("Senbon");
	//public static Item Raitanto = new Raitanto().setUnlocalizedName("Raitanto");
	//public static Item KaMiecz = new StoneSword().setUnlocalizedName("KamienyMiecz");
	//public static Item Katana = new Katana().setUnlocalizedName("Katana");
	//public static Item KBushido = new KBushido().setUnlocalizedName("KBushido");
	//public static Item Kubiki = new Kubiki().setUnlocalizedName("Kubiki");
	//public static Item Kurosawa = new Kurosawa();
	//public static Item RKatana = new RKatana().setUnlocalizedName("RKatana");
	//public static Item Wakizashi = new Wakizashi().setUnlocalizedName("Wakizashi");
	//public static Item MSamuraja = new SamuraiSword().setUnlocalizedName("MSamuraja");
	public static Item IronGlove = new IronGlove().setUnlocalizedName("IronGlove");
	//public static Item Nunchaku = new Nunchaku().setUnlocalizedName("Nunchaku");
	//public static Item ChioRyuuGatana = new ChioRyuuGatana().setUnlocalizedName("ChioRyuuGatana");
	//public static Item Scalpel = new Scalpel().setUnlocalizedName("Skalpel");

	public static void regWeaponsList() {
		//registerItem(Kunai, "Kunai");
		//registerItem(WKunai, "WybuchowyKunai");
		//registerItem(Shuriken, "Shuriken");
		//registerItem(Senbon, "Senbon");
		//registerItem(Raitanto, "Raitanto");
		//registerItem(KaMiecz, "KamiennyMiecz");
		//registerItem(Katana, "Katana");
		//registerItem(KBushido, "KatanaBushido");
		//registerItem(Kubikiribocho, "Kubikiribocho");
		//registerItem(Kurosawa, "Kurosawa");
		//registerItem(RKatana, "RyuuKatana");
		//registerItem(Wakizashi, "Wakizashi");
		//registerItem(SamuraiSword, "SamuraiSword");
		registerItem(IronGlove, "IronGlove");
		//registerItem(Nunchaku, "Nunchaku");
		//registerItem(ChioRyuuGatana, "ChioRyuuGatana");
		//registerItem(Scalpel, "Skalpel");
	}
	protected static void registerWeapon(Item item, String name) {
		GameRegistry.registerItem(item, name);
	}

	protected static void registerRendererToItem(Item item, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
				.register(item, 0, new ModelResourceLocation(References.ModTexturePath + name, "inventory"));
	}
	// public static void regRenderers() {
	 //registerRendererToItem(Kurosawa, "Kurosawa");
	}
	

	

	
//}

