package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import pl.grm.narutocraft.gui.ContainerNCPLPlayer;
import pl.grm.narutocraft.gui.GuiBasic;
import pl.grm.narutocraft.libs.ExtendedProperties;
import cpw.mods.fml.common.network.IGuiHandler;

public class ServerGuiHandler implements IGuiHandler {
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x,
			int y, int z) {
		return getServerGuiElement(ID, player, world, x, y, z);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x,
			int y, int z) {
		if (ID == GuiBasic.GUI_JUTSU_INV) {
			return new ContainerNCPLPlayer(player, player.inventory,
					ExtendedProperties.get(player).inventory);
		} else if (ID == GuiBasic.GUI_SKILL_TREE) { return null; }
		return null;
	}
	
	public void showUICustomizationScreen(EntityPlayerMP player) {
		if (!player.worldObj.isRemote) {
			NetHandler.INSTANCE.sendPacketToClientPlayer(player, (byte) 37, new byte[0]);
		}
	}
}
