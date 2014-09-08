package pl.grm.narutocraft.effects;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;

/**
 * Interface of all effects
 */
public interface IEffect {

	public abstract PotionEffect getEffect();
	public abstract int getJutsuID();
	public abstract int getEffectID();
	public abstract int getDuration();
	public abstract List<ItemStack> getCurativeItems();
	/**
	 * Describes Efeect actions. What it makes.
	 */
	public abstract void action();
	/**
	 * Called to start effect.
	 */
	public abstract void startEffect();
	/**
	 * Called on end effect.
	 */
	public abstract void endEffect();
	/**
	 * Called every tick by Jutsu it corresponds to.
	 */
	public abstract void onEffectUpdate();
	/**
	 * 
	 * @return ticks passed from Effect start.
	 */
	public abstract int getDurationPass();
	/**
	 * Check is effect has finished.
	 * 
	 * @return true if ended.
	 */
	public abstract boolean isEnded();
}
