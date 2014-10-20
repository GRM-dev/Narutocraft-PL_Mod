package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import pl.grm.narutocraft.gui.GuiBase;
import pl.grm.narutocraft.gui.GuiJutsuInvContainer;
import pl.grm.narutocraft.gui.ninja.GuiNinjaStats;
import pl.grm.narutocraft.libs.ExtendedProperties;

public class ClientGuiHandler extends ServerGuiHandler {
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x,
			int y, int z) {
		if (ID == GuiBase.GUI_JUTSU_INV) {
			return new GuiJutsuInvContainer(player, player.inventory,
					ExtendedProperties.get(player).inventory);
		} else if (ID == 3) { return new GuiNinjaStats(player); }
		return null;
	}
}
