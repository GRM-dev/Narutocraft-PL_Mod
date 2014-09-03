package pl.grm.narutocraft.effects;
/**
 * Enum(List) of all effects
 */
public enum EffectsList {
	jutsu(0),SLOWNESS(1),STUN(2),BARRIER(3),BLOCK(4),CONFUSE(5),DISCARDNEGATIVES(6),EXTENDERRANGE(7),HEAL(8),INVISIBLE(9),POISONCLOUD(10),PURGE(11),THROW(12), ;
	
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
