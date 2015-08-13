package pl.grm.narutocraft.registry;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.items.weapons.projectiles.entities.EntityKunai;
import pl.grm.narutocraft.items.weapons.projectiles.entities.EntitySenbon;
import pl.grm.narutocraft.items.weapons.projectiles.entities.EntityShuriken;
import pl.grm.narutocraft.items.weapons.projectiles.entities.EntityExplodeKunai;
import pl.grm.narutocraft.mobs.bijuu.EntityKyuubi;

public class RegEntities extends NarutoCraft {

	public static void RegEntitiesList() {
		int id = 0;
		EntityRegistry.registerModEntity(EntityKunai.class, "Kunai", id, NarutoCraft.instance, 80, 1, true);
		id++;
		EntityRegistry.registerModEntity(EntityExplodeKunai.class, "ExplodeKunai", id, NarutoCraft.instance, 80, 1, true);
		id++;
		EntityRegistry.registerModEntity(EntitySenbon.class, "Senbon", id, NarutoCraft.instance, 80, 1, true);
		id++;
		EntityRegistry.registerModEntity(EntityShuriken.class, "Shuriken", id, NarutoCraft.instance, 80, 1, true);
		id++;

		EntityRegistry.registerModEntity(EntityKyuubi.class, "Kyuubi", id, NarutoCraft.instance, 90, 1, true);
		id++;
		// TODO Normal summons sometimes spawn. (After making summons.
		// EntityRegistry.addSpawn(EntityKyuubi.class, 2, 0, 1,
		// EnumCreatureType.creature, BiomeGenBase.biomeList);//change the
		// values to vary the spawn rarity, biome, etc.
	}
}
