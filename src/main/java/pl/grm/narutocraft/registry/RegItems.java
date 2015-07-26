package pl.grm.narutocraft.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.items.DScroll;
import pl.grm.narutocraft.items.EScroll;
import pl.grm.narutocraft.items.FScroll;
import pl.grm.narutocraft.items.HScroll;
import pl.grm.narutocraft.items.KScroll;
import pl.grm.narutocraft.items.NScroll;
import pl.grm.narutocraft.items.RScroll;
import pl.grm.narutocraft.items.Rin;
import pl.grm.narutocraft.items.Ryo;
import pl.grm.narutocraft.items.SScroll;
import pl.grm.narutocraft.items.armor.NCPLItemArmor;
import pl.grm.narutocraft.items.weapons.BigKunai;
import pl.grm.narutocraft.items.weapons.BigScroll;
import pl.grm.narutocraft.items.weapons.Bijuudama;
import pl.grm.narutocraft.items.weapons.BushidoKatana;
import pl.grm.narutocraft.items.weapons.ChioRyuuGatana;
import pl.grm.narutocraft.items.weapons.DoubleKusarigama;
import pl.grm.narutocraft.items.weapons.ExplosiveNote;
import pl.grm.narutocraft.items.weapons.FoodMilitaryPill;
import pl.grm.narutocraft.items.weapons.Hiramekarei;
import pl.grm.narutocraft.items.weapons.HyuugaSalve;
import pl.grm.narutocraft.items.weapons.IchirakuRamen;
import pl.grm.narutocraft.items.weapons.IronGlove;
import pl.grm.narutocraft.items.weapons.KabutowariAxe;
import pl.grm.narutocraft.items.weapons.KabutowariHammer;
import pl.grm.narutocraft.items.weapons.Kama;
import pl.grm.narutocraft.items.weapons.Katana;
import pl.grm.narutocraft.items.weapons.Kiba;
import pl.grm.narutocraft.items.weapons.Knuckleduster;
import pl.grm.narutocraft.items.weapons.Kubikiribocho;
import pl.grm.narutocraft.items.weapons.Kurosawa;
import pl.grm.narutocraft.items.weapons.Kusanagi;
import pl.grm.narutocraft.items.weapons.KusanagiOrochimaru;
import pl.grm.narutocraft.items.weapons.KusariFuuboo;
import pl.grm.narutocraft.items.weapons.Kusarigama;
import pl.grm.narutocraft.items.weapons.Kusarigamawithpiston;
import pl.grm.narutocraft.items.weapons.LightBomb;
import pl.grm.narutocraft.items.weapons.LullingBomb;
import pl.grm.narutocraft.items.weapons.Machete;
import pl.grm.narutocraft.items.weapons.MetalCable;
import pl.grm.narutocraft.items.weapons.Mine;
import pl.grm.narutocraft.items.weapons.NarutoMaki;
import pl.grm.narutocraft.items.weapons.Nuibari;
import pl.grm.narutocraft.items.weapons.Nunchaku;
import pl.grm.narutocraft.items.weapons.Pasta;
import pl.grm.narutocraft.items.weapons.PillWithCoagulatedBlood;
import pl.grm.narutocraft.items.weapons.Raitanto;
import pl.grm.narutocraft.items.weapons.Ramen;
import pl.grm.narutocraft.items.weapons.RikudouStaff;
import pl.grm.narutocraft.items.weapons.Ringtones;
import pl.grm.narutocraft.items.weapons.RyuuKatana;
import pl.grm.narutocraft.items.weapons.Samehada;
import pl.grm.narutocraft.items.weapons.SamuraiSword;
import pl.grm.narutocraft.items.weapons.Scalpel;
import pl.grm.narutocraft.items.weapons.ShellRockMace;
import pl.grm.narutocraft.items.weapons.Shibuki;
import pl.grm.narutocraft.items.weapons.SmokeBomb;
import pl.grm.narutocraft.items.weapons.StoneSword;
import pl.grm.narutocraft.items.weapons.TaishouSword;
import pl.grm.narutocraft.items.weapons.Tanto;
import pl.grm.narutocraft.items.weapons.ThreeProngedKnife;
import pl.grm.narutocraft.items.weapons.Wakizashi;
import pl.grm.narutocraft.items.weapons.WarKunai;
import pl.grm.narutocraft.items.weapons.Weights;
import pl.grm.narutocraft.items.weapons.projectiles.BigShuriken;
import pl.grm.narutocraft.items.weapons.projectiles.DoubleKunai;
import pl.grm.narutocraft.items.weapons.projectiles.ExplodeKunai;
import pl.grm.narutocraft.items.weapons.projectiles.FuumaShuriken;
import pl.grm.narutocraft.items.weapons.projectiles.KumoShuriken;
import pl.grm.narutocraft.items.weapons.projectiles.Kunai;
import pl.grm.narutocraft.items.weapons.projectiles.PoisonedSenbon;
import pl.grm.narutocraft.items.weapons.projectiles.Senbon;
import pl.grm.narutocraft.items.weapons.projectiles.Shuriken;
import pl.grm.narutocraft.libs.config.Materials;
import pl.grm.narutocraft.libs.config.References;

