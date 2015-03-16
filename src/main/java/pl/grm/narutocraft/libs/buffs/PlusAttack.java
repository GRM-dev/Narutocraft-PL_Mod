package pl.grm.narutocraft.libs.buffs;

import net.minecraft.entity.*;

@Deprecated
// TODO to delete after creating real ones. This is just scheme
public class PlusAttack extends BuffEffect {
	
	public PlusAttack(int buffID, int duration, int amplifier) {
		super(buffID, duration, amplifier);
	}
	
	@Override
	public void stopEffect(EntityLivingBase entityliving) {}
	
	@Override
	protected String jutsuBuffName() {
		return "PlusAttack";
	}
	
	@Override
	public void startEffect(EntityLivingBase paramEntityLivingBase) {}
}
