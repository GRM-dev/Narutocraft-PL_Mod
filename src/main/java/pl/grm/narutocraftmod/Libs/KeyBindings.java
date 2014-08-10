package pl.grm.narutocraftmod.Libs;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.ClientRegistry;

public class KeyBindings{
	public static KeyBinding Jutsu;
    public static KeyBinding NJutsu;
    private static String narutocraftmod = "NarutoCraft Mod";

    public static void init() {
        Jutsu = new KeyBinding("Jutsu", Keyboard.KEY_O, narutocraftmod);
        NJutsu = new KeyBinding("Next Jutsu", Keyboard.KEY_P, narutocraftmod);

        // Register both KeyBindings to the ClientRegistry
        ClientRegistry.registerKeyBinding(Jutsu);
        ClientRegistry.registerKeyBinding(NJutsu);
    }
}
