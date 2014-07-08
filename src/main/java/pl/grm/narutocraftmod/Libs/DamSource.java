package pl.grm.narutocraftmod.Libs;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import pl.grm.narutocraftmod.Entities.EntityKunai;

public class DamSource extends DamageSource {

	public DamSource(String par1Str) {
		super(par1Str);
		// TODO Auto-generated constructor stub
	}

	public static DamageSource causeKunaiDamage(EntityKunai par0EntityKunai, Entity par1Entity) {
		return (new EntityDamageSourceIndirect("kunai", par0EntityKunai, par1Entity)).setProjectile();
	}

}
