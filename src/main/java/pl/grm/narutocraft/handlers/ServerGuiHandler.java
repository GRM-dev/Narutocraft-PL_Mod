package pl.grm.narutocraft.handlers;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraftforge.fml.common.network.*;

public class ServerGuiHandler implements IGuiHandler {
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return getServerGuiElement(ID, player, world, x, y, z);
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			default :
				return null;
		}
	}
	
	public void showUICustomizationScreen(EntityPlayerMP player) {
		if (!player.worldObj.isRemote) {
			// NetHandler.INSTANCE.sendPacketToClientPlayer(player, (byte) 37,
			// new byte[0]);
		}
	}
}
