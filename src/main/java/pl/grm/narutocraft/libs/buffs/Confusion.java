package pl.grm.narutocraft.libs.buffs;

import net.minecraft.entity.EntityLivingBase;

@Deprecated
// TODO to delete after creating real ones. This is just scheme
public class Confusion extends BuffEffect {

	public Confusion(int buffID, int duration, int amplifier) {
		super(buffID, duration, amplifier);
	}

	@Override
	public void stopEffect(EntityLivingBase entityliving) {}

	@Override
	protected String jutsuBuffName() {
		return "Confusion";
	}

	@Override
	public void startEffect(EntityLivingBase paramEntityLivingBase) {}
}
