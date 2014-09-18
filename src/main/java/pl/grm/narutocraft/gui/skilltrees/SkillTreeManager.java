package pl.grm.narutocraft.gui.skilltrees;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

import pl.grm.narutocraft.handlers.JutsuManager;
import pl.grm.narutocraft.jutsu.IJutsu;
import pl.grm.narutocraft.libs.config.ConfigurationHandler;
import cpw.mods.fml.common.FMLLog;

public class SkillTreeManager {
	public static SkillTreeManager instance = new SkillTreeManager();

	private final ArrayList<SkillTreeEntry> ninjutsuTree = new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry> genjutsuTree = new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry> fuuinjutsuTree = new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry> taijutsuTree = new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry> kanjutsuTree = new ArrayList<SkillTreeEntry>();
	private final ArrayList<SkillTreeEntry> soshijutsuTree = new ArrayList<SkillTreeEntry>();

	private final HashMap<Integer, TreePointTypes> skillPointTypeList;
	private int highestSkillDepth = 0;
	private ArrayList<Integer> disableds;
	private ArrayList<SkillTreeEntry> safeCopy;
	private SkillTreeEntry newEntry;
	private ArrayList<SkillTreeEntry> locatedPrerequisites;
	private ArrayList<SkillTreeEntry> treeListing;

	private SkillTreeManager() {
		this.skillPointTypeList = new HashMap<Integer, TreePointTypes>();
	}

	private void calculateHighestOverallTier() {
		int offense = calculateHighestTier(this.ninjutsuTree);
		int defense = calculateHighestTier(this.genjutsuTree);
		int utility = calculateHighestTier(this.fuuinjutsuTree);

		this.highestSkillDepth = Math.max(offense, Math.max(defense, utility));
	}

	private int calculateHighestTier(ArrayList<SkillTreeEntry> tree) {
		int highest = 0;
		for (SkillTreeEntry entry : tree) {
			if (entry.tier > highest) {
				highest = entry.tier;
			}
		}
		return highest;
	}

	public void disableAllSkillsIn(int[] disabledSkills) {
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
		for (int i : disabledSkills) {
			SkillTreeEntry entry = getJutsuTreeEntry(JutsuManager.instance
					.getJutsu(i));
			if (entry != null) {
				entry.enabled = false;
				FMLLog.info("", new Object[]{JutsuManager.instance
						.getJutsuName(entry.getJutsu())});
			} else {
				FMLLog.warning("", new Object[0]);
			}
		}
	}

