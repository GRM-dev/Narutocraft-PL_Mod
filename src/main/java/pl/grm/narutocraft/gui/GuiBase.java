package pl.grm.narutocraft.gui;

import net.minecraft.client.gui.GuiScreen;

public class GuiBase extends GuiScreen {
	public static int	GUI_ID	= 0;
	
	public static final int	GUI_JUTSU_INV	= GUI_ID++, GUI_SKILL_TREE = GUI_ID++;
	
	public GuiBase() {
		
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		this.drawDefaultBackground();
	}
}
