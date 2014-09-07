package pl.grm.narutocraft.effects;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Invisible extends Potion implements IEffect {
	private EntityPlayer player;
	private int ID;
	private int duration;
	private List<ItemStack> curativeItems;
	private int tickCount;
	private boolean ended;

	/**
	 * Make player invisible for duration(ticks).
	 * 
	 * @param ID
	 * @param duration
	 * @param stack
	 * @param world
	 * @param player
	 */
	public Invisible(int ID, int duration, ItemStack stack, World world,
			EntityPlayer player) {
		super(ID, false, 8356754);
		this.player = player;
		this.ID = ID;
		this.duration = duration;
	}

	@Override
	public void action() {
		if (!player.isInvisible())
			player.setInvisible(true);
	}

	@Override
	public void startEffect() {
		this.ended = false;
		this.tickCount = 0;
		this.action();

	}

	@Override
	public void endEffect() {
		player.setInvisible(false);
		this.ended = true;
	}

	@Override
	public void onEffectUpdate() {
		tickCount++;
		if (tickCount > duration)
			endEffect();
	}

	@Override
	public PotionEffect getEffect() {
		return null;
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public int getAmplifier() {
		return 0;
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
