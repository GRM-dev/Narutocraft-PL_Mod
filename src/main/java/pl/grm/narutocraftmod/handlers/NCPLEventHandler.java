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

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import pl.grm.narutocraftmod.hud.ChakraBar.GuiChakraBar;
import pl.grm.narutocraftmod.libs.ExtendedPlayer;
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
	public void onLivingFallEvent(LivingFallEvent event) {
		if (event.entity instanceof EntityPlayer) {
			ExtendedPlayer props = ExtendedPlayer
					.get((EntityPlayer) event.entity);
			if (event.distance > 3.0F && props.getCurrentChakra() > 0) {
				System.out.println("[EVENT] Fall distance: " + event.distance);
				System.out.println("[EVENT] Current chakra: "
						+ props.getCurrentChakra());
				float reduceby = props.getCurrentChakra() < (event.distance - 3.0F)
						? props.getCurrentChakra()
						: (event.distance - 3.0F);
				event.distance -= reduceby;

				props.consumeChakra((int) reduceby);

				System.out.println("[EVENT] Adjusted fall distance: "
						+ event.distance);
			}
		}
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (!event.entity.worldObj.isRemote
				&& event.entity instanceof EntityPlayer) {
			ExtendedPlayer.loadProxyData((EntityPlayer) event.entity);
		}
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (!event.entity.worldObj.isRemote
				&& event.entity instanceof EntityPlayer) {
			ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
		}
	}

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			ExtendedPlayer.get(player).onUpdate();
			if (player.isPlayerFullyAsleep()) {
				System.out
						.println("After a full night's rest, you feel refreshed!");
				ExtendedPlayer.get(player).replenishChakra();
			}
		}
	}
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
		GuiChakraBar guichakrabar = new GuiChakraBar();
		Minecraft mc = guichakrabar.getMc();
		ResourceLocation texture = guichakrabar.getTexture();
		if (event.type != ElementType.EXPERIENCE) {
			return;
		}

		ExtendedPlayer props = ExtendedPlayer.get(mc.thePlayer);
		if (props == null || props.getMaxChakra() == 0) {
			return;
		}

		int xPos = 2;
		int yPos = 2;
		mc.getTextureManager().bindTexture(texture);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		/**
		 * Draw the background bar which contains a transparent section; note
		 * the new size
		 */
		guichakrabar.drawTexturedModalRect(xPos, yPos, 0, 0, 56, 9);
		int manabarwidth = (int) (((float) props.getCurrentChakra() / props
				.getMaxChakra()) * 49);
		guichakrabar.drawTexturedModalRect(xPos + 3, yPos + 3, 0, 9,
				manabarwidth, 3);
		String s = "Chakra " + props.getCurrentChakra() + "/"
				+ props.getMaxChakra();
		yPos += 10;
		mc.fontRenderer.drawString(s, xPos + 1, yPos, 0);
		mc.fontRenderer.drawString(s, xPos - 1, yPos, 0);
		mc.fontRenderer.drawString(s, xPos, yPos + 1, 0);
		mc.fontRenderer.drawString(s, xPos, yPos - 1, 0);
		mc.fontRenderer.drawString(s, xPos, yPos, 8453920);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
	}

}