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
import pl.grm.narutocraft.skilltrees.SkillTree;

// TODO add Tiers to Jutsus.
public enum JutsuEnum {
	NONE(
			5600,
			"None",
			null,
			SkillTree.NONE,
			JutsuTier.NONE,
			0,
			0,
			0,
			0) ,
	MEISAIGAKURE(
			5601,
			"Meisaigakure",
			Meisaigakure.class,
			SkillTree.NINJUTSU,
			JutsuTier.B,
			120,
			360,
			20,
			0) ,
	KAWARIMINOJUTSU(
			5625,
			"Kawarimi No Jutsu",
			KawarimiNoJutsu.class,
			SkillTree.NINJUTSU) ,
	FUMANINKEN(
			5602,
			"FumaNinken",
			FumaNinken.class,
			SkillTree.BUKIJUTSU,
			JutsuTier.D,
			20,
			60,
			5,
			0) ,
	HADAN(
			5603,
			"Hadan",
			Hadan.class,
			SkillTree.BUKIJUTSU,
			JutsuTier.A,
			20,
			60,
			50,
			0) ,
	IAIDO(
			5604,
			"Iaido",
			Iaido.class,
			SkillTree.BUKIJUTSU,
			JutsuTier.S,
			10,
			60,
			100,
			0) ,
	ISSEN(
			5605,
			"Issen",
			Issen.class,
			SkillTree.BUKIJUTSU,
			JutsuTier.B,
			0,
			0,
			30,
			20) ,
	MIKAZUKIKIRI(
			5606,
			"Mikazuki Kiri",
			MikazukiKiri.class,
			SkillTree.BUKIJUTSU,
			JutsuTier.C,
			30,
			50,
			25,
			0) ,
	OMOTEGIRI(
			5607,
			"Omotegiri",
			Omotegiri.class,
			SkillTree.BUKIJUTSU,
			JutsuTier.D,
			20,
			60,
			10,
			0) ,
	SAMURAISABRETECHNIQUE(
			5608,
			"Samurai Sabre Technique",
			SamuraiSabreTechnique.class,
			SkillTree.BUKIJUTSU,
			JutsuTier.C,
			0,
			120,
			15,
			0) ,
	YOSAKUGIRI(
			5609,
			"Yosakugiri",
			Yosakugiri.class,
			SkillTree.BUKIJUTSU,
			JutsuTier.C,
			0,
			60,
			20,
			0) ,
	BYAKUGO(
			5610,
			"Byakugo",
			Byakugo.class,
			SkillTree.IRYOJUTSU,
			JutsuTier.S,
			0,
			600,
			40,
			0) ,
	JIKUKANKEKKAI(
			5611,
			"Jikukan Kekkai",
			JikukanKekkai.class,
			SkillTree.FUUINJUTSU,
			JutsuTier.A,
			600,
			86400,
			200,
			0) ,
	HAYKKARORAN(
			5612,
			"Haykkaroran",
			Haykkaroran.class,
			SkillTree.GENJUTSU,
			JutsuTier.B,
			0,
			60,
			15,
			0) ,
	KOKUANGYONOJUTSU(
			5613,
			"Kokuangyo No Jutsu",
			KokuangyoNoJutsu.class,
			SkillTree.FUUINJUTSU,
			JutsuTier.D,
			30,
			30,
			10,
			0) ,
	KOUKONGARASU(
			5614,
			"Koukongarasu",
			Koukongarasu.class,
			SkillTree.GENJUTSU,
			JutsuTier.B,
			0,
			1800,
			30,
			0) ,
	RAIGENRAIKOCHU(
			5615,
			"Raigen Raikochu",
			RaigenRaikochu.class,
			SkillTree.GENJUTSU,
			JutsuTier.C,
			0,
			50,
			5,
			0) ,
	CHAKURANOMESU(
			5616,
			"Chakura No Mesu",
			ChakuraNoMesu.class,
			SkillTree.IRYOJUTSU,
			JutsuTier.C,
			15,
			180,
			15,
			0) ,
	DOKUGIRI(
			5617,
			"Dokugiri",
			Dokugiri.class,
			SkillTree.IRYOJUTSU,
			JutsuTier.C,
			0,
			240,
			10,
			0) ,
	INYUSHOMETSU(
			5618,
			"InyuShometsu",
			InyuShometsu.class,
			SkillTree.IRYOJUTSU,
			JutsuTier.B,
			0,
			300,
			10,
			0) ,
	RANSHINSHO(
			5619,
			"Ranshinsho",
			Ranshinsho.class,
			SkillTree.IRYOJUTSU,
			JutsuTier.B,
			30,
			300,
			25,
			0) ,
	SAIKANCHUSHUTSUNOJUTSU(
			5620,
			"Saikan Chushutsu No Jutsu",
			SaikanChushutsuNoJutsu.class,
			SkillTree.IRYOJUTSU,
			JutsuTier.D,
			0,
			120,
			5,
			0) ,
	ENMAKUGIRE(
			5621,
			"Enmakugire",
			Enmakugire.class,
			SkillTree.NINJUTSU,
			JutsuTier.C,
			15,
			60,
			10,
			0) ,
	FUKIMIHARI(
			5622,
			"FukimiHari",
			FukimiHari.class,
			SkillTree.NINJUTSU,
			JutsuTier.C,
			0,
			5,
			5,
			0) ,
	HARIJIZO(
			5623,
			"HariJizo",
			HariJizo.class,
			SkillTree.NINJUTSU,
			JutsuTier.B,
			30,
			180,
			5,
			0) ,
	KAI(
			5624,
			"Kai",
			Kai.class,
			SkillTree.NINJUTSU,
			JutsuTier.D,
			0,
			30,
			4,
			0) ,
	KUCHIYOSERASHOMON(
			5626,
			"Kuchiyose Rashomon",
			KuchiyoseRashomon.class,
			SkillTree.NINJUTSU,
			JutsuTier.A,
			60,
			600,
			29,
			0) ,
	NANKAIZOU(
			5627,
			"Nan Kaizou",
			NanKaizou.class,
			SkillTree.NINJUTSU,
			JutsuTier.C,
			0,
			60,
			7,
			0) ,
	NAWANUKENOJUTSU(
			5628,
			"Nawanuke No Jutsu",
			NawanukeNoJutsu.class,
			SkillTree.NINJUTSU,
			JutsuTier.D,
			0,
			0,
			0,
			0) ,
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
			"ChioOdama Rasengan",
			ChioOdamaRasengan.class,
			SkillTree.NINJUTSU) ,
	SHARINGAN(
			5632,
			"Sharingan",
			Sharingan.class,
			SkillTree.NINJUTSU) ,
	SHUNSHINNOJUTSU(
			5633,
			"Shunshin No Jutsu",
			ShunshinNoJutsu.class,
			SkillTree.NINJUTSU,
			JutsuTier.D) ,
	ASAKUJAKU(
			5634,
			"Asa Kujaku",
			AsaKujaku.class,
			SkillTree.TAIJUTSU,
			JutsuTier.A,
			0,
			120,
			0,
			4) ,
	HIRUDORA(
			5635,
			"Hirudora",
			Hirudora.class,
			SkillTree.TAIJUTSU,
			JutsuTier.S,
			0,
			86400,
			0,
			65) ,
	KAGEBUYO(
			5636,
			"Kage Buyo",
			KageBuyo.class,
			SkillTree.TAIJUTSU,
			JutsuTier.D,
			0,
			20,
			0,
			5) ,
	KOSAHO(
			5637,
			"Kosa Ho",
			KosaHo.class,
			SkillTree.TAIJUTSU,
			JutsuTier.C,
			0,
			1,
			0,
			0) ,
	OMOTERENGE(
			5638,
			"Omote Renge",
			OmoteRenge.class,
			SkillTree.TAIJUTSU,
			JutsuTier.B,
			0,
			50,
			0,
			13) ,
	URARENGE(
			5639,
			"Ura Renge",
			UraRenge.class,
			SkillTree.TAIJUTSU,
			JutsuTier.A,
			0,
			86400,
			0,
			50);
	
	private int						jutsuID;
	private SkillTree				jutsuTree;
	private String					jutsuName;
	private Class<? extends Jutsu>	jutsuClass;
	private JutsuTier				tier;
	private long					duration;
	private long					cooldown;
	private int						chakraConsumption;
	private int						damage;
	
	private JutsuEnum(int ID, String name, Class<? extends Jutsu> jutsu,
			SkillTree jutsuType, JutsuTier tier, long duration, long cooldown,
			int chakraConsumption, int damage) {
		this(ID, name, jutsu, jutsuType, tier);
		this.duration = duration;
		this.cooldown = cooldown;
		this.chakraConsumption = chakraConsumption;
		this.setDamage(damage);
	}
	
	private JutsuEnum(int ID, String name, Class<? extends Jutsu> jutsu,
			SkillTree jutsuType, JutsuTier tier) {
		this(ID, name, jutsu, jutsuType);
		this.tier = tier;
	}
	
	private JutsuEnum(int ID, String name, Class<? extends Jutsu> jutsu,
			SkillTree jutsuType) {
		this.jutsuID = ID;
		this.jutsuName = name;
		this.jutsuClass = jutsu;
		this.jutsuTree = jutsuType;
	}
	
	public int getJutsuID() {
		return this.jutsuID;
	}
	
	public SkillTree getJutsuTree() {
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
	
	public Jutsu getJutsu() {
		Jutsu jutsu = null;
		try {
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
	
	public SkillTree getJutsuType() {
		return this.jutsuTree;
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
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
}