public class RegItems extends NarutoCraft {

	
	

	
	// Jutsus
	/*public static Item AsaKujaku = new AsaKujaku()
			.setUnlocalizedName("AsaKujaku");
	public static Item Hirudora = new Hirudora().setUnlocalizedName("Hirudora");
	public static Item KageBuyo = new KageBuyo().setUnlocalizedName("KageBuyo");
	public static Item KosaHo = new KosaHo().setUnlocalizedName("KosaHo");
	public static Item OmoteRenge = new OmoteRenge()
			.setUnlocalizedName("OmoteRenge");
	public static Item UraRenge = new UraRenge().setUnlocalizedName("UraRenge");
	public static Item FumaNinken = new FumaNinken()
			.setUnlocalizedName("FumaNinken");
	public static Item Hadan = new Hadan().setUnlocalizedName("Hadan");
	public static Item Iaido = new Iaido().setUnlocalizedName("Iaido");
	public static Item Issen = new Issen().setUnlocalizedName("Issen");
	public static Item MikazukiKiri = new MikazukiKiri()
			.setUnlocalizedName("MikazukiKiri");
	public static Item MikazukiNoMai = new MikazukiNoMai()
			.setUnlocalizedName("MikazukiNoMai");
	public static Item Omotegiri = new Omotegiri()
			.setUnlocalizedName("Omotegiri");
	public static Item SamuraiSabreTechnique = new SamuraiSabreTechnique()
			.setUnlocalizedName("SamuraSabreTechnique");
	public static Item Yosakugiri = new Yosakugiri()
			.setUnlocalizedName("Yosakugiri");
	public static Item JikukanKekkai = new JikukanKekkai()
			.setUnlocalizedName("JikukanKekkai");
	public static Item Haykkaroran = new Haykkaroran()
			.setUnlocalizedName("Haykkaroran");
	public static Item KokuangyoNoJutsu = new KokuangyoNoJutsu()
			.setUnlocalizedName("KokuangyoNoJutsu");
	public static Item Koukongarasu = new Koukongarasu()
			.setUnlocalizedName("Koukongarasu");
	public static Item RaigenRaikochu = new RaigenRaikochu()
			.setUnlocalizedName("RaigenRaikochu");
	public static Item Byakugo = new Byakugo().setUnlocalizedName("Byakugo");
	public static Item ChakuraNoMesu = new ChakuraNoMesu()
			.setUnlocalizedName("ChakuraNoMesu");
	public static Item Dokugiri = new Dokugiri().setUnlocalizedName("Dokugiri");
	public static Item InyuShometsu = new InyuShometsu()
			.setUnlocalizedName("InyuShometsu");
	public static Item Ranshinsho = new Ranshinsho()
			.setUnlocalizedName("Ranshinsho");
	public static Item SaikanChushutsuNoJutsu = new SaikanChushutsuNoJutsu()
			.setUnlocalizedName("SaikanChushutsuNoJutsu");
	public static Item ChioOdamaRasengan = new ChioOdamaRasengan()
			.setUnlocalizedName("ChioOdamaRasengan");
	public static Item Enmakugire = new Enmakugire()
			.setUnlocalizedName("Enmakugire");
	public static Item FukimiHari = new FukimiHari()
			.setUnlocalizedName("FukimiHari");
	public static Item HariJizo = new HariJizo().setUnlocalizedName("HariJizo");
	public static Item Kai = new Kai().setUnlocalizedName("Kai");
	public static Item KawarimiNoJutsu = new KawarimiNoJutsu()
			.setUnlocalizedName("KawarimiNoJutsu");
	public static Item KuchiyoseRashomon = new KuchiyoseRashomon()
			.setUnlocalizedName("KuchiyoseRashomon");
	public static Item Meisaigakure = new Meisaigakure()
			.setUnlocalizedName("Meisaigakure");
	public static Item NanKaizou = new NanKaizou()
			.setUnlocalizedName("NanKaizou");
	public static Item NawanukeNoJutsu = new NawanukeNoJutsu()
			.setUnlocalizedName("NawanukeNoJutsu");
	public static Item OdamaRasengan = new OdamaRasengan()
			.setUnlocalizedName("OdamaRasengan");
	public static Item Rasengan = new Rasengan().setUnlocalizedName("Rasengan");
	public static Item Sharingan = new Sharingan()
			.setUnlocalizedName("Sharingan");
	public static Item ShunshinNoJutsu = new ShunshinNoJutsu()
			.setUnlocalizedName("ShunshinNoJutsu");*/
	//Armors
/*	public static  Item HelmetRyu =   new NCPLItemArmor(armorRYUU, 0, 0)
	.setUnlocalizedName("HelmetRyu");
public static  Item ChestplateRyu =  new NCPLItemArmor(armorRYUU, 0, 1)
	.setUnlocalizedName("ChestplateRyu");
public static  Item LegginsRyu =  new NCPLItemArmor(armorRYUU, 0, 2)
	.setUnlocalizedName("LegginsRyu");
public static  Item BootsRyu =  new NCPLItemArmor(armorRYUU, 0, 3)
	.setUnlocalizedName("BootsRyu");*/
	//Items
	public static Item FScroll = new FScroll().setUnlocalizedName("FutonScroll");
	public static Item KScroll = new KScroll().setUnlocalizedName("KatonScroll");
	public static Item DScroll = new DScroll().setUnlocalizedName("DotonScroll");
	public static Item SScroll = new SScroll().setUnlocalizedName("SuitonScroll");
	public static Item RScroll = new RScroll().setUnlocalizedName("RaitonScroll");
	public static Item HScroll = new HScroll().setUnlocalizedName("HeavenScroll");
	public static Item EScroll = new EScroll().setUnlocalizedName("EarthScroll");
	public static Item NScroll = new NScroll().setUnlocalizedName("NormalScroll");
	public static Item Rin = new Rin().setUnlocalizedName("Rin");
	public static Item Ryo = new Ryo().setUnlocalizedName("Ryo");
	public static Item Ringtones = new Ringtones().setUnlocalizedName("Ringtones");
	public static Item MetalCable = new MetalCable().setUnlocalizedName("MetalCable");
    public static Item PillWithCoagulatedBlood = new PillWithCoagulatedBlood().setUnlocalizedName("PillWithCoagulatedBlood");
    public static Item FoodMilitaryPill = new FoodMilitaryPill().setUnlocalizedName("FoodMilitaryPill");
    public static Item HyuugaSalve = new HyuugaSalve().setUnlocalizedName("HyuugaSalve");
	public static Item BigScroll = new BigScroll().setUnlocalizedName("BigScroll");
	//Food
	public static Item Ramen = new Ramen().setUnlocalizedName("Ramen");
	public static Item IchirakuRamen = new IchirakuRamen().setUnlocalizedName("IchirakuRamen");
	public static Item Pasta = new Pasta().setUnlocalizedName("Pasta");
	public static Item NarutoMaki = new NarutoMaki().setUnlocalizedName("NarutoMaki");
	//Weapons
	public static Item Kurosawa = new Kurosawa().setUnlocalizedName("Kurosawa");
	public static Item Katana = new Katana().setUnlocalizedName("Katana");
	public static Item ChioRyuuGatana = new ChioRyuuGatana()
			.setUnlocalizedName("ChioRyuuGatana");
	public static Item StoneSword = new StoneSword()
			.setUnlocalizedName("StoneSword");
	public static Item Raitanto = new Raitanto().setUnlocalizedName("Raitanto");
	public static Item BushidoKatana = new BushidoKatana()
			.setUnlocalizedName("BushidoKatana");
	public static Item SamuraiSword = new SamuraiSword()
			.setUnlocalizedName("SamuraiSword");
	public static Item Wakizashi = new Wakizashi()
			.setUnlocalizedName("Wakizashi");
	public static Item Kubikiribocho = new Kubikiribocho()
			.setUnlocalizedName("Kubikiribocho");
	public static Item Tanto = new Tanto().setUnlocalizedName("Tanto");
	public static Item RyuuKatana = new RyuuKatana()
			.setUnlocalizedName("RyuuKatana");
	public static Item TaishouSword = new TaishouSword()
			.setUnlocalizedName("TaishouSword");
	public static Item SmokeBomb = new SmokeBomb()
			.setUnlocalizedName("SmokeBomb");
	public static Item LightBomb = new LightBomb()
			.setUnlocalizedName("LightBomb");
	public static Item BigKunai = new BigKunai().setUnlocalizedName("BigKunai");
	public static Item Scalpel = new Scalpel().setUnlocalizedName("Scalpel");
	public static Item Kama = new Kama().setUnlocalizedName("Kama");
	public static Item KusariFuuboo = new KusariFuuboo()
			.setUnlocalizedName("KusariFuuboo");
	public static Item Kusarigama = new Kusarigama()
			.setUnlocalizedName("Kusarigama");
	public static Item Nunchaku = new Nunchaku().setUnlocalizedName("Nunchaku");
	public static Item DoubleKusarigama = new DoubleKusarigama()
			.setUnlocalizedName("DoubleKurasigama");
	public static Item ShellRockMace = new ShellRockMace()
			.setUnlocalizedName("ShellRockMace");
	public static Item Kusarigamawithpiston = new Kusarigamawithpiston()
			.setUnlocalizedName("Kusarigamawithpiston");
	public static Item Kunai = new Kunai().setUnlocalizedName("Kunai");
	public static Item Shuriken = new Shuriken().setUnlocalizedName("Shuriken");
	public static Item Senbon = new Senbon().setUnlocalizedName("Senbon");
	public static Item ExplodeKunai = new ExplodeKunai()
			.setUnlocalizedName("ExplodeKunai");
	public static Item PoisonedSenbon = new PoisonedSenbon()
			.setUnlocalizedName("PoisonedSenbon");
	public static Item BigShuriken = new BigShuriken()
			.setUnlocalizedName("BigShuriken");
	public static Item DoubleKunai = new DoubleKunai()
			.setUnlocalizedName("DoubleKunai");
	public static Item KumoShuriken = new KumoShuriken()
			.setUnlocalizedName("KumoShuriken");
	public static Item FuumaShuriken = new FuumaShuriken()
			.setUnlocalizedName("FuumaShuriken");
	public static Item Mine = new Mine().setUnlocalizedName("Mine");
	public static Item Weights = new Weights().setUnlocalizedName("Weights");
	public static Item WarKunai = new WarKunai().setUnlocalizedName("WarKunai");
	public static Item LullingBomb = new LullingBomb()
			.setUnlocalizedName("LullingBomb");
	public static Item Hiramekarei = new Hiramekarei()
			.setUnlocalizedName("Hiramekarei");
	public static Item KabutowariHammer = new KabutowariHammer()
			.setUnlocalizedName("KabutowariHammer");
	public static Item KabutowariAxe = new KabutowariAxe()
			.setUnlocalizedName("KabutowariAxe");
	public static Item Kiba = new Kiba().setUnlocalizedName("Kiba");
	public static Item KusanagiOrochimaru = new KusanagiOrochimaru()
			.setUnlocalizedName("KusanagiOrochimaru");
	public static Item Kusanagi = new Kusanagi().setUnlocalizedName("Kusanagi");
	public static Item Nuibari = new Nuibari().setUnlocalizedName("Nuibari");
	public static Item Samehada = new Samehada().setUnlocalizedName("Samehada");
	public static Item Shibuki = new Shibuki().setUnlocalizedName("Shibuki");
	public static Item Machete = new Machete().setUnlocalizedName("Machete");
	public static Item Knuckleduster = new Knuckleduster()
			.setUnlocalizedName("Knuckleduster");
	public static Item ThreeProngedKnife = new ThreeProngedKnife()
			.setUnlocalizedName("ThreeProngedKnife");
	public static Item ExplosiveNote = new ExplosiveNote()
			.setUnlocalizedName("ExplosiveNote");
	public static Item Bijuudama = new Bijuudama()
			.setUnlocalizedName("Bijuudama");
	public static Item RikudouStaff = new RikudouStaff()
			.setUnlocalizedName("RikudouStaff");
	public static Item IronGlove = new IronGlove()
			.setUnlocalizedName("IronGlove");
	
//Materials
	

