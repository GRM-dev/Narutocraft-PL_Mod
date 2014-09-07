package pl.grm.narutocraft.effects;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ExtendedRange extends Potion implements IEffect {

	protected ExtendedRange(int par1, boolean par2, int par3) {
		super(par1, par2, par3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public PotionEffect getEffect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAmplifier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startEffect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endEffect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEffectUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnded() {
		// TODO Auto-generated method stub
		return false;
	}

}
