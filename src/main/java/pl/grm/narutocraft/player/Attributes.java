package pl.grm.narutocraft.player;

public enum Attributes {
	STRENGTH("Strength", "str", 0),
	AGILITY("Agility", "agil", 0),
	DEXTERITY("Dexterity", "dex", 0),
	RESISTANCE("Resistance", "res", 0),

	STAMINA("Stamina", "sta", 0),
	WILLPOWER("WillPower", "will", 0),
	LIFE("Life", "hp", 0),
	THROW("Throw", "throw", 0),
	ALERTNESS("Alertness", "alert", 0),
	CHARISMA("Charisma", "cha", 0),
	LUCK("Luck", "luck", 0);

	private String name;
	private String sName;
	private int baseValue;

	private Attributes(String name, String sName, int baseValue) {
		this.name = name;
		this.sName = sName;
		this.baseValue = baseValue;
	}

	public String getName() {
		return name;
	}

	public String getSName() {
		return sName;
	}

	public int getBaseValue() {
		return baseValue;
	}
}
