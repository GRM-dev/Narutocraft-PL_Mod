package pl.grm.narutocraft.jutsu;

import pl.grm.narutocraft.jutsu.bukijutsu.*;
import pl.grm.narutocraft.jutsu.fuuinjutsu.JikukanKekkai;
import pl.grm.narutocraft.jutsu.genjutsu.*;
import pl.grm.narutocraft.jutsu.iryojutsu.*;
import pl.grm.narutocraft.jutsu.ninjutsu.*;
import pl.grm.narutocraft.jutsu.taijutsu.*;
import pl.grm.narutocraft.skilltrees.SkillTreeEnum;

public enum JutsuParams {
							NONE(5600, "None", null, SkillTreeEnum.NONE, JutsuTier.NONE, 0, 0, 0, 0, false),
	MEISAIGAKURE(5601, "Meisaigakure", Meisaigakure.class, SkillTreeEnum.NINJUTSU, JutsuTier.B, 120, 360, 20, 0, true), KAWARIMINOJUTSU(5625, "KawarimiNoJutsu", KawarimiNoJutsu.class, SkillTreeEnum.NINJUTSU, JutsuTier.D, 0, 60, 10, 0, false),
	FUMANINKEN(5602, "FumaNinken", FumaNinken.class, SkillTreeEnum.BUKIJUTSU, JutsuTier.D, 20, 60, 5, 0, true),
	HADAN(5603, "Hadan", Hadan.class, SkillTreeEnum.BUKIJUTSU, JutsuTier.A, 20, 60, 50, 0, true),
	IAIDO(5604, "Iaido", Iaido.class, SkillTreeEnum.BUKIJUTSU, JutsuTier.S, 10, 60, 100, 0, true),
	ISSEN(5605, "Issen", Issen.class, SkillTreeEnum.BUKIJUTSU, JutsuTier.B, 0, 0, 30, 20, true),
	MIKAZUKIKIRI(5606, "MikazukiKiri", MikazukiKiri.class, SkillTreeEnum.BUKIJUTSU, JutsuTier.C, 30, 50, 25, 0, true),
	OMOTEGIRI(5607, "Omotegiri", Omotegiri.class, SkillTreeEnum.BUKIJUTSU, JutsuTier.D, 20, 60, 10, 0, true),
	SAMURAISABRETECHNIQUE(5608, "SamuraiSabreTechnique", SamuraiSabreTechnique.class, SkillTreeEnum.BUKIJUTSU, JutsuTier.C, 0, 120, 15, 0, true),
	YOSAKUGIRI(5609, "Yosakugiri", Yosakugiri.class, SkillTreeEnum.BUKIJUTSU, JutsuTier.C, 0, 60, 20, 0, true),
	BYAKUGO(5610, "Byakugo", Byakugo.class, SkillTreeEnum.IRYOJUTSU, JutsuTier.S, 0, 600, 40, 0, true),
	JIKUKANKEKKAI(5611, "JikukanKekkai", JikukanKekkai.class, SkillTreeEnum.FUUINJUTSU, JutsuTier.A, 600, 86400, 200, 0, false),
	HAYKKARORAN(5612, "Haykkaroran", Haykkaroran.class, SkillTreeEnum.GENJUTSU, JutsuTier.B, 0, 60, 15, 0, true),
	KOKUANGYONOJUTSU(5613, "KokuangyoNoJutsu", KokuangyoNoJutsu.class, SkillTreeEnum.FUUINJUTSU, JutsuTier.D, 30, 30, 10, 0, true),
	KOUKONGARASU(5614, "Koukongarasu", Koukongarasu.class, SkillTreeEnum.GENJUTSU, JutsuTier.B, 0, 1800, 30, 0, true),
	RAIGENRAIKOCHU(5615, "RaigenRaikochu", RaigenRaikochu.class, SkillTreeEnum.GENJUTSU, JutsuTier.C, 0, 50, 5, 0, true),
	CHAKURANOMESU(5616, "ChakuraNoMesu", ChakuraNoMesu.class, SkillTreeEnum.IRYOJUTSU, JutsuTier.C, 15, 180, 15, 0, false),
	DOKUGIRI(5617, "Dokugiri", Dokugiri.class, SkillTreeEnum.IRYOJUTSU, JutsuTier.C, 0, 240, 10, 0, false),
	INYUSHOMETSU(5618, "InyuShometsu", InyuShometsu.class, SkillTreeEnum.IRYOJUTSU, JutsuTier.B, 0, 300, 10, 0, false),
	RANSHINSHO(5619, "Ranshinsho", Ranshinsho.class, SkillTreeEnum.IRYOJUTSU, JutsuTier.B, 30, 300, 25, 0, true),
	SAIKANCHUSHUTSUNOJUTSU(5620, "SaikanChushutsuNoJutsu", SaikanChushutsuNoJutsu.class, SkillTreeEnum.IRYOJUTSU, JutsuTier.D, 0, 120, 5, 0, false),
	ENMAKUGIRE(5621, "Enmakugire", Enmakugire.class, SkillTreeEnum.NINJUTSU, JutsuTier.C, 15, 60, 10, 0, false),
	FUKIMIHARI(5622, "FukimiHari", FukimiHari.class, SkillTreeEnum.NINJUTSU, JutsuTier.C, 0, 5, 5, 0, false),
	HARIJIZO(5623, "HariJizo", HariJizo.class, SkillTreeEnum.NINJUTSU, JutsuTier.B, 30, 180, 5, 0, false),
	KAI(5624, "Kai", Kai.class, SkillTreeEnum.NINJUTSU, JutsuTier.D, 0, 30, 4, 0, false),
	KUCHIYOSERASHOMON(5626, "KuchiyoseRashomon", KuchiyoseRashomon.class, SkillTreeEnum.NINJUTSU, JutsuTier.A, 60, 600, 29, 0, false),
	NANKAIZOU(5627, "NanKaizou", NanKaizou.class, SkillTreeEnum.NINJUTSU, JutsuTier.C, 0, 60, 7, 0, true),
	NAWANUKENOJUTSU(5628, "NawanukeNoJutsu", NawanukeNoJutsu.class, SkillTreeEnum.NINJUTSU, JutsuTier.D, 0, 0, 2, 0, false),
							RASENGAN(5629, "Rasengan", Rasengan.class, SkillTreeEnum.NINJUTSU, JutsuTier.B, 2, 10, 40, 25, false),
							ODAMARASENGAN(5630, "OdamaRasengan", OdamaRasengan.class, SkillTreeEnum.NINJUTSU, JutsuTier.A, 5, 30, 65, 35, false),
							CHIOODAMARASENGAN(5631, "ChioOdamaRasengan", ChioOdamaRasengan.class, SkillTreeEnum.NINJUTSU, JutsuTier.A, 20, 5, 10, 100, false),
							SHARINGAN(5632, "Sharingan", Sharingan.class, SkillTreeEnum.NINJUTSU, JutsuTier.C, 0, 0, 0, 0, false),
							SHUNSHINNOJUTSU(5633, "ShunshinNoJutsu", ShunshinNoJutsu.class, SkillTreeEnum.NINJUTSU, JutsuTier.D, 0, 0, 0, 0, false),
	ASAKUJAKU(5634, "AsaKujaku", AsaKujaku.class, SkillTreeEnum.TAIJUTSU, JutsuTier.A, 0, 120, 0, 4, true),
	HIRUDORA(5635, "Hirudora", Hirudora.class, SkillTreeEnum.TAIJUTSU, JutsuTier.S, 0, 86400, 0, 65, false),
	KAGEBUYO(5636, "KageBuyo", KageBuyo.class, SkillTreeEnum.TAIJUTSU, JutsuTier.D, 0, 20, 0, 5, false),
	KOSAHO(5637, "KosaHo", KosaHo.class, SkillTreeEnum.TAIJUTSU, JutsuTier.C, 0, 1, 0, 0, false),
	OMOTERENGE(5638, "OmoteRenge", OmoteRenge.class, SkillTreeEnum.TAIJUTSU, JutsuTier.B, 0, 50, 0, 13, false),
	URARENGE(5639, "UraRenge", UraRenge.class, SkillTreeEnum.TAIJUTSU, JutsuTier.A, 0, 86400, 0, 50, false),
	MIKAZUKINOMAI(5640, "MikazukiNoMai", MikazukiNoMai.class, SkillTreeEnum.BUKIJUTSU, JutsuTier.B, 0, 60, 35, 0, true);

