package pl.grmdev.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import pl.grmdev.narutocraft.NarutoCraft;
import pl.grmdev.narutocraft.libs.config.KeyBindings;
import pl.grmdev.narutocraft.libs.network.PacketNinjaRun;
import pl.grmdev.narutocraft.player.ExtendedProperties;

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
			FMLNetworkHandler.openGui(player, NarutoCraft.instance, 3, player.worldObj, (int) player.posX,
					(int) player.posY, (int) player.posZ);
		}
		if (KeyBindings.NRun.isPressed()) {
			EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
			ExtendedProperties.get(player).ninjaRun = ExtendedProperties.get(player).ninjaRun == true ? false : true;
			NarutoCraft.netHandler.sendToServer(new PacketNinjaRun(ExtendedProperties.get(player).ninjaRun));
		}
	}
}
