package pl.grm.narutocraft.gui.skilltrees;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public class GuiSkillTrees extends GuiScreen {

	int xSize = 210, ySize = 246;
	private GuiButton MainTree;
	private EntityPlayer player;

	public GuiSkillTrees(EntityPlayer player) {
		this.player = player;
	}

}
