package pl.grm.narutocraft.registry;

import pl.grm.narutocraft.jutsu.Jutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegJutsus {
	public static void regPowersList() {
		GameRegistry.registerItem(KawarimiNoJutsu, nKawarimiNoJutsu);
		GameRegistry.registerItem(Meisaigakure, nMeisaigakure);
		GameRegistry.registerItem(ShunshinNoJutsu, "ShunshinNoJutsu");
		GameRegistry.registerItem(Sharingan, "Sharingan");
		GameRegistry.registerItem(Rasengan, "Rasengan");
		GameRegistry.registerItem(Rasengan2, "OdamaRasengan");
		GameRegistry.registerItem(Rasengan3, "ChioOdamaRasengan");
		GameRegistry.registerItem(AsaKujaku, "Asa Kujaku");
		GameRegistry.registerItem(Byakugo, "Byakugo");
		GameRegistry.registerItem(ChakuraNoMesu, "Chakura No Mesu");
		GameRegistry.registerItem(Dokugiri, "Dokugiri");
		GameRegistry.registerItem(Enmakugire, "Enmakugire");
		GameRegistry.registerItem(FukimiHari, "FukimiHari");
		GameRegistry.registerItem(FumaNinken, "Fuma Ninken");
		GameRegistry.registerItem(Hadan, "Hadan");
		GameRegistry.registerItem(HariJizo, "HariJizo");
		GameRegistry.registerItem(Haykkaroran, "Haykkaroran");
		GameRegistry.registerItem(Hirudora, "Hirudora");
		GameRegistry.registerItem(Iaido, "Iaido");
		GameRegistry.registerItem(InyuShometsu, "InyuShometsu");
		GameRegistry.registerItem(Issen, "Issen");
		GameRegistry.registerItem(JikukanKekkai, "Jikukan Kekkai");
		GameRegistry.registerItem(KageBuyo, "Kage Buyo");
		GameRegistry.registerItem(Kai, "Kai");
		GameRegistry.registerItem(KokuangyoNoJutsu, "KokouangyoNo Jutsu");
		GameRegistry.registerItem(KosaHo, "KosaHo");
		GameRegistry.registerItem(Koukongarasu, "Koukongarasu");
		GameRegistry.registerItem(KuchiyoseRashomon, "KuchiyoseRashomon");
		GameRegistry.registerItem(MikazukiKiri, "Mikazuki Kiri");
		GameRegistry.registerItem(NanKaizou, "Nan Kaizou");
		GameRegistry.registerItem(NawanukeNoJutsu, "Nawanuke No Jutsu");
		GameRegistry.registerItem(Omotegiri, "Omotegiri");
		GameRegistry.registerItem(OmoteRenge, "Omote Renge");
		GameRegistry.registerItem(RaigenRaikochu, "RaigenRaikochi");
		GameRegistry.registerItem(Ranshinsho, "Ranshinsho");
		GameRegistry.registerItem(SaikanChushutsuNoJutsu,
				"Saikan Chushutsu No Jutsu");
		GameRegistry.registerItem(SamuraiSabreTechnique,
				"SamuraiSabreTehcnique");
		GameRegistry.registerItem(UraRenge, "Ura Renge");
		GameRegistry.registerItem(Yosakugiri, "Yosakugiri");
	}
	public static Jutsu KawarimiNoJutsu = JutsuEnum.KAWARIMINOJUTSU.getJutsu();
	public static String nKawarimiNoJutsu = JutsuEnum.KAWARIMINOJUTSU.getName();
	public static Jutsu Meisaigakure = JutsuEnum.MEISAIGAKURE.getJutsu();
	public static String nMeisaigakure = JutsuEnum.MEISAIGAKURE.getName();
	// public static Jutsu ShunshinNoJutsu = new ShunshinNoJutsu();
	// public static Jutsu Sharingan = new Sharingan();
	// public static Jutsu Rasengan = new Rasengan();
	// public static Jutsu Rasengan2 = new Rasengan2();
	// public static Jutsu Rasengan3 = new Rasengan3();
	// public static Jutsu AsaKujaku = new AsaKujaku();
	// public static Jutsu Byakugo = new Byakugo();
	// public static Jutsu ChakuraNoMesu = new ChakuraNoMesu();
	// public static Jutsu Dokugiri = new Dokugiri();
	// public static Jutsu Enmakugire = new Enmakugire();
	// public static Jutsu FukimiHari = new FukimiHari();
	// public static Jutsu FumaNinken = new FumaNinken();
	// public static Jutsu Hadan = new Hadan();
	// public static Jutsu HariJizo = new HariJizo();
	// public static Jutsu Haykkaroran = new Haykkaroran();
	// public static Jutsu Hirudora = new Hirudora();
	// public static Jutsu Iaido = new Iaido();
	// public static Jutsu InyuShometsu = new InyuShometsu();
	// public static Jutsu Issen = new Issen();
	// public static Jutsu JikukanKekkai = new JikukanKekkai();
	// public static Jutsu KageBuyo = new KageBuyo();
	// public static Jutsu Kai = new Kai();
	// public static Jutsu KokuangyoNoJutsu = new KokuangyoNoJutsu();
	// public static Jutsu KosaHo = new KosaHo();
	// public static Jutsu Koukongarasu = new Koukongarasu();
	// public static Jutsu KuchiyoseRashomon = new KuchiyoseRashomon();
	// public static Jutsu MikazukiKiri = new MikazukiKiri();
	// public static Jutsu NanKaizou = new NanKaizou();
	// public static Jutsu NawanukeNoJutsu = new NawanukeNoJutsu();
	// public static Jutsu Omotegiri = new Omotegiri();
	// public static Jutsu OmoteRenge = new OmoteRenge();
	// public static Jutsu RaigenRaikochu = new RaigenRaikochu();
	// public static Jutsu Ranshinsho = new Ranshinsho();
	// public static Jutsu SaikanChushutsuNoJutsu = new
	// SaikanChushutsuNoJutsu();
	// public static Jutsu SamuraiSabreTechnique = new SamuraiSabreTechnique();
	// public static Jutsu UraRenge = new UraRenge();
	// public static Jutsu Yosakugiri = new Yosakugiri();
}
