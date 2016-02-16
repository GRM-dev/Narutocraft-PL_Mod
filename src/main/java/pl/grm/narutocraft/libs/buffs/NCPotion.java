package pl.grm.narutocraft.libs.buffs;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import pl.grm.narutocraft.libs.config.References;

public class NCPotion extends Potion {

	private static ResourceLocation potionTexture;

	protected NCPotion(int par1, boolean par2, int par3) {
		super(setTextureSheet("empty"), par2, par3);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getStatusIconIndex() {
		if (NCPotion.potionTexture != null) {
			Minecraft.getMinecraft().renderEngine.bindTexture(NCPotion.potionTexture);
		}
		return super.getStatusIconIndex();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon() {
		setTextureSheet("buffs_1.png");
		Minecraft.getMinecraft().renderEngine.bindTexture(NCPotion.potionTexture);
		return true;
	}

	public static ResourceLocation setTextureSheet(String texturesheet) {
		NCPotion.potionTexture = new ResourceLocation(References.GUI_TEXTURE_PATH + texturesheet);
		return NCPotion.potionTexture;
	}

	@Override
	protected Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}
}
