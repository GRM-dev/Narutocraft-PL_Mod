package pl.grm.narutocraft.skilltrees;

import java.util.HashMap;
import java.util.Map;

public class SkillTree implements Cloneable {
	/** Entries of Tree. */
	private Map<Integer, SkillTreeEntry>	entryMap;
	private int								treeID;
	
	public SkillTree(int treeID) {
		this.treeID = treeID;
		if (entryMap == null) {
			entryMap = new HashMap<Integer, SkillTreeEntry>();
		}
	}
	
	public void addEntry(SkillTreeEntry entry) {
		int ID = entry.getJutsu().getJutsuProps().getID();
		if (!entryMap.containsKey(ID)) {
			entryMap.put(ID, entry);
		}
	}
	
	public void clearTree() {
		entryMap.clear();
	}
	
	public boolean contains(SkillTreeEntry entry) {
		int id = entry.getJutsu().getJutsuProps().getID();
		if (entryMap.containsKey(id)) { return true; }
		return false;
	}
	
	public boolean contains(int entryID) {
		if (entryMap.containsKey(entryID)) { return true; }
		return false;
	}
	
	public SkillTreeEntry getEntry(int jutsuID) {
		if (entryMap.containsKey(jutsuID)) {
			SkillTreeEntry entry = entryMap.get(jutsuID);
			return entry;
		}
		return null;
	}
	
	public int getTreeID() {
		return treeID;
	}

	public Map<Integer, SkillTreeEntry> getEntryMap() {
		return entryMap;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
