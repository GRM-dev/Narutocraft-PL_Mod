package pl.grm.narutocraft.gui.stats;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.entity.player.*;

import org.lwjgl.input.*;
import org.lwjgl.opengl.*;

import pl.grm.narutocraft.gui.*;
import pl.grm.narutocraft.libs.config.References;
import pl.grm.narutocraft.player.*;

public class GuiNinjaStatsView extends GuiContainer {
	private EntityPlayer	player;
	private int				padLeft		= 44, padTop = 27; //Padding for the image
	
	private int[] tempAttributes = new int[Attributes.values().length];
	private int startTop, startLeft;
	
	public GuiNinjaStatsView(EntityPlayer player) {
		super(new ContainerNull());
		this.player = player;
	}
	
	/**
	 * Button Clicks
	 * <p>
	 * Tabs id 0-6, Stats and then the 6 Jutsu types
	 **/
	@Override
	protected void actionPerformed(GuiButton button) {
		//TODO Buttons
	}
	
	/**
	 * Draws Background of GUI
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		this.xSize = 256;
		this.ySize = 256;
		//Vanilla Starting points
		startTop = 0;//this.guiTop;
		startLeft = 0;//this.guiLeft; 
		
		NinjaStats stats = ExtendedProperties.get(this.player).getNinStats();
		NinjaAttributes attrb = ExtendedProperties.get(this.player).getNinAttrs();
		
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(References.statsPath);
		drawTexturedModalRect(startLeft, startTop, 0, 0, this.xSize, this.ySize);
		this.buttonList.clear();
		// Start with main control buttons
		int x1 = this.guiLeft;
		int x2 = (this.guiLeft + this.xSize) - (22);
		
		//Drawing
		for (int attrIndex = 0; attrIndex < Attributes.values().length; attrIndex++)
		{
			drawDefaultString(Attributes.values()[attrIndex].getName(), this.startLeft + this.padLeft, this.startTop
					+ this.padTop + (9 * (2 + attrIndex)), 0xddeeee);
			drawDefaultString("" + attrb.getAttValues().get(Attributes.values()[attrIndex].getSName()), this.startLeft + this.padLeft + 110,
					this.startTop + this.padTop + (9 * (2 + attrIndex)), 0xddeeee);
			if (tempAttributes[attrIndex] > 0) {
				this.drawDefaultString("+ " + tempAttributes[attrIndex], this.startLeft + this.padLeft + 125,
						this.startTop + this.padTop + (9 * (2 + attrIndex)), 0x73ff9b);
			}
			// Level up Control
						if (stats.getSkillPoints() >= 2) {
							this.buttonList.add(new GuiNinjaButton(attrIndex, this.startLeft + this.padLeft + 145,
									this.startTop + this.padTop + (9 * (2 + attrIndex)), "plus"));
						}
		}	

		this.drawString(this.fontRendererObj, "Ninja Level: " + stats.getNinjaLevel(),
				this.startLeft + this.padLeft, (this.startTop + this.padTop) - 9, 0xddeeee);
		this.drawString(this.fontRendererObj, "Skill Points: " + stats.getSkillPoints(),
				this.startLeft + this.padLeft, this.startTop + this.padTop, 0xddeeee);
		
		Minecraft.getMinecraft().renderEngine.bindTexture(References.ninjaWidgetsPath);
		drawTexturedModalRect(this.startLeft + 132, (this.startTop + this.padTop) - 7, 66, 0, 39, 4);
		drawTexturedModalRect(this.startLeft + 132, (this.startTop + this.padTop) - 7, 66, 4,
				(stats.getCurrentXp() * 39) / stats.getXpCap(), 4);
	
		this.buttonList.add(new GuiButton(Attributes.values().length, this.startLeft + this.padLeft, this.startTop
				+ this.padTop + (9 * 20), 50, 20, "Save"));
		this.buttonList.add(new GuiButton(Attributes.values().length + 1, this.startLeft + this.padLeft + 50, this.startTop
				+ this.padTop + (9 * 20), 50, 20, "Reset"));

	}
	
	private void drawDefaultString(String text, int x, int y, int color) {
		this.drawString(this.fontRendererObj, text, x, y, color);
	}
	
	/** Keyboard Clicks **/
	@Override
	protected void keyTyped(char par1, int par2) {
		if ((par2 == 1) || (par2 == this.mc.gameSettings.keyBindInventory.getKeyCode())) {
			this.mc.thePlayer.closeScreen();
		}
	}
	
	//TODO figure out mouse click and drag for Forge
	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		if (par1 >= startLeft && par1 <= startLeft + xSize)
		{
			if (par2 >= startTop && par2 <= startTop + ySize)
			{
				if (Mouse.getEventButtonState())
				{
					startLeft += Mouse.getEventDX();
					startTop += Mouse.getEventDY();
				}
			}
		}
	}
}
