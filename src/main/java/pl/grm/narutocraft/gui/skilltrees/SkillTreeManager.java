package pl.grm.narutocraft.gui.skilltrees;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

import pl.grm.narutocraft.handlers.JutsuManager;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.jutsu.JutsuEnum;
import pl.grm.narutocraft.libs.config.ConfigurationHandler;
import cpw.mods.fml.common.FMLLog;

public class SkillTreeManager {
	public static SkillTreeManager instance = new SkillTreeManager();

	private final ArrayList<SkillTreeEntry> ninjutsuTree = new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry> genjutsuTree = new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry> fuuinjutsuTree = new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry> taijutsuTree = new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry> bukijutsuTree = new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry> iryojutsuTree = new ArrayList<SkillTreeEntry>();

	private final HashMap<Integer, TreePointTypes> skillPointTypeList;
	private int highestSkillDepth = 0;
	private ArrayList<Integer> disableds;
	private ArrayList<SkillTreeEntry> safeCopy;
	private SkillTreeEntry newEntry;
	private ArrayList<SkillTreeEntry> locatedPrerequisites;
	private ArrayList<SkillTreeEntry> treeListing;
	private ArrayList<SkillTreeEntry> treeEntries;

	private SkillTreeManager() {
		this.skillPointTypeList = new HashMap<Integer, TreePointTypes>();
	}

	private void calculateHighestOverallTier() {
		int ninjutsu = calculateHighestTier(this.ninjutsuTree);
		int genjutsu = calculateHighestTier(this.genjutsuTree);
		int fuuinjutsu = calculateHighestTier(this.fuuinjutsuTree);
		int taijutsu = calculateHighestTier(this.taijutsuTree);
		int bukijutsu = calculateHighestTier(this.bukijutsuTree);
		int iryojutsu = calculateHighestTier(this.iryojutsuTree);

		this.highestSkillDepth = Math.max(
				ninjutsu,
				Math.max(
						genjutsu,
						Math.max(
								fuuinjutsu,
								Math.max(taijutsu,
										Math.max(bukijutsu, iryojutsu)))));
	}

	private static int calculateHighestTier(ArrayList<SkillTreeEntry> tree) {
		int highest = 0;
		for (SkillTreeEntry entry : tree) {
			if (entry.tier > highest) {
				highest = entry.tier;
			}
		}
		return highest;
	}

	public void disableAllJutsusIn(int[] disabledSkills) {
		for (SkillTreeEntry entry : this.ninjutsuTree) {
			entry.enabled = true;
		}
		for (SkillTreeEntry entry : this.genjutsuTree) {
			entry.enabled = true;
		}
		for (SkillTreeEntry entry : this.fuuinjutsuTree) {
			entry.enabled = true;
		}
		for (SkillTreeEntry entry : this.taijutsuTree) {
			entry.enabled = true;
		}
		for (SkillTreeEntry entry : this.bukijutsuTree) {
			entry.enabled = true;
		}
		for (SkillTreeEntry entry : this.iryojutsuTree) {
			entry.enabled = true;
		}

		for (int id : disabledSkills) {
			SkillTreeEntry entry = getJutsuTreeEntry(JutsuManager.instance
					.getJutsu(id));
			if (entry != null) {
				entry.enabled = false;
				FMLLog.info("", new Object[]{JutsuManager.instance
						.getJutsu(entry.getJutsu().getJutsuID())});
			} else {
				FMLLog.warning("", new Object[0]);
			}
		}
	}

