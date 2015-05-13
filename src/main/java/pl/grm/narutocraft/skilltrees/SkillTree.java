package pl.grm.narutocraft.skilltrees;

import java.util.*;

/**
 * SkillTree containing its Entries(Jutsus)
 */
public class SkillTree implements Cloneable {
	/** Entries of Tree. */
	private Map<Integer, SkillTreeEntry>	entryMap;
	private int								treeID;
	
	/**
	 * @param treeID
	 */
	public SkillTree(int treeID) {
		this.treeID = treeID;
		if (entryMap == null) {
			entryMap = new HashMap<Integer, SkillTreeEntry>();
		}
	}
	
	/**
	 * Adds Entry to tree on EntryMap
	 * 
	 * @param entry
	 */
	public void addEntry(SkillTreeEntry entry) {
		int ID = entry.getJutsu().getJutsuProps().getID();
		if (!entryMap.containsKey(ID)) {
			entryMap.put(ID, entry);
		}
	}
	
	/**
	 * Clears Tree
	 */
	public void clearTree() {
		entryMap.clear();
	}
	
	/**
	 * Checks if tree contains specified entry.
	 * 
	 * @param entry
	 * @return true if contains entry
	 */
	public boolean contains(SkillTreeEntry entry) {
		int id = entry.getJutsu().getJutsuProps().getID();
		if (entryMap.containsKey(id)) { return true; }
		return false;
	}
	
	/**
	 * Checks if tree contains specified entryID
	 * 
	 * @param entryID
	 * @return true if contains entryID
	 */
	public boolean contains(int entryID) {
		if (entryMap.containsKey(entryID)) { return true; }
		return false;
	}
	
	/**
	 * @param jutsuID
	 * @return Entry with specified ID
	 */
	public SkillTreeEntry getEntry(int jutsuID) {
		if (entryMap.containsKey(jutsuID)) {
			SkillTreeEntry entry = entryMap.get(jutsuID);
			return entry;
		}
		return null;
	}
	
	/**
	 * @return tree ID
	 */
	public int getTreeID() {
		return treeID;
	}
	
	/**
	 * @return Map of Entries
	 */
	public Map<Integer, SkillTreeEntry> getEntryMap() {
		return entryMap;
	}
	
	/**
	 * Makes safe copy of tree.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}