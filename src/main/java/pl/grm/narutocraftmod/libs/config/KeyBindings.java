package pl.grm.narutocraftmod.libs.config;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;

public class KeyBindings {
	public static KeyBinding Jutsu;
	public static KeyBinding PJutsu;
	public static KeyBinding NJutsu;
	private static String narutocraftmod = "NarutoCraft Mod";

	public static void init() {
		PJutsu = new KeyBinding("Previous Jutsu", Keyboard.KEY_O,
				narutocraftmod);
		NJutsu = new KeyBinding("Next Jutsu", Keyboard.KEY_P, narutocraftmod);
		Jutsu = new KeyBinding("Jutsu Panel", Keyboard.KEY_I, narutocraftmod);

		// Register KeyBindings to the ClientRegistry
		ClientRegistry.registerKeyBinding(PJutsu);
		ClientRegistry.registerKeyBinding(NJutsu);
		ClientRegistry.registerKeyBinding(Jutsu);

	}
}
