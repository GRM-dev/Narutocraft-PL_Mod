package pl.grm.narutocraft.libs;

import net.minecraft.entity.*;
import net.minecraft.util.*;
import pl.grm.narutocraft.items.weapons.projectiles.entities.*;

public class DamSource extends DamageSource {
	
	public DamSource(String par1Str) {
		super(par1Str);
	}
	
	public static DamageSource causeKunaiDamage(EntityKunai entityKunai,
			Entity shootingEntity) {
		return (new EntityDamageSourceIndirect("kunai", entityKunai, shootingEntity))
				.setProjectile();
	}
	
	public static DamageSource causeSenbonDamage(EntitySenbon entitySenbon,
			Entity shootingEntity) {
		return (new EntityDamageSourceIndirect("senbon", entitySenbon, shootingEntity))
				.setProjectile();
	}
	
	public static DamageSource causeShurikenDamage(EntityShuriken entityShuriken,
			Entity shootingEntity) {
		return (new EntityDamageSourceIndirect("shuriken", entityShuriken, shootingEntity))
				.setProjectile();
	}
	
	public static DamageSource causeWKunaiDamage(EntityWKunai entityWKunai,
			Entity shootingEntity) {
		return (new EntityDamageSourceIndirect("wkunai", entityWKunai, shootingEntity))
				.setProjectile();
	}
	
}
