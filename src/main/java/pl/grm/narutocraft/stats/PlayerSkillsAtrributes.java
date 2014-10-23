package pl.grm.narutocraft.stats;

@Deprecated
public class PlayerSkillsAtrributes {
	public static int	arraySize			= 17;
	public static int	skillPointsPerLevel	= 5;
	// Stats
	private int			strength			= 0, agility = 0, dexterity = 0, resistance = 0,
			elementPowerModifier = 0, chakraModifier = 0, chakraRegenBonus = 0, ninjaLevel = 1;
	
	private int			currentNinjaXp		= 0, ninjaXpLevelUpCap = 15;
	public int			skillPoints			= 0;
	private int			skillTreeBukiLevel	= 0, skillTreeFuuinLevel = 0, skillTreeGenLevel = 0,
			skillTreeIryoLevel = 0, skillTreeNinLevel = 0, skillTreeTaiLevel = 0;
	
	/** Returns an Int array of 17 elements **/
	public int[] getValues() {
		return new int[]{
				this.strength, this.agility, this.dexterity, this.resistance,
				this.elementPowerModifier, this.chakraModifier, this.chakraRegenBonus,
				this.ninjaLevel, this.currentNinjaXp, this.ninjaXpLevelUpCap, this.skillPoints,
				this.skillTreeBukiLevel, this.skillTreeFuuinLevel, this.skillTreeGenLevel,
				this.skillTreeIryoLevel, this.skillTreeNinLevel, this.skillTreeTaiLevel};
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
	 * Takes an Int Array of 17 elements
	 * Best used with getValues, harder to mess up
	 **/
	public void setValues(int[] values) {
		this.strength = values[0];
		this.agility = values[1];
		this.dexterity = values[2];
		this.resistance = values[3];
		this.elementPowerModifier = values[4];
		this.chakraModifier = values[5];
		this.chakraRegenBonus = values[6];
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
		return this.strength;
	}
	
	public int getAgility() {
		return this.agility;
	}
	
	public int getDexterity() {
		return this.dexterity;
	}
	
	public int getResistance() {
		return this.resistance;
	}
	
	public int getElementPowerMod() {
		return this.elementPowerModifier;
	}
	
	public int getMaxChakraMod() {
		return this.chakraModifier;
	}
	
	public int getChakraRegenMod() {
		return this.chakraRegenBonus;
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
		this.strength = v;
	}
	
	public void setAgility(int v) {
		this.agility = v;
	}
	
	public void setDexterity(int v) {
		this.dexterity = v;
	}
	
	public void setResistance(int v) {
		this.resistance = v;
	}
	
	public void setElementPowerMod(int v) {
		this.elementPowerModifier = v;
	}
	
	public void setMaxChakraMod(int v) {
		this.chakraModifier = v;
	}
	
	public void setChakraRegenMod(int v) {
		this.chakraRegenBonus = v;
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
