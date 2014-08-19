package pl.grm.narutocraftmod.Effects;

public enum EffectsList {
	SLOW(0),STUN(1);
	
	private int numberRepresentation;
	
	private EffectsList(int numberRepresentation) {
		this.numberRepresentation = numberRepresentation;
	}
	
	public int getNumber() {
		return numberRepresentation;
	}
}
