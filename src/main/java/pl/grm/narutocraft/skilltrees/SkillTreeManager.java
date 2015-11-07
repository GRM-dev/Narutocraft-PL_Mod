package pl.grm.narutocraft.skilltrees;

import java.util.*;
import java.util.Map.Entry;

import net.minecraftforge.fml.common.FMLLog;
import pl.grm.narutocraft.handlers.JutsuManager;
import pl.grm.narutocraft.jutsu.*;
import pl.grm.narutocraft.libs.config.ConfigurationHandler;

/**
 * Manager of Jutsu SkillTrees
 */
public class SkillTreeManager {

	/** Only one instance of this manager should be in mod. */
	public static SkillTreeManager instance = new SkillTreeManager();
	/** The map of tree lists with eachEntries. Integer=treeID */
	private Map<Integer, SkillTree> trees;
	/** Disabled Entries(Jutsus) */
	private ArrayList<Integer> disableds;
	/** Safe copy of tree to get with only read permission */
	private SkillTree safeCopy;

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
	 * Registers All Entries.
	 */
	private void registerAllEntries() {
		RegisterEntry(JutsuParams.MEISAIGAKURE, 300, 45, 12);
		RegisterEntry(JutsuParams.RASENGAN, 200, 100, 10);
		RegisterEntry(JutsuParams.ODAMARASENGAN, 200, 100, 10, getEntry(JutsuParams.RASENGAN));
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
	private SkillTreeEntry RegisterEntry(JutsuParams jutsuElem, int x, int y, int requiredPoints,
			SkillTreeEntry... prerequisites) {
		SkillTreeEnum tree = jutsuElem.getTree();
		JutsuTier tier = jutsuElem.getTier();
		SkillTreeEntry newEntry;
		ArrayList<SkillTreeEntry> prerequisitesList = convertEntryPrerequisites(tree, prerequisites);
		newEntry = new SkillTreeEntry(x, y, tree, (Jutsu) jutsuElem.getJutsu(), tier, requiredPoints, prerequisitesList);
		getTreefromTreeMap(tree).addEntry(newEntry);
		return newEntry;
	}

	/**
	 * Gets tree reference to tree from Map of Trees
	 * 
	 * @param tree
	 * @return tree from Map of trees
	 */
	public SkillTree getTreefromTreeMap(SkillTreeEnum tree) {
		int id = tree.getID();
		return trees.get(id);
	}

	/**
	 * Converts Prerequisites from ... to ArrayList.
	 * 
	 * @param tree
	 * @param prerequisites
	 * @return ArrayList of {@link SkillTreeEntry}
	 */
	private ArrayList<SkillTreeEntry> convertEntryPrerequisites(SkillTreeEnum tree, SkillTreeEntry... prerequisites) {
		ArrayList<SkillTreeEntry> prerequisitesList = new ArrayList<SkillTreeEntry>();
		SkillTree treeTemp = trees.get(tree.getID());
		if ((prerequisites != null) && (prerequisites.length > 0)) {
			for (SkillTreeEntry prerequisite : prerequisites) {
				if (treeTemp.contains(prerequisite)) {
					prerequisitesList.add(prerequisite);
					break;
				}
			}
			if (prerequisitesList.size() == 0) {
				String.format("Unable to locate one or more prerequisite jutsu in the specified tree (%s).",
						new Object[]{tree.toString()});
			}
		}
		return prerequisitesList;
	}

	/**
	 * Locks all jutsu in all trees.
	 * 
	 * @param disabledJutsusIDs
	 */
	public void lockEntries(int[] disabledJutsusIDs) {
		unlockAllEntries();
		for (int id : disabledJutsusIDs) {
			SkillTreeEntry entry = getEntry(JutsuParams.getByID(id));
			if (entry != null) {
				entry.setEntryState(EntryStates.LOCKED);
				FMLLog.info("Locked",
						new Object[]{JutsuManager.instance.getJutsu(entry.getJutsu().getJutsuProps().getID())});
			} else {
				FMLLog.warning("Entry read problem. Entry exists?", new Object[0]);
			}
		}
	}

	/**
	 * Unlocks All Entries in all trees.
	 */
	public void unlockAllEntries() {
		Iterator<Entry<Integer, SkillTree>> itTrees = trees.entrySet().iterator();
		while (itTrees.hasNext()) {
			Entry<Integer, SkillTree> entryT = itTrees.next();
			SkillTree tree = entryT.getValue();
			Iterator<Entry<Integer, SkillTreeEntry>> itTree = tree.getEntryMap().entrySet().iterator();
			while (itTree.hasNext()) {
				Entry<Integer, SkillTreeEntry> entryE = itTree.next();
				SkillTreeEntry entry = entryE.getValue();
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

	/**
	 * Clears specified tree
	 * 
	 * @param tree
	 */
	public void clearTree(SkillTree tree) {
		int id = tree.getTreeID();
		if (trees.containsKey(id)) {
			trees.get(id).clearTree();
		}
	}

	/**
	 * Checks if entry is locked.
	 * 
	 * @param entryPar
	 * @return true if locked
	 */
	public boolean isEntryLocked(SkillTreeEntry entryPar) {
		SkillTreeEntry entry = getEntry(entryPar);
		if (entry == null) { return false; }
		return entry.getEntryState() == EntryStates.UNLOCKED;
	}

	/**
	 * @return array of locked jutsus ID
	 */
	public int[] getLockedJutsusIDs() {
		this.disableds = new ArrayList<Integer>();
		Iterator<Entry<Integer, SkillTree>> itTrees = trees.entrySet().iterator();
		while (itTrees.hasNext()) {
			Entry<Integer, SkillTree> entryT = itTrees.next();
			SkillTree tree = entryT.getValue();
			Iterator<Entry<Integer, SkillTreeEntry>> itTree = tree.getEntryMap().entrySet().iterator();
			while (itTree.hasNext()) {
				Entry<Integer, SkillTreeEntry> entryE = itTree.next();
				SkillTreeEntry entry = entryE.getValue();
				if (entry.getEntryState() == EntryStates.UNLOCKED) {
					this.disableds.add(entry.getJutsu().getJutsuProps().getID());
				}
			}
		}
		int[] disabledsAmount = new int[this.disableds.size()];
		for (int i = 0; i < this.disableds.size(); i++) {
			disabledsAmount[i] = this.disableds.get(i).intValue();
		}
		return disabledsAmount;
	}

	/**
	 * Returns reference to entry in tree
	 * 
	 * @param jutsu
	 * @return Entry from tree
	 */
	public SkillTreeEntry getEntry(JutsuParams jutsu) {
		int jutsuID = jutsu.getJutsuID();
		SkillTreeEnum treeType = jutsu.getTree();
		int treeID = treeType.getID();
		SkillTree tree = trees.get(treeID);
		SkillTreeEntry entry = tree.getEntry(jutsuID);
		return entry;
	}

	/**
	 * Returns reference to entry in tree
	 * 
	 * @param entry
	 * @return {@link SkillTreeEntry} from {@link SkillTree}
	 */
	public SkillTreeEntry getEntry(SkillTreeEntry entry) {
		int entryID = entry.getJutsu().getJutsuProps().getID();
		int treeID = entry.getTree().getID();
		if (trees.containsKey(treeID)) {
			SkillTree tree = trees.get(treeID);
			if (tree.contains(entryID)) { return tree.getEntry(entryID); }
		}
		return null;
	}

	/**
	 * Gets tree reference from Tree Listing
	 * 
	 * @param tree
	 * @return {@link SkillTree}
	 */
	public SkillTree getTree(SkillTreeEnum tree) {
		SkillTree skillTree = trees.get(tree.getID());
		try {
			this.safeCopy = (SkillTree) skillTree.clone();
		}
		catch (CloneNotSupportedException e) {
			FMLLog.warning("Error with cloning skillTree");
			e.printStackTrace();
		}
		return this.safeCopy;
	}
}