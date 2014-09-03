package pl.grm.narutocraft.itementities.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.itementities.EntityKunai;
import pl.grm.narutocraft.libs.References;
/**
 * Method Render EntityKunai
 * 
 * @author Admaster
 *
 */
public class RenderKunai extends Render {
	final ResourceLocation texture = new ResourceLocation(
			References.ModTexturePath + "textures/model/Kunai.png");

	@Override
	public void doRender(Entity par1EntityKunai, double var2, double var4,
			double var6, float var8, float var9) {
		this.bindTexture(texture);
		Tessellator tessellator = Tessellator.instance;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) var2, (float) var4, (float) var6);
		GL11.glRotatef(
				par1EntityKunai.prevRotationYaw
						+ (par1EntityKunai.rotationYaw - par1EntityKunai.prevRotationYaw)
						* var9 - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(
				par1EntityKunai.prevRotationPitch
						+ (par1EntityKunai.rotationPitch - par1EntityKunai.prevRotationPitch)
						* var9, 0.0F, 0.0F, 1.0F);
		byte b0 = 0;
		float f2 = 0.0F;
		float f3 = 0.5F;
		float f4 = (0 + b0 * 10) / 32.0F;
		float f5 = (5 + b0 * 10) / 32.0F;
		float f6 = 0.0F;
		float f7 = 0.15625F;
		float f8 = (5 + b0 * 10) / 32.0F;
		float f9 = (10 + b0 * 10) / 32.0F;
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
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, f6, f8);
		tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, f7, f8);
		tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, f7, f9);
		tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, f6, f9);
		tessellator.draw();
		GL11.glNormal3f(-f10, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, f6, f8);
		tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, f7, f8);
		tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, f7, f9);
		tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, f6, f9);
		tessellator.draw();
		for (int i = 0; i < 4; i++) {
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, f10);
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-8.0D, -2.0D, 0.0D, f2, f4);
			tessellator.addVertexWithUV(8.0D, -2.0D, 0.0D, f3, f4);
			tessellator.addVertexWithUV(8.0D, 2.0D, 0.0D, f3, f5);
			tessellator.addVertexWithUV(-8.0D, 2.0D, 0.0D, f2, f5);
			tessellator.draw();
		}
		GL11.glDisable(32826);
		GL11.glPopMatrix();
	}

	public void renderSpecial() {
		GL11.glScalef(0.4F, 0.4F, 0.4F);
		GL11.glTranslatef(-0.4F, 0.5F, 0.1F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {

		return null;
	}

}
