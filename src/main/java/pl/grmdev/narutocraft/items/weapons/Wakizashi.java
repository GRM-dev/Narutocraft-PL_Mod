package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.libs.config.Materials;

public class Wakizashi extends SwordMain {

	public Wakizashi() {
		super(Materials.tytan);
		this.setAttackDamage(10);
		this.setMaxDamage(300);
	}
}