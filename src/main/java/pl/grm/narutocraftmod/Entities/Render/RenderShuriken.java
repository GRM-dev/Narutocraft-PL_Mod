package pl.grm.narutocraftmod.Entities.Render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraftmod.Entities.EntityShuriken;
import cpw.mods.fml.client.FMLClientHandler;

public class RenderShuriken extends Render {
	final ResourceLocation texture = new ResourceLocation("narutocraftmod:models/obj/Shuriken.png");
	final ResourceLocation modelobj = new ResourceLocation("narutocraftmod:models/obj/Shuriken.obj");
	private IModelCustom model;
	
	@Override
	public void doRender(Entity par1EntityShuriken, double var2, double var4, double var6, float var8, float var9) 
	{
		Tessellator tessellator = Tessellator.instance;
		this.model = AdvancedModelLoader.loadModel(modelobj);

		GL11.glPushMatrix();
		GL11.glTranslatef((float)var2, (float)var4, (float)var6);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(texture);
		GL11.glRotatef(par1EntityShuriken.prevRotationYaw + (par1EntityShuriken.rotationYaw - par1EntityShuriken.prevRotationYaw) * var9 - 90.0F, 0.0F, 1.0F, 0.0F);
	    GL11.glRotatef(par1EntityShuriken.prevRotationPitch + (par1EntityShuriken.rotationPitch - par1EntityShuriken.prevRotationPitch) * var9, 0.0F, 0.0F, 1.0F);
	    byte b0 = 0;
	    float f2 = 0.0F;
	    float f3 = 0.5F;
	    float f4 = (0 + b0 * 10) / 32.0F;
	    float f5 = (32 + b0 * 10) / 32.0F;
	    float f6 = 0.0F;
	    float f7 = 1.0F;
	    float f8 = (32 + b0 * 10) / 32.0F;
	    float f9 = (64 + b0 * 10) / 32.0F;
	    float f10 = 0.01F;
	    GL11.glEnable(32826);
	    float f11 = EntityShuriken.ShurikenShake - var9;
	    if (f11 > 0.0F)
	    {
	      float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
	      GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
	    }
	    GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
	    GL11.glScalef(f10, f10, f10);
	    GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
	    
		model.renderAll();
		GL11.glPopMatrix();
	}

	public void renderSpecial()
	{
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) 
	{
		return texture;
	}
}
