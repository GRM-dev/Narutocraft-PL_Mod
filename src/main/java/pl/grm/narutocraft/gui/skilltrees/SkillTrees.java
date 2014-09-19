package pl.grm.narutocraft.gui.skilltrees;

public enum SkillTrees {
	NONE(
			0) ,
	MAIN(
			1) ,
	TRAINING(
			2) ,
	PLAYERATTRIBUTES(
			3) ,
	JUTSU(
			4) ,
	CLANJUTSU(
			5) ,
	NINJUTSU(
			6) ,
	GENJUTSU(
			7) ,
	FUUINJUTSU(
			8) ,
	TAIJUTSU(
			9) ,
	BUKIJUTSU(
			10) ,
	IRYOJUTSU(
			11);
	
	private int	treeID;
	
	private SkillTrees(int ID) {
		this.treeID = ID;
	}
	
	public static SkillTrees getByID(int ID) {
		for (SkillTrees sT : SkillTrees.values()) {
			if (sT.treeID == ID) { return sT; }
		}
		return NONE;
	}
	
	public int getID(SkillTrees sT) {
		return this.treeID;
	}
}
