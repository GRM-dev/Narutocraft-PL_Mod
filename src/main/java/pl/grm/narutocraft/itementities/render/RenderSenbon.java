package pl.grm.narutocraft.itementities.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
/**
 * Render method of Entity
 * @author Admaster
 *
 */
public class RenderSenbon extends Render {
	final ResourceLocation texture = new ResourceLocation(
			"narutocraftmod:models/obj/Senbon.png");
	final ResourceLocation modelobj = new ResourceLocation(
			"narutocraftmod:models/obj/Senbon.obj");
	private IModelCustom model;

	@Override
	public void doRender(Entity par1EntitySenbon, double var2, double var4,
			double var6, float var8, float var9) {
		this.model = AdvancedModelLoader.loadModel(modelobj);

		GL11.glPushMatrix();
		GL11.glTranslated(var2, var4, var6);
		GL11.glScalef(1, 1, 1);
		FMLClientHandler.instance().getClient().getTextureManager()
				.bindTexture(texture);
		GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
		model.renderAll();
		GL11.glPopMatrix();
	}

	public void renderSpecial() {
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}
}
