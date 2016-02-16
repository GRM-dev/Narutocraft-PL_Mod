package pl.grmdev.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import pl.grmdev.narutocraft.gui.stats.GuiNinjaStatsView;
import pl.grmdev.narutocraft.libs.config.References;

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
