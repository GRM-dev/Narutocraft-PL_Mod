package pl.grm.narutocraft.jutsu;

import pl.grm.narutocraft.jutsu.bukijutsu.FumaNinken;
import pl.grm.narutocraft.jutsu.bukijutsu.Hadan;
import pl.grm.narutocraft.jutsu.bukijutsu.Iaido;
import pl.grm.narutocraft.jutsu.bukijutsu.Issen;
import pl.grm.narutocraft.jutsu.bukijutsu.MikazukiKiri;
import pl.grm.narutocraft.jutsu.bukijutsu.Omotegiri;
import pl.grm.narutocraft.jutsu.bukijutsu.SamuraiSabreTechnique;
import pl.grm.narutocraft.jutsu.bukijutsu.Yosakugiri;
import pl.grm.narutocraft.jutsu.fuuinjutsu.JikukanKekkai;
import pl.grm.narutocraft.jutsu.genjutsu.Haykkaroran;
import pl.grm.narutocraft.jutsu.genjutsu.KokuangyoNoJutsu;
import pl.grm.narutocraft.jutsu.genjutsu.Koukongarasu;
import pl.grm.narutocraft.jutsu.genjutsu.RaigenRaikochu;
import pl.grm.narutocraft.jutsu.iryojutsu.Byakugo;
import pl.grm.narutocraft.jutsu.iryojutsu.ChakuraNoMesu;
import pl.grm.narutocraft.jutsu.iryojutsu.Dokugiri;
import pl.grm.narutocraft.jutsu.iryojutsu.InyuShometsu;
import pl.grm.narutocraft.jutsu.iryojutsu.Ranshinsho;
import pl.grm.narutocraft.jutsu.iryojutsu.SaikanChushutsuNoJutsu;
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
import pl.grm.narutocraft.skilltrees.SkillTreeEnum;

