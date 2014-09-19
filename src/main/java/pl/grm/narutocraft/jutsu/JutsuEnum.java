package pl.grm.narutocraft.jutsu;

import pl.grm.narutocraft.gui.skilltrees.SkillTrees;
import pl.grm.narutocraft.jutsu.bukijutsu.FumaNinken;
import pl.grm.narutocraft.jutsu.bukijutsu.Hadan;
import pl.grm.narutocraft.jutsu.bukijutsu.Iaido;
import pl.grm.narutocraft.jutsu.bukijutsu.Issen;
import pl.grm.narutocraft.jutsu.bukijutsu.MikazukiKiri;
import pl.grm.narutocraft.jutsu.bukijutsu.Omotegiri;
import pl.grm.narutocraft.jutsu.bukijutsu.SamuraiSabreTechnique;
import pl.grm.narutocraft.jutsu.bukijutsu.Yosakugiri;
import pl.grm.narutocraft.jutsu.fuuinjutsu.Byakugo;
import pl.grm.narutocraft.jutsu.fuuinjutsu.JikukanKekkai;
import pl.grm.narutocraft.jutsu.genjutsu.Haykkaroran;
import pl.grm.narutocraft.jutsu.genjutsu.KokuangyoNoJutsu;
import pl.grm.narutocraft.jutsu.genjutsu.Koukongarasu;
import pl.grm.narutocraft.jutsu.genjutsu.RaigenRaikochu;
import pl.grm.narutocraft.jutsu.iryojutsu.ChakuraNoMesu;
import pl.grm.narutocraft.jutsu.iryojutsu.Dokugiri;
import pl.grm.narutocraft.jutsu.iryojutsu.InyuShometsu;
import pl.grm.narutocraft.jutsu.iryojutsu.Ranshinsho;
import pl.grm.narutocraft.jutsu.iryojutsu.SaikanChushutsuNoJutsu;
import pl.grm.narutocraft.jutsu.ninjutsu.ChioOdamaRasengan;
import pl.grm.narutocraft.jutsu.ninjutsu.Enmakugire;
import pl.grm.narutocraft.jutsu.ninjutsu.FukimiHari;
import pl.grm.narutocraft.jutsu.ninjutsu.HariJizo;
import pl.grm.narutocraft.jutsu.ninjutsu.Kai;
import pl.grm.narutocraft.jutsu.ninjutsu.KawarimiNoJutsu;
import pl.grm.narutocraft.jutsu.ninjutsu.KuchiyoseRashomon;
import pl.grm.narutocraft.jutsu.ninjutsu.Meisaigakure;
import pl.grm.narutocraft.jutsu.ninjutsu.NanKaizou;
import pl.grm.narutocraft.jutsu.ninjutsu.NawanukeNoJutsu;
import pl.grm.narutocraft.jutsu.ninjutsu.OdamaRasengan;
import pl.grm.narutocraft.jutsu.ninjutsu.Rasengan;
import pl.grm.narutocraft.jutsu.ninjutsu.Sharingan;
import pl.grm.narutocraft.jutsu.ninjutsu.ShunshinNoJutsu;
import pl.grm.narutocraft.jutsu.taijutsu.AsaKujaku;
import pl.grm.narutocraft.jutsu.taijutsu.Hirudora;
import pl.grm.narutocraft.jutsu.taijutsu.KageBuyo;
import pl.grm.narutocraft.jutsu.taijutsu.KosaHo;
import pl.grm.narutocraft.jutsu.taijutsu.OmoteRenge;
import pl.grm.narutocraft.jutsu.taijutsu.UraRenge;

