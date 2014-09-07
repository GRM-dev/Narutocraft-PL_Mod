package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class JutsuEventsHandler {
	@SubscribeEvent
	public void playerTick(PlayerTickEvent event) {
		if (event.player instanceof EntityPlayer) {
			// ExtendedProperties props = ExtendedProperties.get(event.player);
			JutsuHandler.iterateOverJutsus();

			if (event.player.worldObj.getWorldTime() % 100 == 0) {

			}

		}
	}
}
