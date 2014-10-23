package pl.grm.narutocraft.stats;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public class NinjaAtrributes {
	public static int				skillPointsPerLevel	= 5;
	
	private Map<String, Integer>	attributes;
	private int						currentNinjaXp		= 0, ninjaXpLevelUpCap = 15;
	public int						skillPoints			= 0, ninjaLevel = 1;
	private int						skillTreeBukiLevel	= 0, skillTreeFuuinLevel = 0,
			skillTreeGenLevel = 0, skillTreeIryoLevel = 0, skillTreeNinLevel = 0,
			skillTreeTaiLevel = 0;
	
	public NinjaAtrributes() {
		this.attributes = new HashMap<String, Integer>();
		for (Attributes att : Attributes.values()) {
			this.attributes.put(att.getSName(), att.getBaseValue());
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
	 * When You want array of values in int[] array just call this method.
	 * 
	 * @return int[] of attributes values
	 */
	public int[] getAttInArray() {
		Integer[] inter = (attributes.entrySet().toArray(new Integer[Attributes.values().length]));
		return ArrayUtils.toPrimitive(inter);
	}
	
	/** Returns a Map of attributes values */
	public Map<String, Integer> getAttValues() {
		return attributes;
	}
	
	/**
	 * Takes an Int Array of 17 elements
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
	
	// Getters
	public int getStrength() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getAgility() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getDexterity() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getResistance() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getElementPowerMod() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getMaxChakraMod() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
	}
	
	public int getChakraRegenMod() {
		Integer param = attributes.get(Attributes.STRENGHT.getSName());
		return param;
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
	
	// Setters
	public void setStrength(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setAgility(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setDexterity(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setResistance(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setElementPowerMod(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setMaxChakraMod(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
	}
	
	public void setChakraRegenMod(int v) {
		attributes.put(Attributes.STRENGHT.getSName(), v);
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
