package pl.grm.narutocraftmod.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import pl.grm.narutocraftmod.hud.ContainerNCPLPlayer;
import pl.grm.narutocraftmod.hud.GuiBasic;
import pl.grm.narutocraftmod.hud.GuiJutsuInvContainer;
import pl.grm.narutocraftmod.libs.ExtendedPlayer;
import cpw.mods.fml.common.network.IGuiHandler;


public class GuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z)
	{
		if (ID == GuiBasic.GUI_JUTSU_INV)
		{
			return new ContainerNCPLPlayer(player, player.inventory, ExtendedPlayer.get(player).inventory);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z)
	{
		
		if (ID == GuiBasic.GUI_JUTSU_INV)
		{
			return new GuiJutsuInvContainer(player, player.inventory, ExtendedPlayer.get(player).inventory);
		}
		
		return null;
	}

}
