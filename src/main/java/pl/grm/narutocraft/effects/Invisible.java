package pl.grm.narutocraft.effects;

import net.minecraft.potion.Potion;

public class Invisible extends Potion {
	public Invisible() {
		super(24, false, 54364);
		this.setPotionName("effect.invisibility");
		this.setIconIndex(0, 1);
	}
}
