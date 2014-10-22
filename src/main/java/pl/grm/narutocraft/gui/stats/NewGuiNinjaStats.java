package pl.grm.narutocraft.gui.stats;

import org.lwjgl.opengl.GL11;

import pl.grm.narutocraft.libs.config.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;


//TODO once this class is complete and working, remove GuiNinjaStats and refactor this to that name
public class NewGuiNinjaStats extends GuiScreen {
	
	public final int xSizeOfTexture = 256;
	public final int ySizeOfTexture = 256;
	
	private EntityPlayer	player;
	private int				padLeft		= 44, padTop = 27;
	private Boolean			jutsuMenu	= false;
	private int				jutsuPage	= 0;
	private int strUpg = 0, agiUpg = 0, dexUpg = 0, resUpg = 0,
			epmUpg = 0, chaUpg = 0, crbUpg = 0;
	private int stbUpg = 0, stfUpg = 0, stgUpg = 0, 
			stiUpg = 0, stnUpg = 0,sttUpg=0;
	
	public String s;
	
	int posX = (this.width - xSizeOfTexture) / 2 + Minecraft.getMinecraft().displayWidth / 2;
	int posY = (this.height - ySizeOfTexture) / 2 + 200;

	public NewGuiNinjaStats(EntityPlayer player)
	{
		super();
		this.player = player;
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		drawDefaultBackground();
		
		//TODO remove jutsu page reference
		this.mc.renderEngine.bindTexture(this.jutsuMenu
				? References.jutsuGUILocation[this.jutsuPage] : References.statsPath);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);

		super.drawScreen(par1, par2, par3);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	protected void keyTyped(char par1, int par2) {
		if ((par2 == 1) || (par2 == this.mc.gameSettings.keyBindInventory.getKeyCode())) {
			this.mc.thePlayer.closeScreen();
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id)
		{
			case 0: 
				//this.mc.displayGuiScreen(new GuiJutsu(this));
			default:
		}
	}
	
	@Override
	public void initGui() {
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, posX+ 120, posY + 10, 90, 20, "select String"));
	}
	
	public void setString(String s)
	{
		this.s = s;
	}
}
