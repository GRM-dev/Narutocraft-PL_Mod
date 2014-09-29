package pl.grm.narutocraft.libs.config;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;

public class KeyBindings {
	public static KeyBinding	Jutsu;
	public static KeyBinding	PJutsu;
	public static KeyBinding	NJutsu;
	public static KeyBinding	NRun;
	private static String		narutocraftmod	= "NarutoCraft Mod";
	
	/**
	 * Register KeyBindings to the ClientRegistry
	 */
	public static void init() {
		PJutsu = new KeyBinding("Previous Jutsu", Keyboard.KEY_O, narutocraftmod);
		NJutsu = new KeyBinding("Next Jutsu", Keyboard.KEY_P, narutocraftmod);
		Jutsu = new KeyBinding("Jutsu Panel", Keyboard.KEY_I, narutocraftmod);
		NRun = new KeyBinding("Ninja Sprint", Keyboard.KEY_F, narutocraftmod);
		
		ClientRegistry.registerKeyBinding(PJutsu);
		ClientRegistry.registerKeyBinding(NJutsu);
		ClientRegistry.registerKeyBinding(Jutsu);
		ClientRegistry.registerKeyBinding(NRun);
	}
}
