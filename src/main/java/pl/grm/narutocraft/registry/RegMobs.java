package pl.grm.narutocraft.registry;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.mobs.bijuu.EntityKyuubi;

public class RegMobs extends NarutoCraft {

	public static void regMobsList() {
		// EntityRegistry.registerGlobalEntityID(Entity.class, "Entity", 1);
		EntityRegistry.registerGlobalEntityID(EntityKyuubi.class, "EntityKyuubi", 4809, 2, 2);
	}
}
