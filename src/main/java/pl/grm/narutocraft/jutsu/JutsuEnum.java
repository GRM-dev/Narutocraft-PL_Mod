package pl.grm.narutocraft.jutsu;

import pl.grm.narutocraft.gui.skilltrees.SkillTree;
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

// TODO add Tiers to Jutsus.
public enum JutsuEnum {
	NONE(
			5600,
			"None",
			null,
			SkillTree.NONE,
			JutsuTier.NONE) ,
	MEISAIGAKURE(
			5601,
			"Meisaigakure",
			Meisaigakure.class,
			SkillTree.NINJUTSU,
			JutsuTier.B) ,
	KAWARIMINOJUTSU(
			5625,
			"KawarimiNoJutsu",
			KawarimiNoJutsu.class,
			SkillTree.NINJUTSU) ,
	FUMANINKEN(
			5602,
			"Fuma Ninken",
			FumaNinken.class,
			SkillTree.BUKIJUTSU) ,
	HADAN(
			5603,
			"Hadan",
			Hadan.class,
			SkillTree.BUKIJUTSU) ,
	IAIDO(
			5604,
			"Iaido",
			Iaido.class,
			SkillTree.BUKIJUTSU) ,
	ISSEN(
			5605,
			"Issen",
			Issen.class,
			SkillTree.BUKIJUTSU) ,
	MIKAZUKIKIRI(
			5606,
			"Mikazuki Kiri",
			MikazukiKiri.class,
			SkillTree.BUKIJUTSU) ,
	OMOTEGIRI(
			5607,
			"Omotegiri",
			Omotegiri.class,
			SkillTree.BUKIJUTSU) ,
	SAMURAISABRETECHNIQUE(
			5608,
			"SamuraiSabreTechnique",
			SamuraiSabreTechnique.class,
			SkillTree.BUKIJUTSU) ,
	YOSAKUGIRI(
			5609,
			"Yosakugiri",
			Yosakugiri.class,
			SkillTree.BUKIJUTSU) ,
	BYAKUGO(
			5610,
			"Byakugo",
			Byakugo.class,
			SkillTree.FUUINJUTSU) ,
	JIKUKANKEKKAI(
			5611,
			"Jikukan Kekkai",
			JikukanKekkai.class,
			SkillTree.FUUINJUTSU) ,
	HAYKKARORAN(
			5612,
			"Haykkaroran",
			Haykkaroran.class,
			SkillTree.FUUINJUTSU) ,
	KOKUANGYONOJUTSU(
			5613,
			"Kokuangyo No Jutsu",
			KokuangyoNoJutsu.class,
			SkillTree.FUUINJUTSU) ,
	KOUKONGARASU(
			5614,
			"Koukongarasu",
			Koukongarasu.class,
			SkillTree.FUUINJUTSU) ,
	RAIGENRAIKOCHU(
			5615,
			"RaigenRaikochu",
			RaigenRaikochu.class,
			SkillTree.FUUINJUTSU) ,
	CHAKURANOMESU(
			5616,
			"Chakura No Mesu",
			ChakuraNoMesu.class,
			SkillTree.IRYOJUTSU) ,
	DOKUGIRI(
			5617,
			"Dokugiri",
			Dokugiri.class,
			SkillTree.IRYOJUTSU) ,
	INYUSHOMETSU(
			5618,
			"InyuShometsu",
			InyuShometsu.class,
			SkillTree.IRYOJUTSU) ,
	RANSHINSHO(
			5619,
			"Ranshinsho",
			Ranshinsho.class,
			SkillTree.IRYOJUTSU) ,
	SAIKANCHUSHUTSUNOJUTSU(
			5620,
			"Saikan Chushutsu No Jutsu",
			SaikanChushutsuNoJutsu.class,
			SkillTree.IRYOJUTSU) ,
	ENMAKUGIRE(
			5621,
			"Enmakugire",
			Enmakugire.class,
			SkillTree.NINJUTSU) ,
	FUKIMIHARI(
			5622,
			"FukimiHari",
			FukimiHari.class,
			SkillTree.NINJUTSU) ,
	HARIJIZO(
			5623,
			"HariJizo",
			HariJizo.class,
			SkillTree.NINJUTSU) ,
	KAI(
			5624,
			"Kai",
			Kai.class,
			SkillTree.NINJUTSU) ,
	KUCHIYOSERASHOMON(
			5626,
			"Kuchiyose Rashomon",
			KuchiyoseRashomon.class,
			SkillTree.NINJUTSU) ,
	NANKAIZOU(
			5627,
			"Nan Kaizou",
			NanKaizou.class,
			SkillTree.NINJUTSU) ,
	NAWANUKENOJUTSU(
			5628,
			"Nawanuke No Jutsu",
			NawanukeNoJutsu.class,
			SkillTree.NINJUTSU,
			JutsuTier.D) ,
	RASENGAN(
			5629,
			"Rasengan",
			Rasengan.class,
			SkillTree.NINJUTSU,
			JutsuTier.B) ,
	ODAMARASENGAN(
			5630,
			"OdamaRasengan",
			OdamaRasengan.class,
			SkillTree.NINJUTSU,
			JutsuTier.A) ,
	CHIOODAMARASENGAN(
			5631,
			"ChioOdamaRasengan",
			ChioOdamaRasengan.class,
			SkillTree.NINJUTSU) ,
	SHARINGAN(
			5632,
			"Sharingan",
			Sharingan.class,
			SkillTree.NINJUTSU) ,
	SHUNSHINNOJUTSU(
			5633,
			"ShunshinNoJutsu",
			ShunshinNoJutsu.class,
			SkillTree.NINJUTSU) ,
	ASAKUJAKU(
			5634,
			"Asa Kujaku",
			AsaKujaku.class,
			SkillTree.TAIJUTSU) ,
	HIRUDORA(
			5635,
			"Hirudora",
			Hirudora.class,
			SkillTree.TAIJUTSU) ,
	KAGEBUYO(
			5636,
			"Kage Buyo",
			KageBuyo.class,
			SkillTree.TAIJUTSU) ,
	KOSAHO(
			5637,
			"KosaHo",
			KosaHo.class,
			SkillTree.TAIJUTSU) ,
	OMOTERENGE(
			5638,
			"Omote Renge",
			OmoteRenge.class,
			SkillTree.TAIJUTSU) ,
	URARENGE(
			5639,
			"Ura Renge",
			UraRenge.class,
			SkillTree.TAIJUTSU);
	
