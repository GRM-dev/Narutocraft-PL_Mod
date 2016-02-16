package pl.grmdev.narutocraft.player;

public enum Stats {
	NINJALEVEL("Ninja Level", "nl", 1),
	NINJAXP("Ninja XP", "nxp", 0),
	NINJAXPCAP("Ninja XP Cap", "nxpc", 15),
	SKILLPOINTS("Skill Points", "sp", 0),
	BUKILEVEL("Bukijutsu Level", "bjl", 0),
	FUUINLEVEL("Fuuinjutsu Level", "fjl", 0),
	GENLEVEL("Genjutsu Level", "gjl", 0),
	IRYOLEVEL("Iryojutsu Level", "ijl", 0),
	NINLEVEL("Ninjutsu Level", "njl", 0),
	TAILEVEL("Taijutsu Level", "tjl", 0),
	CHAKRAMOD("Chakra Modifier", "cm", 0),
	CHAKRAREGEN("Chakra Regeneration", "cr", 0),
	ELEMENTPOWERMOD("Element Power Modifier", "epm", 0);

	private String name;
	private String sName;
	private int baseValue;

	private Stats(String name, String sName, int baseValue) {
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
