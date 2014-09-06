package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import pl.grm.narutocraft.gui.GuiBasic;
import pl.grm.narutocraft.gui.GuiJutsuInvContainer;
import pl.grm.narutocraft.libs.ExtendedPlayer;

public class ClientGuiHandler extends ServerGuiHandler {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {

		if (ID == GuiBasic.GUI_JUTSU_INV) {
			return new GuiJutsuInvContainer(player, player.inventory,
					ExtendedPlayer.get(player).inventory);
		}
		return null;
	}
}