	private int						jutsuID;
	private SkillTree				jutsuTree;
	private String					jutsuName;
	private Class<? extends Jutsu>	jutsuClass;
	private JutsuTier				tier;
	
	/**
	 * Create Enum with params from enum constants.
	 * 
	 * @param ID
	 * @param name
	 * @param jutsu
	 * @param jutsuType
	 * @param tier
	 */
	private JutsuEnum(int ID, String name, Class<? extends Jutsu> jutsu,
			SkillTree jutsuType, JutsuTier tier) {
		this(ID, name, jutsu, jutsuType);
		this.tier = tier;
	}
	
	// TODO to delete after adding Tiers to all jutsu. Remember about assigns.
	private JutsuEnum(int ID, String name, Class<? extends Jutsu> jutsu,
			SkillTree jutsuType) {
		this.jutsuID = ID;
		this.jutsuName = name;
		this.jutsuClass = jutsu;
		this.jutsuTree = jutsuType;
	}
	
	public static JutsuEnum getByID(int ID) {
		for (JutsuEnum jutsu : JutsuEnum.values()) {
			if (jutsu.jutsuID == ID) { return jutsu; }
		}
		return NONE;
	}
	
	public static JutsuEnum getByName(String name) {
		for (JutsuEnum jutsu : JutsuEnum.values()) {
			if (jutsu.jutsuName.equals(name)) { return jutsu; }
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
			e.printStackTrace();
		}
		return jutsu;
	}
	
	public SkillTree getJutsuType() {
		return this.jutsuTree;
	}
	
	public String getName() {
		return this.jutsuName;
	}
	
	public JutsuTier getTier() {
		return this.tier;
	}
}