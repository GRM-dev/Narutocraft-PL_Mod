package pl.grmdev.narutocraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import pl.grmdev.narutocraft.libs.config.References;

import org.lwjgl.opengl.GL11;

/**
 * Button to mod GUIs
 */
public class GuiNinjaButton extends GuiButton {

	private String type;

	public GuiNinjaButton(int par1, int par2, int par3) {
		super(par1, par2, par3, "");
		this.width = 20;
		this.height = 20;
	}

	public GuiNinjaButton(int par1, int par2, int par3, String type) {
		super(par1, par2, par3, "");
		this.type = type;
		this.width = 7;
		this.height = 7;
	}

	// TODO I'd prefer this to use Icons, which it does. But as of 19/09/2014
	// Jutsu are not giving up their Icons.
	@Override
	public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
		if (this.visible) {
			FontRenderer fontrenderer = p_146112_1_.fontRendererObj;
			p_146112_1_.getTextureManager().bindTexture(References.ninjaWidgetsPath);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = (p_146112_2_ >= this.xPosition) && (p_146112_3_ >= this.yPosition)
					&& (p_146112_2_ < (this.xPosition + this.width)) && (p_146112_3_ < (this.yPosition + this.height));
			int k = this.getHoverState(this.hovered);
			GL11.glEnable(GL11.GL_BLEND);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			if (this.type != null) {
				if (this.type.equals("plus")) {
					this.drawTexturedModalRect(this.xPosition, this.yPosition, k == 1 ? 0 : 7, 42, 7, 7);
				}
			} else {
				this.drawTexturedModalRect(this.xPosition, this.yPosition, k == 1 ? 0 : 20, 22, 20, 20);
			}
			this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
			int l = 14737632;

			if (this.packedFGColour != 0) {
				l = this.packedFGColour;
			} else if (!this.enabled) {
				l = 10526880;
			} else if (this.hovered) {
				l = 16777120;
			}

			this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + (this.width / 2), this.yPosition
					+ ((this.height - 8) / 2), l);
		}
	}

	@Override
	protected int getHoverState(boolean p_146114_1_) {
		byte b0 = 1;

		if (!this.enabled) {
			b0 = 0;
		} else if (p_146114_1_) {
			b0 = 2;
		}
		return b0;
	}
}
