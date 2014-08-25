package pl.grm.narutocraftmod.HUD;

import net.minecraft.client.gui.GuiScreen;

public class GuiBasic extends GuiScreen{
	public static int GUI_ID = 0;
	
	public static final int
	GUI_JUTSU_INV = GUI_ID++,
	GUI_ITEM_INV = GUI_ID++;
	
	public GuiBasic () {
		
	}
    
    @Override
    public void drawScreen(int par1, int par2, float par3) {
            this.drawDefaultBackground();
    }
}