public enum JutsuEnum {
	NONE(
			5600,
			"None",
			null,
			SkillTreeEnum.NONE,
			JutsuTier.NONE,
			0,
			0,
			0,
			0) ,
	MEISAIGAKURE(
			5601,
			"Meisaigakure",
			Meisaigakure.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.B,
			120,
			360,
			20,
			0) ,
	KAWARIMINOJUTSU(
			5625,
			"Kawarimi No Jutsu",
			KawarimiNoJutsu.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.D,
			0,
			60,
			10,
			0) // TODO set right values
	,
	FUMANINKEN(
			5602,
			"FumaNinken",
			FumaNinken.class,
			SkillTreeEnum.BUKIJUTSU,
			JutsuTier.D,
			20,
			60,
			5,
			0) ,
	HADAN(
			5603,
			"Hadan",
			Hadan.class,
			SkillTreeEnum.BUKIJUTSU,
			JutsuTier.A,
			20,
			60,
			50,
			0) ,
	IAIDO(
			5604,
			"Iaido",
			Iaido.class,
			SkillTreeEnum.BUKIJUTSU,
			JutsuTier.S,
			10,
			60,
			100,
			0) ,
	ISSEN(
			5605,
			"Issen",
			Issen.class,
			SkillTreeEnum.BUKIJUTSU,
			JutsuTier.B,
			0,
			0,
			30,
			20) ,
	MIKAZUKIKIRI(
			5606,
			"Mikazuki Kiri",
			MikazukiKiri.class,
			SkillTreeEnum.BUKIJUTSU,
			JutsuTier.C,
			30,
			50,
			25,
			0) ,
	OMOTEGIRI(
			5607,
			"Omotegiri",
			Omotegiri.class,
			SkillTreeEnum.BUKIJUTSU,
			JutsuTier.D,
			20,
			60,
			10,
			0) ,
	SAMURAISABRETECHNIQUE(
			5608,
			"Samurai Sabre Technique",
			SamuraiSabreTechnique.class,
			SkillTreeEnum.BUKIJUTSU,
			JutsuTier.C,
			0,
			120,
			15,
			0) ,
	YOSAKUGIRI(
			5609,
			"Yosakugiri",
			Yosakugiri.class,
			SkillTreeEnum.BUKIJUTSU,
			JutsuTier.C,
			0,
			60,
			20,
			0) ,
	BYAKUGO(
			5610,
			"Byakugo",
			Byakugo.class,
			SkillTreeEnum.IRYOJUTSU,
			JutsuTier.S,
			0,
			600,
			40,
			0) ,
	JIKUKANKEKKAI(
			5611,
			"Jikukan Kekkai",
			JikukanKekkai.class,
			SkillTreeEnum.FUUINJUTSU,
			JutsuTier.A,
			600,
			86400,
			200,
			0) ,
	HAYKKARORAN(
			5612,
			"Haykkaroran",
			Haykkaroran.class,
			SkillTreeEnum.GENJUTSU,
			JutsuTier.B,
			0,
			60,
			15,
			0) ,
	KOKUANGYONOJUTSU(
			5613,
			"Kokuangyo No Jutsu",
			KokuangyoNoJutsu.class,
			SkillTreeEnum.FUUINJUTSU,
			JutsuTier.D,
			30,
			30,
			10,
			0) ,
	KOUKONGARASU(
			5614,
			"Koukongarasu",
			Koukongarasu.class,
			SkillTreeEnum.GENJUTSU,
			JutsuTier.B,
			0,
			1800,
			30,
			0) ,
	RAIGENRAIKOCHU(
			5615,
			"Raigen Raikochu",
			RaigenRaikochu.class,
			SkillTreeEnum.GENJUTSU,
			JutsuTier.C,
			0,
			50,
			5,
			0) ,
	CHAKURANOMESU(
			5616,
			"Chakura No Mesu",
			ChakuraNoMesu.class,
			SkillTreeEnum.IRYOJUTSU,
			JutsuTier.C,
			15,
			180,
			15,
			0) ,
	DOKUGIRI(
			5617,
			"Dokugiri",
			Dokugiri.class,
			SkillTreeEnum.IRYOJUTSU,
			JutsuTier.C,
			0,
			240,
			10,
			0) ,
	INYUSHOMETSU(
			5618,
			"InyuShometsu",
			InyuShometsu.class,
			SkillTreeEnum.IRYOJUTSU,
			JutsuTier.B,
			0,
			300,
			10,
			0) ,
	RANSHINSHO(
			5619,
			"Ranshinsho",
			Ranshinsho.class,
			SkillTreeEnum.IRYOJUTSU,
			JutsuTier.B,
			30,
			300,
			25,
			0) ,
	SAIKANCHUSHUTSUNOJUTSU(
			5620,
			"Saikan Chushutsu No Jutsu",
			SaikanChushutsuNoJutsu.class,
			SkillTreeEnum.IRYOJUTSU,
			JutsuTier.D,
			0,
			120,
			5,
			0) ,
	ENMAKUGIRE(
			5621,
			"Enmakugire",
			Enmakugire.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.C,
			15,
			60,
			10,
			0) ,
	FUKIMIHARI(
			5622,
			"FukimiHari",
			FukimiHari.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.C,
			0,
			5,
			5,
			0) ,
	HARIJIZO(
			5623,
			"HariJizo",
			HariJizo.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.B,
			30,
			180,
			5,
			0) ,
	KAI(
			5624,
			"Kai",
			Kai.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.D,
			0,
			30,
			4,
			0) ,
	KUCHIYOSERASHOMON(
			5626,
			"Kuchiyose Rashomon",
			KuchiyoseRashomon.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.A,
			60,
			600,
			29,
			0) ,
	NANKAIZOU(
			5627,
			"Nan Kaizou",
			NanKaizou.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.C,
			0,
			60,
			7,
			0) ,
	NAWANUKENOJUTSU(
			5628,
			"Nawanuke No Jutsu",
			NawanukeNoJutsu.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.D,
			0,
			0,
			2,
			0) ,
	RASENGAN(
			5629,
			"Rasengan",
			Rasengan.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.B,
			2,
			10,
			40,
			25)    // TODO set right values
	,
	ODAMARASENGAN(
			5630,
			"OdamaRasengan",
			OdamaRasengan.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.A,
			5,
			30,
			65,
			35) // TODO set right values
	,
	// CHIOODAMARASENGAN(
	// 5631,
	// "ChioOdamaRasengan",
	// ChioOdamaRasengan.class,
	// SkillTreeEnum.NINJUTSU,
	// JutsuTier.A) ,
	SHARINGAN(
			5632,
			"Sharingan",
			Sharingan.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.C,
			0,
			0,
			0,
			0) // TODO set right values
	,
	SHUNSHINNOJUTSU(
			5633,
			"Shunshin No Jutsu",
			ShunshinNoJutsu.class,
			SkillTreeEnum.NINJUTSU,
			JutsuTier.D,
			0,
			0,
			0,
			0) // TODO set right values
	,
	ASAKUJAKU(
			5634,
			"Asa Kujaku",
			AsaKujaku.class,
			SkillTreeEnum.TAIJUTSU,
			JutsuTier.A,
			0,
			120,
			0,
			4) ,
	HIRUDORA(
			5635,
			"Hirudora",
			Hirudora.class,
			SkillTreeEnum.TAIJUTSU,
			JutsuTier.S,
			0,
			86400,
			0,
			65) ,
	KAGEBUYO(
			5636,
			"Kage Buyo",
			KageBuyo.class,
			SkillTreeEnum.TAIJUTSU,
			JutsuTier.D,
			0,
			20,
			0,
			5) ,
	KOSAHO(
			5637,
			"Kosa Ho",
			KosaHo.class,
			SkillTreeEnum.TAIJUTSU,
			JutsuTier.C,
			0,
			1,
			0,
			0) ,
	OMOTERENGE(
			5638,
			"Omote Renge",
			OmoteRenge.class,
			SkillTreeEnum.TAIJUTSU,
			JutsuTier.B,
			0,
			50,
			0,
			13) ,
	URARENGE(
			5639,
			"Ura Renge",
			UraRenge.class,
			SkillTreeEnum.TAIJUTSU,
			JutsuTier.A,
			0,
			86400,
			0,
			50);
	
