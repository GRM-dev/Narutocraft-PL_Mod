package pl.grm.narutocraft.jutsu;

public enum JutsuList {
	NONE(5600), MEISAIGAKURE(5601);

	private int jutsuID;

	JutsuList(int ID) {
		this.jutsuID = ID;
	}

	public JutsuList getByID(int ID) {
		for (JutsuList jutsu : JutsuList.values()) {
			if (jutsu.jutsuID == ID) {
				return jutsu;
			}
		}
		return NONE;
	}

	public int getID() {
		return this.jutsuID;
	}
}
