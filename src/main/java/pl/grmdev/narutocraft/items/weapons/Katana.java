package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.libs.config.Materials;

public class Katana extends SwordMain {

	public Katana() {
		super(Materials.tytan3);
		this.setAttackDamage(12);
		this.setMaxDamage(350);
	}
}