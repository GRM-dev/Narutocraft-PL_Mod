package pl.grm.narutocraft.jutsu;

import pl.grm.narutocraft.gui.skilltrees.SkillTrees;

public enum JutsuList {
	NONE(5600, SkillTrees.NONE), MEISAIGAKURE(5601, SkillTrees.NINJUTSU), FUMANINKEN(
			5602, SkillTrees.BUKIJUTSU), HADAN(5603, SkillTrees.BUKIJUTSU), IAIDO(
			5604, SkillTrees.BUKIJUTSU), ISSEN(5605, SkillTrees.BUKIJUTSU), MIKAZUKIKIRI(
			5606, SkillTrees.BUKIJUTSU), OMOTEGIRI(5607, SkillTrees.BUKIJUTSU), SAMURAISABRETECHNIQUE(
			5608, SkillTrees.BUKIJUTSU), YOSAKUGIRI(5609, SkillTrees.BUKIJUTSU), BYAKUGO(
			5610, SkillTrees.FUUINJUTSU), JIKUKANKEKKAI(5611,
			SkillTrees.FUUINJUTSU), HAYKKARORAN(5612, SkillTrees.FUUINJUTSU), KOKUANGYONOJUTSU(
			5613, SkillTrees.FUUINJUTSU), KOUKONGARASU(5614,
			SkillTrees.FUUINJUTSU), RAIGENRAIKOCHU(5615, SkillTrees.FUUINJUTSU), CHAKURANOMESU(
			5616, SkillTrees.IRYOJUTSU), DOKUGIRI(5617, SkillTrees.IRYOJUTSU), INYUSHOMETSU(
			5618, SkillTrees.IRYOJUTSU), RANSHINSHO(5619, SkillTrees.IRYOJUTSU), SAIKANCHUSHUTSUNOJUTSU(
			5620, SkillTrees.IRYOJUTSU), ENMAKUGIRE(5621, SkillTrees.NINJUTSU), FUKIMIHARI(
			5622, SkillTrees.NINJUTSU), HARIJIZO(5623, SkillTrees.NINJUTSU), KAI(
			5624, SkillTrees.NINJUTSU), KAWARIMINOJUTSU(5625,
			SkillTrees.NINJUTSU), KUCHIYOSERASHOMON(5626, SkillTrees.NINJUTSU), NANKAIZOU(
			5627, SkillTrees.NINJUTSU), NAWANUKENOJUTSU(5628,
			SkillTrees.NINJUTSU), RASENGAN(5629, SkillTrees.NINJUTSU), RASENGAN2(
			5630, SkillTrees.NINJUTSU), RASENGAN3(5631, SkillTrees.NINJUTSU), SHARINGAN(
			5632, SkillTrees.NINJUTSU), SHUNSHINNOJUTSU(5633,
			SkillTrees.NINJUTSU), ASAKUJAKU(5634, SkillTrees.TAIJUTSU), HIRUDORA(
			5635, SkillTrees.TAIJUTSU), KAGEBUYO(5636, SkillTrees.TAIJUTSU), KOSAHO(
			5637, SkillTrees.TAIJUTSU), OMOTERENGE(5638, SkillTrees.TAIJUTSU), URARENGE(
			5639, SkillTrees.TAIJUTSU);

	private int jutsuID;
	private SkillTrees jutsuType;

	JutsuList(int ID, SkillTrees jutsuType) {
		this.jutsuID = ID;
		this.jutsuType = jutsuType;
	}

	public JutsuList getByID(int ID) {
		for (JutsuList jutsu : JutsuList.values()) {
			if (jutsu.jutsuID == ID) {
				return jutsu;
			}
		}
		return NONE;
	}

	public int getID() {
		return this.jutsuID;
	}

	public SkillTrees getJutsuType() {
		return jutsuType;
	}
}
