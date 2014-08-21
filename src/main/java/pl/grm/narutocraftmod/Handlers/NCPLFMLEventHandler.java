package pl.grm.narutocraftmod.Handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import pl.grm.narutocraftmod.Libs.Registry.RegPowers;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

/**
 * FML Event Handler
 * @author Admaster
 *
 */
public class NCPLFMLEventHandler {
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
	if (event.entity instanceof EntityPlayer)
	{
		EntityPlayer player = (EntityPlayer) event.entity;
		ItemStack heldItem = player.getHeldItem();
		System.out.println("hhhhhhh");
		if (heldItem != null && heldItem.getItem() == RegPowers.KNoJutsu) {
			player.capabilities.allowFlying = true;
		}
		else {
			player.capabilities.allowFlying = player.capabilities.isCreativeMode ? true : false;
			}
		}
	}
	
	@SubscribeEvent
	public void onRenderTick(RenderTickEvent event) {

	}
}
