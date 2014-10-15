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
	
	public int getTreeID() {
		return treeID;
	}
	
	public boolean contains(SkillTreeEntry prerequisite) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public SkillTreeEntry nextEntry() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void clearTree() {
		// TODO Auto-generated method stub
		
	}
	
	public SkillTreeEntry getEntry(int jutsuID) {
		if (entryMap.containsKey(jutsuID)) {
			SkillTreeEntry entry = entryMap.get(jutsuID);
			return entry;
		}
		return null;
	}
	
	public boolean contains(int entryID) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
