package pl.grm.narutocraftmod.Libs;

import pl.grm.narutocraftmod.Libs.Registry.RegPowers;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;


public class NCPLFMLEventHandler {
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
	//event.entity;
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

	//kazdy tick

	}
}
