package pl.grm.narutocraft.libs.modelrender;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NCPLModelRenderer extends ModelRenderer {
	private int displayList;
	private boolean compiled = false;
	@SuppressWarnings({"unchecked", "rawtypes"})
	public ArrayList<ModelWrapper> objs = new ArrayList();
	private boolean isTransparent = false;
	private float transparency;

	public NCPLModelRenderer(ModelBase par1ModelBase) {
		super(par1ModelBase);
	}

	public NCPLModelRenderer(ModelBase par1ModelBase, int par2, int par3) {
		super(par1ModelBase, par2, par3);
	}

	public NCPLModelRenderer(ModelBase par1ModelBase, String par2Str) {
		super(par1ModelBase, par2Str);
	}

	public void addCustomModel(ModelWrapper model) {
		this.objs.add(model);
	}

	@SideOnly(Side.CLIENT)
	private void compileDisplayList(float par1) {
		this.displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(this.displayList, 4864);
		Tessellator var2 = Tessellator.instance;
		for (int var3 = 0; var3 < this.cubeList.size(); var3++) {
			((ModelBox) this.cubeList.get(var3)).render(var2, par1);
		}
		GL11.glEndList();
		this.compiled = true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void render(float par1) {
		if ((!this.isHidden) && (this.showModel)) {
			if (!this.compiled) {
				compileDisplayList(par1);
			}
			GL11.glTranslatef(this.offsetX, this.offsetY, this.offsetZ);
			int var2;
			if ((this.rotateAngleX == 0.0F) && (this.rotateAngleY == 0.0F)
					&& (this.rotateAngleZ == 0.0F)) {
				if ((this.rotationPointX == 0.0F)
						&& (this.rotationPointY == 0.0F)
						&& (this.rotationPointZ == 0.0F)) {
					GL11.glCallList(this.displayList);
					renderCustomModels(par1);
					if (this.childModels != null) {
						for (var2 = 0; var2 < this.childModels.size();) {
							((NCPLModelRenderer) this.childModels.get(var2))
									.render(par1);
							var2++;
							continue;
						}
					}
				}
			}
			GL11.glTranslatef(-this.offsetX, -this.offsetY, -this.offsetZ);
		}
	}

	protected void renderCustomModels(float scale) {
		if (this.isTransparent) {
			GL11.glEnable(3042);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, this.transparency);
		}
		for (int i = 0; i < this.objs.size(); i++) {
			this.objs.get(i).render(scale);
		}
		if (this.isTransparent) {
			GL11.glDisable(3042);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	public void setTransparent(float transparency) {
		this.isTransparent = true;
		this.transparency = transparency;
	}
}
