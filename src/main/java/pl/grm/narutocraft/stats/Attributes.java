package pl.grm.narutocraft.stats;

public enum Attributes {
	STRENGHT(
			"Strenght",
			"str",
			0) ,
	AGILITY(
			"Agility",
			"agil",
			0) ,
	DEXTERITY(
			"Dexterity",
			"dex",
			0) ,
	RESISTANCE(
			"Resistance",
			"res",
			0);
	
	private String	name;
	private String	sName;
	private int		baseValue;
	
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
