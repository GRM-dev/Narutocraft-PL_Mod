package pl.grm.narutocraftmod.Libs;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.HUD.ContainerNCPLPlayer;
import pl.grm.narutocraftmod.HUD.GuiBasic;
import pl.grm.narutocraftmod.HUD.GuiPowerInv;
import cpw.mods.fml.common.network.IGuiHandler;

public class ProxyCommon implements IGuiHandler {
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	public void registerRenderInfomation(){}
	
	public void registerRendering(){}
	
	public void registerRenderThings() {}
    
    public void registerSound() {}

    @Override
    public Object getServerGuiElement ( int ID, EntityPlayer player, World world, int x, int y, int z ) {
    	if (ID == GuiBasic.GUI_CUSTOM_INV)  {
			return new ContainerNCPLPlayer(player, player.inventory, ExtendedPlayer.get(player).inventory);
		} else if (ID == GuiBasic.GUI_ITEM_INV)  {
			return null; //new ContainerMagicBag(player, player.inventory, new InventoryMagicBag(player.getHeldItem()));
		} else {
			return null;
		}
    }

    @Override
    public Object getClientGuiElement ( int ID, EntityPlayer player, World world, int x, int y, int z ) {
    	if (ID == GuiBasic.GUI_CUSTOM_INV) {
			return new GuiPowerInv(player, player.inventory, ExtendedPlayer.get(player).inventory);
		} else if (ID == GuiBasic.GUI_ITEM_INV)  {
			return null; //new GuiMagicBag(player, player.inventory, new InventoryMagicBag(player.getHeldItem()));
		} else {
			return null;
		}
    }

	public int addArmor(String armor) {
		return 0;
	}
	
	public static void storeEntityData(String name, NBTTagCompound compound) {
		extendedEntityData.put(name, compound);
	}
	
	public static NBTTagCompound getEntityData(String name) {
		return extendedEntityData.remove(name);
	}
    
}
