package pl.grm.narutocraft.effects;

import java.util.List;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class Slowness extends Potion implements IEffect {

	public Slowness(int ID) {
		super(ID, false, 5926017);
		this.setPotionName("effect.slowness");
		this.setIconIndex(1, 0);
		this.func_111184_a(SharedMonsterAttributes.movementSpeed,
				"91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2);
	}

	public Slowness() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PotionEffect getEffect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getJutsuID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEffectID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDuration() {
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
	public int getDurationPass() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEnded() {
		// TODO Auto-generated method stub
		return false;
	}

}
