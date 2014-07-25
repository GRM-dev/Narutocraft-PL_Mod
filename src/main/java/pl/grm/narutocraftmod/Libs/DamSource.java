package pl.grm.narutocraftmod.Libs;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import pl.grm.narutocraftmod.Entities.EntityKunai;
import pl.grm.narutocraftmod.Entities.EntityWKunai;

public class DamSource extends DamageSource {

	public DamSource(String par1Str) {
		super(par1Str);
		// TODO Auto-generated constructor stub
	}

	public static DamageSource causeKunaiDamage(EntityKunai par0EntityKunai, Entity par1Entity) {
		return (new EntityDamageSourceIndirect("kunai", par0EntityKunai, par1Entity)).setProjectile();
	}

	public static DamageSource causeWKunaiDamage(EntityWKunai par0EntityWKunai,	Entity par1Entity) {
		return (new EntityDamageSourceIndirect("wkunai", par0EntityWKunai, par1Entity)).setProjectile();
	}

}
