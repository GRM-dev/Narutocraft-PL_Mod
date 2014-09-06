package pl.grm.narutocraft.weapons.projectiles.entities.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.libs.References;
import cpw.mods.fml.client.FMLClientHandler;
/**
 * Render method of Entity Shuriken with obj model file
 * 
 * @author Admaster
 *
 */
public class RenderShuriken extends Render {
	final ResourceLocation texture = new ResourceLocation(
			References.ModTexturePath + "models/obj/Shuriken.png");
	final ResourceLocation modelobj = new ResourceLocation(
			References.ModTexturePath + "models/obj/Shuriken.obj");
	private IModelCustom model;
	private int rotation = 0;
	private float scale = 0.01F;

	@Override
	public void doRender(Entity par1EntityShuriken, double var2, double var4,
			double var6, float var8, float var9) {
		this.model = AdvancedModelLoader.loadModel(modelobj);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) var2, (float) var4, (float) var6);
		FMLClientHandler.instance().getClient().getTextureManager()
				.bindTexture(texture);
		GL11.glRotatef(
				par1EntityShuriken.prevRotationYaw
						+ (par1EntityShuriken.rotationYaw - par1EntityShuriken.prevRotationYaw)
						* var9 - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(
				par1EntityShuriken.prevRotationPitch
						+ (par1EntityShuriken.rotationPitch - par1EntityShuriken.prevRotationPitch)
						* var9, 0.0F, 0.0F, 1.0F);
		GL11.glEnable(32826);
		GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);

		if (!par1EntityShuriken.onGround)
			onUpdate();

		GL11.glRotatef(-rotation, 0, 1, 0);
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef(-4.0F, 0.0F, 0.0F);

		model.renderAll();
		GL11.glPopMatrix();
	}

	public void renderSpecial() {
	}

	public void onUpdate() {
		rotation = (rotation + 1) % 360;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}
}
