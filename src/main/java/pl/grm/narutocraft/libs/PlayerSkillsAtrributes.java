package pl.grm.narutocraft.libs;

public class PlayerSkillsAtrributes
{
	public static int arraySize = 11;
	public static int skillPointsPerLevel = 5;
	//Stats
	private int strength = 0, agility = 0, dexterity = 0, 
			resistance = 0,elementPowerModifier = 0, chakraModifier = 0, 
			chakraRegenBonus = 0, ninjaLevel = 1;
	
	public int currentNinjaXp = 0, ninjaXpLevelUpCap = 15;
	public int skillPoints = 0;
	
	//Getters
	public int getStrength(){return strength;}
	public int getAgility(){return agility;}
	public int getDexterity(){return dexterity;}
	public int getResistance(){return resistance;}
	public int getElementPowerModifier(){return elementPowerModifier;}
	public int getChakraModifier(){return chakraModifier;}
	public int getChakraRegenBonus(){return chakraRegenBonus;}
	public int getNinjaLevel(){return ninjaLevel;}
	public int getCurrentNinjaXp(){return currentNinjaXp;}
	public int getNinjaXpCap(){return ninjaXpLevelUpCap;}
	
	//Setters
	public void setStrength(int v){strength = v;}
	public void setAgility(int v){agility = v;}
	public void setDexterity(int v){dexterity = v;}
	public void setResistance(int v){resistance = v;}
	public void setElementPowerModifier(int v){elementPowerModifier = v;}
	public void setChakraModifier(int v){chakraModifier = v;}
	public void setChakraRegenBonus(int v){chakraRegenBonus = v;}
	
	/**This is used to add xp, it also handles leveling up**/
	public void levelUp (int xpGained)
	{
		if (currentNinjaXp + xpGained >= ninjaXpLevelUpCap)
		{
			int xpTotal = currentNinjaXp + xpGained;
			if (xpTotal > ninjaXpLevelUpCap)
			{
				currentNinjaXp = xpTotal - ninjaXpLevelUpCap;
			}
			else currentNinjaXp = 0;
			ninjaLevel++;
			skillPoints += skillPointsPerLevel;
			//Cap doubles plus 50% more
			ninjaXpLevelUpCap = (int)(ninjaXpLevelUpCap * 2.5f);
		}
		else
		{
			currentNinjaXp += xpGained;
		}
	}
	
	/** Returns an Int array of 11 elements **/
	public int[] getValues()
	{
		return new int[]{strength,agility,dexterity,
			resistance,elementPowerModifier,chakraModifier,
			chakraRegenBonus,ninjaLevel,currentNinjaXp,
			ninjaXpLevelUpCap,skillPoints};
	}
	
	/** Takes an Int Array of 11 elements **/
	public void setValues(int[] values)
	{
		strength = values[0];
		agility = values[1];
		dexterity = values[2];
		resistance = values[3];
		elementPowerModifier = values[4];
		chakraModifier = values[5];
		chakraRegenBonus = values[6];
		ninjaLevel = values[7];
		currentNinjaXp = values[8];
		ninjaXpLevelUpCap = values[9];
		skillPoints = values[10];
	}
}
