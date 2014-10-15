package pl.grm.narutocraft.skilltrees;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import pl.grm.narutocraft.handlers.JutsuManager;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import pl.grm.narutocraft.jutsu.JutsuTier;
import pl.grm.narutocraft.libs.config.ConfigurationHandler;
import cpw.mods.fml.common.FMLLog;

public class SkillTreeManager {
	/** Only one instance of this manager should be in mod. */
	public static SkillTreeManager							instance	= new SkillTreeManager();
	/** The map of tree lists with eachEntries. Integer=treeID */
	private Map<Integer, HashMap<Integer, SkillTreeEntry>>	trees;
	/** Disabled Entries(Jutsus) */
	private ArrayList<Integer>								disableds;
	/** Safe copy of tree to get with only read permission */
	private HashMap<Integer, SkillTreeEntry>				safeCopy;
	/** Selected Tree */
	private HashMap<Integer, SkillTreeEntry>				selectedTree;
	/** Entries of selectedTree. */
	private HashMap<Integer, SkillTreeEntry>				treeEntries;
	
	private SkillTreeManager() {
		this.trees = new HashMap<Integer, HashMap<Integer, SkillTreeEntry>>();
		for (SkillTree skillTree : SkillTree.values()) {
			if (skillTree.getID() != 0) {
				trees.put(skillTree.getID(), skillTree.getTreeList());
			}
		}
	}
	
	/**
	 * Initialize all trees with entries.
	 */
	public void init() {
		clearTrees();
		registerAllEntries();
		ConfigurationHandler.saveJutsus();
	}
	
	/**
	 * Resgisters All Entries.
	 */
	private void registerAllEntries() {
		RegisterEntry(JutsuEnum.MEISAIGAKURE, 300, 45, 12);
		RegisterEntry(JutsuEnum.RASENGAN, 200, 100, 10);
		RegisterEntry(JutsuEnum.ODAMARASENGAN, 200, 100, 10, getEntry(JutsuEnum.RASENGAN));
	}
	
	/**
	 * Create SkillTreeEntry with specified params.
	 * 
	 * @param jutsuElem
	 * @param x
	 *            x position
	 * @param y
	 *            y position
	 * @param requiredPoints
	 *            Points required to unlock
	 * @param prerequisites
	 * @return SkillTreeEntry
	 */
	private SkillTreeEntry RegisterEntry(JutsuEnum jutsuElem, int x, int y, int requiredPoints,
			SkillTreeEntry... prerequisites) {
		SkillTree tree = jutsuElem.getTree();
		JutsuTier tier = jutsuElem.getTier();
		SkillTreeEntry newEntry;
		ArrayList<SkillTreeEntry> prerequisitesList = convertEntryPrerequisites(tree, prerequisites);
		
		newEntry = new SkillTreeEntry(x, y, tree, jutsuElem.getJutsu(), tier, requiredPoints,
				prerequisitesList);
		this.getTreefromTreeMap(tree).put(newEntry.getJutsu().getJutsuProps().getID(), newEntry);
		return newEntry;
	}
	
	/**
	 * @param tree
	 * @return tree from trees of tree ;)
	 */
	public HashMap<Integer, SkillTreeEntry> getTreefromTreeMap(SkillTree tree) {
		int id = tree.getID();
		selectedTree = trees.get(id);
		return selectedTree;
	}
	
	/**
	 * Converts Prerequisites from ... to ArrayList.
	 * 
	 * @param tree
	 * @param prerequisites
	 * @return
	 */
	private ArrayList<SkillTreeEntry> convertEntryPrerequisites(SkillTree tree,
			SkillTreeEntry... prerequisites) {
		ArrayList<SkillTreeEntry> prerequisitesList = new ArrayList<SkillTreeEntry>();
		HashMap<Integer, SkillTreeEntry> treeTemp = trees.get(tree.getID());
		if ((prerequisites != null) && (prerequisites.length > 0)) {
			for (SkillTreeEntry prerequisite : prerequisites) {
				if (treeTemp.containsKey(prerequisite.getJutsu().getJutsuProps().getID())) {
					prerequisitesList.add(prerequisite);
					break;
				}
			}
			if (prerequisitesList.size() == 0) { throw new InvalidParameterException(String.format(
					"Unable to locate one or more prerequisite jutsu in the specified tree (%s).",
					new Object[]{tree.toString()})); }
		}
		return prerequisitesList;
	}
	
