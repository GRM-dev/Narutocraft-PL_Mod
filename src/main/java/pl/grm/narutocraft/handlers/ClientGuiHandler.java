package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import pl.grm.narutocraft.gui.stats.GuiNinjaStatsView;
import pl.grm.narutocraft.libs.config.References;

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
