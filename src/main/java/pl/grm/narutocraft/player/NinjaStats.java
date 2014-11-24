package pl.grm.narutocraft.player;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

/**
 * NinjaStats use {@link StatsSettings}
 */
public class NinjaStats {
	private static final String		NBTCompoundName			= "NinjaAttributes";
	private int						skillPointsPerLevel		= StatsSettings.skillPointsPerLevel;
	private int						currentNinjaXp			= 0;
	private int						ninjaXpLevelUpCap		= 15;
	private int						skillPoints				= 0;
	private int						ninjaLevel				= 1;
	private int						skillTreeBukiLevel		= 0;
	private int						skillTreeFuuinLevel		= 0;
	private int						skillTreeGenLevel		= 0;
	private int						skillTreeIryoLevel		= 0;
	private int						skillTreeNinLevel		= 0;
	private int						skillTreeTaiLevel		= 0;
	private int						maxChakra				= StatsSettings.chakraBase * 20;
	private int						chakraModifier			= 0;
	private int						chakraRegenBonus		= 0;
	private int						elementPowerModifier	= 0;
	private Map<String, Integer>	stats;
	
	public NinjaStats() {
		this.stats = new HashMap<String, Integer>();
		for (Stats stat : Stats.values()) {
			this.stats.put(stat.getSName(), stat.getBaseValue());
		}
	}
	
	public void writoToNBT(NBTTagCompound properties) {
		NBTTagList tagList = new NBTTagList();
		Iterator<Entry<String, Integer>> iterator = stats.entrySet().iterator();
		while (iterator.hasNext()) {
			NBTTagCompound tag = new NBTTagCompound();
			Entry<String, Integer> entry = iterator.next();
			String name = entry.getKey();
			Integer value = entry.getValue();
			tag.setInteger(name, value);
			tagList.appendTag(tag);
		}
		properties.setTag(NBTCompoundName, tagList);
	}
	
	public void readFromNBT(NBTTagCompound properties) {
		NBTTagList tagList = properties.getTagList(NBTCompoundName, Constants.NBT.TAG_COMPOUND);
		int amount = tagList.tagCount();
		if (amount > 0) {
			for (int i = 0; i < amount; i++) {
				NBTTagCompound tag = tagList.getCompoundTagAt(i);
				if (!tag.hasNoTags()) {
					for (StatsSettings stat : StatsSettings.values()) {
						String name = stat.getSName();
						if (tag.hasKey(name)) {
							int value = tag.getInteger(name);
							stats.put(name, value);
						}
					}
				}
			}
		}
	}
	
	/** This is used to add xp, it also handles leveling up **/
	public void levelUp(int xpGained) {
		int currentXp = stats.get(Stats.NINJAXP.getSName());
		int xpCap = stats.get(Stats.NINJAXPCAP.getSName());
		if (currentXp + xpGained >= xpCap) {
			int ninjaLevel = stats.get(Stats.NINLEVEL.getSName());
			int skillPoints = stats.get(Stats.SKILLPOINTS.getSName());
			int xpTotal = currentXp + xpGained;
			if (xpTotal > xpCap) {
				currentXp = xpTotal - xpCap;
			} else {
				currentXp = 0;
			}
			ninjaLevel++;
			skillPoints += skillPointsPerLevel;
			xpCap = (int) (xpCap * 1.75);
			stats.put(Stats.NINJALEVEL.getSName(), ninjaLevel);
			stats.put(Stats.SKILLPOINTS.getSName(), skillPoints);
			stats.put(Stats.NINJAXPCAP.getSName(), xpCap);
		} else {
			currentXp += xpGained;
		}
		stats.put(Stats.NINJAXP.getSName(), currentXp);
	}
	
