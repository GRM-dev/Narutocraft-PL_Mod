package pl.grm.narutocraft.jutsu;

public interface IJutsu {

	/**
	 * Initialize Jutsu when activated
	 */
	public void onJutsuActivation();

	/**
	 * Method invoked by JutsuEvent every Player Tick.
	 */
	public void onJutsuUpdate();

	/**
	 * Called on Jutsu end.
	 */
	public void onJutsuEnd();
}