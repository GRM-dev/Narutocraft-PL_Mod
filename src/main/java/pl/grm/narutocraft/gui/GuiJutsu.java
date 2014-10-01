package pl.grm.narutocraft.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.StringTranslate;

public class GuiJutsu extends GuiScreen {

	protected NewGuiNinjaStats parentGui;
	
	protected GuiSlotList list;
	
	public GuiJutsu (NewGuiNinjaStats parent)
	{
		this.parentGui = parent;
		this.list = new GuiSlotList(parent);
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(0, 25, this.height - 38, 120, 20, "Done"));

	}
	
	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.enabled)
		 {
			 switch (par1GuiButton.id)
			 {
				 case 0:
					 this.mc.displayGuiScreen(this.parentGui);
			 }
		 }
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		this.list.drawScreen(par1, par2, par3);
		 super.drawScreen(par1, par2, par3);

	}
	
}
