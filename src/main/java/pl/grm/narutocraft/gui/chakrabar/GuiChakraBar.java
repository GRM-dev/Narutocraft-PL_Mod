package pl.grm.narutocraft.gui.chakrabar;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.*;

import org.lwjgl.opengl.*;

import pl.grm.narutocraft.player.*;

/**
 * GUI showing current chakra on HUD
 */
public class GuiChakraBar extends Gui {
	private Minecraft				mc;
	private final ResourceLocation	texture	= new ResourceLocation("narutocraft",
													"textures/gui/chakra_bar3.png");
	private int						barW	= 54, barH = 9;
	
	public GuiChakraBar(Minecraft mc) {
		super();
		this.mc = mc;
	}
	
	public Minecraft getMc() {
		this.mc = Minecraft.getMinecraft();
		return this.mc;
	}
	
	public ResourceLocation getTexture() {
		return this.texture;
	}
	
	@SubscribeEvent(
			priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
		if (event.type != ElementType.EXPERIENCE) { return; }
		ExtendedProperties props = ExtendedProperties.get(this.mc.thePlayer);
		if ((props == null) || (props.getNinStats().getMaxChakra() == 0)) { return; }
		int xPos = 2;
		int yPos = 2;
		this.mc.getTextureManager().bindTexture(this.texture);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		drawTexturedModalRect(xPos, yPos, 0, 0, this.barW, this.barH);
		
		int chakrabarwidth = (props.getCurrentChakra() * this.barW)
				/ props.getNinStats().getMaxChakra();
		drawTexturedModalRect(xPos, yPos, 0, this.barH, chakrabarwidth, this.barH);
		String s = "Chakra " + props.getCurrentChakra() + "/" + props.getNinStats().getMaxChakra();
		yPos += this.barH + 2;
		this.mc.fontRendererObj.drawString(s, xPos + 1, yPos, 0);
		this.mc.fontRendererObj.drawString(s, xPos - 1, yPos, 0);
		this.mc.fontRendererObj.drawString(s, xPos, yPos + 1, 0);
		this.mc.fontRendererObj.drawString(s, xPos, yPos - 1, 0);
		this.mc.fontRendererObj.drawString(s, xPos, yPos, 8453920);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
	}
}
