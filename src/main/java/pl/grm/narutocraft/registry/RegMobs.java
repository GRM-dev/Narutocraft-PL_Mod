package pl.grm.narutocraft.registry;

import net.minecraftforge.fml.common.registry.*;
import pl.grm.narutocraft.*;
import pl.grm.narutocraft.mobs.bijuu.*;

public class RegMobs extends NarutoCraft {
	public static void regMobsList() {
		// EntityRegistry.registerGlobalEntityID(Entity.class, "Entity", 1);
		EntityRegistry.registerGlobalEntityID(EntityKyuubi.class, "EntityKyuubi", 4809,
				2, 2);
	}
}
