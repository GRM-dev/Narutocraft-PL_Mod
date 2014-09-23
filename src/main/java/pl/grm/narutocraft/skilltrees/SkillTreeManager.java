package pl.grm.narutocraft.skilltrees;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import pl.grm.narutocraft.jutsu.JutsuManager;
import pl.grm.narutocraft.jutsu.JutsuTier;
import pl.grm.narutocraft.libs.config.ConfigurationHandler;
import cpw.mods.fml.common.FMLLog;

public class SkillTreeManager {
	public static SkillTreeManager			instance		= new SkillTreeManager();
	private final ArrayList<SkillTreeEntry>	ninjutsuTree	= new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry>	genjutsuTree	= new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry>	fuuinjutsuTree	= new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry>	taijutsuTree	= new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry>	bukijutsuTree	= new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry>	iryojutsuTree	= new ArrayList<SkillTreeEntry>();
	private final Map<Integer, SkillTree>	skillPointTypeList;
	private ArrayList<Integer>				disableds;
	private ArrayList<SkillTreeEntry>		safeCopy;
	private SkillTreeEntry					newEntry;
	private ArrayList<SkillTreeEntry>		locatedPrerequisites;
	private ArrayList<SkillTreeEntry>		treeListing;
	private ArrayList<SkillTreeEntry>		treeEntries;
	
	private SkillTreeManager() {
		this.skillPointTypeList = new HashMap<Integer, SkillTree>();
	}
	
	public void init() {
		clearTrees();
		
		RegisterEntry(JutsuEnum.MEISAIGAKURE, 300, 45, 12, new SkillTreeEntry[0]);
		RegisterEntry(JutsuEnum.ODAMARASENGAN, 200, 100, 10, new SkillTreeEntry(
				JutsuEnum.RASENGAN));
		// RegisterEntry(JutsuManager.instance.getJutsu("PhysicalDamage"), 300,
		// 90, SkillTrees.Offense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Projectile")});
		
		ConfigurationHandler.saveJutsus();
	}
	
	private void RegisterEntry(JutsuEnum jutsuListElem, int x, int y, int requiredPoints,
			SkillTreeEntry... prerequisites) {
		SkillTree tree = jutsuListElem.getJutsuType();
		JutsuTier tier = jutsuListElem.getTier();
		
		switch (tree) {
			case NINJUTSU :
				this.treeListing = this.ninjutsuTree;
				break;
			case GENJUTSU :
				this.treeListing = this.genjutsuTree;
				break;
			case FUUINJUTSU :
				this.treeListing = this.fuuinjutsuTree;
				break;
			case TAIJUTSU :
				this.treeListing = this.taijutsuTree;
				break;
			case BUKIJUTSU :
				this.treeListing = this.bukijutsuTree;
				break;
			case IRYOJUTSU :
				this.treeListing = this.iryojutsuTree;
				break;
			default :
				break;
		}
		loadPrerequisites(tree, prerequisites);
		this.newEntry = new SkillTreeEntry(x, y, tree, jutsuListElem.getJutsu(), tier,
				requiredPoints,
				this.locatedPrerequisites
						.toArray(new SkillTreeEntry[this.locatedPrerequisites.size()]));
		this.treeListing.add(this.newEntry);
		this.skillPointTypeList.put(
				Integer.valueOf(JutsuManager.instance.getJutsuID(jutsuListElem)),
				SkillTree.JUTSU);
	}
	
	// TODO check if work
	private void loadPrerequisites(SkillTree tree, SkillTreeEntry... prerequisites) {
		this.locatedPrerequisites = new ArrayList<SkillTreeEntry>();
		if ((prerequisites != null) && (prerequisites.length > 0)) {
			for (SkillTreeEntry prerequisite : prerequisites) {
				for (SkillTreeEntry entry : this.treeListing) {
					if (entry.jutsu == prerequisite) {
						this.locatedPrerequisites.add(entry);
						break;
					}
				}
			}
			if (this.locatedPrerequisites.size() == 0) { throw new InvalidParameterException(
					String.format(
							"Unable to locate one or more prerequisite jutsu in the specified tree (%s).",
							new Object[]{tree.toString()})); }
		}
	}
	
