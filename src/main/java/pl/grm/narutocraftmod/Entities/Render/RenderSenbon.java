package pl.grm.narutocraftmod.Entities.Render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraftmod.Entities.EntitySenbon;

public class RenderSenbon extends Render {
	final ResourceLocation texture = new ResourceLocation("narutocraftmod:models/obj/Shuriken.png");
	final ResourceLocation model = new ResourceLocation("narutocraftmod:models/obj/Shuriken.obj");

	@Override
	public void doRender(Entity par1EntitySenbon, double var2, double var4, double var6, float var8, float var9) 
	{
		Tessellator tessellator = Tessellator.instance;
		IModelCustom modelSenbon = AdvancedModelLoader.loadModel(model);

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
