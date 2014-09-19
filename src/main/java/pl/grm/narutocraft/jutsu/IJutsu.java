package pl.grm.narutocraft.jutsu;


public interface IJutsu {
	/**
	 * Initialize Jutsu when activated
	 */
	public void activateJutsu();
	
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
}