package pl.grm.narutocraft.gui.skilltrees;

import net.minecraft.client.gui.*;
import net.minecraft.entity.player.*;

public class GuiSkillTrees extends GuiScreen {
	int						xSize	= 210, ySize = 246;
	private GuiButton		MainTree;
	private EntityPlayer	player;
	
	public GuiSkillTrees(EntityPlayer player) {
		this.player = player;
	}
	
}
