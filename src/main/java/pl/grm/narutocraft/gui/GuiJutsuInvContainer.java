package pl.grm.narutocraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.libs.References;

public class GuiJutsuInvContainer extends GuiContainer {
	private float							xSize_lo, ySize_lo;
	private EntityPlayer					player;
	private static final ResourceLocation	iconLocation	= new ResourceLocation(
																	References.ModTexturePath
																			+ "textures/gui/jutsuGUI.png");
	private final JutsuInv					inventory;
	
	public GuiJutsuInvContainer(EntityPlayer player, InventoryPlayer inventoryPlayer,
			JutsuInv inventoryCustom) {
		super(new ContainerNCPLPlayer(player, inventoryPlayer, inventoryCustom));
		this.inventory = inventoryCustom;
		this.player = player;
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		super.drawScreen(par1, par2, par3);
		this.xSize_lo = par1;
		this.ySize_lo = par2;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(iconLocation);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		String s = this.inventory.hasCustomInventoryName() ? this.inventory
				.getInventoryName() : I18n.format(this.inventory.getInventoryName());
		this.fontRendererObj.drawString(s, 5, 25, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), this.xSize
				- this.fontRendererObj.getStringWidth(s), this.ySize - 96, 4210752);
	}
}
