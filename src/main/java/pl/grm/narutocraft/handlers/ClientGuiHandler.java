package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import pl.grm.narutocraft.gui.ninja.GuiNinjaStats;
import pl.grm.narutocraft.libs.References;

public class ClientGuiHandler extends ServerGuiHandler {
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case References.STATS :
			case References.SKILL_TREE :
				return new GuiNinjaStats(player);
			default :
				return null;
		}
	}
}
