package pl.grm.narutocraft.effects;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;

public class Slowness extends Potion {

	public Slowness(int ID) {
		super(ID, false, 5926017);
		this.setPotionName("effect.slowness");
		this.setIconIndex(1, 0);
		this.func_111184_a(SharedMonsterAttributes.movementSpeed,
				"91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2);
	}

}
