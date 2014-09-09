package pl.grm.narutocraft.jutsu;

import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public interface IJutsu {
	/**
	 * Method invoked by JutsuEvent every Player Tick.
	 */
	public void onJutsuUpdate();

	/**
	 * Initialize Jutsu when activated
	 */
	public void activateJutsu();

	/**
	 * Called on Jutsu end.
	 */
	public void jutsuEnd();

	/**
	 * @return Map of Jutsu Props
	 */
	public Map<Integer, IJutsu> getJutsuProps();

	/**
	 * Adds to Map Jutsu durations.
	 */
	public void updateJutsuDurationsMap();

	/**
	 * Check if Jutsu is Active
	 * 
	 * @return true if Jutsu is activated.
	 */
	public boolean isActive();

	/**
	 * Enable/diasable jutsu.
	 * 
	 * @param par
	 *            false to disable
	 */
	public void setActive(boolean par);

	/**
	 * Consumes amount of chackra.
	 * 
	 * @param value
	 */
	public void consumeChackra(EntityPlayer player, int value);

	/**
	 * Writes to NBT.
	 * 
	 * @param properties
	 */
	public void writeToNBT(NBTTagCompound properties);

	/**
	 * Reads from NBT.
	 * 
	 * @param properties
	 */
	public void readFromNBT(NBTTagCompound properties);

	/**
	 * Id of the Jutsu.
	 * 
	 * @return ID of Jutsu
	 */
	public int getJutsuID();

	/**
	 * 
	 * @return jutsu duration
	 */
	public abstract int getTotalDuration();

	/**
	 * 
	 * @return ticks passed from Effect start.
	 */
	public abstract int getDurationPass();
}