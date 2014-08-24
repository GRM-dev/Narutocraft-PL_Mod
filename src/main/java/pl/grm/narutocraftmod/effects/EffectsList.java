package pl.grm.narutocraftmod.effects;
/**
 * Enum(List) of all effects
 */
public enum EffectsList {
	SLOW(0),STUN(1), jutsu(2);
	
	private int numberRepresentation;
	/**
	 * private constructor triggered by itself and used by {@link ItemEffect}
	 * @param numberRepresentation
	 */
	private EffectsList(int numberRepresentation) {
		this.numberRepresentation = numberRepresentation;
	}
	/**
	 * get number of effect
	 * @return the number of enum element
	 */
	public int getNumber() {
		return numberRepresentation;
	}
}
