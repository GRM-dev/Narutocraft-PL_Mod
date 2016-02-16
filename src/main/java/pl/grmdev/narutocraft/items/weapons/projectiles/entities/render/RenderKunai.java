package pl.grmdev.narutocraft.items.weapons.projectiles.entities.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import pl.grmdev.narutocraft.items.weapons.projectiles.entities.EntityKunai;
import pl.grmdev.narutocraft.libs.config.References;

/**
 * Method Render EntityKunai
 *
 * @author Admaster
 */
public class RenderKunai extends Render {

	public RenderKunai() {
		super(Minecraft.getMinecraft().getRenderManager());
	}

	public RenderKunai(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(Entity par1EntityKunai, double var2, double var4, double var6, float var8, float var9) {
		this.bindTexture(this.getEntityTexture(null));
		WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
		GL11.glPushMatrix();
		GL11.glTranslatef((float) var2, (float) var4, (float) var6);
		GL11.glRotatef(
				(par1EntityKunai.prevRotationYaw
						+ ((par1EntityKunai.rotationYaw - par1EntityKunai.prevRotationYaw) * var9)) - 90.0F,
				0.0F, 1.0F, 0.0F);
		GL11.glRotatef(
				par1EntityKunai.prevRotationPitch
						+ ((par1EntityKunai.rotationPitch - par1EntityKunai.prevRotationPitch) * var9),
				0.0F, 0.0F, 1.0F);
		byte b0 = 0;
		float f2 = 0.0F;
		float f3 = 0.5F;
		float f4 = (0 + (b0 * 10)) / 32.0F;
		float f5 = (5 + (b0 * 10)) / 32.0F;
		float f6 = 0.0F;
		float f7 = 0.15625F;
		float f8 = (5 + (b0 * 10)) / 32.0F;
		float f9 = (10 + (b0 * 10)) / 32.0F;
		float f10 = 0.05625F;
		GL11.glEnable(32826);
		float f11 = EntityKunai.kunaiShake - var9;
		if (f11 > 0.0F) {
			float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
			GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
		}
		GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(f10, f10, f10);
		GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
		GL11.glNormal3f(f10, 0.0F, 0.0F);
		worldRenderer.begin(GL11.GL_QUADS, worldRenderer.getVertexFormat());
		addVertexData(worldRenderer, -7.0D, -2.0D, -2.0D, f6, f8);
		addVertexData(worldRenderer, -7.0D, -2.0D, 2.0D, f7, f8);
		addVertexData(worldRenderer, -7.0D, 2.0D, 2.0D, f7, f9);
		addVertexData(worldRenderer, -7.0D, 2.0D, -2.0D, f6, f9);
		worldRenderer.finishDrawing();
		GL11.glNormal3f(-f10, 0.0F, 0.0F);
		worldRenderer.begin(GL11.GL_QUADS, worldRenderer.getVertexFormat());
		addVertexData(worldRenderer, -7.0D, 2.0D, -2.0D, f6, f8);
		addVertexData(worldRenderer, -7.0D, 2.0D, 2.0D, f7, f8);
		addVertexData(worldRenderer, -7.0D, -2.0D, 2.0D, f7, f9);
		addVertexData(worldRenderer, -7.0D, -2.0D, -2.0D, f6, f9);
		worldRenderer.finishDrawing();
		for (int i = 0; i < 4; i++) {
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, f10);
			worldRenderer.begin(GL11.GL_QUADS, worldRenderer.getVertexFormat());
			addVertexData(worldRenderer, -8.0D, -2.0D, 0.0D, f2, f4);
			addVertexData(worldRenderer, 8.0D, -2.0D, 0.0D, f3, f4);
			addVertexData(worldRenderer, 8.0D, 2.0D, 0.0D, f3, f5);
			addVertexData(worldRenderer, -8.0D, 2.0D, 0.0D, f2, f5);
			worldRenderer.finishDrawing();
		}
		GL11.glDisable(32826);
		GL11.glPopMatrix();
	}

	private void addVertexData(WorldRenderer worldRenderer, double d, double e, double f, float f6, float f8) {
		worldRenderer.addVertexData(new int[]{(int) d, (int) e, (int) f, (int) f6, (int) f8});
	}

	public void renderSpecial() {
		GL11.glScalef(0.4F, 0.4F, 0.4F);
		GL11.glTranslatef(-0.4F, 0.5F, 0.1F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return new ResourceLocation(References.ModTexturePath + "textures/model/Kunai.png");
	}

}