	private int						jutsuID;
	private String					jutsuName;
	private Class<? extends Jutsu>	jutsuClass;
	private SkillTreeEnum			jutsuTree;
	private JutsuTier				tier;
	private long					duration;
	private long					cooldown;
	private int						chakraConsumption;
	private int						damage;
	
	/**
	 * @param ID
	 * @param name
	 * @param jutsu
	 * @param jutsuType
	 * @param tier
	 * @param duration
	 * @param cooldown
	 * @param chakraConsumption
	 * @param damage
	 */
	private JutsuEnum(int ID, String name, Class<? extends Jutsu> jutsu,
			SkillTreeEnum jutsuType, JutsuTier tier, long duration, long cooldown,
			int chakraConsumption, int damage) {
		this.duration = duration;
		this.cooldown = cooldown;
		this.chakraConsumption = chakraConsumption;
		this.damage = damage;
		this.tier = tier;
		this.jutsuID = ID;
		this.jutsuName = name;
		this.jutsuClass = jutsu;
		this.jutsuTree = jutsuType;
	}
	
	/**
	 * @param ID
	 * @return JutsuEnum containing ID
	 */
	public static JutsuEnum getByID(int ID) {
		for (JutsuEnum jutsu : JutsuEnum.values()) {
			if (jutsu.jutsuID == ID) { return jutsu; }
		}
		return NONE;
	}
	
	/**
	 * @param name
	 * @return JutsuEnum containg name
	 */
	public static JutsuEnum getByName(String name) {
		for (JutsuEnum jutsu : JutsuEnum.values()) {
			if (jutsu.jutsuName.equals(name)) { return jutsu; }
		}
		return NONE;
	}
	
	/**
	 * Returns iJustsu containg this Enum Constant
	 * 
	 * @param iJutsu
	 * @return JutsuEnum containing specified IJutsu
	 */
	public static JutsuEnum getByIJutsu(IJutsu iJutsu) {
		for (JutsuEnum jutsu : JutsuEnum.values()) {
			if (jutsu != NONE) {
				if (jutsu.jutsuClass.equals(iJutsu)) { return jutsu; }
			}
		}
		return NONE;
	}
	
	public int getJutsuID() {
		return this.jutsuID;
	}
	
	public SkillTreeEnum getTree() {
		return this.jutsuTree;
	}
	
	public int getChakraConsumption() {
		return this.chakraConsumption;
	}
	
	public String getJutsuName() {
		return this.jutsuName;
	}
	
	public Class<? extends Jutsu> getJutsuClass() {
		return this.jutsuClass;
	}
	
	public long getDuration() {
		return this.duration;
	}
	
	public long getCooldown() {
		return this.cooldown;
	}
	
	/**
	 * Create and return Instance of class from enum constants
	 *
	 * @return Jutsu
	 */
	public Jutsu getJutsu() {
		Jutsu jutsu = null;
		try {                 // TODO add exception handling
			jutsu = this.jutsuClass.newInstance();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return jutsu;
	}
	
	public String getName() {
		return this.jutsuName;
	}
	
	public JutsuTier getTier() {
		return this.tier;
	}
	
	public int getDamage() {
		return damage;
	}
}