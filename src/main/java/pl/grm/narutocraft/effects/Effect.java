package pl.grm.narutocraft.effects;

import net.minecraft.potion.Potion;

/**
 * Enum(List) of all effects
 */
public enum Effect {
	SLOWNESS(new Slowness()), STUN(), BARRIER(), BLOCK(), CONFUSE(), DISCARDNEGATIVES(), EXTENDERRANGE(), HEAL(), INVISIBLE(
			new Invisible()), POISONCLOUD(), PURGE(), THROW();

	public int effectID;

	private Effect() {
	}

	/**
	 * private constructor triggered by itself and used by {@link ItemEffect}
	 * 
	 * @param effect
	 */
	private Effect(Potion effect) {
		this.effectID = effect.getId();
	}
	public int getEffect() {
		return effectID;
	}
}
