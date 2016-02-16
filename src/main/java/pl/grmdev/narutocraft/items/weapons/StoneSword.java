package pl.grmdev.narutocraft.items.weapons;

import pl.grmdev.narutocraft.libs.config.Materials;

public class StoneSword extends SwordMain {

	public StoneSword() {
		super(Materials.kamien);
		this.setAttackDamage(26);
		this.setMaxDamage(2500);

	}
}