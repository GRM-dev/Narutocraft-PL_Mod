package pl.grm.narutocraft.items.weapons.projectiles.entities.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.libs.config.References;

/**
 * Render method of Entity
 *
 * @author Admaster
 */
public class RenderSenbon extends Render {

	public RenderSenbon(RenderManager p_i46179_1_) {
		super(p_i46179_1_);
	}

	final ResourceLocation texture = new ResourceLocation(References.ModTexturePath + "models/obj/Senbon.png");
	final ResourceLocation modelobj = new ResourceLocation(References.ModTexturePath + "models/obj/Senbon.obj");

	@Override
	public void doRender(Entity par1EntitySenbon, double var2, double var4, double var6, float var8, float var9) {
		float scale = 0.1F;

		GL11.glPushMatrix();
		GL11.glTranslated(var2, var4, var6);
		GL11.glScalef(scale, scale, scale);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(this.texture);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		GL11.glPopMatrix();
	}

	public void renderSpecial() {}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return this.texture;
	}
}
