package pl.grm.narutocraft.jutsu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public interface IJutsu {
	/**
	 * Initialize Jutsu when activated
	 */
	public void activateJutsu();

	/**
	 * Consumes amount of chackra.
	 *
	 * @param value
	 */
	public void consumeChackra(EntityPlayer player, int value);

	/**
	 * Id of the Jutsu.
	 *
	 * @return ID of Jutsu
	 */
	public int getJutsuID();

	/**
	 * @return List of Jutsu Props
	 */
	public int[] getJutsuProps();

	/**
	 * Check if Jutsu is Active
	 *
	 * @return true if Jutsu is activated.
	 */
	public boolean isActive();

	/**
	 * Called on Jutsu end.
	 */
	public void jutsuEnd();

	/**
	 * Method invoked by JutsuEvent every Player Tick.
	 */
	public void onJutsuUpdate();

	/**
	 * Reads from NBT.
	 *
	 * @param properties
	 */
	public void readFromNBT(NBTTagCompound properties);

	/**
	 * Enable/diasable jutsu.
	 *
	 * @param par
	 *            false to disable
	 */
	public void setActive(boolean par);

	/**
	 * Adds to Map Jutsu durations.
	 */
	public void updateJutsuProperties();

	/**
	 * Writes to NBT.
	 *
	 * @param properties
	 */
	public void writeToNBT(NBTTagCompound properties);
}