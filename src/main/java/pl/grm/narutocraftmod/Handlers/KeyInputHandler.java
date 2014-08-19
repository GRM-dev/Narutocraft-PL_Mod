package pl.grm.narutocraftmod.Handlers;

import pl.grm.narutocraftmod.Libs.KeyBindings;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandler {
	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(KeyBindings.Jutsu.isPressed())
            System.out.println("Jutsu");
        if(KeyBindings.NJutsu.isPressed())
            System.out.println("Next Jutsu");
    }
}
