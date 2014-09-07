package pl.grm.narutocraft.jutsu;

import java.util.List;
import java.util.Map;

import pl.grm.narutocraft.effects.IEffect;

public interface IJutsu {
	public List<IEffect> effects = null;

	/**
	 * Uploads to Map EffectList using setEffect.
	 */
	public abstract void uploadEffects();
	public abstract Map<IJutsu, IEffect> getEffects();
	public abstract void setEffect(IEffect effect);
	public abstract boolean isActive();
	public abstract void setActive(boolean par);
	public abstract void onJutsuUpdate();
}