package pl.grm.narutocraftmod.Entities.Render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

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
		GL11.glScalef(0.01F, 0.01F, 0.01F);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(texture);
		GL11.glRotatef(par1EntityShuriken.prevRotationYaw + (par1EntityShuriken.rotationYaw - par1EntityShuriken.prevRotationYaw) * var9 - 90.0F, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(par1EntityShuriken.prevRotationPitch + (par1EntityShuriken.rotationPitch - par1EntityShuriken.prevRotationPitch) * var9, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90F, 0.0F, 0.0F, 1.0F);
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
