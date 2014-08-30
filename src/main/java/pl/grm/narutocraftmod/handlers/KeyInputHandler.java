package pl.grm.narutocraftmod.handlers;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.hud.GuiBasic;
import pl.grm.narutocraftmod.libs.config.KeyBindings;
import pl.grm.narutocraftmod.network.OpenGuiPacket;
/**
 * gets keyboard button presses form {@link KeyBindings}
 * 
 * @author Admaster
 *
 */
public class KeyInputHandler {

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		if (KeyBindings.PJutsu.isPressed()) {
			System.out.println("Previous Jutsu");
		}
		if (KeyBindings.NJutsu.isPressed()) {
			System.out.println("Next Jutsu");
		}
		if (KeyBindings.Jutsu.isPressed()) {
			System.out.println("Open Panel");
			EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
			NarutoCraftMod.packetPipeline.sendToServer(new OpenGuiPacket(
					GuiBasic.GUI_JUTSU_INV));
			player.openGui(NarutoCraftMod.instance, GuiBasic.GUI_JUTSU_INV,
					player.worldObj, (int) player.posX, (int) player.posY,
					(int) player.posZ);
		}
	}
}
