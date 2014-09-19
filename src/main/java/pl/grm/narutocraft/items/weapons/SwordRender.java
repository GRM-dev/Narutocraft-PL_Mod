package pl.grm.narutocraft.items.weapons;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class SwordRender implements IItemRenderer {
	
	// protected dagger SwordModel;
	
	public SwordRender() {
		// SwordModel = new dagger();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
			case EQUIPPED :
				return true;
			case EQUIPPED_FIRST_PERSON :
				return true;
			default :
				return false;
		}
	}
	
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		switch (type) {
			case EQUIPPED :
			case EQUIPPED_FIRST_PERSON : {
				
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.getTexture(new ResourceLocation(
						"/assets/tutorial/textures/model/dagger.png")); // NEED
																		// TO
																		// FIX
																		// THIS
				
				float scale = 1.4F;
				GL11.glScalef(scale, scale, scale);
				GL11.glRotatef(90, -1, 0, 0);
				GL11.glRotatef(85, 0, 0, 1);
				GL11.glRotatef(180, 0, 1, 0);
				GL11.glRotatef(135, 1, 0, 0);
				GL11.glTranslatef(-0.1F, -0.5F, 0.5F); // Left-Right
				// Forward-Backwards Up-Down
				SwordModel
						.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				
				GL11.glPopMatrix();
			}
			default :
				break;
		}
	}
	
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		
		return false;
	}
}