	public int[] getDisabledJutsusIDs() {
		this.disableds = new ArrayList<Integer>();
		for (SkillTreeEntry entry : this.ninjutsuTree) {
			if (!entry.enabled) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.getJutsu())));
			}
		}
		for (SkillTreeEntry entry : this.genjutsuTree) {
			if (!entry.enabled) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.getJutsu())));
			}
		}
		for (SkillTreeEntry entry : this.fuuinjutsuTree) {
			if (!entry.enabled) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.getJutsu())));
			}
		}
		for (SkillTreeEntry entry : this.taijutsuTree) {
			if (!entry.enabled) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.getJutsu())));
			}
		}
		for (SkillTreeEntry entry : this.bukijutsuTree) {
			if (!entry.enabled) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.getJutsu())));
			}
		}
		for (SkillTreeEntry entry : this.iryojutsuTree) {
			if (!entry.enabled) {
				this.disableds.add(Integer.valueOf(JutsuManager.instance
						.getJutsuID(entry.getJutsu())));
			}
		}

		int[] toReturn = new int[this.disableds.size()];
		for (int i = 0; i < this.disableds.size(); i++) {
			toReturn[i] = this.disableds.get(i).intValue();
		}
		return toReturn;
	}

	public int getHighestTier() {
		return this.highestSkillDepth;
	}

	public SkillTreeEntry getJutsuTreeEntry(SkillTreeEntry part) {
		treeEntries = instance.getTree(SkillTrees.NINJUTSU);
		for (SkillTreeEntry st_entry : treeEntries) {
			IJutsu jutsu = st_entry.getJutsu();
			if ((jutsu != null) && (jutsu == part)) {
				return st_entry;
			}
		}
		treeEntries = instance.getTree(SkillTrees.GENJUTSU);
		for (SkillTreeEntry st_entry : treeEntries) {
			IJutsu jutsu = st_entry.getJutsu();
			if ((jutsu != null) && (jutsu == part)) {
				return st_entry;
			}
		}
		return null;
	}

	public ArrayList<SkillTreeEntry> getTree(SkillTrees tree) {
		this.safeCopy = new ArrayList<SkillTreeEntry>();
		switch (tree.ordinal()) {
			case 1 :
				this.safeCopy.addAll(this.genjutsuTree);
				break;
			case 2 :
				this.safeCopy.addAll(this.ninjutsuTree);
				break;
			case 3 :
				this.safeCopy.addAll(this.fuuinjutsuTree);
				break;
			case 4 :
				this.safeCopy.addAll(this.taijutsuTree);
				break;
			case 5 :
				this.safeCopy.addAll(this.bukijutsuTree);
				break;
			case 6 :
				this.safeCopy.addAll(this.iryojutsuTree);
				break;
			default :
				break;
		}
		return this.safeCopy;
	}

	public void init() {
		this.ninjutsuTree.clear();
		RegisterEntry(JutsuEnum.MEISAIGAKURE, 300, 45, 12,
				new SkillTreeEntry[0]);
		// RegisterEntry(JutsuManager.instance.getJutsu("PhysicalDamage"), 300,
		// 90, SkillTrees.Offense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Projectile")});

		calculateHighestOverallTier();
		ConfigurationHandler.saveJutsus();
	}

	public boolean isSkillDisabled(SkillTreeEntry component) {
		SkillTreeEntry entry = getJutsuTreeEntry(component);
		if (entry == null) {
			return false;
		}
		return !entry.enabled;
	}

	public void RegisterEntry(JutsuEnum jutsuListElem, int x, int y,
			int requiredPoints, SkillTreeEntry... prerequisites) {
		SkillTrees tree = jutsuListElem.getJutsuType();
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

		this.locatedPrerequisites = new ArrayList<SkillTreeEntry>();
		if ((prerequisites != null) && (prerequisites.length > 0)) {
			for (SkillTreeEntry prerequisite : prerequisites) {
				for (SkillTreeEntry entry : this.treeListing) {
					if (entry.getJutsu() == prerequisite) {
						this.locatedPrerequisites.add(entry);
						break;
					}
				}
			}
			if (this.locatedPrerequisites.size() == 0) {
				throw new InvalidParameterException(
						String.format(
								"Unable to locate one or more prerequisite jutsu in the specified tree (%s).",
								new Object[]{tree.toString()}));
			}
		}
		boolean enabled = true;
		this.newEntry = new SkillTreeEntry(x, y, tree,
				this.locatedPrerequisites
						.toArray(new SkillTreeEntry[this.locatedPrerequisites
								.size()]), jutsuListElem.getJutsu(), enabled);

		this.treeListing.add(this.newEntry);
		this.skillPointTypeList.put(Integer.valueOf(JutsuManager.instance
				.getJutsuID(jutsuListElem)), TreePointTypes.JUTSU);
	}
}
