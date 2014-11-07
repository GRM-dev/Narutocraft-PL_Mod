package pl.grm.narutocraft.libs.buffs;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import pl.grm.narutocraft.NarutoCraft;
import pl.grm.narutocraft.ProxyCommon;
import cpw.mods.fml.relauncher.ReflectionHelper;

public abstract class BuffEffect extends PotionEffect {
	protected boolean		InitialApplication;
	protected boolean		HasNotified;
	protected Random		rand;
	private static float	maxExtendDuration	= 900.0F;
	
	public BuffEffect(int buffID, int duration, int amplifier) {
		super(buffID, duration, amplifier > 0 ? amplifier - 1 : amplifier);
		this.InitialApplication = true;
		this.HasNotified = (duration / 20 <= 5);
		this.rand = new Random();
	}
	
	public static boolean ExtendDuration(PotionEffect pe) {
		int newDuration = pe.getDuration() + 2;
		if (newDuration <= maxExtendDuration) { return SetDuration(pe, newDuration); }
		return false;
	}
	
	public static boolean SetDuration(PotionEffect pe, int duration) {
		// pe.duration = duration; //FIXME duration not visible
		return true;
	}
	
	public static boolean SetAmplifier(PotionEffect pe, int amplifier) {
		ReflectionHelper.setPrivateValue(PotionEffect.class, pe, Integer.valueOf(amplifier), 2);
		return true;
	}
	
	public boolean shouldNotify() {
		return true;
	}
	
	public abstract void applyEffect(EntityLivingBase paramEntityLivingBase);
	
	public abstract void stopEffect(EntityLivingBase paramEntityLivingBase);
	
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
			applyEffect(entityliving);
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
	
	protected abstract String jutsuBuffName();
	
	@Override
	public String getEffectName() {
		return String.format("Jutsu: %s", new Object[]{jutsuBuffName()});
	}
}
