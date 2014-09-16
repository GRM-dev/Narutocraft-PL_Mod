package pl.grm.narutocraft.libs.registry;

import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.mobs.bijuu.EntityKyuubi;
import cpw.mods.fml.common.registry.EntityRegistry;

public class RegMobs extends NarutoCraft {
	public static void regMobsList() {
		//EntityRegistry.registerGlobalEntityID(Entity.class, "Entity", 1);
    	EntityRegistry.registerGlobalEntityID(EntityKyuubi.class, "EntityKyuubi", 4809, 2, 2);
	}
}
