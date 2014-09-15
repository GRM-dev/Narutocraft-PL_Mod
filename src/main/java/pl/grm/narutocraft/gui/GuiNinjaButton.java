package pl.grm.narutocraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.libs.References;

public class GuiNinjaButton extends GuiButton
{
	public static final ResourceLocation tex = 
			new ResourceLocation(References.ModTexturePath+"textures/gui/NinjaGuiWidgets.png");
	private IIcon icon;
	private String type;

	public GuiNinjaButton(int par1, int par2, int par3, IIcon par4)
	{
		super(par1, par2, par3, "");
		icon = par4;
		this.width = 20;
        this.height = 20;
	}
	
	public GuiNinjaButton(int par1, int par2, int par3, String type)
	{
		super(par1, par2, par3, "");
		this.type = type;
		this.width = 7;
        this.height = 7;
	}
	
	@Override
	protected int getHoverState(boolean p_146114_1_)
	{
		byte b0 = 1;
	
	    if (!this.enabled)
	    {
	        b0 = 0;
	    }
	    else if (p_146114_1_)
	    {
	        b0 = 2;
	    }
	
	    return b0;
	}
	
	@Override
	public void drawButton(Minecraft p_146112_1_, int p_146112_2_,
			int p_146112_3_)
	{
		if (this.visible)
        {
			FontRenderer fontrenderer = p_146112_1_.fontRenderer;
            p_146112_1_.getTextureManager().bindTexture(tex);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int k = this.getHoverState(this.field_146123_n);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			if (type != null)
            {
            	if (type.equals("plus"))
            	{
            		this.drawTexturedModalRect(this.xPosition, this.yPosition, k == 1 ? 0 : 7, 42, 7, 7);
            	}
            }
			else
			{	            
	            this.drawTexturedModalRect(this.xPosition, this.yPosition, k == 1 ? 0 : 20, 22, 20, 20);
	            if (icon != null)
	            {
		            TextureManager manager = Minecraft.getMinecraft().renderEngine;
		            manager.bindTexture(manager.getResourceLocation(1));
		            //RENDER ITEMS
		            
		            drawTexturedModelRectFromIcon(this.xPosition + 2, this.yPosition + 2, icon, 16, 16);
	            }	            
			}
			this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
            int l = 14737632;

            if (packedFGColour != 0)
            {
                l = packedFGColour;
            }
            else if (!this.enabled)
            {
                l = 10526880;
            }
            else if (this.field_146123_n)
            {
                l = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }
	}

}
