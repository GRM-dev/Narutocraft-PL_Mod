package pl.grm.narutocraftmod.hud.chakrabar;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraftmod.libs.ExtendedPlayer;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiChakraBar extends Gui {
	private Minecraft mc;
	private final ResourceLocation texture = new ResourceLocation(
			"narutocraftmod", "textures/gui/chakra_bar3.png");
	
	public int barW = 54, barH = 9;

	public ResourceLocation getTexture() {
		return texture;
	}

	public GuiChakraBar() {
	
	}

	public GuiChakraBar(Minecraft mc) {
		super();
		this.mc = mc;
	}

	public Minecraft getMc() {
		mc = Minecraft.getMinecraft();
		return mc;
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) 
	{
		/*GuiChakraBar guichakrabar = new GuiChakraBar();
		Minecraft mc = guichakrabar.getMc();*/
		//ResourceLocation texture = guichakrabar.getTexture();
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
		drawTexturedModalRect(xPos, yPos, 
				0, 0, 
				barW, barH);
		
		int manabarwidth = (int) (((float) props.getCurrentChakra() / 
				props.getMaxChakra()) * barW);
		
		drawTexturedModalRect(xPos, yPos, 0, barH,
				manabarwidth, barH);
		String s = "Chakra " + props.getCurrentChakra() + "/"
				+ props.getMaxChakra();
		yPos += barH + 2;
		mc.fontRenderer.drawString(s, xPos + 1, yPos, 0);
		mc.fontRenderer.drawString(s, xPos - 1, yPos, 0);
		mc.fontRenderer.drawString(s, xPos, yPos + 1, 0);
		mc.fontRenderer.drawString(s, xPos, yPos - 1, 0);
		mc.fontRenderer.drawString(s, xPos, yPos, 8453920);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
	}
	
	/*@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}
		ExtendedPlayer props = ExtendedPlayer.get(this.mc.thePlayer);

		if (props == null || props.getMaxChakra() == 0)
		{
			return;
		}
		int xPos = 2;
		int yPos = 2;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.mc.getTextureManager().bindTexture(texture);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		this.drawTexturedModalRect(xPos, yPos, 0, 0, barW, barH);
		int manabarwidth = (int)(((float) props.getCurrentChakra() / props.getMaxChakra()) * barW);
		this.drawTexturedModalRect(xPos, yPos, 0, barH, manabarwidth, barH);
	}*/
}
