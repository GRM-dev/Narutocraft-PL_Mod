package pl.grm.narutocraft.libs.buffs;

import java.util.*;

import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraftforge.fml.relauncher.*;
import pl.grm.narutocraft.*;

public abstract class BuffEffect extends PotionEffect {
	protected boolean	InitialApplication;
	protected boolean	HasNotified;
	protected Random	rand;
	
	/**
	 * @param buffID
	 * @param duration
	 * @param amplifier
	 */
	public BuffEffect(int buffID, int duration, int amplifier) {
		super(buffID, duration, amplifier > 0 ? amplifier - 1 : amplifier);
		this.InitialApplication = true;
		this.HasNotified = (duration / 20 <= 5);
		this.rand = new Random();
	}
	
	protected abstract String jutsuBuffName();
	
	public abstract void startEffect(EntityLivingBase paramEntityLivingBase);
	
	public abstract void stopEffect(EntityLivingBase paramEntityLivingBase);
	
	public static boolean setAmplifier(PotionEffect pe, int amplifier) {
		ReflectionHelper.setPrivateValue(PotionEffect.class, pe, Integer.valueOf(amplifier), 2);
		return true;
	}
	
	public boolean shouldNotify() {
		return true;
	}
	
	private void effectEnding(EntityLivingBase entityliving) {
		stopEffect(entityliving);
	}
	
	@Override
	public void performEffect(EntityLivingBase entityliving) {}
	
	@Override
	public void combine(PotionEffect potioneffect) {
		if (!(potioneffect instanceof BuffEffect)) { return; }
		int thisAmplifier = getAmplifier();
		if (thisAmplifier >= potioneffect.getAmplifier()) {
			super.combine(potioneffect);
			this.HasNotified = false;
		}
	}
	
	@Override
	public boolean onUpdate(EntityLivingBase entityliving) {
		if (this.InitialApplication) {
			this.InitialApplication = false;
			startEffect(entityliving);
		} else if (getDuration() <= 1) {
			effectEnding(entityliving);
		} else if ((getDuration() / 20 < 5) && (!this.HasNotified) && (shouldNotify())
				&& (!entityliving.worldObj.isRemote)) {
			this.HasNotified = true;
		}
		performEffect(entityliving);
		if ((NarutoCraft.proxy instanceof ProxyCommon)) { return super.onUpdate(entityliving); }
		return true;
	}
	
	public boolean isReady(int i, int j) {
		int k = 25 >> j;
		if (k > 0) { return i % k == 0; }
		return true;
	}
	
	@Override
	public String getEffectName() {
		return String.format("Jutsu: %s", new Object[]{jutsuBuffName()});
	}
}
