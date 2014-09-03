package pl.grm.narutocraftmod.handlers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraftmod.hud.chakrabar.GuiChakraBar;
import pl.grm.narutocraftmod.libs.ExtendedPlayer;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/**
 * Event Handler of NCPL mod
 * 
 * @author Admaster
 *
 */
public class NCPLEventHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer
				&& ExtendedPlayer.get((EntityPlayer) event.entity) == null)
			ExtendedPlayer.register((EntityPlayer) event.entity);
		if (event.entity instanceof EntityPlayer
				&& event.entity
						.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(
					ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(
							(EntityPlayer) event.entity));
	}

	@SubscribeEvent
	public void onLivingFallEvent(LivingFallEvent event) 
	{
		if (event.entity instanceof EntityPlayer) 
		{
			ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) event.entity);
			if (event.distance > 3.0F && props.getCurrentChakra() > 0) 
			{
				System.out.println("[EVENT] Fall distance: " + event.distance);
				System.out.println("[EVENT] Current chakra: " + props.getCurrentChakra());
				float reduceby = props.getCurrentChakra() < (event.distance - 3.0F) ? props.getCurrentChakra() : (event.distance - 3.0F);
				event.distance -= reduceby;

				props.consumeChakra((int) reduceby);

				System.out.println("[EVENT] Adjusted fall distance: "
						+ event.distance);
			}
		}
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) 
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) 
		{
			ExtendedPlayer.loadProxyData((EntityPlayer) event.entity);
		}
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) 
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) 
		{
			ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
		}
	}

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) 
	{
		if (event.entity instanceof EntityPlayer) 
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			//ExtendedPlayer.get(player).onUpdate();
			if (event.entity.worldObj.getWorldTime() % 100 == 0)ExtendedPlayer.get(player).regenChakra(1);
			if (player.isPlayerFullyAsleep()) 
			{
				System.out.println("After a full night's rest, you feel refreshed!");
				ExtendedPlayer.get(player).replenishChakra();
			}
		}
	}

}