package pl.grm.narutocraft.gui;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.libs.References;

public class GuiNinjaStats extends GuiContainer
{
	public static final ResourceLocation texture1 = 
			new ResourceLocation(References.ModTexturePath+"textures/gui/SkillTree_Utility.png");
	public static final ResourceLocation texture2 = 
			new ResourceLocation(References.ModTexturePath+"textures/gui/SkillTreeUI.png");
	
	private EntityPlayer player;
	private int pad = 4;
	private int ch = 20;
	private Boolean jutsuMenu = false;

	public GuiNinjaStats(EntityPlayer player)
	{
		super(new ContainerNull());
		
		this.player = player;
		xSize = jutsuMenu ? 210 : 256;
		ySize = jutsuMenu ? 210 : 256;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) 
	{	
		xSize = jutsuMenu ? 210 : 256;
		ySize = jutsuMenu ? 210 : 256;
		
		/*TextureManager manager = Minecraft.getMinecraft().renderEngine;
	    manager.bindTexture(manager.getResourceLocation(1));
	    //RENDER ITEMS
	    
	    drawTexturedModelRectFromIcon(300, 300, RotItems.itemGunpowderInfuser.getIconFromDamage(0), 16, 16);*/	
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(jutsuMenu ? texture2 : texture1);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		this.buttonList.clear();
		//Start with main control buttons
		
		int x1 = guiLeft;
		int x2 = (guiLeft + xSize) - (22);
		int x3 = (x2 + x1) / 2;
		
		this.buttonList.add(new GuiNinjaTab(0, x2, guiTop - 22, Items.apple.getIconFromDamage(0)));
		//this.drawString(fontRendererObj, ExtendPlayer.classNames[selectedClass], x3, guiTop + pad + 5, 0xddeeee);
		this.buttonList.add(new GuiNinjaTab(1, x1, guiTop - 22, Items.apple.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(2, x1 + 22, guiTop - 22, Items.apple.getIconFromDamage(0)));
		
		//this.drawString(fontRendererObj, "Current Class: " + ExtendPlayer.get(player).getCurrentClassName(), guiLeft + pad, guiTop + pad + 45, 0xdbdd15);

		//Visual information on location
		/*this.drawString(fontRendererObj, "X: "+(xOffset+te.xCoord)+" offSet: "+xOffset, (startLeft + ((gridSizeX * 2) * cw)) + cw * 5, (startTop + (gridSizeZ * ch) + 4) - ch, 0xFFFFFF);
		this.drawString(fontRendererObj, "Y: "+(yOffset+te.yCoord)+" offSet: "+yOffset, (startLeft + ((gridSizeX * 2) * cw)) + cw * 5, (startTop + (gridSizeZ * ch) + 4), 0xFFFFFF);
		this.drawString(fontRendererObj, "Z: "+(zOffset+te.zCoord)+" offSet: "+zOffset, (startLeft + ((gridSizeX * 2) * cw)) + cw * 5, (startTop + (gridSizeZ * ch) + 4) + ch, 0xFFFFFF);*/
	}
	
	/** Button Clicks **/
	@Override
	protected void actionPerformed(GuiButton button) 
	{	
		switch (button.id)
		{
			case 0: // Class Forward
				break;
			case 1: // Class Back
				break;
			case 2: // Change Class
				jutsuMenu = !jutsuMenu;
				break;			
		}
	}
	
	/** Keyboard Clicks **/
	@Override
	protected void keyTyped(char par1, int par2)
	{		
		if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.getKeyCode())
        {
            this.mc.thePlayer.closeScreen();
        }		
	}
}
