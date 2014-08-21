package pl.grm.narutocraftmod.Entities.Models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
/**
 * Model of {@link EntityLunai}
 * @author Admaster
 *
 */
public class ModelKunai extends ModelBase {
	ModelRenderer Pivot;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape2a;
	ModelRenderer Shape3a;
	ModelRenderer Uch1;
	ModelRenderer Uch2;
	ModelRenderer UchE;

	public ModelKunai() {
		textureWidth = 64;
		textureHeight = 64;

		Pivot = new ModelRenderer(this, 0, 0);
		Pivot.addBox(0F, 0F, 0F, 1, 1, 12);
		Pivot.setRotationPoint(0F, 0F, 0F);
		Pivot.setTextureSize(64, 64);
		Pivot.mirror = true;
		setRotation(Pivot, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 16);
		Shape2.addBox(0F, 0F, 0F, 1, 1, 6);
		Shape2.setRotationPoint(0F, -1F, 2F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 29);
		Shape3.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape3.setRotationPoint(0F, -2F, 4F);
		Shape3.setTextureSize(64, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape2a = new ModelRenderer(this, 0, 37);
		Shape2a.addBox(0F, 0F, 0F, 1, 1, 6);
		Shape2a.setRotationPoint(0F, 1F, 2F);
		Shape2a.setTextureSize(64, 64);
		Shape2a.mirror = true;
		setRotation(Shape2a, 0F, 0F, 0F);
		Shape3a = new ModelRenderer(this, 0, 24);
		Shape3a.addBox(0F, 0F, 0F, 1, 1, 3);
		Shape3a.setRotationPoint(0F, 2F, 4F);
		Shape3a.setTextureSize(64, 64);
		Shape3a.mirror = true;
		setRotation(Shape3a, 0F, 0F, 0F);
		Uch1 = new ModelRenderer(this, 0, 46);
		Uch1.addBox(0F, 0F, -1F, 1, 1, 2);
		Uch1.setRotationPoint(0F, -1F, 13F);
		Uch1.setTextureSize(64, 64);
		Uch1.mirror = true;
		setRotation(Uch1, 0F, 0F, 0F);
		Uch2 = new ModelRenderer(this, 0, 51);
		Uch2.addBox(0F, 0F, -1F, 1, 1, 2);
		Uch2.setRotationPoint(0F, 1F, 13F);
		Uch2.setTextureSize(64, 64);
		Uch2.mirror = true;
		setRotation(Uch2, 0F, 0F, 0F);
		UchE = new ModelRenderer(this, 0, 57);
		UchE.addBox(0F, 0F, -1F, 1, 1, 1);
		UchE.setRotationPoint(0F, 0F, 15F);
		UchE.setTextureSize(64, 64);
		UchE.mirror = true;
		setRotation(UchE, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Pivot.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape2a.render(f5);
		Shape3a.render(f5);
		Uch1.render(f5);
		Uch2.render(f5);
		UchE.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
