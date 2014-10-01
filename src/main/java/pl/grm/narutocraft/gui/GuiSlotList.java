package pl.grm.narutocraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;

public class GuiSlotList extends GuiSlot {

	protected Minecraft mc;
	protected int slotHeight;
	private NewGuiNinjaStats gui;
	private String[] strings;


	
	public GuiSlotList(NewGuiNinjaStats gui)
	{
		super(gui.mc,gui.width,gui.height,32,gui.height,24);
		this.slotHeight = 24;
		this.mc = gui.mc;
		this.gui = gui;
		strings = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};

	}
	
	public GuiSlotList(Minecraft par1Minecraft, int par2, int par3, int par4,
			int par5, int par6) {
		super(par1Minecraft, par2, par3, par4, par5, par6);
	}

	@Override
	protected int getSize() {
		return strings.length;
	}

	@Override
	protected void elementClicked(int var1, boolean var2, int var3, int var4) {
		if (var2)//twice
		{
			this.gui.setString(strings[var1]);
			 this.mc.displayGuiScreen(gui);

		}
		
	}

	@Override
	protected boolean isSelected(int var1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void drawBackground() {
		gui.drawDefaultBackground();
	}

	@Override
	protected void drawSlot(int var1, int var2, int var3, int var4,
			Tessellator var5, int var6, int var7) {
		// TODO Auto-generated method stub
		
	}

}