public enum JutsuEnum {
	NONE(
			5600,
			"None",
			null,
			SkillTrees.NONE) ,
	MEISAIGAKURE(
			5601,
			"Meisaigakure",
			Meisaigakure.class,
			SkillTrees.NINJUTSU) ,
	KAWARIMINOJUTSU(
			5625,
			"KawarimiNoJutsu",
			KawarimiNoJutsu.class,
			SkillTrees.NINJUTSU) ,
	FUMANINKEN(
			5602,
			"Fuma Ninken",
			FumaNinken.class,
			SkillTrees.BUKIJUTSU) ,
	HADAN(
			5603,
			"Hadan",
			Hadan.class,
			SkillTrees.BUKIJUTSU) ,
	IAIDO(
			5604,
			"Iaido",
			Iaido.class,
			SkillTrees.BUKIJUTSU) ,
	ISSEN(
			5605,
			"Issen",
			Issen.class,
			SkillTrees.BUKIJUTSU) ,
	MIKAZUKIKIRI(
			5606,
			"Mikazuki Kiri",
			MikazukiKiri.class,
			SkillTrees.BUKIJUTSU) ,
	OMOTEGIRI(
			5607,
			"Omotegiri",
			Omotegiri.class,
			SkillTrees.BUKIJUTSU) ,
	SAMURAISABRETECHNIQUE(
			5608,
			"SamuraiSabreTechnique",
			SamuraiSabreTechnique.class,
			SkillTrees.BUKIJUTSU) ,
	YOSAKUGIRI(
			5609,
			"Yosakugiri",
			Yosakugiri.class,
			SkillTrees.BUKIJUTSU) ,
	BYAKUGO(
			5610,
			"Byakugo",
			Byakugo.class,
			SkillTrees.FUUINJUTSU) ,
	JIKUKANKEKKAI(
			5611,
			"Jikukan Kekkai",
			JikukanKekkai.class,
			SkillTrees.FUUINJUTSU) ,
	HAYKKARORAN(
			5612,
			"Haykkaroran",
			Haykkaroran.class,
			SkillTrees.FUUINJUTSU) ,
	KOKUANGYONOJUTSU(
			5613,
			"Kokuangyo No Jutsu",
			KokuangyoNoJutsu.class,
			SkillTrees.FUUINJUTSU) ,
	KOUKONGARASU(
			5614,
			"Koukongarasuê",
			Koukongarasu.class,
			SkillTrees.FUUINJUTSU) ,
	RAIGENRAIKOCHU(
			5615,
			"RaigenRaikochu",
			RaigenRaikochu.class,
			SkillTrees.FUUINJUTSU) ,
	CHAKURANOMESU(
			5616,
			"Chakura No Mesu",
			ChakuraNoMesu.class,
			SkillTrees.IRYOJUTSU) ,
	DOKUGIRI(
			5617,
			"Dokugiri",
			Dokugiri.class,
			SkillTrees.IRYOJUTSU) ,
	INYUSHOMETSU(
			5618,
			"InyuShometsu",
			InyuShometsu.class,
			SkillTrees.IRYOJUTSU) ,
	RANSHINSHO(
			5619,
			"Ranshinsho",
			Ranshinsho.class,
			SkillTrees.IRYOJUTSU) ,
	SAIKANCHUSHUTSUNOJUTSU(
			5620,
			"Saikan Chushutsu No Jutsu",
			SaikanChushutsuNoJutsu.class,
			SkillTrees.IRYOJUTSU) ,
	ENMAKUGIRE(
			5621,
			"Enmakugire",
			Enmakugire.class,
			SkillTrees.NINJUTSU) ,
	FUKIMIHARI(
			5622,
			"FukimiHari",
			FukimiHari.class,
			SkillTrees.NINJUTSU) ,
	HARIJIZO(
			5623,
			"HariJizo",
			HariJizo.class,
			SkillTrees.NINJUTSU) ,
	KAI(
			5624,
			"Kai",
			Kai.class,
			SkillTrees.NINJUTSU) ,
	KUCHIYOSERASHOMON(
			5626,
			"Kuchiyose Rashomon",
			KuchiyoseRashomon.class,
			SkillTrees.NINJUTSU) ,
	NANKAIZOU(
			5627,
			"Nan Kaizou",
			NanKaizou.class,
			SkillTrees.NINJUTSU) ,
	NAWANUKENOJUTSU(
			5628,
			"Nawanuke No Jutsu",
			NawanukeNoJutsu.class,
			SkillTrees.NINJUTSU) ,
	RASENGAN(
			5629,
			"Rasengan",
			Rasengan.class,
			SkillTrees.NINJUTSU) ,
	ODAMARASENGAN(
			5630,
			"OdamaRasengan",
			OdamaRasengan.class,
			SkillTrees.NINJUTSU) ,
	CHIOODAMARASENGAN(
			5631,
			"ChioOdamaRasengan",
			ChioOdamaRasengan.class,
			SkillTrees.NINJUTSU) ,
	SHARINGAN(
			5632,
			"Sharingan",
			Sharingan.class,
			SkillTrees.NINJUTSU) ,
	SHUNSHINNOJUTSU(
			5633,
			"ShunshinNoJutsu",
			ShunshinNoJutsu.class,
			SkillTrees.NINJUTSU) ,
	ASAKUJAKU(
			5634,
			"Asa Kujaku",
			AsaKujaku.class,
			SkillTrees.TAIJUTSU) ,
	HIRUDORA(
			5635,
			"Hirudora",
			Hirudora.class,
			SkillTrees.TAIJUTSU) ,
	KAGEBUYO(
			5636,
			"Kage Buyo",
			KageBuyo.class,
			SkillTrees.TAIJUTSU) ,
	KOSAHO(
			5637,
			"KosaHo",
			KosaHo.class,
			SkillTrees.TAIJUTSU) ,
	OMOTERENGE(
			5638,
			"Omote Renge",
			OmoteRenge.class,
			SkillTrees.TAIJUTSU) ,
	URARENGE(
			5639,
			"Ura Renge",
			UraRenge.class,
			SkillTrees.TAIJUTSU);
	
	private int						jutsuID;
	private SkillTrees				jutsuType;
	private String					jutsuName;
	private Class<? extends Jutsu>	jutsuClass;
	
	JutsuEnum(int ID, String name, Class<? extends Jutsu> jutsu, SkillTrees jutsuType) {
		this.jutsuID = ID;
		this.jutsuName = name;
		this.jutsuClass = jutsu;
		this.jutsuType = jutsuType;
	}
	
	public static JutsuEnum getByID(int ID) {
		for (JutsuEnum jutsu : JutsuEnum.values()) {
			if (jutsu.jutsuID == ID) { return jutsu; }
		}
		return NONE;
	}
	
	public static JutsuEnum getByName(String name) {
		for (JutsuEnum jutsu : JutsuEnum.values()) {
			if (jutsu.jutsuName == name) { return jutsu; }
		}
		return NONE;
	}
	
	public int getID() {
		return this.jutsuID;
	}
	
	public Jutsu getJutsu() {
		Jutsu jutsu = null;
		try {
			jutsu = this.jutsuClass.newInstance();
		}
		catch (InstantiationException | IllegalAccessException e) {
			System.out.println("LOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOL");
			e.printStackTrace();
		}
		return jutsu;
	}
	
	public SkillTrees getJutsuType() {
		return this.jutsuType;
	}
	
	public String getName() {
		return this.jutsuName;
	}
}
