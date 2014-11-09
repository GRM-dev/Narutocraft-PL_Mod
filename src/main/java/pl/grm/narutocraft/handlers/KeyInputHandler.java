package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.libs.config.KeyBindings;
import pl.grm.narutocraft.libs.network.PacketNinjaRun;
import pl.grm.narutocraft.player.ExtendedProperties;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

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