	public static ArmorMaterial Bushido = Materials.armorBUSHIDO;
	public static ArmorMaterial Anbu = Materials.armorANBU;
	public static ArmorMaterial Kiri = Materials.armorKIRI;
	public static ArmorMaterial Suna = Materials.armorSUNA;
	public static ArmorMaterial Akatsuki = Materials.armorAKATSUKI;
	public static ArmorMaterial Iwa = Materials.armorIWA;
	public static ArmorMaterial Konoha = Materials.armorKONOHA;
	public static ArmorMaterial Oto = Materials.armorOTO;
	public static ArmorMaterial Old = Materials.armorOLD;
	public static ArmorMaterial Kumo = Materials.armorKUMO;
	public static ArmorMaterial Ryuu = Materials.armorRYUU;
	
	// public static int renderBushidoArmor = proxy.addArmor("Bushido");
	// public static Item = new (id+);
	//Armors
	public static  Item HelmetRyu =   new NCPLItemArmor(Ryuu, 1, 0).setUnlocalizedName("HelmetRyu");
	public static  Item ChestplateRyu =  new NCPLItemArmor(Ryuu, 1, 1).setUnlocalizedName("ChestplateRyu");
	public static  Item LegginsRyu =  new NCPLItemArmor(Ryuu, 1, 2).setUnlocalizedName("LegginsRyu");
	public static  Item BootsRyu =  new NCPLItemArmor(Ryuu, 1, 3).setUnlocalizedName("BootsRyu");
	public static Item HelmetBushido = new NCPLItemArmor(Bushido, 2, 0).setUnlocalizedName("HelmetBushido");
	public static Item ChestplateBushido = new NCPLItemArmor(Bushido, 2, 1).setUnlocalizedName("ChestplateBushido");
	public static Item LegginsBushido = new NCPLItemArmor(Bushido, 2, 2).setUnlocalizedName("LegginsBushido");
	public static Item BootsBushido = new NCPLItemArmor(Bushido, 2, 3).setUnlocalizedName("BootsBushido");
	public static Item HelmetAnbu = new NCPLItemArmor(Anbu, 2, 0).setUnlocalizedName("HelmetAnbu");
	public static Item HelmetAnbu2 = new NCPLItemArmor(Anbu, 2, 0).setUnlocalizedName("HelmetAnbu2");
	public static Item HelmetAnbu3 = new NCPLItemArmor(Anbu, 2, 0).setUnlocalizedName("HelmetAnbu3");
	public static Item HelmetAnbu4 = new NCPLItemArmor(Anbu, 2, 0).setUnlocalizedName("HelmetAnbu4");
	public static Item ChestplateAnbu = new NCPLItemArmor(Anbu, 2, 1).setUnlocalizedName("ChestplateAnbu");
	public static Item LegginsAnbu = new NCPLItemArmor(Anbu, 2, 2).setUnlocalizedName("LegginsAnbu");
	public static Item BootsAnbu = new NCPLItemArmor(Anbu, 2, 3).setUnlocalizedName("BootsAnbu");
	public static  Item ChestplateKiri =  new NCPLItemArmor(Kiri, 4, 1)
	.setUnlocalizedName("ChestplateKiri");
public static  Item LegginsKiri =  new NCPLItemArmor(Kiri, 4, 2)
	.setUnlocalizedName("LegginsKiri");
public static Item BootsKiri = new NCPLItemArmor(Kiri, 4, 3).setUnlocalizedName("BootsKiri");
public static  Item ChestplateSuna =  new NCPLItemArmor(Suna, 4, 1)
	.setUnlocalizedName("ChestplateSuna");
public static  Item LegginsSuna =  new NCPLItemArmor(Suna, 4, 2)
	.setUnlocalizedName("LegginsSuna");
public static Item BootsSuna = new NCPLItemArmor(Suna, 4, 3).setUnlocalizedName("BootsSuna");
public static  Item HelmetAkatsuki =  new NCPLItemArmor(Akatsuki, 4, 0)
	.setUnlocalizedName("HelmetAkatsuki");
public static  Item HelmetAkatsuki2 =  new NCPLItemArmor(Akatsuki, 4, 0)
	.setUnlocalizedName("HelmetAkatsuki2");
public static  Item HelmetAkatsuki3 =  new NCPLItemArmor(Akatsuki, 4, 0)
	.setUnlocalizedName("HelmetAkatsuki3");
public static  Item ChestplateAkatsuki =  new NCPLItemArmor(Akatsuki, 4, 1)
	.setUnlocalizedName("ChestplateAkatsuki");
public static  Item ChestplateAkatsuki2 =  new NCPLItemArmor(Akatsuki, 4, 1)
	.setUnlocalizedName("ChestplateAkatsuki2");
public static  Item ChestplateAkatsuki3 =  new NCPLItemArmor(Akatsuki, 4, 1)
	.setUnlocalizedName("ChestplateAkatsuki3");
public static  Item ChestplateAkatsuki4 =  new NCPLItemArmor(Akatsuki, 4, 1)
	.setUnlocalizedName("ChestplateAkatsuki4");
public static  Item LegginsAkatsuki =  new NCPLItemArmor(Akatsuki, 4, 2)
	.setUnlocalizedName("LegginsAkatsuki");
public static  Item BootsAkatsuki =  new NCPLItemArmor(Akatsuki, 4, 3)
	.setUnlocalizedName("BootsAkatsuki");
public static  Item ChestplateIwa =  new NCPLItemArmor(Iwa, 4, 1)
	.setUnlocalizedName("ChestplateIwa");
public static  Item LegginsIwa =  new NCPLItemArmor(Iwa, 4, 2)
	.setUnlocalizedName("LegginsIwa");
public static  Item BootsIwa =  new NCPLItemArmor(Iwa, 4, 3)
	.setUnlocalizedName("BootsIwa");

public static  Item ChestplateKonoha =  new NCPLItemArmor(Konoha, 4, 1)
	.setUnlocalizedName("ChestplateKonoha");
public static  Item LegginsKonoha =  new NCPLItemArmor(Konoha, 4, 2)
	.setUnlocalizedName("LegginsKonoha");
public static  Item BootsKonoha =  new NCPLItemArmor(Konoha, 4, 3)
	.setUnlocalizedName("BootsKonoha");
public static  Item ChestplateOto =  new NCPLItemArmor(Oto, 4, 1)
	.setUnlocalizedName("ChestplateOto");
public static  Item LegginsOto =  new NCPLItemArmor(Oto, 4, 2)
	.setUnlocalizedName("LegginsOto");
public static  Item BootsOto =  new NCPLItemArmor(Oto, 4, 3)
	.setUnlocalizedName("BootsOto");
public static  Item ChestplateOld =  new NCPLItemArmor(Old, 4, 1)
	.setUnlocalizedName("ChestplateOld");
public static  Item LegginsOld =  new NCPLItemArmor(Old, 4, 2)
	.setUnlocalizedName("LegginsOld");
public static  Item BootsOld =  new NCPLItemArmor(Old, 4, 3)
	.setUnlocalizedName("BootsOld");
public static  Item ChestplateKumo =  new NCPLItemArmor(Kumo, 4, 1)
	.setUnlocalizedName("ChestplateKumo");
public static  Item LegginsKumo =  new NCPLItemArmor(Kumo, 4, 2)
	.setUnlocalizedName("LegginsKumo");
public static  Item BootsKumo =  new NCPLItemArmor(Kumo, 4, 3)
	.setUnlocalizedName("BootsKumo");

