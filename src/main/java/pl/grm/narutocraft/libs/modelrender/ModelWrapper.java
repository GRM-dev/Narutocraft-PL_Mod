package pl.grm.narutocraft.libs.modelrender;

import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class ModelWrapper {
	public IModelCustom	model;
	int					frame	= 0;
	float				offsetX	= 0.0F;
	float				offsetY	= 0.0F;
	float				offsetZ	= 0.0F;
	
	public ModelWrapper(IModelCustom m) {
		this.model = m;
	}
	
	public ModelWrapper(IModelCustom m, float x, float y, float z) {
		this.model = m;
		this.offsetX = x;
		this.offsetY = y;
		this.offsetZ = z;
	}
	
	public void render(float scale) {
		GL11.glPushMatrix();
		GL11.glScalef(scale, scale, scale);
		
		GL11.glTranslatef(this.offsetX, this.offsetZ, this.offsetY);
		this.model.renderAll();
		GL11.glPopMatrix();
	}
	
	public void renderSmd(float scale) {
		GL11.glPushMatrix();
		GL11.glScalef(scale, scale, scale);
		this.model.renderAll();
		GL11.glPopMatrix();
	}
	
	public ModelWrapper setOffsets(float x, float y, float z) {
		this.offsetX = x;
		this.offsetY = y;
		this.offsetZ = z;
		return this;
	}
}
