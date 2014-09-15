package pl.grm.narutocraft.gui;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.libs.ExtendedProperties;
import pl.grm.narutocraft.libs.References;
import pl.grm.narutocraft.libs.registry.RegItems;
import pl.grm.narutocraft.libs.registry.RegJutsus;

public class GuiNinjaStats extends GuiContainer
{
	public static final ResourceLocation stats = 
			new ResourceLocation(References.ModTexturePath+"textures/gui/SkillTree_Utility.png");
	public static final ResourceLocation[] jutsu = 
			new ResourceLocation[]
					{
						new ResourceLocation(References.ModTexturePath+"textures/gui/JutsuPage1.png"),
						new ResourceLocation(References.ModTexturePath+"textures/gui/JutsuPage2.png"),
						new ResourceLocation(References.ModTexturePath+"textures/gui/JutsuPage3.png"),
						new ResourceLocation(References.ModTexturePath+"textures/gui/JutsuPage4.png"),
						new ResourceLocation(References.ModTexturePath+"textures/gui/JutsuPage5.png"),
						new ResourceLocation(References.ModTexturePath+"textures/gui/JutsuPage6.png")
					};
	public static final ResourceLocation ninjaWidgets = 
			new ResourceLocation(References.ModTexturePath+"textures/gui/NinjaGuiWidgets.png");
	
	private EntityPlayer player;
	private int padLeft = 44, padTop = 27;
	private Boolean jutsuMenu = false;
	private int jutsuPage = 0;

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
		Minecraft.getMinecraft().renderEngine.bindTexture(jutsuMenu ? jutsu[jutsuPage] : stats);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		this.buttonList.clear();
		//Start with main control buttons
		
		int x1 = guiLeft;
		int x2 = (guiLeft + xSize) - (22);
		int x3 = (x2 + x1) / 2;
		
		//Controls
		this.buttonList.add(new GuiNinjaTab(0, x2, guiTop - 22, RegJutsus.Enmakugire.getIconFromDamage(0)));//Stats page		
		this.buttonList.add(new GuiNinjaTab(1, x1, guiTop - 22, Items.apple.getIconFromDamage(0)));//Jutsu
		this.buttonList.add(new GuiNinjaTab(2, x1 + 22, guiTop - 22, Items.apple.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(3, x1 + 22 * 2, guiTop - 22, Items.apple.getIconFromDamage(0)));//Jutsu
		this.buttonList.add(new GuiNinjaTab(4, x1 + 22 * 3, guiTop - 22, Items.apple.getIconFromDamage(0)));
		this.buttonList.add(new GuiNinjaTab(5, x1 + 22 * 4, guiTop - 22, Items.apple.getIconFromDamage(0)));//Jutsu
		this.buttonList.add(new GuiNinjaTab(6, x1 + 22 * 5, guiTop - 22, Items.apple.getIconFromDamage(0)));
		
		//Stats
		ExtendedProperties props = ExtendedProperties.get(player);
		if (!jutsuMenu)
		{
			this.drawString(fontRendererObj, "Ninja Level: " + props.psa.getNinjaLevel(), guiLeft + 175, guiTop + 9, 0xddeeee);
			if (props.psa.skillPoints > 0)
				this.drawString(fontRendererObj, "Skill Points: " + props.psa.skillPoints, guiLeft + padLeft, guiTop + 9, 0xddeeee);
			Minecraft.getMinecraft().renderEngine.bindTexture(ninjaWidgets);
			drawTexturedModalRect(guiLeft + 132, guiTop + 12, 66, 0, 39, 4);
			drawTexturedModalRect(guiLeft + 132, guiTop + 12, 66, 4, 
					(int)(props.psa.getCurrentNinjaXp() * 39 / 
							props.psa.getNinjaXpCap()), 4);
			
			this.drawString(fontRendererObj, "Stats (3 points)", guiLeft + padLeft, guiTop + padTop + 9, 0xddeeee);
			this.drawString(fontRendererObj, "Strength: " + props.psa.getStrength(), guiLeft + padLeft, guiTop + padTop + 9 * 2, 0xddeeee);
			this.drawString(fontRendererObj, "Resistance: " + props.psa.getResistance(), guiLeft + padLeft, guiTop + padTop + 9 * 3, 0xddeeee);			
			this.drawString(fontRendererObj, "Dexterity: " + props.psa.getDexterity(), guiLeft + padLeft, guiTop + padTop + 9 * 4, 0xddeeee);
			this.drawString(fontRendererObj, "Agility: " + props.psa.getAgility(), guiLeft + padLeft, guiTop + padTop + 9 * 5, 0xddeeee);
			if (props.psa.skillPoints >= 3)
			{
				this.buttonList.add(new GuiNinjaButton(7, guiLeft + padLeft + 70, guiTop + padTop + 9 * 2, "plus"));
				this.buttonList.add(new GuiNinjaButton(8, guiLeft + padLeft + 70, guiTop + padTop + 9 * 3, "plus"));
				this.buttonList.add(new GuiNinjaButton(9, guiLeft + padLeft + 70, guiTop + padTop + 9 * 4, "plus"));
				this.buttonList.add(new GuiNinjaButton(10, guiLeft + padLeft + 70, guiTop + padTop + 9 * 5, "plus"));
			}
			
			this.drawString(fontRendererObj, "Taining (1 point)", guiLeft + padLeft, guiTop + padTop + 9 * 7, 0xddeeee);
			this.drawString(fontRendererObj, "Element Power: " + props.psa.getElementPowerModifier(), guiLeft + padLeft, guiTop + padTop + 9 * 8, 0xddeeee);
			this.drawString(fontRendererObj, "Max Chakra Bonus: " + props.psa.getChakraModifier(), guiLeft + padLeft, guiTop + padTop + 9 * 9, 0xddeeee);
			this.drawString(fontRendererObj, "Chakra Regen Bonus: " + props.psa.getChakraRegenBonus(), guiLeft + padLeft, guiTop + padTop + 9 * 10, 0xddeeee);
			if (props.psa.skillPoints >= 1)
			{
				this.buttonList.add(new GuiNinjaButton(11, guiLeft + padLeft + 120, guiTop + padTop + 9 * 8, "plus"));
				this.buttonList.add(new GuiNinjaButton(12, guiLeft + padLeft + 120, guiTop + padTop + 9 * 9, "plus"));
				this.buttonList.add(new GuiNinjaButton(13, guiLeft + padLeft + 120, guiTop + padTop + 9 * 10, "plus"));
			}
		}
	}
	
	/** Button Clicks **/
	@Override
	protected void actionPerformed(GuiButton button) 
	{	
		//Tabs 0 - 6, Stats and then the 6 Jutsu types
		switch (button.id)
		{
			case 0: // Stats
				jutsuMenu = false;
				break;
			case 1: // jutsu
				jutsuMenu = true;
				jutsuPage = 0;
				break;
			case 2: // jutsu
				jutsuMenu = true;
				jutsuPage = 1;
				break;	
			case 3: // jutsu
				jutsuMenu = true;
				jutsuPage = 2;
				break;	
			case 4: // jutsu
				jutsuMenu = true;
				jutsuPage = 3;
				break;	
			case 5: // jutsu
				jutsuMenu = true;
				jutsuPage = 4;
				break;	
			case 6: // jutsu
				jutsuMenu = true;
				jutsuPage = 5;
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
