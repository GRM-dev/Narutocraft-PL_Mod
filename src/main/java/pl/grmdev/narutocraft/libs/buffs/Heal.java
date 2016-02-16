package pl.grmdev.narutocraft.libs.buffs;

import net.minecraft.entity.EntityLivingBase;

@Deprecated
// TODO to delete after creating real ones. This is just scheme
public class Heal extends BuffEffect {

	public Heal(int buffID, int duration, int amplifier) {
		super(buffID, duration, amplifier);
	}

	@Override
	public void stopEffect(EntityLivingBase entityliving) {}

	@Override
	protected String jutsuBuffName() {
		return "Heal";
	}

	@Override
	public void startEffect(EntityLivingBase paramEntityLivingBase) {

	}
}