	private int jutsuID;
	private String jutsuName;
	private Class<? extends Jutsu> jutsuClass;
	private SkillTreeEnum jutsuTree;
	private JutsuTier tier;
	private long duration;
	private long cooldown;
	private int chakraConsumption;
	private int damage;
	private boolean buffType;

	

	/**
	 * @param ID
	 *            Unique ID of Jutsu
	 * @param name
	 *            Name of Jutsu
	 * @param jutsuClass
	 *            Class of Jutsu
	 * @param jutsuType
	 *            Specifies the jutsu tree
	 * @param tier
	 *            Tier of Jutsu
	 * @param duration
	 *            Duration of Jutsu. If set 0 than onClick one time use
	 * @param cooldown
	 *            Cooldown of jutsu
	 * @param chakraConsumption
	 *            How many chakra jutsu should consume
	 * @param damage
	 *            Damage dealt by Jutsu
	 * @param bufftype
	 *            is jutsu the buff
	 */
	private JutsuParams(int ID,String name , Class<? extends Jutsu> jutsuClass, SkillTreeEnum jutsuType, JutsuTier tier,
			long duration, long cooldown, int chakraConsumption, int damage, boolean bufftype) {
		this.duration = duration;
		this.cooldown = cooldown;
		this.chakraConsumption = chakraConsumption;
		this.damage = damage;
		this.tier = tier;
		this.jutsuID = ID;
		this.jutsuClass = jutsuClass;
		this.jutsuName = name;
		
		this.jutsuTree = jutsuType;
		this.buffType = bufftype;
	}

	/**
	 * @param ID
	 * @return JutsuEnum containing ID
	 */
	public static JutsuParams getByID(int ID) {
		for (JutsuParams jutsu : JutsuParams.values()) {
			if (jutsu.jutsuID == ID) { return jutsu; }
		}
		return NONE;
	}

	/**
	 * @param name
	 * @return JutsuEnum containg name
	 */
	public static JutsuParams getByName(String name) {
		for (JutsuParams jutsu : JutsuParams.values()) {
			if (jutsu.jutsuName.toUpperCase().equals(name.toUpperCase())) { return jutsu; }
		}
		return NONE;
	}

	/**
	 * Returns iJustsu containg this Enum Constant
	 * 
	 * @param iJutsu
	 * @return JutsuEnum containing specified IJutsu
	 */
	public static JutsuParams getByIJutsu(IJutsu iJutsu) {
		for (JutsuParams jutsu : JutsuParams.values()) {
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
	public IJutsu getJutsu() {
		IJutsu jutsu = null;
		try { // TODO add exception handling
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

	public SkillTreeEnum getJutsuTree() {
		return this.jutsuTree;
	}

	public boolean isBuffType() {
		return this.buffType;
	}
	

	
}