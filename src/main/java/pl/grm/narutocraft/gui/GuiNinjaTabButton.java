package pl.grm.narutocraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.libs.config.References;

public class GuiNinjaTabButton extends GuiButton {

	public static ResourceLocation res = new ResourceLocation(References.MODID + ":" + "textures/gui/myButton.png");

	public GuiNinjaTabButton(int par1, int par2, int par3) {
		super(par1, par2, par3, "");
		this.width = 22;
		this.height = 22;
	}

	// TODO rework this class to use a image instead of a Icon
	@Override
	public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
		if (this.visible) {
			p_146112_1_.getTextureManager().bindTexture(References.ninjaWidgetsPath);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = (p_146112_2_ >= this.xPosition) && (p_146112_3_ >= this.yPosition)
					&& (p_146112_2_ < (this.xPosition + this.width)) && (p_146112_3_ < (this.yPosition + this.height));
			int k = this.getHoverState(this.hovered);
			GL11.glEnable(GL11.GL_BLEND);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			this.drawTexturedModalRect(this.xPosition, this.yPosition, k == 1 ? 0 : 22, 0, 22, 22);
			TextureManager manager = Minecraft.getMinecraft().renderEngine;
			manager.bindTexture(res);
			// RENDER ITEMS
			this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
			/*
			 * int l = 14737632; if (packedFGColour != 0) { l = packedFGColour;
			 * } else if (!this.enabled) { l = 10526880; } else if
			 * (this.field_146123_n) { l = 16777120; }
			 * this.drawCenteredString(fontrenderer, this.displayString,
			 * this.xPosition + this.width / 2, this.yPosition + (this.height -
			 * 8) / 2, l);
			 */
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