	protected static void registerItem(Item item, String name) {
		GameRegistry.registerItem(item, name);
	}

	protected static void registerRendererToItem(Item item, String name) {
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						0,
						new ModelResourceLocation(References.ModTexturePath
								+ name, "inventory"));
	}

	public static void regItemsList() {
		// registerItem(, "");
		
		//Items
		registerItem(FScroll, "FScroll");
		registerItem(KScroll, "KScroll");
		registerItem(DScroll, "DScroll");
		registerItem(SScroll, "SScroll");
		registerItem(RScroll, "RScroll");
		registerItem(HScroll, "HScroll");
		registerItem(EScroll, "EScroll");
		registerItem(NScroll, "NScroll");
		registerItem(Rin, "Rin");
		registerItem(Ryo, "Ryo");
		registerItem(MetalCable, "MetalCable");
		registerItem(PillWithCoagulatedBlood, "PillWithCoagulatedBlood");
		registerItem(FoodMilitaryPill, "FoodMilitaryPill");
		registerItem(Ringtones, "Ringtones");
		registerItem(HyuugaSalve, "HyuugaSalve");
		registerItem(BigScroll, "BigScroll");
		//Food
		registerItem(Ramen, "Ramen");
		registerItem(IchirakuRamen, "IchirakuRamen");
		registerItem(Pasta, "Pasta");
		registerItem(NarutoMaki, "NarutoMaki");
		//Weapons
		registerItem(Kurosawa, "Kurosawa");
		registerItem(Katana, "Katana");
		registerItem(ChioRyuuGatana, "ChioRyuuGatana");
		registerItem(StoneSword, "StoneSword");
		registerItem(Raitanto, "Raitanto");
		registerItem(BushidoKatana, "BushidoKatana");
		registerItem(SamuraiSword, "SamuraiSword");
		registerItem(Wakizashi, "Wakizashi");
		registerItem(Kubikiribocho, "Kubikiribocho");
		registerItem(Tanto, "Tanto");
		registerItem(RyuuKatana, "RyuuKatana");
		registerItem(TaishouSword, "TaishouSword");
		registerItem(SmokeBomb, "SmokeBomb");
		registerItem(LightBomb, "LightBomb");
		registerItem(BigKunai, "BigKunai");
		registerItem(Scalpel, "Scalpel");
		registerItem(Kama, "Kama");
		registerItem(KusariFuuboo, "KusariFuuboo");
		registerItem(Kusarigama, "Kusarigama");
		registerItem(Nunchaku, "Nunchaku");
		registerItem(DoubleKusarigama, "DoubleKusarigama");
		registerItem(ShellRockMace, "ShellRockMace");
		registerItem(Kusarigamawithpiston, "Kusarigamawithpiston");
		registerItem(Kunai, "Kunai");
		registerItem(Shuriken, "Shuriken");
		registerItem(Senbon, "Senbon");
		registerItem(ExplodeKunai, "ExplodeKunai");
		registerItem(PoisonedSenbon, "PoisonedSenbon");
		registerItem(DoubleKunai, "DoubleKunai");
		registerItem(KumoShuriken, "KumoShuriken");
		registerItem(FuumaShuriken, "FuumaShuriken");
		registerItem(BigShuriken, "BigShuriken");
		registerItem(Mine, "Mine");
		registerItem(WarKunai, "WarKunai");
		registerItem(Weights, "Weights");
		registerItem(Shibuki, "Shibuki");
		registerItem(Samehada, "Samehada");
		registerItem(Nuibari, "Nuibari");
		registerItem(Kusanagi, "Kusanagi");
		registerItem(KusanagiOrochimaru, "KusanagiOrochimaru");
		registerItem(Kiba, "Kiba");
		registerItem(KabutowariAxe, "KabutowariAxe");
		registerItem(KabutowariHammer, "KabutowariHammer");
		registerItem(Hiramekarei, "Hiramekarei");
		registerItem(LullingBomb, "LullingBomb");
		registerItem(Machete, "Machete");
		registerItem(Knuckleduster, "Knuckleduster");
		registerItem(ThreeProngedKnife, "ThreeProngedKnife");
		registerItem(HelmetRyu, "HelmetRyu");
		registerItem(ChestplateRyu, "ChestplateRyu");
		registerItem(LegginsRyu, "LegginsRyu");
		registerItem(ExplosiveNote, "ExplosiveNote");
		registerItem(Bijuudama, "Bijuudama");
		registerItem(RikudouStaff, "RikudouStaff");
		registerItem(IronGlove, "IronGlove");
		//Armor
		registerItem(HelmetBushido, "HelmetBushido");
		registerItem(ChestplateBushido, "ChestplateBushido");
		registerItem(LegginsBushido, "LegginsBushido");
		registerItem(BootsBushido, "BootsBushido");
		registerItem(HelmetRyu, "HelmetRyu");
		registerItem(ChestplateRyu, "ChestplateRyu");
		registerItem(LegginsRyu, "LegginsRyu");
		registerItem(BootsRyu, "BootsRyu");
		registerItem(HelmetAnbu , "HelmetAnbu");
		registerItem(HelmetAnbu2, "HelmetAnbu2");
		registerItem(HelmetAnbu3, "HelmetAnbu3");
		registerItem(HelmetAnbu4, "HelmetAnbu4");
		registerItem(ChestplateAnbu, "ChestplateAnbu");
		registerItem(LegginsAnbu, "LegginsAnbu");
		registerItem(BootsAnbu, "BootsAnbu");
		registerItem(ChestplateKiri, "ChestplateKiri");
		registerItem(LegginsKiri, "LegginsKiri");
		registerItem(BootsKiri, "BootsKiri");
		registerItem(ChestplateSuna, "ChestplateSuna");
		registerItem(LegginsSuna, "LegginsSuna");
		registerItem(BootsSuna, "BootsSuna");
		registerItem(HelmetAkatsuki, "HelmetAkatsuki");
		registerItem(HelmetAkatsuki2, "HelmetAkatsuki2");
		registerItem(HelmetAkatsuki3, "HelmetAkatsuki3");
		registerItem(ChestplateAkatsuki, "PlateAkatsuki");
		registerItem(ChestplateAkatsuki2, "ChestplateAkatsuki2");
		registerItem(ChestplateAkatsuki3, "ChestplateAkatsuki3");
		registerItem(ChestplateAkatsuki4, "ChestplateAkatsuki4");
		registerItem(LegginsAkatsuki, "LegginsAkatsuki");
		registerItem(BootsAkatsuki, "BootsAkatsuki");
		registerItem(ChestplateIwa, "ChestplateIwa");
		registerItem(LegginsIwa, "LegginsIwa");
		registerItem(BootsIwa, "BootsIwa");
		registerItem(ChestplateKonoha, "ChestplateKonoha");
		registerItem(LegginsKonoha, "LegginsKonoha");
		registerItem(BootsKonoha, "BootsKonoha");
		registerItem(ChestplateOto, "ChestplateOto");
		registerItem(LegginsOto, "LegginsOto");
		registerItem(BootsOto, "BootsOto");
		registerItem(ChestplateOld, "ChestplateOld");
		registerItem(LegginsOld, "LegginsOld");
		registerItem(BootsOld, "BootsOld");
		registerItem(ChestplateKumo, "ChestplateKumo");
		registerItem(LegginsKumo, "LegginsKumo");
		registerItem(BootsKumo, "BootsKumo");
		
		
		
		/*registerItem(AsaKujaku, "AsaKujaku");
		registerItem(Hirudora, "Hirudora");
		registerItem(KageBuyo, "KageBuyo");
		registerItem(KosaHo, "KosaHo");
		registerItem(OmoteRenge, "OmoteRenge");
		registerItem(UraRenge, "UraRenge");
		registerItem(FumaNinken, "FumaNinken");
		registerItem(Hadan, "Hadan");
		registerItem(Iaido, "Iaido");
		registerItem(Issen, "Issen");
		registerItem(MikazukiKiri, "MikazukiKiri");
		registerItem(MikazukiNoMai, "MikazukiNoMai");
		registerItem(Omotegiri, "Omotegiri");
		registerItem(SamuraiSabreTechnique, "SamuraiSabreTechnique");
		registerItem(Yosakugiri, "Yosakugiri");
		registerItem(JikukanKekkai, "JikukanKekkai");
		registerItem(Haykkaroran, "Haykkaroran");
		registerItem(KokuangyoNoJutsu, "KokuangyoNoJutsu");
		registerItem(Koukongarasu, "Koukongarasu");
		registerItem(RaigenRaikochu, "RaigenRaikochu");
		registerItem(Byakugo, "Byakugo");
		registerItem(ChakuraNoMesu, "ChakuraNoMesu");
		registerItem(Dokugiri, "Dokugiri");
		registerItem(InyuShometsu, "InyuShometsu");
		registerItem(Ranshinsho, "Ranshinsho");
		registerItem(SaikanChushutsuNoJutsu, "SaikanChushutsuNoJutsu");
		registerItem(ChioOdamaRasengan, "ChioOdamaRasengan");
		registerItem(Enmakugire, "Enmakugire");
		registerItem(FukimiHari, "FukimiHari");
		registerItem(HariJizo, "HariJizo");
		registerItem(Kai, "Kai");
		registerItem(KawarimiNoJutsu, "KawarimiNoJutsu");
		registerItem(KuchiyoseRashomon, "KuchiyoseRashomon");
		registerItem(Meisaigakure, "Meisaigakure");
		registerItem(NanKaizou, "NanKaizou");
		registerItem(NawanukeNoJutsu, "NawanukeNoJutsu");
		registerItem(OdamaRasengan, "OdamaRasengan");
		registerItem(Rasengan, "Rasengan");
		registerItem(Sharingan, "Sharingan");
		registerItem(ShunshinNoJutsu, "ShunshinNoJutsu");*/

		// registerItem(, "");
	}

	public static void regRenderers() {
		
		
		//Items
		registerRendererToItem(KScroll, "KScroll");
		registerRendererToItem(RScroll, "RScroll");
		registerRendererToItem(DScroll, "DScroll");
		registerRendererToItem(FScroll, "FScroll");
		registerRendererToItem(SScroll, "SScroll");
		registerRendererToItem(HScroll, "HScroll");
		registerRendererToItem(EScroll, "EScroll");
		registerRendererToItem(NScroll, "NScroll");
		registerRendererToItem(Rin, "Rin");
		registerRendererToItem(Ryo, "Ryo");
		registerRendererToItem(MetalCable, "MetalCable");
		registerRendererToItem(PillWithCoagulatedBlood, "PillWithCoagulatedBlood");
		registerRendererToItem(FoodMilitaryPill, "FoodMilitaryPill");
		registerRendererToItem(Ringtones, "Ringtones");
		registerRendererToItem(HyuugaSalve, "HyuugaSalve");
		registerRendererToItem(BigScroll, "BigScroll");
		//Food
		registerRendererToItem(Ramen, "Ramen");
		registerRendererToItem(IchirakuRamen, "IchirakuRamen");
		registerRendererToItem(Pasta, "Pasta");
		registerRendererToItem(NarutoMaki, "NarutoMaki");
		//Weapons
		registerRendererToItem(Kurosawa, "Kurosawa");
		registerRendererToItem(Katana, "Katana");
		registerRendererToItem(ChioRyuuGatana, "ChioRyuuGatana");
		registerRendererToItem(StoneSword, "StoneSword");
		registerRendererToItem(Raitanto, "Raitanto");
		registerRendererToItem(BushidoKatana, "BushidoKatana");
		registerRendererToItem(SamuraiSword, "SamuraiSword");
		registerRendererToItem(Wakizashi, "Wakizashi");
		registerRendererToItem(Kubikiribocho, "Kubikiribocho");
		registerRendererToItem(Tanto, "Tanto");
		registerRendererToItem(RyuuKatana, "RyuuKatana");
		registerRendererToItem(TaishouSword, "TaishouSword");
		registerRendererToItem(SmokeBomb, "SmokeBomb");
		registerRendererToItem(LightBomb, "LightBomb");
		registerRendererToItem(BigKunai, "BigKunai");
		registerRendererToItem(Scalpel, "Scalpel");
		registerRendererToItem(Kama, "Kama");
		registerRendererToItem(KusariFuuboo, "KusariFuuboo");
		registerRendererToItem(Kusarigama, "Kusarigama");
		registerRendererToItem(Nunchaku, "Nunchaku");
		registerRendererToItem(DoubleKusarigama, "DoubleKusarigama");
		registerRendererToItem(ShellRockMace, "ShellRockMace");
		registerRendererToItem(Kusarigamawithpiston, "Kusarigamawithpiston");
		registerRendererToItem(Kunai, "Kunai");
		registerRendererToItem(Shuriken, "Shuriken");
		registerRendererToItem(ExplodeKunai, "ExplodeKunai");
		registerRendererToItem(Senbon, "Senbon");
		registerRendererToItem(BigShuriken, "BigShuriken");
		registerRendererToItem(FuumaShuriken, "FuumaShuriken");
		registerRendererToItem(KumoShuriken, "KumoShuriken");
		registerRendererToItem(DoubleKunai, "DoubleKunai");
		registerRendererToItem(PoisonedSenbon, "PoisonedSenbon");
		registerRendererToItem(Mine, "Mine");
		registerRendererToItem(Weights, "Weights");
		registerRendererToItem(WarKunai, "WarKunai");
		registerRendererToItem(Shibuki, "Shibuki");
		registerRendererToItem(Samehada, "Samehada");
		registerRendererToItem(Nuibari, "Nuibari");
		registerRendererToItem(Kusanagi, "Kusanagi");
		registerRendererToItem(KusanagiOrochimaru, "KusanagiOrochimaru");
		registerRendererToItem(Kiba, "Kiba");
		registerRendererToItem(KabutowariAxe, "KabutowariAxe");
		registerRendererToItem(KabutowariHammer, "KabutowariHammer");
		registerRendererToItem(Hiramekarei, "Hiramekarei");
		registerRendererToItem(LullingBomb, "LullingBomb");
		registerRendererToItem(Machete, "Machete");
		registerRendererToItem(Knuckleduster, "Knuckleduster");
		registerRendererToItem(ThreeProngedKnife, "ThreeProngedKnife");
		registerRendererToItem(ExplosiveNote, "ExplosiveNote");
		registerRendererToItem(Bijuudama, "Bijuudama");
		registerRendererToItem(RikudouStaff, "RikudouStaff");
		registerRendererToItem(IronGlove, "IronGlove");
		
		
		/*registerRendererToItem(AsaKujaku, "AsaKujaku");
		registerRendererToItem(Hirudora, "Hirudora");
		registerRendererToItem(KageBuyo, "KageBuyo");
		registerRendererToItem(KosaHo, "KosaHo");
		registerRendererToItem(OmoteRenge, "OmoteRenge");
		registerRendererToItem(UraRenge, "UraRenge");
		registerRendererToItem(FumaNinken, "FumaNinken");
		registerRendererToItem(Hadan, "Hadan");
		registerRendererToItem(Iaido, "Iaido");
		registerRendererToItem(Issen, "Issen");
		registerRendererToItem(MikazukiKiri, "MikazukiKiri");
		registerRendererToItem(MikazukiNoMai, "MikazukiNoMai");
		registerRendererToItem(Omotegiri, "Omotegiri");
		registerRendererToItem(SamuraiSabreTechnique, "SamuraiSabreTechnique");
		registerRendererToItem(JikukanKekkai, "JikukanKekkai");
		registerRendererToItem(Haykkaroran, "Haykkaroran");
		registerRendererToItem(KokuangyoNoJutsu, "KokuangyoNoJutsu");
		registerRendererToItem(Koukongarasu, "Koukongarasu");
		registerRendererToItem(RaigenRaikochu, "RaigenRaikochu");
		registerRendererToItem(Byakugo, "Byakugo");
		registerRendererToItem(ChakuraNoMesu, "ChakuraNoMesu");
		registerRendererToItem(Dokugiri, "Dokugiri");
		registerRendererToItem(InyuShometsu, "InyuShometsu");
		registerRendererToItem(Ranshinsho, "Ranshinsho");
		registerRendererToItem(SaikanChushutsuNoJutsu, "SaikanChushutsuNoJutsu");
		registerRendererToItem(ChioOdamaRasengan, "ChioOdamaRasengan");
		registerRendererToItem(Enmakugire, "Enmakugire");
		registerRendererToItem(FukimiHari, "FukimiHari");
		registerRendererToItem(HariJizo, "HariJizo");
		registerRendererToItem(Kai, "Kai");
		registerRendererToItem(KawarimiNoJutsu, "KawarimiNoJutsu");
		registerRendererToItem(KuchiyoseRashomon, "KuchiyoseRashomon");
		registerRendererToItem(Meisaigakure, "Meisaigakure");
		registerRendererToItem(NanKaizou, "NanKaizou");
		registerRendererToItem(NawanukeNoJutsu, "NawanukeNoJutsu");
		registerRendererToItem(OdamaRasengan, "OdamaRasengan");
		registerRendererToItem(Rasengan, "Rasengan");
		registerRendererToItem(Sharingan, "Sharingan");
		registerRendererToItem(ShunshinNoJutsu, "ShunshinNoJutsu");*/
		//Armors
		registerRendererToItem(HelmetRyu, "HelmetRyu");
		registerRendererToItem(ChestplateRyu, "ChestplateRyu");
		registerRendererToItem(LegginsRyu, "LegginsRyu");
		registerRendererToItem(BootsRyu, "BootsRyu");
		registerRendererToItem(HelmetBushido, "HelmetBushido");
		registerRendererToItem(ChestplateBushido, "ChestplateBushido");
		registerRendererToItem(LegginsBushido, "LegginsBushido");
		registerRendererToItem(BootsBushido, "BootsBushido");
		registerRendererToItem(HelmetAnbu , "HelmetAnbu");
		registerRendererToItem(HelmetAnbu2, "HelmetAnbu2");
		registerRendererToItem(HelmetAnbu3, "HelmetAnbu3");
		registerRendererToItem(HelmetAnbu4, "HelmetAnbu4");
		registerRendererToItem(ChestplateAnbu, "ChestplateAnbu");
		registerRendererToItem(LegginsAnbu, "LegginsAnbu");
		registerRendererToItem(BootsAnbu, "BootsAnbu");
		registerRendererToItem(ChestplateKiri, "ChestplateKiri");
		registerRendererToItem(LegginsKiri, "LegginsKiri");
		registerRendererToItem(BootsKiri, "BootsKiri");
		registerRendererToItem(ChestplateSuna, "ChestplateSuna");
		registerRendererToItem(LegginsSuna, "LegginsSuna");
		registerRendererToItem(BootsSuna, "BootsSuna");
		registerRendererToItem(HelmetAkatsuki, "HelmetAkatsuki");
		registerRendererToItem(HelmetAkatsuki2, "HelmetAkatsuki2");
		registerRendererToItem(HelmetAkatsuki3, "HelmetAkatsuki3");
		registerRendererToItem(ChestplateAkatsuki, "PlateAkatsuki");
		registerRendererToItem(ChestplateAkatsuki2, "ChestplateAkatsuki2");
		registerRendererToItem(ChestplateAkatsuki3, "ChestplateAkatsuki3");
		registerRendererToItem(ChestplateAkatsuki4, "ChestplateAkatsuki4");
		registerRendererToItem(LegginsAkatsuki, "LegginsAkatsuki");
		registerRendererToItem(BootsAkatsuki, "BootsAkatsuki");
		registerRendererToItem(ChestplateIwa, "ChestplateIwa");
		registerRendererToItem(LegginsIwa, "LegginsIwa");
		registerRendererToItem(BootsIwa, "BootsIwa");
		registerRendererToItem(ChestplateKonoha, "ChestplateKonoha");
		registerRendererToItem(LegginsKonoha, "LegginsKonoha");
		registerRendererToItem(BootsKonoha, "BootsKonoha");
		registerRendererToItem(ChestplateOto, "ChestplateOto");
		registerRendererToItem(LegginsOto, "LegginsOto");
		registerRendererToItem(BootsOto, "BootsOto");
		registerRendererToItem(ChestplateOld, "ChestplateOld");
		registerRendererToItem(LegginsOld, "LegginsOld");
		registerRendererToItem(BootsOld, "BootsOld");
		registerRendererToItem(ChestplateKumo, "ChestplateKumo");
		registerRendererToItem(LegginsKumo, "LegginsKumo");
		registerRendererToItem(BootsKumo, "BootsKumo");
	}
}
