package pl.grm.narutocraft.items.weapons;

import pl.grm.narutocraft.libs.config.Materials;

public class Katana extends SwordMain {

	public Katana() {
		super(Materials.tytan3);
		this.setAttackDamage(12);
		this.setMaxDamage(350);
	}
}