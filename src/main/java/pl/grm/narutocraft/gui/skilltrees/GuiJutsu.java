package pl.grm.narutocraft.gui.skilltrees;

import net.minecraft.client.gui.*;
import pl.grm.narutocraft.gui.stats.*;

public class GuiJutsu extends GuiScreen {
	private GuiNinjaStatsView	parentGui;
	//private GuiSlotList			list;
	
	public GuiJutsu(GuiNinjaStatsView guiNinjaStats) {
		this.parentGui = guiNinjaStats;
		//this.list = new GuiSlotList(guiNinjaStats);
		width = 150;
		height = 150;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(0, 25, this.height - 38, 120, 20, "Done"));
	}
	
	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.enabled) {
			switch (par1GuiButton.id) {
				case 0 :
					this.mc.displayGuiScreen(this.parentGui);
				default :
					break;
			}
		}
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		//this.list.drawScreen(par1, par2, par3);
		super.drawScreen(par1, par2, par3);
	}
}