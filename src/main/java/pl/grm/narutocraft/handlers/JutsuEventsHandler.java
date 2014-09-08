package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class JutsuEventsHandler {
	JutsuHandler jH = new JutsuHandler();

	@SubscribeEvent
	public void playerTick(PlayerTickEvent event) {
		if (event.player instanceof EntityPlayer) {
			// ExtendedProperties props = ExtendedProperties.get(event.player);
			jH.iterateOverJutsus();

			if (event.player.worldObj.getWorldTime() % 100 == 0) {

			}
		}
	}
}
