package pl.grm.narutocraft.libs.buffs;

import net.minecraft.entity.EntityLivingBase;

@Deprecated
// TODO to delete after creating real ones. This is just scheme
public class Fire extends BuffEffect {
	
	public Fire(int buffID, int duration, int amplifier) {
		super(buffID, duration, amplifier);
	}
	
	@Override
	public void stopEffect(EntityLivingBase entityliving) {}
	
	@Override
	protected String jutsuBuffName() {
		return "Fire";
	}
	
	@Override
	public void startEffect(EntityLivingBase paramEntityLivingBase) {}
}
