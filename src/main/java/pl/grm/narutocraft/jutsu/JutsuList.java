package pl.grm.narutocraft.jutsu;

public enum JutsuList {
	NONE(5600), MEISAIGAKURE(5601);

	private int ID;

	JutsuList(int ID) {
		this.ID = ID;
	}

	public int getID() {
		return ID;
	}
}
