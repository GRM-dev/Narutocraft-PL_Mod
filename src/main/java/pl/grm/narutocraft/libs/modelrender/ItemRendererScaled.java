package pl.grm.narutocraft.libs.modelrender;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRendererScaled implements IItemRenderer {
	private final float scale;

	public ItemRendererScaled(float scale) {
		this.scale = scale;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return (type == ItemRenderType.EQUIPPED)
				|| (type == ItemRenderType.EQUIPPED_FIRST_PERSON);
	}

	private void renderEquippedItem(ItemStack stack, EntityLivingBase entity,
			boolean firstPerson) {
		GL11.glPushMatrix(); // Push the render matrix out
		// Proceed to make alterations
		float f = this.scale;
		if (firstPerson) {
			f *= 1.75F;
			GL11.glTranslatef(-0.35F * this.scale, -0.125F * this.scale, 0.0F);
		} else {
			f *= (entity instanceof EntityPlayer ? 2.0F : 1.75F);
			GL11.glTranslatef(1.0F - f, -0.125F * this.scale,
					0.05F * this.scale);
		}
		GL11.glScalef(f, f, f);

		IIcon icon = stack.getItem().getIcon(stack, 0);
		Tessellator tessellator = Tessellator.instance;
		ItemRenderer.renderItemIn2D(tessellator, icon.getMaxU(),
				icon.getMinV(), icon.getMinU(), icon.getMaxV(),
				icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
		GL11.glPopMatrix();// Pop the render matrix back in with changes to be
							// used.
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
			case EQUIPPED_FIRST_PERSON :
				renderEquippedItem(item, (EntityLivingBase) data[1], true);
				break;
			case EQUIPPED :
				renderEquippedItem(item, (EntityLivingBase) data[1], false);
				break;
			default :
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return false;
	}
}
