package pl.grm.narutocraft.libs.registry;

import pl.grm.narutocraft.NarutoCraftMod;
import pl.grm.narutocraft.itementities.EntityKunai;
import pl.grm.narutocraft.itementities.EntitySenbon;
import pl.grm.narutocraft.itementities.EntityShuriken;
import pl.grm.narutocraft.itementities.EntityWKunai;
import pl.grm.narutocraft.mobs.bijuu.EntityKyuubi;
import cpw.mods.fml.common.registry.EntityRegistry;

public class RegEntities extends NarutoCraftMod {
	public static void RegEntitiesList() {
    	int id =0;
    	EntityRegistry.registerModEntity(EntityKunai.class, "Kunai", id, NarutoCraftMod.instance, 80, 1, true); id++;
    	EntityRegistry.registerModEntity(EntityWKunai.class, "WKunai", id, NarutoCraftMod.instance, 80, 1, true); id++;
    	EntityRegistry.registerModEntity(EntitySenbon.class, "Senbon", id, NarutoCraftMod.instance, 80, 1, true); id++;
    	EntityRegistry.registerModEntity(EntityShuriken.class, "Shuriken", id, NarutoCraftMod.instance, 80, 1, true); id++;
    	
    	EntityRegistry.registerModEntity(EntityKyuubi.class, "Kyuubi", id, NarutoCraftMod.instance, 80, 1, true); id++;
    	//EntityRegistry.addSpawn(EntityKyuubi.class, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.biomeList);//change the values to vary the spawn rarity, biome, etc.              
    	
	}
}
