package pl.grm.narutocraft.effects;

public enum EffectList {
	NONE(0, null), INVISIBLE(1, new Invisible()), SLOWNESS(2, new Slowness());

	private int ID;
	private IEffect effect;

	private EffectList(int effectID, IEffect effect) {
		this.ID = effectID;
		this.effect = effect;
	}

	public int getID() {
		return ID;
	}

	public IEffect getById(int ID) {
		for (EffectList eListElem : EffectList.values()) {
			if (eListElem.getID() == ID)
				return eListElem.getEffect();
		}
		return null;
	}

	public IEffect getEffect() {
		return effect;
	}
}
