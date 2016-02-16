package pl.grmdev.narutocraft;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.server.FMLServerHandler;

public class ProxyCommon {

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();

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
		for (WorldServer ws : this.getWorldServers()) {
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

	public void registerCommands() {}

	public void registerRenderInfomation() {}

	public void registerRendering() {}

	public void registerRenderThings() {}

	public void registerSound() {}

	private WorldServer[] getWorldServers() {
		return FMLServerHandler.instance().getServer().worldServers;
	}
}
