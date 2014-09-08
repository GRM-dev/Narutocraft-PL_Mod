package pl.grm.narutocraft.jutsu;

import java.util.Map;

import pl.grm.narutocraft.effects.IEffect;

public interface IJutsu {
	/**
	 * Uploads to Map EffectList using setEffect.
	 */
	public abstract void uploadEffects();
	/**
	 * IJutsu with corresponding Effect.
	 * 
	 * @return Map of linkages.
	 */
	public abstract Map<IJutsu, IEffect> getEffects();
	/**
	 * Set effect to Jutsu.
	 * 
	 * @param effect
	 */
	public abstract void setEffect(IEffect effect);
	/**
	 * Check if Jutsu is Active
	 * 
	 * @return true if Jutsu is activated.
	 */
	public abstract boolean isActive();
	/**
	 * Enable/diasable jutsu.
	 * 
	 * @param par
	 *            false to disable
	 */
	public abstract void setActive(boolean par);
	/**
	 * Method invoked by JutsuEvent every Player Tick.
	 */
	public abstract void onJutsuUpdate();
	/**
	 * Consumes amount of chackra.
	 * 
	 * @param value
	 */
	public abstract void consumeChackra(int value);
	/**
	 * Id of the Jutsu.
	 * 
	 * @return ID of Jutsu
	 */
	public abstract int getID();
}