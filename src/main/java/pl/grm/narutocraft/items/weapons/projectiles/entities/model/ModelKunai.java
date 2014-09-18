package pl.grm.narutocraft.items.weapons.projectiles.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
/**
 * Model of {@link EntityLunai}
 * 
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
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.Pivot = new ModelRenderer(this, 0, 0);
		this.Pivot.addBox(0F, 0F, 0F, 1, 1, 12);
		this.Pivot.setRotationPoint(0F, 0F, 0F);
		this.Pivot.setTextureSize(64, 64);
		this.Pivot.mirror = true;
		setRotation(this.Pivot, 0F, 0F, 0F);
		this.Shape2 = new ModelRenderer(this, 0, 16);
		this.Shape2.addBox(0F, 0F, 0F, 1, 1, 6);
		this.Shape2.setRotationPoint(0F, -1F, 2F);
		this.Shape2.setTextureSize(64, 64);
		this.Shape2.mirror = true;
		setRotation(this.Shape2, 0F, 0F, 0F);
		this.Shape3 = new ModelRenderer(this, 0, 29);
		this.Shape3.addBox(0F, 0F, 0F, 1, 1, 3);
		this.Shape3.setRotationPoint(0F, -2F, 4F);
		this.Shape3.setTextureSize(64, 64);
		this.Shape3.mirror = true;
		setRotation(this.Shape3, 0F, 0F, 0F);
		this.Shape2a = new ModelRenderer(this, 0, 37);
		this.Shape2a.addBox(0F, 0F, 0F, 1, 1, 6);
		this.Shape2a.setRotationPoint(0F, 1F, 2F);
		this.Shape2a.setTextureSize(64, 64);
		this.Shape2a.mirror = true;
		setRotation(this.Shape2a, 0F, 0F, 0F);
		this.Shape3a = new ModelRenderer(this, 0, 24);
		this.Shape3a.addBox(0F, 0F, 0F, 1, 1, 3);
		this.Shape3a.setRotationPoint(0F, 2F, 4F);
		this.Shape3a.setTextureSize(64, 64);
		this.Shape3a.mirror = true;
		setRotation(this.Shape3a, 0F, 0F, 0F);
		this.Uch1 = new ModelRenderer(this, 0, 46);
		this.Uch1.addBox(0F, 0F, -1F, 1, 1, 2);
		this.Uch1.setRotationPoint(0F, -1F, 13F);
		this.Uch1.setTextureSize(64, 64);
		this.Uch1.mirror = true;
		setRotation(this.Uch1, 0F, 0F, 0F);
		this.Uch2 = new ModelRenderer(this, 0, 51);
		this.Uch2.addBox(0F, 0F, -1F, 1, 1, 2);
		this.Uch2.setRotationPoint(0F, 1F, 13F);
		this.Uch2.setTextureSize(64, 64);
		this.Uch2.mirror = true;
		setRotation(this.Uch2, 0F, 0F, 0F);
		this.UchE = new ModelRenderer(this, 0, 57);
		this.UchE.addBox(0F, 0F, -1F, 1, 1, 1);
		this.UchE.setRotationPoint(0F, 0F, 15F);
		this.UchE.setTextureSize(64, 64);
		this.UchE.mirror = true;
		setRotation(this.UchE, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Pivot.render(f5);
		this.Shape2.render(f5);
		this.Shape3.render(f5);
		this.Shape2a.render(f5);
		this.Shape3a.render(f5);
		this.Uch1.render(f5);
		this.Uch2.render(f5);
		this.UchE.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
