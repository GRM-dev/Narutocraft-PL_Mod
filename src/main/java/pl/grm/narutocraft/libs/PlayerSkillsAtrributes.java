package pl.grm.narutocraft.libs;

public class PlayerSkillsAtrributes {
	public static int arraySize = 11;
	public static int skillPointsPerLevel = 5;
	// Stats
	private int strength = 0, agility = 0, dexterity = 0, resistance = 0,
			elementPowerModifier = 0, chakraModifier = 0, chakraRegenBonus = 0,
			ninjaLevel = 1;

	public int currentNinjaXp = 0, ninjaXpLevelUpCap = 15;
	public int skillPoints = 0;

	public int getAgility() {
		return this.agility;
	}
	public int getChakraModifier() {
		return this.chakraModifier;
	}
	public int getChakraRegenBonus() {
		return this.chakraRegenBonus;
	}
	public int getCurrentNinjaXp() {
		return this.currentNinjaXp;
	}
	public int getDexterity() {
		return this.dexterity;
	}
	public int getElementPowerModifier() {
		return this.elementPowerModifier;
	}
	public int getNinjaLevel() {
		return this.ninjaLevel;
	}
	public int getNinjaXpCap() {
		return this.ninjaXpLevelUpCap;
	}
	public int getResistance() {
		return this.resistance;
	}
	// Getters
	public int getStrength() {
		return this.strength;
	}

	/** Returns an Int array of 11 elements **/
	public int[] getValues() {
		return new int[]{this.strength, this.agility, this.dexterity,
				this.resistance, this.elementPowerModifier,
				this.chakraModifier, this.chakraRegenBonus, this.ninjaLevel,
				this.currentNinjaXp, this.ninjaXpLevelUpCap, this.skillPoints};
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
	public void setAgility(int v) {
		this.agility = v;
	}
	public void setChakraModifier(int v) {
		this.chakraModifier = v;
	}
	public void setChakraRegenBonus(int v) {
		this.chakraRegenBonus = v;
	}
	public void setDexterity(int v) {
		this.dexterity = v;
	}
	public void setElementPowerModifier(int v) {
		this.elementPowerModifier = v;
	}

	public void setResistance(int v) {
		this.resistance = v;
	}

	// Setters
	public void setStrength(int v) {
		this.strength = v;
	}

	/** Takes an Int Array of 11 elements **/
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
	}
}
