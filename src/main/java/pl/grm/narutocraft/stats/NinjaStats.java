package pl.grm.narutocraft.stats;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import pl.grm.narutocraft.libs.config.BaseValues;

/**
 * NinjaStats use {@link Stats}
 */
public class NinjaStats {
	private static final String		NBTCompoundName		= "NinjaAttributes";
	private int						skillPointsPerLevel	= BaseValues.skillPointsPerLevel;
	private Map<String, Integer>	stats;
	
	private int						currentNinjaXp		= 0, ninjaXpLevelUpCap = 15;
	private int						skillPoints			= 0, ninjaLevel = 1;
	private int						skillTreeBukiLevel	= 0, skillTreeFuuinLevel = 0,
			skillTreeGenLevel = 0, skillTreeIryoLevel = 0, skillTreeNinLevel = 0,
			skillTreeTaiLevel = 0;
	
	public NinjaStats() {
		this.stats = new HashMap<String, Integer>();
		
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
					for (Stats stat : Stats.values()) {
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
		if ((this.currentNinjaXp + xpGained) >= this.ninjaXpLevelUpCap) {
			int xpTotal = this.currentNinjaXp + xpGained;
			if (xpTotal > this.ninjaXpLevelUpCap) {
				this.currentNinjaXp = xpTotal - this.ninjaXpLevelUpCap;
			} else {
				this.currentNinjaXp = 0;
			}
			this.ninjaLevel++;
			this.skillPoints += skillPointsPerLevel;
			// Cap increases by 75% more
			this.ninjaXpLevelUpCap = (int) (this.ninjaXpLevelUpCap * 1.75f);
		} else {
			this.currentNinjaXp += xpGained;
		}
	}
	
	/**
	 * Takes an Int Array
	 * Best used with getValues, harder to mess up
	 **/
	public void setValues(int[] values) {
		this.ninjaLevel = values[7];
		this.currentNinjaXp = values[8];
		this.ninjaXpLevelUpCap = values[9];
		this.skillPoints = values[10];
		this.skillTreeBukiLevel = values[11];
		this.skillTreeFuuinLevel = values[12];
		this.skillTreeGenLevel = values[13];
		this.skillTreeIryoLevel = values[14];
		this.skillTreeNinLevel = values[15];
		this.skillTreeTaiLevel = values[16];
	}
	
	public int getCurrentXp() {
		return this.currentNinjaXp;
	}
	
	public int getXpCap() {
		return this.ninjaXpLevelUpCap;
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
}
