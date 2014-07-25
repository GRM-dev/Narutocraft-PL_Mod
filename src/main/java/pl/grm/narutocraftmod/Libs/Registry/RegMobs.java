package pl.grm.narutocraftmod.Libs.Registry;

import cpw.mods.fml.common.registry.EntityRegistry;
import pl.grm.narutocraftmod.NarutoCraftMod;
import pl.grm.narutocraftmod.Mobs.Bijuu.EntityKyuubi;

public class RegMobs extends NarutoCraftMod {
	public static void RegMobsList() {
		//EntityRegistry.registerGlobalEntityID(Entity.class, "Entity", 1);
    	EntityRegistry.registerGlobalEntityID(EntityKyuubi.class, "EntityKyuubi", 4809, 2, 2);
	}
}
