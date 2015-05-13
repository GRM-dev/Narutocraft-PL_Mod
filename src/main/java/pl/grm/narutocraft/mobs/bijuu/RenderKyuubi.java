package pl.grm.narutocraft.mobs.bijuu;

import net.minecraft.client.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

import org.lwjgl.opengl.*;

public class RenderKyuubi extends RenderLiving {
	private static final ResourceLocation	Kyuubi_Texture	= new ResourceLocation(
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
