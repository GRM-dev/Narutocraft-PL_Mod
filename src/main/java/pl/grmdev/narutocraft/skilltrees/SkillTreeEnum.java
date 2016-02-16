package pl.grmdev.narutocraft.skilltrees;

public enum SkillTreeEnum {
	NONE(0),
	MAIN(1),
	TRAINING(2),
	PLAYERATTRIBUTES(3),
	JUTSU(4),
	CLANJUTSU(5),
	NINJUTSU(6),
	GENJUTSU(7),
	FUUINJUTSU(8),
	TAIJUTSU(9),
	BUKIJUTSU(10),
	IRYOJUTSU(11);

	private int treeID;

	private SkillTreeEnum(int ID) {
		this.treeID = ID;
	}

	public static SkillTreeEnum getByID(int ID) {
		for (SkillTreeEnum sT : SkillTreeEnum.values()) {
			if (sT.treeID == ID) { return sT; }
		}
		return NONE;
	}

	public int getID() {
		return this.treeID;
	}
}
