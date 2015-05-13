package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.*;
import net.minecraftforge.fml.client.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.network.internal.*;
import pl.grm.narutocraft.*;
import pl.grm.narutocraft.libs.config.*;
import pl.grm.narutocraft.libs.network.*;
import pl.grm.narutocraft.player.*;

/**
 * gets keyboard button presses form {@link KeyBindings}
 *
 * @author Admaster
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
			FMLNetworkHandler.openGui(player, NarutoCraft.instance, 3, player.worldObj,
					(int) player.posX, (int) player.posY, (int) player.posZ);
		}
		if (KeyBindings.NRun.isPressed()) {
			EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
			ExtendedProperties.get(player).ninjaRun = ExtendedProperties.get(player).ninjaRun == true
					? false : true;
			NarutoCraft.netHandler.sendToServer(new PacketNinjaRun(
					ExtendedProperties.get(player).ninjaRun));
		}
	}
}
