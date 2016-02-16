package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.libs.config.Materials;

public class SamuraiSword extends SwordMain {

	public SamuraiSword() {
		super(Materials.stal3);
		this.setAttackDamage(4);
		this.setMaxDamage(800);

	}
}