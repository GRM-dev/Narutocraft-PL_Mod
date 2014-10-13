package pl.grm.narutocraft.skilltrees;

import java.util.HashMap;

public enum SkillTree {
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
	
	private int										treeID;
	private final HashMap<Integer, SkillTreeEntry>	treeEntryList;
	
	private SkillTree(int ID) {
		this.treeID = ID;
		treeEntryList = new HashMap<Integer, SkillTreeEntry>();
	}
	
	public static SkillTree getByID(int ID) {
		for (SkillTree sT : SkillTree.values()) {
			if (sT.treeID == ID) { return sT; }
		}
		return NONE;
	}
	
	public static SkillTree getByTree(HashMap<Integer, SkillTreeEntry> treeEntries) {
		for (SkillTree sT : SkillTree.values()) {
			if (sT.treeEntryList == treeEntries) { return sT; }
		}
		return NONE;
	}
	
	public int getID() {
		return this.treeID;
	}
	
	public HashMap<Integer, SkillTreeEntry> getTreeList() {
		return treeEntryList;
	}
}
