package pl.grm.narutocraft.libs.buffs;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NCPotion extends Potion {
	private ResourceLocation	potionTexture;
	
	protected NCPotion(int par1, boolean par2, int par3) {
		super(par1, par2, par3);
	}
	
	public void setTextureSheet(String texturesheet) {
		this.potionTexture = new ResourceLocation("nc", texturesheet);
	}
	
	@SideOnly(Side.CLIENT)
	public int func_76392_e() {
		if (this.potionTexture != null) {
			Minecraft.getMinecraft().renderEngine.bindTexture(this.potionTexture);
		}
		return super.getStatusIconIndex();
	}
}
