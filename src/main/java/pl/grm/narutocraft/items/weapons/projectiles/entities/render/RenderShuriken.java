package pl.grm.narutocraft.items.weapons.projectiles.entities.render;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.fml.client.*;

import org.lwjgl.opengl.*;

import pl.grm.narutocraft.libs.config.References;

/**
 * Render method of Entity Shuriken with obj model file
 *
 * @author Admaster
 */
public class RenderShuriken extends Render {
	public RenderShuriken(RenderManager p_i46179_1_) {
		super(p_i46179_1_);
	}
	
	final ResourceLocation	texture		= new ResourceLocation(References.ModTexturePath
												+ "models/obj/Shuriken.png");
	final ResourceLocation	modelobj	= new ResourceLocation(References.ModTexturePath
												+ "models/obj/Shuriken.obj");
	private int				rotation	= 0;
	private float			scale		= 0.01F;
	
	@Override
	public void doRender(Entity par1EntityShuriken, double var2, double var4, double var6,
			float var8, float var9) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) var2, (float) var4, (float) var6);
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(this.texture);
		GL11.glRotatef(
				(par1EntityShuriken.prevRotationYaw + ((par1EntityShuriken.rotationYaw - par1EntityShuriken.prevRotationYaw) * var9)) - 90.0F,
				0.0F, 1.0F, 0.0F);
		GL11.glRotatef(
				par1EntityShuriken.prevRotationPitch
						+ ((par1EntityShuriken.rotationPitch - par1EntityShuriken.prevRotationPitch) * var9),
				0.0F, 0.0F, 1.0F);
		GL11.glEnable(32826);
		GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
		
		if (!par1EntityShuriken.onGround) {
			onUpdate();
		}
		
		GL11.glRotatef(-this.rotation, 0, 1, 0);
		GL11.glScalef(this.scale, this.scale, this.scale);
		GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
		GL11.glPopMatrix();
	}
	
	public void onUpdate() {
		this.rotation = (this.rotation + 1) % 360;
	}
	
	public void renderSpecial() {}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return this.texture;
	}
}