	// For Networking
	public String[] getInfo() {
		String[] info = new String[stats.size()];
		Iterator<Entry<String, Integer>> iterator = stats.entrySet().iterator();
		int index = 0;
		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			String name = entry.getKey();
			Integer value = entry.getValue();
			info[index] = name + ":" + value;
			index++;
		}
		return info;
	}
	
	// For Networking
	public void setInfo(String[] info) {
		String[] splitInfo;
		for (String i : info) {
			splitInfo = i.split(":");
			stats.put(splitInfo[0], Integer.parseInt(splitInfo[1]));
		}
	}
	
	public int getCurrentXp() {
		return this.stats.get(Stats.NINJAXP.getSName());
	}
	
	public void setCurrentXp(int xp) {
		this.stats.put(Stats.NINJAXP.getSName(), xp);
		this.levelUp(0);// Just to update the level in case of large set.
	}
	
	public int getChakraModifier() {
		return this.stats.get(Stats.CHAKRAMOD.getSName());
	}
	
	public void setChakraModifier(int chakraModifier) {
		this.stats.put(Stats.CHAKRAMOD.getSName(), chakraModifier);
	}
	
	public int getChakraRegenBonus() {
		return this.chakraRegenBonus;
	}
	
	public void setChakraRegenBonus(int chakraRegenBonus) {
		this.chakraRegenBonus = chakraRegenBonus;
	}
	
	public int getXpCap() {
		return this.stats.get(Stats.NINJAXPCAP.getSName());
	}
	
	public int getSkillPointsPerLevel() {
		return this.skillPointsPerLevel;
	}
	
	public void setSkillPointsPerLevel(int skillPointsPerLevel) {
		this.skillPointsPerLevel = skillPointsPerLevel;
	}
	
	public int getSkillPoints() {
		return this.stats.get(Stats.SKILLPOINTS.getSName());
	}
	
	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}
	
	public int getSkillTreeBukiLevel() {
		return this.skillTreeBukiLevel;
	}
	
	public void setSkillTreeBukiLevel(int skillTreeBukiLevel) {
		this.skillTreeBukiLevel = skillTreeBukiLevel;
	}
	
	public int getSkillTreeFuuinLevel() {
		return this.skillTreeFuuinLevel;
	}
	
	public void setSkillTreeFuuinLevel(int skillTreeFuuinLevel) {
		this.skillTreeFuuinLevel = skillTreeFuuinLevel;
	}
	
	public int getSkillTreeGenLevel() {
		return this.skillTreeGenLevel;
	}
	
	public void setSkillTreeGenLevel(int skillTreeGenLevel) {
		this.skillTreeGenLevel = skillTreeGenLevel;
	}
	
	public int getSkillTreeIryoLevel() {
		return this.skillTreeIryoLevel;
	}
	
	public void setSkillTreeIryoLevel(int skillTreeIryoLevel) {
		this.skillTreeIryoLevel = skillTreeIryoLevel;
	}
	
	public int getSkillTreeNinLevel() {
		return this.skillTreeNinLevel;
	}
	
	public void setSkillTreeNinLevel(int skillTreeNinLevel) {
		this.skillTreeNinLevel = skillTreeNinLevel;
	}
	
	public int getSkillTreeTaiLevel() {
		return this.skillTreeTaiLevel;
	}
	
	public void setSkillTreeTaiLevel(int skillTreeTaiLevel) {
		this.skillTreeTaiLevel = skillTreeTaiLevel;
	}
	
	public Map<String, Integer> getStats() {
		return this.stats;
	}
	
	public void setNinjaLevel(int ninjaLevel) {
		this.ninjaLevel = ninjaLevel;
	}
	
	public int getNinjaLevel() {
		return this.ninjaLevel;
	}
	
	public int getBukiTreeLevel() {
		return this.skillTreeBukiLevel;
	}
	
	public int getFuuinTreeLevel() {
		return this.skillTreeFuuinLevel;
	}
	
	public int getGenTreeLevel() {
		return this.skillTreeGenLevel;
	}
	
	public int getIryoTreeLevel() {
		return this.skillTreeIryoLevel;
	}
	
	public int getNinTreeLevel() {
		return this.skillTreeNinLevel;
	}
	
	public int getTaiTreeLevel() {
		return this.skillTreeTaiLevel;
	}
	
	public void setBukiTreeLevel(int v) {
		this.skillTreeBukiLevel = v;
	}
	
	public void setFuuinTreeLevel(int v) {
		this.skillTreeFuuinLevel = v;
	}
	
	public void setGenTreeLevel(int v) {
		this.skillTreeGenLevel = v;
	}
	
	public void setIryoTreeLevel(int v) {
		this.skillTreeIryoLevel = v;
	}
	
	public void setNinTreeLevel(int v) {
		this.skillTreeNinLevel = v;
	}
	
	public void setTaiTreeLevel(int v) {
		this.skillTreeTaiLevel = v;
	}
	
	public int getMaxChakra() {
		return maxChakra;
	}
	
	public void setMaxChakra(int maxChakra) {
		this.maxChakra = maxChakra;
	}
	
	public int getElementPowerModifier() {
		return elementPowerModifier;
	}
	
	public void setElementPowerModifier(int elementPowerModifier) {
		this.elementPowerModifier = elementPowerModifier;
	}
}