	public void lockAllJutsusIn(int[] disabledJutsus) {
		for (SkillTreeEntry entry : this.ninjutsuTree) {
			entry.entryState = EntryStates.UNLOCKED;
		}
		for (SkillTreeEntry entry : this.genjutsuTree) {
			entry.entryState = EntryStates.UNLOCKED;
		}
		for (SkillTreeEntry entry : this.fuuinjutsuTree) {
			entry.entryState = EntryStates.UNLOCKED;
		}
		for (SkillTreeEntry entry : this.taijutsuTree) {
			entry.entryState = EntryStates.UNLOCKED;
		}
		for (SkillTreeEntry entry : this.bukijutsuTree) {
			entry.entryState = EntryStates.UNLOCKED;
		}
		for (SkillTreeEntry entry : this.iryojutsuTree) {
			entry.entryState = EntryStates.UNLOCKED;
		}
		
		for (int id : disabledJutsus) {
			SkillTreeEntry entry = getJutsuTreeEntry(JutsuManager.instance.getJutsu(id));
			if (entry != null) {
				entry.entryState = EntryStates.LOCKED;
				FMLLog.info("", new Object[]{JutsuManager.instance.getJutsu(entry.jutsu
						.getJutsuProps().getJutsuID())});
			} else {
				FMLLog.warning("", new Object[0]);
			}
		}
	}
	
	public int[] getLockedJutsusIDs() {
		this.disableds = new ArrayList<Integer>();
		for (SkillTreeEntry entry : this.ninjutsuTree) {
			if (entry.entryState == EntryStates.UNLOCKED) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.jutsu)));
			}
		}
		for (SkillTreeEntry entry : this.genjutsuTree) {
			if (entry.entryState == EntryStates.UNLOCKED) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.jutsu)));
			}
		}
		for (SkillTreeEntry entry : this.fuuinjutsuTree) {
			if (entry.entryState == EntryStates.UNLOCKED) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.jutsu)));
			}
		}
		for (SkillTreeEntry entry : this.taijutsuTree) {
			if (entry.entryState == EntryStates.UNLOCKED) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.jutsu)));
			}
		}
		for (SkillTreeEntry entry : this.bukijutsuTree) {
			if (entry.entryState == EntryStates.UNLOCKED) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.jutsu)));
			}
		}
		for (SkillTreeEntry entry : this.iryojutsuTree) {
			if (entry.entryState == EntryStates.UNLOCKED) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.jutsu)));
			}
		}
		
		int[] toReturn = new int[this.disableds.size()];
		for (int i = 0; i < this.disableds.size(); i++) {
			toReturn[i] = this.disableds.get(i).intValue();
		}
		return toReturn;
	}
	
	public SkillTreeEntry getJutsuTreeEntry(SkillTreeEntry part) {
		this.treeEntries = instance.getTree(SkillTree.NINJUTSU);
		for (SkillTreeEntry st_entry : this.treeEntries) {
			IJutsu jutsu = st_entry.jutsu;
			if ((jutsu != null) && (jutsu == part)) { return st_entry; }
		}
		this.treeEntries = instance.getTree(SkillTree.GENJUTSU);
		for (SkillTreeEntry st_entry : this.treeEntries) {
			IJutsu jutsu = st_entry.jutsu;
			if ((jutsu != null) && (jutsu == part)) { return st_entry; }
		}
		return null;
	}
	
	public ArrayList<SkillTreeEntry> getTree(SkillTree tree) {
		this.safeCopy = new ArrayList<SkillTreeEntry>();
		switch (tree.ordinal()) {
			case 6 :
				this.safeCopy.addAll(this.ninjutsuTree);
				break;
			case 7 :
				this.safeCopy.addAll(this.genjutsuTree);
				break;
			case 8 :
				this.safeCopy.addAll(this.fuuinjutsuTree);
				break;
			case 9 :
				this.safeCopy.addAll(this.taijutsuTree);
				break;
			case 10 :
				this.safeCopy.addAll(this.bukijutsuTree);
				break;
			case 11 :
				this.safeCopy.addAll(this.iryojutsuTree);
				break;
			default :
				break;
		}
		return this.safeCopy;
	}
	
	private void clearTrees() {
		this.ninjutsuTree.clear();
		this.genjutsuTree.clear();
		this.bukijutsuTree.clear();
		this.fuuinjutsuTree.clear();
		this.iryojutsuTree.clear();
		this.taijutsuTree.clear();
	}
	
	private boolean isSkillLocked(SkillTreeEntry component) {
		SkillTreeEntry entry = getJutsuTreeEntry(component);
		if (entry == null) { return false; }
		return entry.entryState == EntryStates.UNLOCKED;
	}
}
