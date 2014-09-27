package pl.grm.narutocraft;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldServer;
import pl.grm.narutocraft.network.PlayerTracker;
import cpw.mods.fml.server.FMLServerHandler;

public class ProxyCommon {
	private static final Map<String, NBTTagCompound>	extendedEntityData	= new HashMap<String, NBTTagCompound>();
	public PlayerTracker								playerTracker;
	
	public static NBTTagCompound getEntityData(String name) {
		return extendedEntityData.remove(name);
	}
	
	public static void storeEntityData(String name, NBTTagCompound compound) {
		extendedEntityData.put(name, compound);
	}
	
	public int addArmor(String armor) {
		return 0;
	}
	
	public EntityLivingBase getEntityByID(int entityID) {
		Entity ent = null;
		for (WorldServer ws : getWorldServers()) {
			ent = ws.getEntityByID(entityID);
			if (ent != null) {
				if ((ent instanceof EntityLivingBase)) {
					break;
				}
				return null;
			}
		}
		return (EntityLivingBase) ent;
	}
	
	public void registerRenderInfomation() {}
	
	public void registerRendering() {}
	
	public void registerRenderThings() {}
	
	public void registerSound() {}
	
	public void registerCommands() {}
	
	private WorldServer[] getWorldServers() {
		return FMLServerHandler.instance().getServer().worldServers;
	}
}
