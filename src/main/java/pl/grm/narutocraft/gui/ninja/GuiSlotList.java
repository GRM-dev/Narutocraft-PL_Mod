package pl.grm.narutocraft.gui.ninja;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.renderer.Tessellator;

public class GuiSlotList extends GuiSlot {
	protected Minecraft		mc;
	private GuiNinjaStatsView	gui;
	private String[]		strings;
	
	public GuiSlotList(GuiNinjaStatsView guiNinjaStats) {
		super(guiNinjaStats.mc, guiNinjaStats.getSizeX(), guiNinjaStats.getSizeY(), guiNinjaStats
				.getTop(), guiNinjaStats.getSizeY(), 24);
		this.left = guiNinjaStats.getLeft();
		this.mc = guiNinjaStats.mc;
		this.gui = guiNinjaStats;
		strings = new String[]{
				"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven"};
	}
	
	@Override
	protected int getSize() {
		return strings.length;
	}
	
	@Override
	protected void elementClicked(int var1, boolean var2, int var3, int var4) {
		if (var2)// twice
		{
			// this.gui.setString(strings[var1]);
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
	protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5, int var6,
			int var7) {
		this.gui.drawCenteredString(gui.getFontRenderer(), strings[var1], this.gui.width / 2,
				var3 + 1, 16777215);
	}
}