	/**
	 * @return array of locked jutsus ID
	 */
	public int[] getLockedJutsusIDs() {
		this.disableds = new ArrayList<Integer>();
		Iterator<Entry<Integer, HashMap<Integer, SkillTreeEntry>>> itTree = trees.entrySet()
				.iterator();
		while (itTree.hasNext()) {
			Entry<Integer, HashMap<Integer, SkillTreeEntry>> entryT = itTree.next();
			Iterator<Entry<Integer, SkillTreeEntry>> itEntry = entryT.getValue().entrySet()
					.iterator();
			while (itEntry.hasNext()) {
				Entry<Integer, SkillTreeEntry> entryE = itEntry.next();
				SkillTreeEntry entry = entryE.getValue();
				if (entry.getEntryState() == EntryStates.UNLOCKED) {
					this.disableds.add(Integer.valueOf(JutsuManager.instance.getJutsuID(entry
							.getJutsu())));
				}
			}
		}
		int[] toReturn = new int[this.disableds.size()];
		for (int i = 0; i < this.disableds.size(); i++) {
			toReturn[i] = this.disableds.get(i).intValue();
		}
		return toReturn;
	}
	
	/**
	 * Locks all jutsu in all trees.
	 * 
	 * @param disabledJutsusIDs
	 */
	public void lockJustThisEntries(int[] disabledJutsusIDs) {
		unlockAllEntries();
		
		for (int id : disabledJutsusIDs) {
			SkillTreeEntry entry = getEntryInTree(JutsuManager.instance.getJutsu(id));
			if (entry != null) {
				entry.setEntryState(EntryStates.LOCKED);
				FMLLog.info(
						"Locked",
						new Object[]{JutsuManager.instance.getJutsu(entry.getJutsu()
								.getJutsuProps().getID())});
			} else {
				FMLLog.warning("", new Object[0]);
			}
		}
	}
	
	/**
	 * Unlocks All Entries in all trees.
	 */
	public void unlockAllEntries() {
		Iterator<Entry<Integer, HashMap<Integer, SkillTreeEntry>>> itTree = trees.entrySet()
				.iterator();
		while (itTree.hasNext()) {
			Entry<Integer, HashMap<Integer, SkillTreeEntry>> entryT = itTree.next();
			Iterator<Entry<Integer, SkillTreeEntry>> itEntry = entryT.getValue().entrySet()
					.iterator();
			while (itEntry.hasNext()) {
				Entry<Integer, SkillTreeEntry> entryE = itEntry.next();
				SkillTreeEntry entry = entryE.getValue();
				entry.setEntryState(EntryStates.UNLOCKED);
			}
		}
	}
	
	/**
	 * Clears all trees.
	 */
	public void clearTrees() {
		Iterator<Entry<Integer, HashMap<Integer, SkillTreeEntry>>> itTree = trees.entrySet()
				.iterator();
		while (itTree.hasNext()) {
			Entry<Integer, HashMap<Integer, SkillTreeEntry>> entryT = itTree.next();
			entryT.getValue().clear();
		}
		
	}
	
	private boolean isSkillLocked(SkillTreeEntry entry) {
		SkillTreeEntry treeT = getEntryInTree(entry);
		if (treeT == null) { return false; }
		return treeT.getEntryState() == EntryStates.UNLOCKED;
	}
	
	public SkillTreeEntry getEntry(JutsuEnum jutsu) {
		int jutsuID = jutsu.getJutsuID();
		SkillTree treeType = jutsu.getTree();
		int treeID = treeType.getID();
		HashMap<Integer, SkillTreeEntry> treeTemp = trees.get(treeID);
		SkillTreeEntry entry = treeTemp.get(jutsuID);
		return entry;
	}
	
	public SkillTreeEntry getEntryInTree(SkillTreeEntry entry) {
		int entryID = entry.getJutsu().getJutsuProps().getID();
		int treeID = entry.getTree().getID();
		if (trees.containsKey(treeID)) {
			HashMap<Integer, SkillTreeEntry> tree = trees.get(treeID);
			if (tree.containsKey(entryID)) { return tree.get(entryID); }
		}
		return null;
	}
	
	public HashMap<Integer, SkillTreeEntry> getTree(SkillTree tree) {
		this.safeCopy = new HashMap<Integer, SkillTreeEntry>();
		this.safeCopy.putAll(trees.get(tree.getID()));
		return this.safeCopy;
	}
	
	public HashMap<Integer, SkillTreeEntry> getTreeListing() {
		return this.selectedTree;
	}
	
	public HashMap<Integer, SkillTreeEntry> getTreeEntries() {
		return this.treeEntries;
	}
}