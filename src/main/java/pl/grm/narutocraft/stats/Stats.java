package pl.grm.narutocraft.stats;

/**
 * Other statistics than attributes like level of player, base level, etc.
 * <p>
 * When base value than its name = " ".
 */
public enum Stats {
	ARMOR_BASE(
			" ",
			"armor_base",
			4);
	
	private String	name;
	private int		baseValue;
	private String	sName;
	
	private Stats(String name, String sName, int baseValue) {
		this.name = name;
		this.sName = sName;
		this.baseValue = baseValue;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBaseValue() {
		return baseValue;
	}
	
	public String getSName() {
		return sName;
	}
}
