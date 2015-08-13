package pl.grm.narutocraft.items.weapons;

import pl.grm.narutocraft.libs.config.Materials;

public class Wakizashi extends SwordMain {

	public Wakizashi() {
		super(Materials.tytan);
		this.setAttackDamage(10);
		this.setMaxDamage(300);
	}
}