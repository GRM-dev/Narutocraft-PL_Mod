package pl.grm.narutocraft.effects;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Invisible implements IEffect {
	private EntityPlayer player;
	public int effectID;
	private int duration;
	private List<ItemStack> curativeItems;
	private int durationPass;
	private boolean ended;
	private int jutsuID;

	/**
	 * Make player invisible for duration(ticks).
	 * 
	 * @param jutsuID
	 * @param duration
	 * @param stack
	 * @param world
	 * @param player
	 */
	public Invisible(int jutsuID, int duration, ItemStack stack, World world,
			EntityPlayer player) {
		this();
		this.player = player;
		this.jutsuID = jutsuID;
		this.duration = duration;
	}

	public Invisible() {
		this.effectID = EffectList.INVISIBLE.getID();
	}

	@Override
	public void action() {
		if (!player.isInvisible())
			player.setInvisible(true);
	}

	@Override
	public void startEffect() {
		this.ended = false;
		this.durationPass = 0;
		this.action();

	}

	@Override
	public void endEffect() {
		player.setInvisible(false);
		this.ended = true;
	}

	@Override
	public void onEffectUpdate() {
		durationPass++;
		if (durationPass > duration)
			endEffect();
	}

	@Override
	public int getDurationPass() {
		return durationPass;
	}

	@Override
	public PotionEffect getEffect() {
		return null;
	}

	@Override
	public int getEffectID() {
		return effectID;
	}

	@Override
	public int getJutsuID() {
		return jutsuID;
	}

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		return curativeItems;
	}

	@Override
	public boolean isEnded() {
		return ended;
	}
}