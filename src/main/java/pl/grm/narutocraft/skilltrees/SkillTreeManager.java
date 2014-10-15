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
	public static SkillTreeManager	instance	= new SkillTreeManager();
	/** The map of tree lists with eachEntries. Integer=treeID */
	private Map<Integer, SkillTree>	trees;
	/** Disabled Entries(Jutsus) */
	private ArrayList<Integer>		disableds;
	/** Safe copy of tree to get with only read permission */
	private SkillTree				safeCopy;
	/** Selected Tree */
	private SkillTree				selectedTree;
	
	private SkillTreeManager() {
		if (trees == null) {
			this.trees = new HashMap<Integer, SkillTree>();
			for (SkillTreeEnum skillTreeConst : SkillTreeEnum.values()) {
				int treeID = skillTreeConst.getID();
				if (treeID != 0) {
					SkillTree skillTree = new SkillTree(treeID);
					trees.put(treeID, skillTree);
				}
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
	public SkillTreeEntry RegisterEntry(JutsuEnum jutsuElem, int x, int y,
			int requiredPoints, SkillTreeEntry... prerequisites) {
		SkillTreeEnum tree = jutsuElem.getTree();
		JutsuTier tier = jutsuElem.getTier();
		SkillTreeEntry newEntry;
		ArrayList<SkillTreeEntry> prerequisitesList = convertEntryPrerequisites(tree,
				prerequisites);
		
		newEntry = new SkillTreeEntry(x, y, tree, jutsuElem.getJutsu(), tier,
				requiredPoints, prerequisitesList);
		this.getTreefromTreeMap(tree).addEntry(newEntry);
		return newEntry;
	}
	
	/**
	 * @param tree
	 * @return tree from trees of tree ;)
	 */
	public SkillTree getTreefromTreeMap(SkillTreeEnum tree) {
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
	private ArrayList<SkillTreeEntry> convertEntryPrerequisites(SkillTreeEnum tree,
			SkillTreeEntry... prerequisites) {
		ArrayList<SkillTreeEntry> prerequisitesList = new ArrayList<SkillTreeEntry>();
		SkillTree treeTemp = trees.get(tree.getID());
		if ((prerequisites != null) && (prerequisites.length > 0)) {
			for (SkillTreeEntry prerequisite : prerequisites) {
				if (treeTemp.contains(prerequisite)) {
					prerequisitesList.add(prerequisite);
					break;
				}
			}
			if (prerequisitesList.size() == 0) { throw new InvalidParameterException(
					String.format(
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
		Iterator<Entry<Integer, SkillTree>> itTree = trees.entrySet().iterator();
		while (itTree.hasNext()) {
			Entry<Integer, SkillTree> entryT = itTree.next();
			SkillTree itEntry = entryT.getValue();
			while (itEntry.hasNext()) {
				SkillTreeEntry entry = itEntry.nextEntry();
				if (entry.getEntryState() == EntryStates.UNLOCKED) {
					this.disableds.add(Integer.valueOf(JutsuManager.instance
							.getJutsuID(entry.getJutsu())));
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
		Iterator<Entry<Integer, SkillTree>> itTree = trees.entrySet().iterator();
		while (itTree.hasNext()) {
			Entry<Integer, SkillTree> entryT = itTree.next();
			SkillTree itEntry = entryT.getValue();
			while (itEntry.hasNext()) {
				SkillTreeEntry entry = itEntry.nextEntry();
				entry.setEntryState(EntryStates.UNLOCKED);
			}
		}
	}
	
	/**
	 * Clears all trees.
	 */
	public void clearTrees() {
		Iterator<Entry<Integer, SkillTree>> itTree = trees.entrySet().iterator();
		while (itTree.hasNext()) {
			Entry<Integer, SkillTree> entryT = itTree.next();
			SkillTree itEntry = entryT.getValue();
			itEntry.clearTree();
		}
	}
	
	private boolean isSkillLocked(SkillTreeEntry entry) {
		SkillTreeEntry treeT = getEntryInTree(entry);
		if (treeT == null) { return false; }
		return treeT.getEntryState() == EntryStates.UNLOCKED;
	}
	
	public SkillTreeEntry getEntry(JutsuEnum jutsu) {
		int jutsuID = jutsu.getJutsuID();
		SkillTreeEnum treeType = jutsu.getTree();
		int treeID = treeType.getID();
		SkillTree treeTemp = trees.get(treeID);
		SkillTreeEntry entry = treeTemp.getEntry(jutsuID);
		return entry;
	}
	
	public SkillTreeEntry getEntryInTree(SkillTreeEntry entry) {
		int entryID = entry.getJutsu().getJutsuProps().getID();
		int treeID = entry.getTree().getID();
		if (trees.containsKey(treeID)) {
			SkillTree tree = trees.get(treeID);
			if (tree.contains(entryID)) { return tree.getEntry(entryID); }
		}
		return null;
	}
	
	public SkillTree getTree(SkillTreeEnum tree) {
		SkillTree skillTree = trees.get(tree.getID());
		try {
			this.safeCopy = (SkillTree) skillTree.clone();
		}
		catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.safeCopy;
	}
	
	public SkillTree getTreeListing() {
		return this.selectedTree;
	}
}