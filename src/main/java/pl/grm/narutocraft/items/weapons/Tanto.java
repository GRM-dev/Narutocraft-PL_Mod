package pl.grm.narutocraft.items.weapons;

import pl.grm.narutocraft.libs.config.Materials;

public class Tanto extends SwordMain {

	public Tanto() {
		super(Materials.tytan5);
		this.setAttackDamage(8);
		this.setMaxDamage(250);

	}
}