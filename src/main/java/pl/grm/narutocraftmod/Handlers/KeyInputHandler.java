package pl.grm.narutocraftmod.Handlers;

import pl.grm.narutocraftmod.Libs.KeyBindings;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
/**
 * gets keyboard button presses form {@link KeyBindings}
 * @author Admaster
 *
 */
public class KeyInputHandler {
	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(KeyBindings.PJutsu.isPressed())
            System.out.println("Previous Jutsu");
        if(KeyBindings.NJutsu.isPressed())
            System.out.println("Next Jutsu");
    }
}
