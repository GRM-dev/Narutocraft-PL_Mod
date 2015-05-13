package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import pl.grm.narutocraft.gui.stats.*;
import pl.grm.narutocraft.libs.config.*;

public class ClientGuiHandler extends ServerGuiHandler {
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case References.STATS :
			case References.SKILL_TREE :
				return new GuiNinjaStatsView(player);
			default :
				return null;
		}
	}
}
