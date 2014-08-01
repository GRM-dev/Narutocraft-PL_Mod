package pl.grm.narutocraftmod.Libs;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import pl.grm.narutocraftmod.Entities.EntityKunai;
import pl.grm.narutocraftmod.Entities.EntitySenbon;
import pl.grm.narutocraftmod.Entities.EntityWKunai;

public class DamSource extends DamageSource {

	public DamSource(String par1Str) {
		super(par1Str);
		// TODO Auto-generated constructor stub
	}

	public static DamageSource causeKunaiDamage(EntityKunai entityKunai, Entity shootingEntity) {
		return (new EntityDamageSourceIndirect("kunai", entityKunai, shootingEntity)).setProjectile();
	}

	public static DamageSource causeWKunaiDamage(EntityWKunai entityWKunai,	Entity shootingEntity) {
		return (new EntityDamageSourceIndirect("wkunai", entityWKunai, shootingEntity)).setProjectile();
	}

	public static DamageSource causeSenbonDamage(EntitySenbon entitySenbon,	Entity shootingEntity) {
		return (new EntityDamageSourceIndirect("senbon", entitySenbon, shootingEntity)).setProjectile();
	}

}