	public int[] getDisabledSkillIDs() {
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
		ArrayList<SkillTreeEntry> treeEntries = instance
				.getTree(SkillTrees.NINJUTSU);
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
		}
		return this.safeCopy;
	}

	public void init() {
		this.ninjutsuTree.clear();
		// RegisterEntry(JutsuManager.instance.getJutsu("Projectile"), 300, 45,
		// SkillTrees.Offense, TreePointTypes.BLUE, new SkillTreeEntry[0]);
		// RegisterEntry(JutsuManager.instance.getJutsu("PhysicalDamage"), 300,
		// 90, SkillTrees.Offense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Projectile")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Gravity"), 255, 70,
		// SkillTrees.Offense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Projectile")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Bounce"), 345, 70,
		// SkillTrees.Offense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Projectile")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("FireDamage"), 210, 135,
		// SkillTrees.Offense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("PhysicalDamage")});
		// RegisterEntry(JutsuManager.instance.getJutsu("LightningDamage"), 255,
		// 135, SkillTrees.Offense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("FireDamage")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Ignition"), 165, 135,
		// SkillTrees.Offense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("FireDamage")});
		// RegisterEntry(
		// JutsuManager.instance.getJutsu("Forge"),
		// 120,
		// 135,
		// SkillTrees.Offense,
		// TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Ignition")});
		//
		// RegisterEntry(
		// JutsuManager.instance.getJutsu("Contingency_Fire"),
		// 165,
		// 180,
		// SkillTrees.Offense,
		// TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Ignition")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("MagicDamage"), 390,
		// 135,
		// SkillTrees.Offense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("PhysicalDamage")});
		// RegisterEntry(JutsuManager.instance.getJutsu("FrostDamage"), 345,
		// 135,
		// SkillTrees.Offense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("MagicDamage")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Drown"), 435, 135,
		// SkillTrees.Offense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("MagicDamage")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Blind"), 233, 180,
		// SkillTrees.Offense, TreePointTypes.GREEN, new SkillTreeEntry[]{
		// JutsuManager.instance.getJutsu("FireDamage"),
		// JutsuManager.instance.getJutsu("LightningDamage")});
		// RegisterEntry(JutsuManager.instance.getJutsu("AoE"), 300, 180,
		// SkillTrees.Offense, TreePointTypes.GREEN, new SkillTreeEntry[]{
		// JutsuManager.instance.getJutsu("PhysicalDamage"),
		// JutsuManager.instance.getJutsu("FrostDamage"),
		// JutsuManager.instance.getJutsu("FireDamage"),
		// JutsuManager.instance.getJutsu("LightningDamage"),
		// JutsuManager.instance.getJutsu("MagicDamage")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Freeze"), 345, 180,
		// SkillTrees.Offense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("FrostDamage")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Knockback"), 390, 180,
		// SkillTrees.Offense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("MagicDamage")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Solar"), 210, 225,
		// SkillTrees.Offense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Blind")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Storm"), 255, 225,
		// SkillTrees.Offense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("LightningDamage")});
		// RegisterEntry(
		// JutsuManager.instance.getJutsu("AstralDistortion"),
		// 367,
		// 215,
		// SkillTrees.Offense,
		// TreePointTypes.GREEN,
		// new SkillTreeEntry[]{
		// JutsuManager.instance.getJutsu("MagicDamage"),
		// JutsuManager.instance.getJutsu("FrostDamage")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Silence"), 345, 245,
		// SkillTrees.Offense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("AstralDistortion")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Fling"), 390, 245,
		// SkillTrees.Offense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Knockback")});
		// RegisterEntry(JutsuManager.instance.getJutsu("VelocityAdded"), 390,
		// 290, SkillTrees.Offense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Fling")});
		// RegisterEntry(JutsuManager.instance.getJutsu("WateryGrave"), 435,
		// 245,
		// SkillTrees.Offense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Drown")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Piercing"), 323, 215,
		// SkillTrees.Offense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Freeze")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Beam"), 300, 270,
		// SkillTrees.Offense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("AoE")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Damage"), 300, 315,
		// SkillTrees.Offense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Beam")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Fury"), 255, 315,
		// SkillTrees.Offense, TreePointTypes.RED, new SkillTreeEntry[]{
		// JutsuManager.instance.getJutsu("Beam"),
		// JutsuManager.instance.getJutsu("Storm")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Wave"), 367, 315,
		// SkillTrees.Offense, TreePointTypes.RED, new SkillTreeEntry[]{
		// JutsuManager.instance.getJutsu("Beam"),
		// JutsuManager.instance.getJutsu("Fling")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Blizzard"), 75, 45,
		// SkillTrees.Offense, TreePointTypes.SILVER,
		// new SkillTreeEntry[0]);
		// RegisterEntry(JutsuManager.instance.getJutsu("FallingStar"), 75, 90,
		// SkillTrees.Offense, TreePointTypes.SILVER,
		// new SkillTreeEntry[0]);
		// RegisterEntry(JutsuManager.instance.getJutsu("FireRain"), 75, 135,
		// SkillTrees.Offense, TreePointTypes.SILVER,
		// new SkillTreeEntry[0]);
		// RegisterEntry(JutsuManager.instance.getJutsu("Dismembering"), 75,
		// 180,
		// SkillTrees.Offense, TreePointTypes.SILVER,
		// new SkillTreeEntry[0]);
		//
		// this.defenseTree.clear();
		// RegisterEntry(JutsuManager.instance.getJutsu("Self"), 267, 45,
		// SkillTrees.Defense, TreePointTypes.BLUE, new SkillTreeEntry[0]);
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Leap"), 222, 90,
		// SkillTrees.Defense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Self")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Regeneration"), 357,
		// 90,
		// SkillTrees.Defense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Self")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Shrink"), 402, 90,
		// SkillTrees.Defense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Regeneration")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Slowfall"), 222, 135,
		// SkillTrees.Defense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Leap")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Heal"), 357, 135,
		// SkillTrees.Defense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Regeneration")});
		// RegisterEntry(JutsuManager.instance.getJutsu("LifeTap"), 312, 135,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Heal")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Healing"), 402, 135,
		// SkillTrees.Defense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Heal")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Summon"), 267, 135,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("LifeTap")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Contingency_Damage"),
		// 447, 180, SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Healing")});
		//
		// RegisterEntry(
		// JutsuManager.instance.getJutsu("Haste"),
		// 177,
		// 155,
		// SkillTrees.Defense,
		// TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Slowfall")});
		// RegisterEntry(
		// JutsuManager.instance.getJutsu("Slow"),
		// 132,
		// 155,
		// SkillTrees.Defense,
		// TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Slowfall")});
		//
		// RegisterEntry(
		// JutsuManager.instance.getJutsu("GravityWell"),
		// 222,
		// 180,
		// SkillTrees.Defense,
		// TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Slowfall")});
		// RegisterEntry(JutsuManager.instance.getJutsu("LifeDrain"), 312, 180,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("LifeTap")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Dispel"), 357, 180,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Heal")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Contingency_Fall"),
		// 267,
		// 180, SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("GravityWell")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("SwiftSwim"), 177, 200,
		// SkillTrees.Defense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Haste")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Repel"), 132, 200,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Slow")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Levitate"), 222, 225,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("GravityWell")});
		// RegisterEntry(JutsuManager.instance.getJutsu("ManaDrain"), 312, 225,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("LifeDrain")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Zone"), 357, 225,
		// SkillTrees.Defense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Dispel")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Wall"), 87, 200,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Repel")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Accelerate"), 177, 245,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("SwiftSwim")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Entangle"), 132, 245,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Repel")});
		// RegisterEntry(
		// JutsuManager.instance.getJutsu("Appropriation"),
		// 87,
		// 245,
		// SkillTrees.Defense,
		// TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Entangle")});
		//
		// RegisterEntry(
		// JutsuManager.instance.getJutsu("Flight"),
		// 222,
		// 270,
		// SkillTrees.Defense,
		// TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Levitate")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Shield"), 357, 270,
		// SkillTrees.Defense, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Zone")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Contingency_Health"),
		// 402, 270, SkillTrees.Defense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Shield")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Rune"), 157, 315,
		// SkillTrees.Defense, TreePointTypes.GREEN, new SkillTreeEntry[]{
		// JutsuManager.instance.getJutsu("Accelerate"),
		// JutsuManager.instance.getJutsu("Entangle")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("RuneProcs"), 157, 360,
		// SkillTrees.Defense, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Rune")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Speed"), 202, 315,
		// SkillTrees.Defense, TreePointTypes.RED, new SkillTreeEntry[]{
		// JutsuManager.instance.getJutsu("Accelerate"),
		// JutsuManager.instance.getJutsu("Flight")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Reflect"), 357, 315,
		// SkillTrees.Defense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Shield")});
		// RegisterEntry(JutsuManager.instance.getJutsu("ChronoAnchor"), 312,
		// 315,
		// SkillTrees.Defense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Reflect")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Duration"), 312, 360,
		// SkillTrees.Defense, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("ChronoAnchor")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("ManaLink"), 30, 45,
		// SkillTrees.Defense, TreePointTypes.SILVER,
		// new SkillTreeEntry[0]);
		// RegisterEntry(JutsuManager.instance.getJutsu("ManaShield"), 30, 90,
		// SkillTrees.Defense, TreePointTypes.SILVER,
		// new SkillTreeEntry[0]);
		// RegisterEntry(JutsuManager.instance.getJutsu("BuffPower"), 30, 135,
		// SkillTrees.Defense, TreePointTypes.SILVER,
		// new SkillTreeEntry[0]);
		//
		// this.utilityTree.clear();
		// RegisterEntry(JutsuManager.instance.getJutsu("Touch"), 275, 75,
		// SkillTrees.Utility, TreePointTypes.BLUE, new SkillTreeEntry[0]);
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Dig"), 275, 120,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Touch")});
		// RegisterEntry(JutsuManager.instance.getJutsu("WizardsAutumn"), 315,
		// 120, SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Dig")});
		// RegisterEntry(JutsuManager.instance.getJutsu("TargetNonSolid"), 230,
		// 75, SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Touch")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("PlaceBlock"), 185, 93,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Dig")});
		// RegisterEntry(JutsuManager.instance.getJutsu("FeatherTouch"), 230,
		// 137,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Dig")});
		// RegisterEntry(JutsuManager.instance.getJutsu("MiningPower"), 185,
		// 137,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("FeatherTouch")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Light"), 275, 165,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Dig")});
		// RegisterEntry(JutsuManager.instance.getJutsu("NightVision"), 185,
		// 165,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Light")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Binding"), 275, 210,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Light")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Disarm"), 230, 210,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Binding")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Charm"), 315, 235,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Binding")});
		// RegisterEntry(JutsuManager.instance.getJutsu("TrueSight"), 185, 210,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("NightVision")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Lunar"), 145, 210,
		// SkillTrees.Utility, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("TrueSight")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("HarvestPlants"), 365,
		// 120, SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Binding")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Plow"), 365, 165,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Binding")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Plant"), 365, 210,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Binding")});
		// RegisterEntry(JutsuManager.instance.getJutsu("CreateWater"), 365,
		// 255,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Binding")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Drought"), 365, 300,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Binding")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("BanishRain"), 365, 345,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Drought")});
		// RegisterEntry(JutsuManager.instance.getJutsu("WaterBreathing"), 410,
		// 345, SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Drought")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Grow"), 410, 210,
		// SkillTrees.Utility, TreePointTypes.RED, new SkillTreeEntry[]{
		// JutsuManager.instance.getJutsu("Drought"),
		// JutsuManager.instance.getJutsu("CreateWater"),
		// JutsuManager.instance.getJutsu("Plant"),
		// JutsuManager.instance.getJutsu("Plow"),
		// JutsuManager.instance.getJutsu("HarvestPlants")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Chain"), 455, 210,
		// SkillTrees.Utility, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Grow")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Rift"), 275, 255,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Binding")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Invisibility"), 185,
		// 255,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("TrueSight")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("RandomTeleport"), 185,
		// 300, SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Invisibility")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Attract"), 245, 300,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Rift")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Telekinesis"), 305,
		// 300,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Rift")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Blink"), 185, 345,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("RandomTeleport")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Range"), 140, 345,
		// SkillTrees.Utility, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Blink")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Channel"), 275, 345,
		// SkillTrees.Utility, TreePointTypes.GREEN, new SkillTreeEntry[]{
		// JutsuManager.instance.getJutsu("Attract"),
		// JutsuManager.instance.getJutsu("Telekinesis")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Radius"), 275, 390,
		// SkillTrees.Utility, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Channel")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Transplace"), 185, 390,
		// SkillTrees.Utility, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Blink")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Mark"), 155, 435,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Transplace")});
		// RegisterEntry(JutsuManager.instance.getJutsu("Recall"), 215, 435,
		// SkillTrees.Utility, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("Transplace")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("DivineIntervention"),
		// 172, 480, SkillTrees.Utility, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Recall"),
		// JutsuManager.instance.getJutsu("Mark")});
		// RegisterEntry(JutsuManager.instance.getJutsu("EnderIntervention"),
		// 198,
		// 480, SkillTrees.Utility, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance.getJutsu("Recall"),
		// JutsuManager.instance.getJutsu("Mark")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Contingency_Death"),
		// 198,
		// 524, SkillTrees.Utility, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("EnderIntervention")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("Daylight"), 75, 45,
		// SkillTrees.Utility, TreePointTypes.SILVER,
		// new SkillTreeEntry[0]);
		// RegisterEntry(JutsuManager.instance.getJutsu("Moonrise"), 75, 90,
		// SkillTrees.Utility, TreePointTypes.SILVER,
		// new SkillTreeEntry[0]);
		// RegisterEntry(JutsuManager.instance.getJutsu("Prosperity"), 75, 135,
		// SkillTrees.Utility, TreePointTypes.SILVER,
		// new SkillTreeEntry[0]);
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("ManaRegenI"), 275, 75,
		// SkillTrees.Talents, TreePointTypes.BLUE, new SkillTreeEntry[0]);
		// RegisterEntry(JutsuManager.instance.getJutsu("Colour"), 230, 75,
		// SkillTrees.Talents, TreePointTypes.BLUE, new SkillTreeEntry[0]);
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("AffinityGains"), 365,
		// 120, SkillTrees.Talents, TreePointTypes.BLUE,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("ManaRegenI")});
		// RegisterEntry(JutsuManager.instance.getJutsu("ManaRegenII"), 275,
		// 120,
		// SkillTrees.Talents, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("ManaRegenI")});
		// RegisterEntry(JutsuManager.instance.getJutsu("SpellMotion"), 230,
		// 120,
		// SkillTrees.Talents, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("ManaRegenII")});
		// RegisterEntry(JutsuManager.instance.getJutsu("AugmentedCasting"),
		// 230,
		// 165, SkillTrees.Talents, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("SpellMotion")});
		// RegisterEntry(JutsuManager.instance.getJutsu("ManaRegenIII"), 275,
		// 165,
		// SkillTrees.Talents, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("ManaRegenII")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("ExtraSummon"), 230,
		// 210,
		// SkillTrees.Talents, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("AugmentedCasting")});
		//
		// RegisterEntry(JutsuManager.instance.getJutsu("MageBandI"), 320, 120,
		// SkillTrees.Talents, TreePointTypes.GREEN,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("ManaRegenI")});
		// RegisterEntry(JutsuManager.instance.getJutsu("MageBandII"), 320, 165,
		// SkillTrees.Talents, TreePointTypes.RED,
		// new SkillTreeEntry[]{JutsuManager.instance
		// .getJutsu("MageBandI")});

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

	public void RegisterEntry(IJutsu jutsu, int x, int y, SkillTrees tree,
			TreePointTypes requiredPoint, SkillTreeEntry... prerequisites) {
		this.treeListing = tree == SkillTrees.NINJUTSU
				? this.ninjutsuTree
				: tree == SkillTrees.GENJUTSU
						? this.genjutsuTree
						: tree == SkillTrees.FUUINJUTSU
								? this.fuuinjutsuTree
								: tree == SkillTrees.TAIJUTSU
										? this.taijutsuTree
										: tree == SkillTrees.KANJUTSU
												? this.kanjutsuTree
												: tree == SkillTrees.KANJUTSU
														? this.kanjutsuTree
														: this.soshijutsuTree;

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
								.size()]), jutsu, enabled);
		this.treeListing.add(this.newEntry);

		this.skillPointTypeList.put(
				Integer.valueOf(JutsuManager.instance.getJutsuID(jutsu)),
				requiredPoint);
	}
}
