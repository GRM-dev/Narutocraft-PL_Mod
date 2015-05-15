package pl.grm.narutocraft.mobs.bijuu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderKyuubi extends RenderLiving {

	private static final ResourceLocation Kyuubi_Texture = new ResourceLocation(
			"narutocraft:textures/entity/Kyuubi.png");

	public RenderKyuubi(ModelBase par1ModelBase, float par2) {
		super(Minecraft.getMinecraft().getRenderManager(), par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return Kyuubi_Texture;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		float scale = 10.0F;
		GL11.glScalef(scale, scale, scale);
	}
}
