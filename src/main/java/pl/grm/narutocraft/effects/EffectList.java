package pl.grm.narutocraft.effects;

public enum EffectList {
	NONE(0), INVISIBLE(1), SLOWNESS(2);

	private int ID;

	private EffectList(int effectID) {
		this.ID = effectID;
	}

	public int getID() {
		return ID;
	}
}
